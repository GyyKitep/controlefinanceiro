package br.com.controlefinanceiro.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.controlefinanceiro.modelo.Despesa;

public class DespesaDto {

	private String descricao;
	private double valor;
	private Integer data;
	
	public DespesaDto() {
	}
	
	public DespesaDto(Despesa despesa) {
		this.descricao = despesa.getDescricao();
		this.valor = despesa.getValor();
		this.data = despesa.getData();
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
	public static List<DespesaDto> converter(List<Despesa> despesa) {
		List<DespesaDto> listDespesasDtos = new ArrayList<DespesaDto>();
		
		despesa.stream()
			.forEach(d -> {
				listDespesasDtos.add(new DespesaDto(d));
			});;

		
		return listDespesasDtos;
	}
	
	
}
