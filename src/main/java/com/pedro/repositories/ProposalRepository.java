package com.pedro.repositories;

import com.pedro.entities.ProposalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;
import java.util.Optional;

@ApplicationScoped
public class ProposalRepository implements PanacheRepository<ProposalEntity> {

    public Optional<ProposalEntity> findByCustomer(String customer) {
        return Optional.of(find("customer", customer).firstResult());
    }

}
