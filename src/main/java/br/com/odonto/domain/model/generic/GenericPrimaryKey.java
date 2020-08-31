package br.com.odonto.domain.model.generic;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//CLASSE CRIADA PARA SER HERDADA PELAS OUTRAS MODEL E PADRONIZAR OS PK / ID
@MappedSuperclass
public class GenericPrimaryKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericPrimaryKey other = (GenericPrimaryKey) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		
		//CRIADO AUTOMATICAMENTE DA IDE
		//return "GenericPrimaryKey [codigo=" + codigo + "]";
		
		//Usado no OminiFaces para o SelectOneMenu... COPIADO DO PROJETO ODONTO ORIGINAL QUE USAVA PRIMEFACES 
		return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
	}

}
