package br.com.listatelefonica;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
		/*List<Contato> contatos = new ArrayList<Contato>();
		contatos.add(new Contato("pedro da Silva", "9999-9999", new Date(), OperadorasRepositorio.EMBRATEL));
		contatos.add(new Contato("ANA MARIA", "9999-9998", new Date(), OperadorasRepositorio.VIVO));
		contatos.add(new Contato("Maria de jesus", "99999-9991", new Date(), OperadorasRepositorio.OI));
		return contatos;*/
		return new ContatoDAO().pesquisar();
	}
	
	@POST
	@Path("/contatos/salvar")
	@Consumes({MediaType.APPLICATION_JSON})
	public void salvarContato(Contato contato){		
		new ContatoDAO().salvar(contato);
	}
	
	@POST
	@Path("/contatos/removar")
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
