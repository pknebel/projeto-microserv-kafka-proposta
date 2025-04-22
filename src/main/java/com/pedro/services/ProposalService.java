package com.pedro.services;

import com.pedro.dto.ProposalDetailsDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ProposalService {

    ProposalDetailsDTO findFullProposal(Long id);

    void createNewProposal(ProposalDetailsDTO proposalDetailsDTO);

    void removeProposal(Long id);

}
