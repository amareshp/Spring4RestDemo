package com.va.ws.hello;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final static Logger LOGGER = Logger.getLogger(HelloController.class.getName());
    
    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player) {
        Message msg = new Message(player, "Hello " + player);
        try {
            ObjectMapper mapper = new ObjectMapper();
            String msgJson = mapper.writeValueAsString(msg);
            LOGGER.info("printing message: " + msgJson);
        } catch(Exception ex) {
            LOGGER.error(ex);
        }
        return msg;
    }

}

