package br.com.controlefinanceiro.dto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.controlefinanceiro.modelo.Receita;

public class ReceitaDto {

	private String descricao;
	private double valor;
	private String data;
	
	public ReceitaDto() {
		
	}	
	
	public ReceitaDto(Receita receita) {
		this.descricao = receita.getDescricao();
		this.valor = receita.getValor();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		this.data = formatter.format(receita.getData());	
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public static List<ReceitaDto> converter(List<Receita> receita) {
		List<ReceitaDto> listReceitasDtos = new ArrayList<ReceitaDto>();
		
		receita.stream()
			.forEach(r -> {
				listReceitasDtos.add(new ReceitaDto(r));
			});;

		
		return listReceitasDtos;
	}
	
	
}
