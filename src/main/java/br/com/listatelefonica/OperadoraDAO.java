package br.com.listatelefonica;

import java.util.List;

import com.mysema.query.jpa.impl.JPAQuery;

public class OperadoraDAO extends GenericDAO<Operadora>{

	public OperadoraDAO() {
		super(Operadora.class, "listatelefonica");
	}
	
	@Override
	public List<Operadora> pesquisar() {
		QOperadora operadora = QOperadora.operadora;
		JPAQuery query = new JPAQuery(getEntityManager());
		
		List<Operadora> operadoras = query.from(operadora).where(operadora.categoria.equalsIgnoreCase("fixo")).list(operadora);
		
		return operadoras;
	}

}
