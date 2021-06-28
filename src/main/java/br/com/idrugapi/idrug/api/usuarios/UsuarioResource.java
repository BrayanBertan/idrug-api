/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.idrugapi.idrug.api.usuarios;

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
@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @PersistenceContext(unitName = "IdrugPU")
    EntityManager entityManager;
    
    @GET
    public List<Usuario> getUsuario() {
        return entityManager
                .createQuery("SELECT c FROM Usuario c", Usuario.class)
                .getResultList();
    }
    
    @POST
    public Response addUsuario(Usuario usuario) {
        entityManager.persist(usuario);
        return Response
                .status(Response.Status.CREATED)
                .entity(usuario)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Usuario getUsuario(@PathParam("id") Integer id) {
        return entityManager.find(Usuario.class, id);
    }

    @DELETE
    @Path("{id}")
    public void removeUsuario(@PathParam("id") Integer id) {
        Usuario alunoEncontrado = entityManager.find(Usuario.class, id);
        entityManager.remove(alunoEncontrado);
    }

    @PUT
    @Path("{id}")
    public Usuario updateUsuario(@PathParam("id") Integer id, Usuario usuario) {
        usuario.setId(id);
        entityManager.merge(usuario);
        return usuario;
    } 
}
