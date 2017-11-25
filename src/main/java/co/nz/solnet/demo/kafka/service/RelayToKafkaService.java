package co.nz.solnet.demo.kafka.service;

import co.nz.solnet.demo.kafka.KafkaConfiguration;
import co.nz.solnet.demo.kafka.KafkaProducerWrapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;

@Service
public class RelayToKafkaService {
    @Autowired
    private KafkaProducerWrapper kafkaProducerWrapper;

    @Autowired
    private Properties kafkaProperties;

    public void splitAndRelay(String message) {
        String ts = String.valueOf(new Date().getTime());
        message.chars()
                .forEach(ch -> {
                    String str = String.valueOf((char)ch);
                    kafkaProducerWrapper.getStringProducer().send(new ProducerRecord<>(kafkaProperties.getProperty("first.topic"), ts, str));
        });
    }
}
