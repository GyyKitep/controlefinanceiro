package br.com.controlefinanceiro.controller.form;

import java.time.LocalDate;

import br.com.controlefinanceiro.modelo.Receita;
import br.com.controlefinanceiro.repository.ReceitaRepository;

public class AtualizacaoReceitaForm {
	
	private String descricao;
	private double valor;
	private LocalDate data;
	
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
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
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
