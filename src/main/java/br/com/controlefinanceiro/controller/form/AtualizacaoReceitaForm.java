package br.com.controlefinanceiro.controller.form;

import br.com.controlefinanceiro.modelo.Receita;
import br.com.controlefinanceiro.repository.ReceitaRepository;

public class AtualizacaoReceitaForm {
	
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
	
	public Receita atualizar(long id, ReceitaRepository receitaRepository) {		
		Receita receita = receitaRepository.getReferenceById(id);
		receita.setDescricao(this.descricao);
		receita.setValor(this.valor);
		receita.setData(this.data);
		return receita;
	}	
}
