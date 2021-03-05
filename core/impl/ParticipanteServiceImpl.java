package br.com.b3.pip.gerenciarrecurso.core.impl;


import org.springframework.stereotype.Service;

import br.com.b3.pip.gerenciarrecurso.core.ParticipanteService;
import br.com.b3.pip.gerenciarrecurso.model.ParticipanteDO;
import br.com.b3.pip.gerenciarrecurso.repository.ParticipanteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ParticipanteServiceImpl implements ParticipanteService{
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public ParticipanteDO findById(Integer numeroParticipante) {
		return participanteRepository.findById(numeroParticipante).orElse(null);
	}
	
	// enquanto não é compose key, retorna somente o primeiro item
	// depois que arrumar, remover ".get(0)"
	// e talvez tenha que montar a composekey pra passar pro findBy
	public Integer findByCodigoParticipante(Integer codigoParticipante) {
		List<ParticipanteDO> p = participanteRepository.findByCodigoParticipanteAndNumeroCategoriaParticipante(codigoParticipante, 60);
		if(p!= null && p.size() > 0) {
			return p.get(0).getNumeroParticipante();
		} 
		return null;
	}
	
	public List<ParticipanteDO> findAll() {
		return participanteRepository.findAll();
	}

}