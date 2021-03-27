package dk.logb.microservices.techstack.service;


import dk.logb.microservices.techstack.model.Subscription;
import dk.logb.microservices.techstack.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository repository;

    public <S extends Subscription> S save(S s) {
        return repository.save(s);
    }

    public Optional<Subscription> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public Iterable<Subscription> findAll() {
        return repository.findAll();
    }

    public long count() {
        return repository.count();
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
