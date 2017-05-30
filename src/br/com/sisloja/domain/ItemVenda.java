package br.com.sisloja.domain;

import java.math.BigDecimal;

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

@Entity
@Table(name = "item_venda")
@NamedQueries({
	@NamedQuery(name = "ItemVenda.listar", query = "SELECT item FROM ItemVenda item"),
	@NamedQuery(name = "ItemVenda.buscarPorCodigo", query = "SELECT item FROM ItemVenda item WHERE item.id = :id")
})
public class ItemVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iditem_venda")
	private Long id;
			
	@Column(name = "descricao", length = 45)
	private String descricao;
	
	@Column(name = "valor_unitario", precision = 7, scale = 2, nullable = false)
	private BigDecimal valorUnitario;
	
	@Column(name = "qtde", nullable = false)
	private Integer quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "venda_idvenda", referencedColumnName = "idvenda")
	private Venda venda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_idproduto", referencedColumnName = "idproduto")
	private Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", descricao=" + descricao
				+ ", valorUnitario=" + valorUnitario + ", quantidade=" + quantidade + ", venda=" + venda + ", produto="
				+ produto + "]";
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
		ItemVenda other = (ItemVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
