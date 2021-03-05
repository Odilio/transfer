package br.com.b3.pip.gerenciarrecurso.core.impl;

import org.springframework.stereotype.Service;

import br.com.b3.pip.gerenciarrecurso.core.ContratoService;
import br.com.b3.pip.gerenciarrecurso.model.ContratoDO;
import br.com.b3.pip.gerenciarrecurso.repository.ContratoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratoRepository repository;
	
	public static final Logger logger = LoggerFactory.getLogger(ContratoServiceImpl.class);

	public ContratoDO findById(Integer numeroContrato) {
		return repository.findById(numeroContrato).orElse(null);
	}
	
	public ContratoDO findByCodigoContrato(String codigoContrato) {
		return repository.findByCodigoContrato(codigoContrato);
	}
	
	public ContratoDO findByNumeroOferta(Integer numeroOferta) {
		return repository.findByNumeroOferta(numeroOferta);
	}
	
	public ContratoDO findByNumeroOperacao(Integer numeroOperacao) {
		return repository.findByNumeroOperacao(numeroOperacao);
	}

	public List<ContratoDO> findAll() {
		return repository.findAll();
	}

	public ContratoDO save(ContratoDO contrato) {
		return repository.save(contrato);
	}

}