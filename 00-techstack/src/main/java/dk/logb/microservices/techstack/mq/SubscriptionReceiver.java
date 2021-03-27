package dk.logb.microservices.techstack.mq;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "subscriptionQueue")
public class SubscriptionReceiver {
    @Autowired
    private Logger logger;

    @RabbitHandler
    public void receive(String in) {
        logger.info(" [x] Received '" + in + "'");
    }
}