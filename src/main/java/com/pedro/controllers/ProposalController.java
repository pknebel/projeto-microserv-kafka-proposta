package com.pedro.controllers;

import com.pedro.dto.ProposalDTO;
import com.pedro.dto.ProposalDetailsDTO;
import com.pedro.services.ProposalService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api/proposal")
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);

    @Inject
    ProposalService proposalService;

    @Inject
    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GET
    @Path("/{id}")
    public ProposalDetailsDTO findDetailsProposal(@PathParam("id") Long id) {
        return proposalService.findFullProposal(id);
    }

    @POST
    public Response createProposal(ProposalDetailsDTO proposalDetails) {

        LOG.info("--- Recebendo Proposta de Compra ---");

        try{

            proposalService.createNewProposal(proposalDetails);

            return Response.ok().build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removeProposal(@PathParam("id") Long id) {
        try {
            proposalService.removeProposal(id);
            return Response.ok().build();
            
        } catch (Exception e) {
            return Response.serverError().build();

        }
    }
}