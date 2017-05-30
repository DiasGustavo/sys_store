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

@Entity
@Table (name = "fornecedor")
@NamedQueries({
	@NamedQuery(name = "Fornecedor.listar", query = "SELECT fornecedor FROM Fornecedor fornecedor"),
	@NamedQuery(name = "Fornecedor.buscarPorCodigo", query = "SELECT fornecedor FROM Fornecedor fornecedor WHERE fornecedor.id = :id")
})
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idfornecedor")
	private Long id;
	
	@NotEmpty(message="O campo insc Municipal é obrigatório")
	@Size(min = 5, max = 45 , message="O campo Nome deve ter entre 5 e 45 caracteres")
	@Column(name = "insc_munic", length = 45, nullable = false)
	private String insMunicipal;
	
	@NotEmpty(message="O campo insc Estadual é obrigatório")
	@Size(min = 5, max = 45 , message="O campo Nome deve ter entre 5 e 45 caracteres")
	@Column(name = "insc_estad", length = 45, nullable = false)
	private String insEstadual;
	
	@NotNull(message="O campo Pessoa Jurídica é obrigatório")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoaJuridica_idpessoa", referencedColumnName = "idpessoa")
	private PessoaJuridica pj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInsMunicipal() {
		return insMunicipal;
	}

	public void setInsMunicipal(String insMunicipal) {
		this.insMunicipal = insMunicipal;
	}

	public String getInsEstadual() {
		return insEstadual;
	}

	public void setInsEstadual(String insEstadual) {
		this.insEstadual = insEstadual;
	}

	public PessoaJuridica getPj() {
		return pj;
	}

	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", insMunicipal=" + insMunicipal + ", insEstadual=" + insEstadual + ", pj=" + pj
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
