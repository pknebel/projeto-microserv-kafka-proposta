package com.pedro.messages;

import com.pedro.dto.ProposalDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaEvent {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    @Channel("proposal")
    Emitter<ProposalDTO> proposalRequestEmitter;

    public void sendKafkaEvent(ProposalDTO proposalDTO) {
        LOG.info("Sending Kafka event");
        proposalRequestEmitter.send(proposalDTO).toCompletableFuture().join();
    }

}
