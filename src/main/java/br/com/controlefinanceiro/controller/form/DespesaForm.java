package br.com.controlefinanceiro.controller.form;

import java.util.Optional;

import br.com.controlefinanceiro.modelo.Categoria;
import br.com.controlefinanceiro.modelo.Despesa;
import br.com.controlefinanceiro.repository.CategoriaRepository;
import br.com.controlefinanceiro.repository.DespesaRepository;

public class DespesaForm {
	
	private String descricao;
	private double valor;
	private Integer data;
	private String categoria;
	
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
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public Despesa converter(DespesaRepository despesaRepository, CategoriaRepository categoriaRepository) {		
			
		if(this.categoria == null) {
			this.categoria = "Outras";
		}
		
		Optional<Categoria> categoria = categoriaRepository.findByDescricao(this.categoria);		

		if  (!categoria.isPresent()) {
			return null;
		}			
		
		return new Despesa(this.descricao, this.valor, this.data, categoria.get());
	}

}
