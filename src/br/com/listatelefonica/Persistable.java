package br.com.listatelefonica;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@MappedSuperclass
public abstract class Persistable implements Serializable {				
	
	private static final long serialVersionUID = 1L;
	
	//comentario2
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Integer codigo;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


}
