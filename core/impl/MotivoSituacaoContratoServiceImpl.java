package br.com.b3.pip.gerenciarrecurso.core.impl;

import org.springframework.stereotype.Service;

import br.com.b3.pip.gerenciarrecurso.core.MotivoSituacaoContratoService;
import br.com.b3.pip.gerenciarrecurso.model.MotivoSituacaoContratoDO;
import br.com.b3.pip.gerenciarrecurso.repository.MotivoSituacaoContratoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class MotivoSituacaoContratoServiceImpl implements MotivoSituacaoContratoService {

	@Autowired
	private MotivoSituacaoContratoRepository repository;

	public List<MotivoSituacaoContratoDO> findAll() {
		return repository.findAll();
	}
	
	public MotivoSituacaoContratoDO findByNumeroMotivoSituacaoContrato(Integer numeroMotivoSituacaoContrato) {
		return repository.findById(numeroMotivoSituacaoContrato).orElse(null);
	}
	
}