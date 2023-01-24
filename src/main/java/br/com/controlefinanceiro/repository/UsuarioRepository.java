package br.com.controlefinanceiro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controlefinanceiro.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ 
	
	Optional<Usuario> findByNome(String nome);

}
