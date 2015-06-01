package com.va.ws.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;

import com.va.ws.hello.HelloController;

public class CamelUtil {
    private final static Logger LOGGER = Logger.getLogger(HelloController.class.getName());
    
    private static long durationMs = 60000;
    private static CamelContext camelContext = new DefaultCamelContext();

    public void init() {
        // initialization logic
        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:/Users/apatta2/MyData/temp?noop=true").to("file:/Users/apatta2/MyData/temp/target");
                }
            });
            camelContext.start();
        } catch (Exception camelException) {
            LOGGER.error("Exception trying to copy files - {0}" + camelException.toString());
        }

    }

    public void cleanup() {
        // destruction logic
        try {
            camelContext.stop();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
