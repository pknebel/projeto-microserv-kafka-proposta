package com.pedro.services;

import com.pedro.dto.ProposalDTO;
import com.pedro.dto.ProposalDetailsDTO;
import com.pedro.entities.ProposalEntity;
import com.pedro.messages.KafkaEvent;
import com.pedro.repositories.ProposalRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    ProposalRepository proposalRepository;

    @Inject
    KafkaEvent kafkaMessages;

    @Override
    public ProposalDetailsDTO findFullProposal(Long id) {
        ProposalEntity proposal = proposalRepository.findById(id);

        return ProposalDetailsDTO.builder()
                .proposalId(proposal.getId())
                .proposalValidityDays(proposal.getProposalValidityDays())
                .country(proposal.getCountry())
                .priceTonne(proposal.getPriceTonne())
                .customer(proposal.getCustomer())
                .tonnes(proposal.getTonnes())
                .build();

    }

    @Override
    public void createNewProposal(ProposalDetailsDTO proposalDetailsDTO) {

        ProposalDTO proposal = buildAndSaveNewProposal(proposalDetailsDTO);
        kafkaMessages.sendKafkaEvent(proposal);

    }

    @Override
    public void removeProposal(Long id) {

    }

    @Transactional
    private ProposalDTO buildAndSaveNewProposal(ProposalDetailsDTO proposalDetailsDTO) {

        try{

        }catch (Exception e){

        }
    }

}
