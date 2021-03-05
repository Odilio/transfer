package br.com.b3.pip.gerenciarrecurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.b3.pip.gerenciarrecurso.model.MovimentoFinanceiroDO;

@Repository
public interface MovimentoFinanceiroRepository extends JpaRepository<MovimentoFinanceiroDO, Integer>, JpaSpecificationExecutor<MovimentoFinanceiroDO> {

}
