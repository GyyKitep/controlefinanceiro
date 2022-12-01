package br.com.controlefinanceiro.controller.form;

import br.com.controlefinanceiro.modelo.Despesa;
import br.com.controlefinanceiro.repository.DespesaRepository;

public class DespesaForm {
	
	private String descricao;
	private double valor;
	private Integer data;
	
	public DespesaForm() {
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

	public Despesa converter(DespesaRepository despesaRepository) {		
		return new Despesa(this.descricao, this.valor, this.data);
	}

}
