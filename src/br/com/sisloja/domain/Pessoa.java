package br.com.sisloja.domain;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="pessoa")
@NamedQueries({
	@NamedQuery(name = "Pessoa.listar", query = "SELECT pessoa FROM Pessoa pessoa"),
	@NamedQuery(name = "Pessoa.buscarPorCodigo", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.id = :id")
})
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idpessoa")
	private Long id;
	
	@NotEmpty(message="O campo Nome é obrigatório")
	@Size(min = 5, max = 50 , message="O campo Nome deve ter entre 5 e 50 caracteres")
	@Column(name = "nome", length = 50, nullable = false )
	private String nome;
	
	@NotEmpty(message="O campo Telefone é obrigatório")
	@Size(min = 5, max = 50 , message="O campo Telefone deve ter entre 1 e 14 caracteres")
	@Column(name = "telefone", length = 14, nullable = false )
	private String telefone;
	
	@NotEmpty(message="O campo Email é obrigatório")
	@Size(min = 5, max = 50 , message="O campo Email deve ter entre 5 e 50 caracteres")
	@Column(name = "email", length = 50, nullable = false )
	private String email;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "dt_nascimento", nullable = false)
	private Date dataNascimento;
	
	@NotEmpty(message="O campo sexo é um campo obrigatório.")
	@Column(name = "sexo", length = 50, nullable = false)
	private String sexo;
	
	@NotEmpty(message="O campo status é um campo obrigatório.")
	@Column(name = "status", length = 2, nullable = false)
	private String status;
	
	@NotNull(message="O campo Endereço é obrigatório")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "endereco_idendereco", referencedColumnName = "idendereco", nullable = false)	
	private Endereco endereco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco="
				+ endereco + "]";
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
}
