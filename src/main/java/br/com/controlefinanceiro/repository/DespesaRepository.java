package br.com.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefinanceiro.modelo.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	
	Despesa findByData(Integer data);
	Despesa findByDescricao(String descricao);
}
