package br.com.controlefinanceiro.controller.form;

import java.time.LocalDate;
import java.util.Optional;

import br.com.controlefinanceiro.modelo.Categoria;
import br.com.controlefinanceiro.modelo.Despesa;
import br.com.controlefinanceiro.repository.CategoriaRepository;
import br.com.controlefinanceiro.repository.DespesaRepository;

public class AtualizacaoDespesaForm {
	
	
	private String descricao;
	private double valor;
	private LocalDate data;
	private String categoria;
	
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
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Despesa atualizar(long id, DespesaRepository despesaRepository, CategoriaRepository categoriaRepository) {		
		
		if(this.categoria == null) {
			this.categoria = "Outras";
		}
		
		Optional<Categoria> categoria = categoriaRepository.findByDescricao(this.categoria);		

		if  (!categoria.isPresent()) {
			return null;
		}		

		Despesa despesa = despesaRepository.getReferenceById(id);
		despesa.setDescricao(this.descricao);
		despesa.setValor(this.valor);
		despesa.setData(this.data);
		despesa.setCategoria(categoria.get());

		return despesa;
	}
	
	
}
