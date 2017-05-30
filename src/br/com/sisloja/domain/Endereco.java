package br.com.sisloja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "endereco")
@NamedQueries({ @NamedQuery(name = "Endereco.listar", query = "SELECT endereco FROM Endereco endereco"),
		@NamedQuery(name = "Endereco.buscarPorCodigo", query = "SELECT endereco FROM Endereco endereco WHERE endereco.id = :id") })
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idendereco")
	private Long id;

	@NotEmpty(message = "O campo Logradouro é obrigatório")
	@Size(min = 5, max = 50, message = "O campo Logradouro deve ter entre 5 e 50 caracteres")
	@Column(name = "logradouro", length = 50, nullable = false)
	private String logradouro;

	@Column(name = "complemento", length = 50)
	private String complemento;

	@Column(name = "numero")
	private Integer numero;

	@NotEmpty(message = "O campo Bairro é obrigatório")
	@Size(min = 5, max = 50, message = "O campo Bairro deve ter entre 5 e 50 caracteres")
	@Column(name = "bairro", length = 50)
	private String bairro;

	@NotEmpty(message = "O campo Cidade é obrigatório")
	@Size(min = 5, max = 50, message = "O campo Cidade deve ter entre 5 e 50 caracteres")
	@Column(name = "cidade", length = 50, nullable = false)
	private String cidade;

	@NotEmpty(message = "O campo Estado é obrigatório")
	@Size(min = 5, max = 50, message = "O campo Estado deve ter entre 5 e 50 caracteres")
	@Column(name = "estado", length = 50, nullable = false)
	private String estado;

	@NotEmpty(message = "O campo CEP é obrigatório")
	@Size(min = 9, max = 9, message = "O campo CEP deve ter 9 caracteres")
	@Column(name = "cep", length = 9)
	private String cep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return " logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
