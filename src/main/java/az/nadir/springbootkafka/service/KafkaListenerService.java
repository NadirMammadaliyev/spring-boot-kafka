package az.nadir.springbootkafka.service;

import az.nadir.springbootkafka.dto.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerService {

    @KafkaListener(
            topics = "${springboot.kafka.topic}",
            groupId = "${springboot.kafka.group.id}"
    )
    public void listen(@Payload KafkaMessage kafkaMessage) {
        log.info("Message received. MessageID: {} Message: {} Date: {}", kafkaMessage.getId(),
                kafkaMessage.getMessage(), kafkaMessage.getMessageDate());
    }
}
