package br.com.sisloja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "estabelecimento")
@NamedQueries({
	@NamedQuery(name = "Estabelecimento.listar", query = "SELECT estabelecimento FROM Estabelecimento estabelecimento"),
	@NamedQuery(name = "Estabelecimento.buscarPorCodigo", query = "SELECT estabelecimento FROM Estabelecimento estabelecimento WHERE estabelecimento.id = :id")})
public class Estabelecimento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idestabelecimento")
	private Long id;
	
	@NotEmpty(message="O campo atividade é obrigatório")
	@Size(min = 5, max = 50 , message="O campo atividade deve ter entre 5 e 50 caracteres")
	@Column(name = "atividade", length = 50, nullable = false)
	private String atividade;
	
	@NotNull(message="O campo Pessoa Jurídica é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoaJuridica_idpessoa", referencedColumnName = "idpessoa", nullable = false)
	private PessoaJuridica pj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public PessoaJuridica getPj() {
		return pj;
	}

	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}

	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", atividade=" + atividade + ", pj=" + pj + "]";
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
		Estabelecimento other = (Estabelecimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
