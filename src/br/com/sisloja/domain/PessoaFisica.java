package br.com.sisloja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table (name = "pessoaFisica")
@NamedQueries({
	@NamedQuery(name = "PessoaFisica.listar", query = "SELECT pfisica FROM PessoaFisica pfisica"),
	@NamedQuery(name = "PessoaFisica.buscarPorCodigo", query = "SELECT pfisica FROM PessoaFisica pfisica WHERE pfisica.id = :id")
})
public class PessoaFisica {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "idpf")
	private Long id;
	
	@NotEmpty(message="O Campo CPF é obrigatório.")
	@CPF(message="O CPF informado é inválido.")
	@Column (name = "cpf", length = 14, nullable = false)
	private String cpf;
	
	@NotEmpty(message="O Campo RG é obrigatório.")
	@Column (name = "rg", length = 12, nullable = false)
	private String rg;
	
	@NotNull(message="O campo Pessoa é obrigatório")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "pessoa_idpessoa", referencedColumnName = "idpessoa", nullable = false)
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "PessoaFisica [id=" + id + ", cpf=" + cpf + ", pessoa=" + pessoa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
