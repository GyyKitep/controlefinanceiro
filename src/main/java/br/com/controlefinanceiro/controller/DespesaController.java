package br.com.controlefinanceiro.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.controlefinanceiro.controller.form.AtualizacaoDespesaForm;
import br.com.controlefinanceiro.controller.form.DespesaForm;
import br.com.controlefinanceiro.dto.DespesaDto;
import br.com.controlefinanceiro.dto.DetalhesDaDespesaDto;
import br.com.controlefinanceiro.modelo.Despesa;
import br.com.controlefinanceiro.repository.DespesaRepository;

@RestController  
@RequestMapping("/despesa")
public class DespesaController {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@GetMapping
	public List<DespesaDto> listarDespesas(){
	
		List<Despesa> despesa = despesaRepository.findAll();				
		
		return DespesaDto.converter(despesa);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDaDespesaDto> detalharDespesa (@PathVariable Long id) {   
		
		Optional<Despesa> despesa = despesaRepository.findById(id);	
		
		if  (despesa.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaDespesaDto(despesa.get()));
		}
		
		return ResponseEntity.notFound().build();

	}	
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<DespesaDto> cadastrar(@RequestBody DespesaForm form, UriComponentsBuilder uriBuilder) {
		Despesa despesa = form.converter(despesaRepository);
		
		despesaRepository.save(despesa);
		URI uri = uriBuilder.path("/despesa/{id}").buildAndExpand(despesa.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DespesaDto(despesa));
		
	}	
	
	@PutMapping("/{id}") 
	public ResponseEntity<DespesaDto> atualizar(@PathVariable long id, @RequestBody AtualizacaoDespesaForm form){
		
		Optional<Despesa> optional = despesaRepository.findById(id);
		
		if  (optional.isPresent()) {
			Despesa despesa = form.atualizar(id, despesaRepository); 
			despesaRepository.save(despesa);
			return ResponseEntity.ok(new DespesaDto(despesa));
		}
		
		return ResponseEntity.notFound().build();
				
		

	}		
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable long id){
		
		Optional<Despesa> optional = despesaRepository.findById(id);
		
		if  (optional.isPresent()) {
			despesaRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();		

	}		
		
	
}
