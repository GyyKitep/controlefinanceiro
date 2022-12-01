package br.com.controlefinanceiro.controller.form;

import br.com.controlefinanceiro.modelo.Despesa;
import br.com.controlefinanceiro.repository.DespesaRepository;

public class AtualizacaoDespesaForm {
	
	
	private String descricao;
	private double valor;
	private Integer data;
	
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
	public Despesa atualizar(long id, DespesaRepository despesaRepository) {		
		Despesa despesa = despesaRepository.getReferenceById(id);
		despesa.setDescricao(this.descricao);
		despesa.setValor(this.valor);
		despesa.setData(this.data);
		return despesa;
	}
	
	
}
