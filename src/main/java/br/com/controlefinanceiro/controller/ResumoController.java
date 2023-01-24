package br.com.controlefinanceiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlefinanceiro.dto.DetalhesDaDespesaDto;
import br.com.controlefinanceiro.dto.DetalhesDoResumoDto;
import br.com.controlefinanceiro.repository.DespesaRepository;
import br.com.controlefinanceiro.repository.ReceitaRepository;

@RestController  
@RequestMapping("/resumo")
public class ResumoController {
	
	@Autowired
	private DespesaRepository despesaRepository;
	@Autowired
	private ReceitaRepository receitaRepository;
	
	
	@GetMapping("/{ano}/{mes}")
	@ReadOnlyProperty
	public ResponseEntity<DetalhesDoResumoDto> listarDespesasPorMes(@PathVariable(name = "ano") int ano,
			@PathVariable(name = "mes") int mes) {

		
		DetalhesDoResumoDto detalhesDoResumoDto = new DetalhesDoResumoDto(ano, mes, despesaRepository, receitaRepository);

		return ResponseEntity.ok(detalhesDoResumoDto);
	}		
}
