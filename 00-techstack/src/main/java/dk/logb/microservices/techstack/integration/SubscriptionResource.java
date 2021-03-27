package dk.logb.microservices.techstack.integration;

import dk.logb.microservices.techstack.model.Subscription;
import dk.logb.microservices.techstack.service.SubscriptionService;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SubscriptionResource {
    public static final String LB_SUBSCRIPTION_EXCHANGE = "lb.subscription"; //exchange in rabbit mq
    public static final String SUBSCRIPTION_ROUTING_KEY = "subscriptionkey"; //routing key for exchange -> queue binding

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private Logger logger;


    @GetMapping("/subscriptions")
    public String subscribe(@RequestParam("mail") String mail) {
        logger.info("subscribing to " + mail);
        save(mail);
        publish(mail);
        return "OK";
    }

    private void save(String mail) {
        Subscription subscription = new Subscription(mail);
        subscriptionService.save(subscription);
        logger.info("saved subscription mail address:  " + mail);
    }

    private void publish(String mail) {
        this.template.convertAndSend(LB_SUBSCRIPTION_EXCHANGE, SUBSCRIPTION_ROUTING_KEY, mail);
        logger.info("published create subscription event: " + mail);
    }
}
