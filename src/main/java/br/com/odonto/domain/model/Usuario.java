package br.com.odonto.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.odonto.domain.model.generic.GenericCadastro;

@Entity
public class Usuario extends GenericCadastro {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "current_password", length = 64)
	private String password;
	
	@Column(name = "role", length = 45)
	private String role;//NÍVEL DE ACESSO
	
	@Column(name = "user_enable", length = 45)
	private Short enabled;//ATIVO OU INATIVO
	
	@Column(name = "dta_last_change")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtaLastChange;//DATA DA ULTIMA ALTERAÇÃO
	
	@Column(name = "last_password", length = 64)
	private String lastPassword;//ULTIMA SENHA CRIADA

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Short getEnabled() {
		return enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}

	public Date getDtaLastChange() {
		return dtaLastChange;
	}

	public void setDtaLastChange(Date dtaLastChange) {
		this.dtaLastChange = dtaLastChange;
	}

	public String getLastPassword() {
		return lastPassword;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dtaLastChange == null) ? 0 : dtaLastChange.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((lastPassword == null) ? 0 : lastPassword.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Usuario other = (Usuario) obj;
		if (dtaLastChange == null) {
			if (other.dtaLastChange != null)
				return false;
		} else if (!dtaLastChange.equals(other.dtaLastChange))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (lastPassword == null) {
			if (other.lastPassword != null)
				return false;
		} else if (!lastPassword.equals(other.lastPassword))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}


}
