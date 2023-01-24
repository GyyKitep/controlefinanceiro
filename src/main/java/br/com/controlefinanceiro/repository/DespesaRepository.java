package br.com.controlefinanceiro.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.controlefinanceiro.modelo.Despesa;
import br.com.controlefinanceiro.projection.CategoriaValorOnly;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	
	Despesa findByData(Integer data);
	Despesa findByDescricao(String descricao);
	
	@Query("SELECT d FROM Despesa d WHERE MONTH(data) = :mes AND YEAR(data) = :ano")
	List<Despesa> findByProcuraPorAnoMes(int ano, int mes);

	@Query("SELECT SUM(valor) FROM Despesa WHERE MONTH(data) = :mes AND YEAR(data) = :ano GROUP  BY categoria_id")
	double findByListaDeCategoriasAcumulandoValorPorAnoMes(int ano, int mes);	
	
	@Query("SELECT SUM(valor) FROM Despesa WHERE MONTH(data) = :mes AND YEAR(data) = :ano GROUP  BY YEAR(data),  MONTH(data)")
	double findByAcumulaValorPorAnoMes(int ano, int mes);	
	
	@Query("SELECT categoria.id AS id,categoria.descricao AS descricao, SUM(valor) AS valor FROM Despesa WHERE MONTH(data) = :mes AND YEAR(data) = :ano GROUP BY categoria_id")
	List<CategoriaValorOnly> findByAcumulaCategoria(int ano, int mes);		

	@Query("SELECT categoria.id, SUM(valor)FROM Despesa WHERE MONTH(data) = :mes AND YEAR(data) = :ano GROUP BY categoria_id")
	Map<Long, Double> findByAcumulaCategoriaMap(int ano, int mes);	
	
	
}

