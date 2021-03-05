package br.com.b3.pip.gerenciarrecurso.core;

import br.com.b3.pip.gerenciarrecurso.model.StatusMensagemContrato;

public interface GerenciarRecursoService {

	public void receberRecursos(StatusMensagemContrato statusMensagemContrato);
	
	public void respostaTransferenciaDevolucao(StatusMensagemContrato statusMensagemContrato);
	
	public void respostaTransferenciaTomador(StatusMensagemContrato statusMensagemContrato);
}
