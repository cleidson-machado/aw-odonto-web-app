package br.com.odonto.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.odonto.domain.model.generic.GenericCadastro;

@Entity
public class Contratante extends GenericCadastro {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "camada_funcional", length = 10)
	private String camada;
	
	@Column(name = "registro_nativo", length = 20)
	private String nativo;
	
	@Column(name = "dta_muda_camada")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaMudaCamada;
	
	@Column(name = "contratante_status", length = 60)
	private String contratanteStatus; //Vai receber os Valores de um Enum vinculado ao OneSelection

	public String getCamada() {
		return camada;
	}

	public void setCamada(String camada) {
		this.camada = camada;
	}

	public String getNativo() {
		return nativo;
	}

	public void setNativo(String nativo) {
		this.nativo = nativo;
	}

	public Date getDtaMudaCamada() {
		return dtaMudaCamada;
	}

	public void setDtaMudaCamada(Date dtaMudaCamada) {
		this.dtaMudaCamada = dtaMudaCamada;
	}

	public String getContratanteStatus() {
		return contratanteStatus;
	}

	public void setContratanteStatus(String contratanteStatus) {
		this.contratanteStatus = contratanteStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((camada == null) ? 0 : camada.hashCode());
		result = prime * result + ((contratanteStatus == null) ? 0 : contratanteStatus.hashCode());
		result = prime * result + ((dtaMudaCamada == null) ? 0 : dtaMudaCamada.hashCode());
		result = prime * result + ((nativo == null) ? 0 : nativo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contratante other = (Contratante) obj;
		if (camada == null) {
			if (other.camada != null)
				return false;
		} else if (!camada.equals(other.camada))
			return false;
		if (contratanteStatus == null) {
			if (other.contratanteStatus != null)
				return false;
		} else if (!contratanteStatus.equals(other.contratanteStatus))
			return false;
		if (dtaMudaCamada == null) {
			if (other.dtaMudaCamada != null)
				return false;
		} else if (!dtaMudaCamada.equals(other.dtaMudaCamada))
			return false;
		if (nativo == null) {
			if (other.nativo != null)
				return false;
		} else if (!nativo.equals(other.nativo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contratante [camada=" + camada + ", nativo=" + nativo + ", dtaMudaCamada=" + dtaMudaCamada
				+ ", contratanteStatus=" + contratanteStatus + "]";
	}

}
