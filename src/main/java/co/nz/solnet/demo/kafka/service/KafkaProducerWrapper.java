package co.nz.solnet.demo.kafka.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Properties;

@Component
public class KafkaProducerWrapper {
    private Producer<String, String> stringProducer;

    public KafkaProducerWrapper(@Autowired Properties kafkaProperties) {
        stringProducer = new KafkaProducer<>(kafkaProperties);
    }

    @PreDestroy
    private void kafkaProducerClose() {
        stringProducer.close();
    }

    public Producer<String, String> getStringProducer() {
        return stringProducer;
    }

    public void setStringProducer(Producer<String, String> stringProducer) {
        this.stringProducer = stringProducer;
    }
}
