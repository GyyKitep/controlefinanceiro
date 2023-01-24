package br.com.controlefinanceiro.controller.form;

import java.time.LocalDate;

import br.com.controlefinanceiro.modelo.Receita;
import br.com.controlefinanceiro.repository.ReceitaRepository;

public class ReceitaForm {

	private String descricao;
	private double valor;
	private LocalDate data;

	public ReceitaForm() {
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Receita converter(ReceitaRepository receitaRepository) {
		return new Receita(this.descricao, this.valor, this.data);
	}	
	
}
