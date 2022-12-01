package br.com.controlefinanceiro.dto;

import br.com.controlefinanceiro.modelo.Receita;

public class DetalhesDaReceitaDto {

	private String descricao;
	private double valor;
	private Integer data;
	
	public DetalhesDaReceitaDto() {
	}
	
	public DetalhesDaReceitaDto(Receita receita) {
		this.descricao = receita.getDescricao();
		this.valor = receita.getValor();
		this.data = receita.getData();
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
}
