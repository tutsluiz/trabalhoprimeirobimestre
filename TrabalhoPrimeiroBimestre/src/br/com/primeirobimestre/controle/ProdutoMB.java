package br.com.primeirobimestre.controle;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import br.com.primeirobimestre.modelo.CRUD;
import br.com.primeirobimestre.modelo.Produto;

@ManagedBean
@SessionScoped
public class ProdutoMB {
	
	
	private Produto produto = new Produto();
	private DataModel<Produto> listarProdutos;
	
      /* 
    public ProdutoMB() {
    	this.setProdutos(new ArrayList<Produto>());;
    	this.setProduto(new Produto());
    	}
	*/
   

	public void Salvar(){
		try {
			CRUD.inserir(produto);
			System.out.println("Produto Salvo!");
			this.setNome("");
			this.setDescricao("");
			this.setQuantidade(0);
			this.setValor(0.0);
			System.out.println("Campos do Formulario limpos!");
		} catch (Exception e) {
			System.out.println("ERRO AO CHAMAR O METODO SALVAR NO BEAN PRODUTO");
			e.printStackTrace();
		}
	}
	
	public void EditarQuantidade() {
		Produto prodTemp = (Produto)(listarProdutos.getRowData());
		System.out.println("Altera quantidade do Produto"+getNome()+"com o ID: " + prodTemp.getId());
		System.out.println("Quantidade anterior"+getQuantidade());
		prodTemp.setQuantidade(produto.getQuantidade());
		CRUD.atualizarQuantidade(prodTemp.getId(), prodTemp.getQuantidade());
		produto.setQuantidade(0);
	}
	
	public void ExcluirProduto() {
		Produto prodTemp = (Produto)(listarProdutos.getRowData());
		System.out.println("Remove Produto"+getNome()+"com o ID: " + prodTemp.getId());
		CRUD.remover(prodTemp.getId());		
	}
	

	public DataModel<Produto> getListarTodos() {	
		List<Produto> produtos = new CRUD().listar();
		listarProdutos = new ListDataModel<Produto>(produtos);
		System.out.println("INICIO LISTANDO TODOS");
		return listarProdutos;
		
	}
	
	

		
	public String getId() {
		return String.valueOf(produto.getId());
	}
	public void setId(String id) {
		produto.setId(Integer.parseInt(id));;
	}
	public String getNome() {
		return produto.getNome();
	}
	public void setNome(String nome) {
		produto.setNome(nome);;
	}
	public int getQuantidade() {
		return produto.getQuantidade();
	}
	public void setQuantidade(int quantidade) {
		produto.setQuantidade(quantidade);;
	}
	public String getDescricao() {
		return produto.getDescricao();
	}
	public void setDescricao(String descricao) {
		produto.setDescricao(descricao);
	}
	public double getValor() {
		return produto.getValor();
	}
	public void setValor(double valor) {
		produto.setValor(valor);
	}
	
	/*
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
*/	

}
