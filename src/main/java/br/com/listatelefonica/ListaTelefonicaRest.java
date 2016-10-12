package br.com.listatelefonica;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/listatelefonica")
public class ListaTelefonicaRest {
	
	@GET
	@Path("/contatos/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Contato get(@PathParam("id")Integer id){
		return new ContatoDAO().pesquisar(id);
	}
	
	@GET
	@Path("/contatos")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Contato>getContatos(){
		return new ContatoDAO().pesquisar();
	}
	
	@POST
	@Path("/contatos/salvar")
	@Consumes({MediaType.APPLICATION_JSON})
	public void salvarContato(Contato contato){		
		new ContatoDAO().salvar(contato);
	}
	
	@POST
	@Path("/contatos/remover")
	@Consumes({MediaType.APPLICATION_JSON})
	public void removerContato(List<Contato> contatos){		
		ContatoDAO dao = new ContatoDAO();
		for (Contato contato : contatos) {
			Contato c = dao.pesquisar(contato.getCodigo());
			if(c != null){
				dao.excluir(c);
			}
		}
	}
	
	@GET
	@Path("/operadoras")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Operadora>getOperadoras(){
		return new OperadoraDAO().pesquisar();
	}
	
}
