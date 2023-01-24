package br.com.controlefinanceiro.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.controlefinanceiro.projection.CategoriaValorOnly;
import br.com.controlefinanceiro.repository.DespesaRepository;
import br.com.controlefinanceiro.repository.ReceitaRepository;

public class DetalhesDoResumoDto {
	
	double valorTotalReceita;
	double valorTotalDespesa;
	double valorTotal;
	List<CategoriaValorOnly> valorTotalPorCategoria;
	//Map<Long, Double> teste = new HashMap<Long, Double>();
	
	
	public DetalhesDoResumoDto(int ano, int mes, DespesaRepository despesaRepository, ReceitaRepository receitaRepository) { 
	
		this.valorTotalReceita = receitaRepository.findByAcumulaValorPorAnoMes(ano, mes);
		this.valorTotalDespesa = despesaRepository.findByAcumulaValorPorAnoMes(ano, mes);
		this.valorTotal = valorTotalReceita - valorTotalDespesa;
		
		this.valorTotalPorCategoria = despesaRepository.findByAcumulaCategoria(ano, mes);
		
		//this.teste = despesaRepository.findByAcumulaCategoriaMap(ano, mes); 
		//System.out.println(teste.values() );
	}


	public double getValorTotalReceita() {
		return valorTotalReceita;
	}


	public double getValorTotalDespesa() {
		return valorTotalDespesa;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public List<CategoriaValorOnly> getValorTotalPorCategoria() {
		return valorTotalPorCategoria;
	}
	
	
	
	
}
