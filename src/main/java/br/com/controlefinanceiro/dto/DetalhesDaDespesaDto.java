package br.com.controlefinanceiro.dto;

import br.com.controlefinanceiro.modelo.Categoria;
import br.com.controlefinanceiro.modelo.Despesa;

public class DetalhesDaDespesaDto {

	private String descricao;
	private double valor;
	private Integer data;
	private Categoria categoria;
	
	public DetalhesDaDespesaDto() {
	}
	
	public DetalhesDaDespesaDto(Despesa despesa) {
		this.descricao = despesa.getDescricao();
		this.valor = despesa.getValor();
		this.data = despesa.getData();
		this.categoria = despesa.getCategoria();
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
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
}
