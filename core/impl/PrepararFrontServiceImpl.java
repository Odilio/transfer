package br.com.b3.pip.gerenciarrecurso.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.b3.pip.gerenciarrecurso.core.ContratoService;
import br.com.b3.pip.gerenciarrecurso.core.GerenciarRecursoService;
import br.com.b3.pip.gerenciarrecurso.core.MovimentoFinanceiroService;
import br.com.b3.pip.gerenciarrecurso.core.ParticipanteService;
import br.com.b3.pip.gerenciarrecurso.core.PrepararFrontService;
import br.com.b3.pip.gerenciarrecurso.model.ContratoDO;
import br.com.b3.pip.gerenciarrecurso.model.FrontCredito;
import br.com.b3.pip.gerenciarrecurso.model.FrontMovimentoFinanceiro;
import br.com.b3.pip.gerenciarrecurso.model.MovimentoFinanceiroDO;
import br.com.b3.pip.gerenciarrecurso.model.StatusMensagemContrato;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PrepararFrontServiceImpl implements PrepararFrontService {

	public static final Logger logger = LoggerFactory.getLogger(PrepararFrontServiceImpl.class);
	
	@Autowired
	private MovimentoFinanceiroService movimentoFinanceiroService;
	
	@Autowired
	private ParticipanteService participanteService;
	
	@Autowired
	private ContratoService contratoService;
	
	@Autowired
	private GerenciarRecursoService gerenciarRecursoService;

	public List<FrontMovimentoFinanceiro> preparaFrontTabela(List<MovimentoFinanceiroDO> movimentosFinanceiros) {
		List<FrontMovimentoFinanceiro> frontMovimentosFinanceiros = new ArrayList<FrontMovimentoFinanceiro>();
		
		for(MovimentoFinanceiroDO movimentoFinanceiro : movimentosFinanceiros) {
			FrontMovimentoFinanceiro frontMovimentoFinanceiro = new FrontMovimentoFinanceiro();
			frontMovimentoFinanceiro.setNumeroMovimentoFinanceiro(movimentoFinanceiro.getNumeroMovimentoFinanceiro());
			frontMovimentoFinanceiro.setCodigoContrato(movimentoFinanceiro.getContrato().getCodigoContrato());
			frontMovimentoFinanceiro.setMotivoSituacaoContrato(movimentoFinanceiro.getContrato().getMotivoSituacaoContrato().getNomeMotivoSituacaoContrato());
			frontMovimentoFinanceiro.setNumeroParticipante(movimentoFinanceiro.getParticipante().getCodigoParticipante());
			frontMovimentoFinanceiro.setDataHoraInicioMovimentoInter(movimentoFinanceiro.getDataHoraInicioMovimento());
			if("C".equals(movimentoFinanceiro.getIndicadorCreditoDebito())) {
				frontMovimentoFinanceiro.setIndicadorCreditoDebito("CREDITO");
			} else if ("D".equals(movimentoFinanceiro.getIndicadorCreditoDebito())) {
				frontMovimentoFinanceiro.setIndicadorCreditoDebito("DEBITO");
			} else {
				frontMovimentoFinanceiro.setIndicadorCreditoDebito("???");
			}
			frontMovimentoFinanceiro.setValorTransferencia(String.format("%.2f", movimentoFinanceiro.getValorTransferencia()));
			
			frontMovimentosFinanceiros.add(frontMovimentoFinanceiro);
		}
		
		Collections.sort(frontMovimentosFinanceiros, new Comparator<FrontMovimentoFinanceiro>() {
			public int compare(FrontMovimentoFinanceiro o1, FrontMovimentoFinanceiro o2) {
				return o2.getNumeroMovimentoFinanceiro().compareTo(o1.getNumeroMovimentoFinanceiro());
			}
		});
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		frontMovimentosFinanceiros.forEach(movimento->movimento.setDataHoraInicioMovimento(movimento.getDataHoraInicioMovimentoInter().format(formatter)));
		return frontMovimentosFinanceiros;
	}
	
	public ModelAndView returnarSalvar(FrontCredito frontCredito) {
		ModelAndView mv = new ModelAndView("ProjetoWeb/gerar_credito");
		mv.addObject("frontCredito", frontCredito);
		
		String msgm = "";
		if(frontCredito != null) {
			if(frontCredito.getCodigoParticipante() == null ||
			   frontCredito.getContrato() == null ||
			   frontCredito.getValor() == null) {
				msgm = "Favor preencher todos os campos";
				logger.error(msgm);
				mv.addObject("messageError", msgm);
				return mv;
			}
			try {
				Integer numParticipante = participanteService.findByCodigoParticipante(frontCredito.getCodigoParticipante());
				if(numParticipante != null) {
					ContratoDO contrato = contratoService.findByCodigoContrato(frontCredito.getContrato());
					if(contrato != null) {
						StatusMensagemContrato statusMensagemContrato = new StatusMensagemContrato(numParticipante, contrato.getNumeroContrato(), null, null, frontCredito.getValor());
						gerenciarRecursoService.receberRecursos(statusMensagemContrato);
						msgm = "Crédito simulado com sucesso!";
						mv.addObject("messageSucess", msgm);
					} else {
						msgm = "Contrato não encontrado";
						mv.addObject("messageError", msgm);
					}
				}else {
					msgm = "Participante não encontrado";
					mv.addObject("messageError", msgm);
				}
			} catch (Exception e) {
				msgm = "Falha ao gerar simulação de credito: " + e.getMessage();
				logger.error(msgm);
				mv.addObject("messageError", msgm);
			}
			
		} else {
			msgm = "Favor preencher todos os campos";
			logger.error(msgm);
			mv.addObject("messageError", msgm);
		}

		List<MovimentoFinanceiroDO> movimentosFinanceiros = movimentoFinanceiroService.findAll();
		List<FrontMovimentoFinanceiro> frontMovimentosFinanceiros = preparaFrontTabela(movimentosFinanceiros);
		mv.addObject("movimentos", frontMovimentosFinanceiros);
		
		return mv;
	}
	
	public ModelAndView gerarCredito() {
		ModelAndView mv = new ModelAndView("ProjetoWeb/gerar_credito");
		mv.addObject("frontCredito", new FrontCredito());
		
		List<MovimentoFinanceiroDO> movimentosFinanceiros = movimentoFinanceiroService.findAll();
		List<FrontMovimentoFinanceiro> frontMovimentosFinanceiros = preparaFrontTabela(movimentosFinanceiros);
		mv.addObject("movimentos", frontMovimentosFinanceiros);
		
		return mv;
	}
}