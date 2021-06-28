/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.idrugapi.idrug.api.farmacia;

import br.com.idrugapi.idrug.api.usuarios.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author brayanbertan
 */
@Stateless
@Path("farmacias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FarmaciaResouce {
    @PersistenceContext(unitName = "IdrugPU")
    EntityManager entityManager;
    
    @GET
    public List<Farmacia> getFarmacia() {
        return entityManager
                .createQuery("SELECT f FROM Farmacia f", Farmacia.class)
                .getResultList();
    }
    
    @POST
    public Response addFarmacia(Farmacia alunos) {
        entityManager.persist(alunos);
        return Response
                .status(Response.Status.CREATED)
                .entity(alunos)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Farmacia getFarmacia(@PathParam("id") Integer id) {
        return entityManager.find(Farmacia.class, id);
    }

    @DELETE
    @Path("{id}")
    public void removeFarmacia(@PathParam("id") Integer id) {
        Farmacia alunoEncontrado = entityManager.find(Farmacia.class, id);
        entityManager.remove(alunoEncontrado);
    }

    @PUT
    @Path("{id}")
    public Farmacia updateFarmacia(@PathParam("id") Integer id, Farmacia farmacia) {
        farmacia.setId(id);
        entityManager.merge(farmacia);
        return farmacia;
    } 
}
