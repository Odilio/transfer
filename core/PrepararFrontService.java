package br.com.b3.pip.gerenciarrecurso.core;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import br.com.b3.pip.gerenciarrecurso.model.FrontCredito;
import br.com.b3.pip.gerenciarrecurso.model.FrontMovimentoFinanceiro;
import br.com.b3.pip.gerenciarrecurso.model.MovimentoFinanceiroDO;

public interface PrepararFrontService {
	
	public List<FrontMovimentoFinanceiro> preparaFrontTabela(List<MovimentoFinanceiroDO> movimentosFinanceiros);
	
	public ModelAndView returnarSalvar(FrontCredito frontCredito);
	
	public ModelAndView gerarCredito();
	
}
