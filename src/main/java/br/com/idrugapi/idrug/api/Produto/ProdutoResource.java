/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.idrugapi.idrug.api.Produto;


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
@Path("produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {
     @PersistenceContext(unitName = "IdrugPU")
    EntityManager entityManager;
    
    @GET
    public List<Produto> getProduto() {
        return entityManager
                .createQuery("SELECT c FROM Produto c", Produto.class)
                .getResultList();
    }
    
    @POST
    public Response addProduto(Produto alunos) {
        entityManager.persist(alunos);
        return Response
                .status(Response.Status.CREATED)
                .entity(alunos)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Produto getProduto(@PathParam("id") Integer id) {
        return entityManager.find(Produto.class, id);
    }

    @DELETE
    @Path("{id}")
    public void removeProduto(@PathParam("id") Integer id) {
        Produto alunoEncontrado = entityManager.find(Produto.class, id);
        entityManager.remove(alunoEncontrado);
    }

    @PUT
    @Path("{id}")
    public Produto updateProduto(@PathParam("id") Integer id, Produto produto) {
        produto.setId(id);
        entityManager.merge(produto);
        return produto;
    } 
}
