package br.com.b3.pip.gerenciarrecurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.b3.pip.gerenciarrecurso.model.MotivoSituacaoContratoDO;

@Repository
public interface MotivoSituacaoContratoRepository extends JpaRepository<MotivoSituacaoContratoDO, Integer> {
}