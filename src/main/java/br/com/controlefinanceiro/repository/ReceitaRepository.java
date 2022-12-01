package br.com.controlefinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefinanceiro.modelo.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	

	Receita findByDescricao(String descricao);

}
