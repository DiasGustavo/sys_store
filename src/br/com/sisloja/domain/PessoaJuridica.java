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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;





@Entity
@Table(name = "pessoaJuridica")
@NamedQueries({
	@NamedQuery(name = "PessoaJuridica.listar", query = "SELECT pjuridica FROM PessoaJuridica pjuridica"),
	@NamedQuery(name =  "PessoaJuridica.buscarPorCodigo", query = "SELECT pjuridica FROM PessoaJuridica pjuridica WHERE pjuridica.id = :id")
})
public class PessoaJuridica {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpessoa")
	private Long id;
	
	@CNPJ(message="O campo CNPJ é obrigatório. ")
	@Column(name = "cnpj", length = 18, nullable = false)
	private String cnpj;
	
	@NotEmpty(message="O campo Razão Social é obrigatório")
	@Size(min = 5, max = 50 , message="O campo Razão Social deve ter entre 5 e 50 caracteres")
	@Column(name = "razaoSocial", length = 50, nullable = false)
	private String razaoSocial;
	
	@NotEmpty(message="O campo Nome Fantasia é obrigatório")
	@Size(min = 5, max = 50 , message="O campo Nome Fantasia deve ter entre 5 e 50 caracteres")
	@Column(name = "nomeFantasia", length = 50, nullable = false)
	private String nomeFantazia;
	
	@NotNull(message="O campo Pessoa é obrigatório")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_idpessoa", referencedColumnName = "idpessoa", nullable = false)
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomeFantazia() {
		return nomeFantazia;
	}

	public void setNomeFantazia(String nomeFantazia) {
		this.nomeFantazia = nomeFantazia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [id=" + id + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", pessoa=" + pessoa
				+ "]";
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
		PessoaJuridica other = (PessoaJuridica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
