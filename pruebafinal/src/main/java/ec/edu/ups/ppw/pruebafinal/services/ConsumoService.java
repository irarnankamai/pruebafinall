package ec.edu.ups.ppw.pruebafinal.services;

import java.util.List;

import ec.edu.ups.ppw.pruebafinal.business.ConsumoGestion;
import ec.edu.ups.ppw.pruebafinal.model.Consumo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/consumo")
public class ConsumoService {

    @Inject
    private ConsumoGestion gConsumo;

    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Consumo consumo) {
        try {
            gConsumo.createConsumo(consumo);
            return Response.ok(consumo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en DB")).build();
        }
    }

    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Consumo consumo) {
        try {
            gConsumo.updateConsumo(consumo);
            return Response.ok(consumo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }

    @DELETE
    @Produces("application/json")
    public Response delete(@QueryParam("id") int id) {
        try {
            gConsumo.deleteConsumo(id);
            return Response.ok(new Respuesta(Respuesta.OK, "Consumo eliminado correctamente")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR,"Error en DB" )).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Consumo get(@QueryParam("id") int id) {
        Consumo consumo;
        try {
            consumo = gConsumo.getConsumo(id);
            return consumo;
        } catch(Exception e) {
            e.printStackTrace();
            return null;  
        }
    }

    @GET
    @Produces("application/json")
    public List<Consumo> list() {
        List<Consumo> consumos = gConsumo.getConsumos();
        return consumos;
    }
    
}
