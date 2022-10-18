package az.nadir.springbootkafka.controller;

import az.nadir.springbootkafka.dto.KafkaMessage;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka-message")
@RequiredArgsConstructor
public class ResourceController {

    @Value("${springboot.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @PostMapping("send")
    public void sendMessage(@RequestBody KafkaMessage kafkaMessage){
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), kafkaMessage);
    }
}
