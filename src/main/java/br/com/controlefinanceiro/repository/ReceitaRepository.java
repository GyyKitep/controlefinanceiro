package br.com.controlefinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.controlefinanceiro.modelo.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	
	@Query("SELECT r FROM Receita r WHERE r.descricao LIKE %:descricao%")
	List<Receita> findByDescricao(@Param("descricao")String descricao);

    @Query("SELECT r FROM Receita r WHERE MONTH(DATA) = :mes AND YEAR(DATA) = :ano")
	List<Receita> findByProcuraPorAnoMes(int ano, int mes);

	@Query("SELECT SUM(valor) FROM Receita WHERE MONTH(data) = :mes AND YEAR(data) = :ano GROUP  BY YEAR(data),  MONTH(data)")
	double findByAcumulaValorPorAnoMes(int ano, int mes);

}
