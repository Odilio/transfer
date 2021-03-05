package br.com.b3.pip.gerenciarrecurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.b3.pip.gerenciarrecurso.model.ContratoDO;

@Repository
public interface ContratoRepository extends JpaRepository<ContratoDO, Integer> {

	public ContratoDO findByCodigoContrato(String codigoContrato);
	
	public ContratoDO findByNumeroOferta(Integer numeroOferta);
	
	public ContratoDO findByNumeroOperacao(Integer numeroOperacao);
	
	@Query(value = "SELECT S_PIPCODIGO_CONTRATO.nextval FROM dual", nativeQuery = true)
	public Integer getNextSequence();

}
