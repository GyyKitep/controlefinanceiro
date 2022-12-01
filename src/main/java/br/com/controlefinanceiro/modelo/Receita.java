package br.com.controlefinanceiro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;
	private double valor;
	private Integer data;
	
	public Receita() {
	}
	
	public Receita(String descricao, double valor, Integer data) {
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	
	
	
}
