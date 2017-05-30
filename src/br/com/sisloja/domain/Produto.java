package br.com.sisloja.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="produto")
@NamedQueries({
	@NamedQuery(name = "Produto.listar", query = "SELECT produto FROM Produto produto" ),
	@NamedQuery(name = "Produto.buscarPorCodigo", query = "SELECT produto FROM Produto produto WHERE produto.id = :id")
})
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idproduto")
	private Long id;
	@NotEmpty(message="Campo Nome obrigatório.")
	@Size(min = 5, max = 50 , message="O campo Nome deve ter entre 5 e 50 caracteres")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@NotEmpty(message="Campo Validade obrigatório.")
	@Size(min = 5, max = 50 , message="O campo validade deve ter entre 5 e 50 caracteres no formato 12/12/1900")
	@Column(name = "validade", length = 50)
	private String validade;
	
	@NotNull(message="Preço do Custo é obrigatorio.")
	@DecimalMin(value="0.00", message="o campo preço custo deve ser maior do que 0.00")
	@DecimalMax(value="99999.99", message="o campo preço custo deve ser menor do que 100 mil.")
	@Digits(integer = 5, fraction = 2, message = "coloque um preço válido para o preço custo")
	@Column (name = "preco_custo", precision = 7, scale = 2, nullable = false)
	private BigDecimal precoCusto;
	
	@NotNull(message="Preço de Venda é obrigatorio.")
	@DecimalMin(value="0.00", message="o campo preço venda deve ser maior do que 0.00")
	@DecimalMax(value="99999.99", message="o campo preço venda deve ser menor do que 100 mil.")
	@Digits(integer = 5, fraction = 2, message = "coloque um preço válido para o preço de venda")
	@Column (name = "preco_venda", precision = 7, scale = 2, nullable = false)
	private BigDecimal precoVenda;
	
	@NotNull(message="A quantidade de reposição é obrigatório.")
	@Min(value=0, message="O campo de reposição deve ser maior do que 0")
	@Max(value=10000, message="O campo de reposição deve ser menor do 10 mil")
	@Column(name = "valor_reposicao", nullable = false)
	private Integer valorReposicao;
	
	@Column(name = "localizacao", length = 45)
	private String localizacao;
	
	@NotNull(message="A quantidade é obrigatório.")
	@Min(value=0, message="O campo de quantidade deve ser maior do que 0")
	@Max(value=10000, message="O campo de quantidade deve ser menor do 10 mil")
	@Column (name = "qtde", nullable = false)
	private Integer quantidade;
	
	@NotEmpty(message="Campo Código de barra é obrigatório.")
	@Size(min = 5, max = 50 , message="O campo Código de barra deve ter entre 5 e 45 caracteres.")
	@Column(name = "codigo_barra", length = 45, nullable = false)
	private String codigoBarra;

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

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getValorReposicao() {
		return valorReposicao;
	}

	public void setValorReposicao(Integer valorReposicao) {
		this.valorReposicao = valorReposicao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", validade=" + validade + ", precoCusto=" + precoCusto
				+ ", precoVenda=" + precoVenda + ", valorReposicao=" + valorReposicao + ", localizacao=" + localizacao
				+ ", quantidade=" + quantidade + ", codigoBarra=" + codigoBarra + "]";
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
