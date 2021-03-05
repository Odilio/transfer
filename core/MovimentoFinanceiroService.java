package br.com.b3.pip.gerenciarrecurso.core;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.b3.pip.gerenciarrecurso.dto.CriacaoMovimentoFinanceiroDTO;
import br.com.b3.pip.gerenciarrecurso.dto.MovimentoFinanceiroDTO;
import br.com.b3.pip.gerenciarrecurso.exceptions.ParametroObrigatorioException;
import br.com.b3.pip.gerenciarrecurso.exceptions.SemRegistroException;
import br.com.b3.pip.gerenciarrecurso.model.MovimentoFinanceiroDO;

public interface MovimentoFinanceiroService {
	
	public MovimentoFinanceiroDO findById(Integer numeroContrato);

	public List<MovimentoFinanceiroDO> findAll();

	public MovimentoFinanceiroDO save(MovimentoFinanceiroDO oferta);
	
	public Page<MovimentoFinanceiroDTO> getMovimentosFinanceiros(MovimentoFinanceiroDTO filtros, Pageable page) throws SemRegistroException;
	
	public CriacaoMovimentoFinanceiroDTO criarMovimento(MovimentoFinanceiroDTO parametros) throws ParametroObrigatorioException, SemRegistroException;
}
