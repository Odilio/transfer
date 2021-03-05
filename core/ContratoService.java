package br.com.b3.pip.gerenciarrecurso.core;

import java.util.List;

import br.com.b3.pip.gerenciarrecurso.model.ContratoDO;

public interface ContratoService {
	
	public ContratoDO findById(Integer numeroContrato);

	public ContratoDO findByCodigoContrato(String codigoContrato);
	
	public ContratoDO findByNumeroOferta(Integer numeroOferta);
	
	public ContratoDO findByNumeroOperacao(Integer numeroOperacao);

	public List<ContratoDO> findAll();

	public ContratoDO save(ContratoDO oferta);
	
}
