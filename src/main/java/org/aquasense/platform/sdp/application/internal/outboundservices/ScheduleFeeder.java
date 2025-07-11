package org.aquasense.platform.sdp.application.internal.outboundservices;

import org.aquasense.platform.sdp.domain.model.aggregates.Schedule;
import org.aquasense.platform.sdp.infrastructure.persistence.jpa.repositories.ScheduleRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ScheduleFeeder {

    private final ScheduleRepository scheduleRepository;
    private final RestTemplate restTemplate;

    public ScheduleFeeder(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(cron = "0 * * * * *")
    public void checkAndFeed() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now().withSecond(0).withNano(0);

        List<Schedule> schedules = scheduleRepository.findAll();
        for (Schedule schedule : schedules) {
            if (schedule.getDay().equals(today) && schedule.getHour().equals(now)) {
                FeedRequest request = new FeedRequest(schedule.getPondId(), schedule.getDuration());
                restTemplate.postForObject("http://localhost:8081/api/v1/feed", request, Void.class);
            }
        }
    }

    public static class FeedRequest {
        public Long pondId;
        public Object duration; // Usa el tipo correcto para duration

        public FeedRequest(Long pondId, Object duration) {
            this.pondId = pondId;
            this.duration = duration;
        }
    }
}