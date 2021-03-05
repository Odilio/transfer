package br.com.b3.pip.gerenciarrecurso.core;

import java.util.List;

import br.com.b3.pip.gerenciarrecurso.model.MotivoSituacaoContratoDO;

public interface MotivoSituacaoContratoService {

	public List<MotivoSituacaoContratoDO> findAll();
	
	public MotivoSituacaoContratoDO findByNumeroMotivoSituacaoContrato(Integer numeroMotivoSituacaoContrato);
}
