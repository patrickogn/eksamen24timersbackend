package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ConferenceDTO;
import entities.Conference;
import facades.ConferenceFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/conf")
public class ConferenceResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final ConferenceFacade FACADE =  ConferenceFacade.getConferenceFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<ConferenceDTO> rns = FACADE.getAllConferences();
        return Response.ok().entity(GSON.toJson(rns)).build();
    }
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCoferenceTalks(@PathParam("id") int id) {
        List<ConferenceDTO> rns = FACADE.getConferenceTalks(id);
        return GSON.toJson(rns);
    }






    @POST
    @Path("createconf")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes ({MediaType.APPLICATION_JSON})
//    @RolesAllowed("user")

    public String createConference(String conference) {
        ConferenceDTO cf = GSON.fromJson(conference, ConferenceDTO.class);
        ConferenceDTO cNew = FACADE.createConference(cf.getId(), cf.getName(), cf.getLocation(), cf.getCapacity(), cf.getDate(), cf.getTime());
        return GSON.toJson(cNew);
    }
}