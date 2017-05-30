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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "funcionario")
@NamedQueries({
	@NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),
	@NamedQuery(name = "Funcionario.buscarPorCodigo", query="SELECT funcionario FROM Funcionario funcionario WHERE funcionario.id = :id"),
	@NamedQuery(name = "Funcionario.autenticar", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.login = :login AND funcionario.senha = :senha")
})
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idfuncionario")
	private Long id;
	
	@NotEmpty(message="O login é campo obrigatório.")
	@Size(min = 5, max = 50 , message="O campo login deve ter entre 5 e 50 caracteres")
	@Column(name = "login", length = 50, nullable = false)
	private String login;
	
	@NotEmpty(message="A senha é um campo obrigatório.")
	@Size(min = 6, max = 32 , message="O campo Senha deve ter entre 6 e 32 caracteres")
	@Column(name = "senha", length = 32, nullable = false)
	private String senha;
	
	@NotEmpty(message="O campo função é um campo obrigatório.")
	@Column(name = "funcao", length = 50, nullable = false)
	private String funcao;
	
	@NotNull(message="O campo Pessoa Física é obrigatório")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_fisica_idpf", referencedColumnName = "idpf", nullable = false)
	private PessoaFisica pf;
	
	@NotNull(message="O campo Estabelecimento é obrigatório")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estabelecimento_idestabelecimento", referencedColumnName = "idestabelecimento", nullable = false)
	private Estabelecimento estabelecimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public PessoaFisica getPf() {
		return pf;
	}

	public void setPf(PessoaFisica pf) {
		this.pf = pf;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", login=" + login + ", senha=" + senha + ", funcao=" + funcao + ", pf=" + pf
				+ ", estabelecimento=" + estabelecimento + "]";
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
