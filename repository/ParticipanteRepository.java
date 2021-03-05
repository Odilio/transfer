package br.com.b3.pip.gerenciarrecurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.b3.pip.gerenciarrecurso.model.ParticipanteDO;

@Repository
public interface ParticipanteRepository extends JpaRepository<ParticipanteDO, Integer> {
	
	public List<ParticipanteDO> findByCodigoParticipanteAndNumeroCategoriaParticipante(Integer codigoParticipante, Integer numeroCategoriaParticipante);
}