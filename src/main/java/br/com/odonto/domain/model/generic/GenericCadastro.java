package br.com.odonto.domain.model.generic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public class GenericCadastro extends GenericPrimaryKey {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome", length = 50)
	private String nome;
	
	@Column(name = "sobre_nome", length = 100)
	private String sobreNome;
	
	@Column(name = "num_cnpj", length = 20, nullable = true)
	private String cnpj;
	
	@Column(name = "num_cpf", length = 20, nullable = true)
	private String cpf;
	
	@Column(name = "num_rg", length = 20)
	private String rg;
	
	@Column(name = "num_ramal", length = 20)
	private String ramal;
	
	@Column(name = "fone1", length = 50)
	private String fone1;
	
	@Column(name = "fone2", length = 50)
	private String fone2;
	
	@Column(name = "fone3", length = 50)
	private String fone3;
	
	@Column(name = "email1", length = 100)
	@NotBlank(message="O E-mail é obrigatório!")
	@Email//VALIDADOR EMBUTIDO NA CLASSE
	private String email1;
	
	@Column(name = "email2", length = 100)
	private String email2;
	
	@Column(name = "email3", length = 100)
	private String email3;
	
	@Column(name = "dta_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaNascimento;
	
	@Column(name = "dta_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaCadastro;
	
	@Column(name = "sexo", length = 20)
	private String sexo;
	
	@Column(name = "est_civil", length = 50)
	private String estCivil;
	
	@Column(name = "tipo_cadastro", length = 100)
	private String tipo; //Enum FÍSICA OU JURÍDICA.

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public String getFone3() {
		return fone3;
	}

	public void setFone3(String fone3) {
		this.fone3 = fone3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public Date getDtaNascimento() {
		return dtaNascimento;
	}

	public void setDtaNascimento(Date dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}

	public Date getDtaCadastro() {
		return dtaCadastro;
	}

	public void setDtaCadastro(Date dtaCadastro) {
		this.dtaCadastro = dtaCadastro;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dtaCadastro == null) ? 0 : dtaCadastro.hashCode());
		result = prime * result + ((dtaNascimento == null) ? 0 : dtaNascimento.hashCode());
		result = prime * result + ((email1 == null) ? 0 : email1.hashCode());
		result = prime * result + ((email2 == null) ? 0 : email2.hashCode());
		result = prime * result + ((email3 == null) ? 0 : email3.hashCode());
		result = prime * result + ((estCivil == null) ? 0 : estCivil.hashCode());
		result = prime * result + ((fone1 == null) ? 0 : fone1.hashCode());
		result = prime * result + ((fone2 == null) ? 0 : fone2.hashCode());
		result = prime * result + ((fone3 == null) ? 0 : fone3.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((sobreNome == null) ? 0 : sobreNome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		GenericCadastro other = (GenericCadastro) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dtaCadastro == null) {
			if (other.dtaCadastro != null)
				return false;
		} else if (!dtaCadastro.equals(other.dtaCadastro))
			return false;
		if (dtaNascimento == null) {
			if (other.dtaNascimento != null)
				return false;
		} else if (!dtaNascimento.equals(other.dtaNascimento))
			return false;
		if (email1 == null) {
			if (other.email1 != null)
				return false;
		} else if (!email1.equals(other.email1))
			return false;
		if (email2 == null) {
			if (other.email2 != null)
				return false;
		} else if (!email2.equals(other.email2))
			return false;
		if (email3 == null) {
			if (other.email3 != null)
				return false;
		} else if (!email3.equals(other.email3))
			return false;
		if (estCivil == null) {
			if (other.estCivil != null)
				return false;
		} else if (!estCivil.equals(other.estCivil))
			return false;
		if (fone1 == null) {
			if (other.fone1 != null)
				return false;
		} else if (!fone1.equals(other.fone1))
			return false;
		if (fone2 == null) {
			if (other.fone2 != null)
				return false;
		} else if (!fone2.equals(other.fone2))
			return false;
		if (fone3 == null) {
			if (other.fone3 != null)
				return false;
		} else if (!fone3.equals(other.fone3))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ramal == null) {
			if (other.ramal != null)
				return false;
		} else if (!ramal.equals(other.ramal))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (sobreNome == null) {
			if (other.sobreNome != null)
				return false;
		} else if (!sobreNome.equals(other.sobreNome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GenericCadastro [nome=" + nome + ", sobreNome=" + sobreNome + ", cnpj=" + cnpj + ", cpf=" + cpf
				+ ", rg=" + rg + ", ramal=" + ramal + ", fone1=" + fone1 + ", fone2=" + fone2 + ", fone3=" + fone3
				+ ", email1=" + email1 + ", email2=" + email2 + ", email3=" + email3 + ", dtaNascimento="
				+ dtaNascimento + ", dtaCadastro=" + dtaCadastro + ", sexo=" + sexo + ", estCivil=" + estCivil
				+ ", tipo=" + tipo + "]";
	}

}
