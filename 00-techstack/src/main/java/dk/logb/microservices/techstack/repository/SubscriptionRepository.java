package dk.logb.microservices.techstack.repository;


import dk.logb.microservices.techstack.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
