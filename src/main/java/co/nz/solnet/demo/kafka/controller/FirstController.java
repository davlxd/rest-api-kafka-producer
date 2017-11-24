package co.nz.solnet.demo.kafka.controller;

import co.nz.solnet.demo.kafka.model.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/first", method = RequestMethod.POST)
    public ResponseEntity first(@RequestBody SimpleMessage message) {
        logger.info(message.toString());
        return ResponseEntity.ok().body(message);
    }
}
