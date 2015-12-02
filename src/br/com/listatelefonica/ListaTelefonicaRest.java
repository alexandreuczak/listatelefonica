package br.com.listatelefonica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/listatelefonica")
public class ListaTelefonicaRest {

	
	
	public Contato get(Integer id){
		return new Contato("Pedro", "9999-9999", new Date(), OperadorasRepositorio.EMBRATEL);
	}
	
	@GET
	@Path("/contatos")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Contato>getContatos(){
		List<Contato> contatos = new ArrayList<Contato>();
		contatos.add(new Contato("pedro da Silva", "9999-9999", new Date(), OperadorasRepositorio.EMBRATEL));
		contatos.add(new Contato("ANA MARIA", "9999-9998", new Date(), OperadorasRepositorio.VIVO));
		contatos.add(new Contato("Maria de jesus", "99999-9991", new Date(), OperadorasRepositorio.OI));
		return contatos;
	}
	
	@GET
	@Path("/operadoras")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Operadora>getOperadoras(){
		return OperadorasRepositorio.getOperadoras();
	}
	
}
