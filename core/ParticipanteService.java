package br.com.b3.pip.gerenciarrecurso.core;

import java.util.List;

import br.com.b3.pip.gerenciarrecurso.model.ParticipanteDO;

public interface ParticipanteService {

	public ParticipanteDO findById(Integer numeroParticipante);
	
	public Integer findByCodigoParticipante(Integer codigoParticipante);
	
	public List<ParticipanteDO> findAll();	
}
