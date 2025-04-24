package com.pedro.controllers;

import com.pedro.dto.ProposalDTO;
import com.pedro.dto.ProposalDetailsDTO;
import com.pedro.services.ProposalService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api/proposal")
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);
    private final ProposalService proposalService;

    @jakarta.inject.Inject
    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GET
    @Path("/{id}")
    public ProposalDetailsDTO findDetailsProposal(@PathParam("id") Long id) {
        return proposalService.findFullProposal(id);
    }
}
