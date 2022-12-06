package br.com.controlefinanceiro.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.controlefinanceiro.modelo.Categoria;
import br.com.controlefinanceiro.modelo.Despesa;

public class DespesaDto {

	private String descricao;
	private double valor;
	private Integer data;
	private Categoria categoria;
	
	public DespesaDto() {
	}
	
	public DespesaDto(Despesa despesa) {
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
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public static List<DespesaDto> converter(List<Despesa> despesa) {
		List<DespesaDto> listDespesasDtos = new ArrayList<DespesaDto>();
		
		despesa.stream()
			.forEach(d -> {
				listDespesasDtos.add(new DespesaDto(d));
			});;

		
		return listDespesasDtos;
	}
	
	
}
