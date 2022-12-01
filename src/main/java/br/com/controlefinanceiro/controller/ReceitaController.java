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

import br.com.controlefinanceiro.controller.form.AtualizacaoReceitaForm;
import br.com.controlefinanceiro.controller.form.ReceitaForm;
import br.com.controlefinanceiro.dto.DetalhesDaReceitaDto;
import br.com.controlefinanceiro.dto.ReceitaDto;
import br.com.controlefinanceiro.modelo.Despesa;
import br.com.controlefinanceiro.modelo.Receita;
import br.com.controlefinanceiro.repository.ReceitaRepository;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@GetMapping
	public List<ReceitaDto> listarReceitas(){
	
		List<Receita> receita = receitaRepository.findAll();				
		
		return ReceitaDto.converter(receita);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDaReceitaDto> detalharReceita (@PathVariable Long id) {   
		
		Optional<Receita> receita = receitaRepository.findById(id);	
		
		if  (receita.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaReceitaDto(receita.get()));
		}
		
		return ResponseEntity.notFound().build();

	}		
	
	@PostMapping
	@Transactional
	public ResponseEntity<ReceitaDto> cadastrar(@RequestBody ReceitaForm form, UriComponentsBuilder uriBuilder) {
		Receita receita = form.converter(receitaRepository);
		
		receitaRepository.save(receita);
		URI uri = uriBuilder.path("/receita/{id}").buildAndExpand(receita.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ReceitaDto(receita));
		
	}		
	
	@PutMapping("/{id}") 
	public ResponseEntity<ReceitaDto> atualizar(@PathVariable long id, @RequestBody AtualizacaoReceitaForm form){
		
		Optional<Receita> optional = receitaRepository.findById(id);
		
		if  (optional.isPresent()) {
			Receita receita = form.atualizar(id, receitaRepository); 
			receitaRepository.save(receita);
			return ResponseEntity.ok(new ReceitaDto(receita));
		}
		
		return ResponseEntity.notFound().build();

	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable long id){
		
		Optional<Receita> optional = receitaRepository.findById(id);
		
		if  (optional.isPresent()) {
			receitaRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();		

	}		
			
}
