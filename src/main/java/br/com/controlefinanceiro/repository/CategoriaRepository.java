package br.com.controlefinanceiro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefinanceiro.modelo.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

	Optional<Categoria> findByDescricao(String descricao);
}
