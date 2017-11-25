package co.nz.solnet.demo.kafka.controller;

import co.nz.solnet.demo.kafka.model.SimpleMessage;
import co.nz.solnet.demo.kafka.service.RelayToKafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RelayToKafkaService relayToKafkaService;

    @RequestMapping(value = "/first", method = RequestMethod.POST)
    public ResponseEntity first(@RequestBody SimpleMessage message) {
        logger.info(message.toString());

        relayToKafkaService.splitAndRelay(message.getMessage());
        return ResponseEntity.ok().body(message);
    }
}
