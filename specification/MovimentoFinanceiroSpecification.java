package br.com.b3.pip.gerenciarrecurso.specification;

import br.com.b3.pip.gerenciarrecurso.model.MovimentoFinanceiroDO;

public class MovimentoFinanceiroSpecification extends AbstractSpecification<MovimentoFinanceiroDO> {

	private static final long serialVersionUID = 1L;

	public MovimentoFinanceiroSpecification() {}
	
	public MovimentoFinanceiroSpecification(SearchCriteria criteria) {
		super(criteria);
	}
	
}
