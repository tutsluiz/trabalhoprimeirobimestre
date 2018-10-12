package br.com.primeirobimestre.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable{
	
	
	//Classe POJO contem os atributos - Getters e Setters
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private int quantidade;
	@Column
	private double valor;
	
	

	public Produto() {
	}
	
	
	
	
	public Produto(int id, String nome, String descricao, int quantidade, double valor) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}
    


	//Getters e Setters gerados automaticamente
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	

}
