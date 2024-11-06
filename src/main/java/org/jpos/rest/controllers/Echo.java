package org.jpos.rest.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.jpos.rest.services.contracts.EchoService;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/echo")
@Tag(name = "Echo")
public class Echo {

    @Inject
    private EchoService echoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response echo() {
        return Response.ok(echoService.echo()).build();
    }

}