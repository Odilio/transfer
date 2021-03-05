package br.com.b3.pip.gerenciarrecurso.core.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.b3.pip.gerenciarrecurso.core.ContratoService;
import br.com.b3.pip.gerenciarrecurso.core.GerenciarRecursoService;
import br.com.b3.pip.gerenciarrecurso.core.MovimentoFinanceiroService;
import br.com.b3.pip.gerenciarrecurso.core.ParticipanteService;
import br.com.b3.pip.gerenciarrecurso.dto.CriacaoMovimentoFinanceiroDTO;
import br.com.b3.pip.gerenciarrecurso.dto.MovimentoFinanceiroDTO;
import br.com.b3.pip.gerenciarrecurso.exceptions.ParametroObrigatorioException;
import br.com.b3.pip.gerenciarrecurso.exceptions.SemRegistroException;
import br.com.b3.pip.gerenciarrecurso.mapper.MovimentoFinanceiroMapper;
import br.com.b3.pip.gerenciarrecurso.model.ContratoDO;
import br.com.b3.pip.gerenciarrecurso.model.MovimentoFinanceiroDO;
import br.com.b3.pip.gerenciarrecurso.model.StatusMensagemContrato;
import br.com.b3.pip.gerenciarrecurso.repository.MovimentoFinanceiroRepository;
import br.com.b3.pip.gerenciarrecurso.specification.MovimentoFinanceiroSpecification;

@Service
public class MovimentoFinanceiroServiceImpl implements MovimentoFinanceiroService {

	private static final String VALOR_OBRIGATORIO = "Valor da Transferência é obrigatório";
	private static final String CODIGO_CONTRATO_OBRIGATORIO = "Código do Contrato é obrigatório";
	private static final String PARTICIPANTE_OBRIGATORIO = "Código do Participante é obrigatório";
	private static final String DADOS_INVALIDOS = "Dados para criar o movimento financeiro são inválidos";
	private static final String CREDITO_CRIADO = "Crédito Simulado com Sucesso";
	private static final String CONTRATO_NAO_ENCONTRADO = "Contrato não foi encontrado";
	private static final String PARTICIPANTE_NAO_ENCONTRADO = "Participante não foi encontrado";
	private static final String MENSAGEM_SEM_DADOS = "Não foram encontrado dados para essa consulta";

	@Autowired
	private MovimentoFinanceiroRepository repository;
	
	@Autowired
	private MovimentoFinanceiroMapper mapper;
	
	@Autowired
	private ParticipanteService participanteService;
	
	@Autowired
	private ContratoService contratoService;
	
	@Autowired
	private GerenciarRecursoService gerenciaRecursoService;
	
	public static final Logger logger = LoggerFactory.getLogger(MovimentoFinanceiroServiceImpl.class);

	public MovimentoFinanceiroDO findById(Integer numeroMovimentoFinanceiro) {
		return repository.findById(numeroMovimentoFinanceiro).orElse(null);
	}

	public List<MovimentoFinanceiroDO> findAll() {
		return repository.findAll();
	}
	
	public MovimentoFinanceiroDO save(MovimentoFinanceiroDO movimentoFinanceiro) {
		return repository.save(movimentoFinanceiro);
	}
	
	public Page<MovimentoFinanceiroDTO> getMovimentosFinanceiros(MovimentoFinanceiroDTO filtros, Pageable page) throws SemRegistroException {
		Specification<MovimentoFinanceiroDO> parametros = new MovimentoFinanceiroSpecification(); 
		
		Page<MovimentoFinanceiroDTO> movimentos = this.repository.findAll(parametros, page).map(this.mapper::toDTO);
		
		if (!movimentos.hasContent()) {
			throw new SemRegistroException(MENSAGEM_SEM_DADOS);
		}
		
		return movimentos;
	}
	
	@Override
	public CriacaoMovimentoFinanceiroDTO criarMovimento(MovimentoFinanceiroDTO parametros) throws ParametroObrigatorioException, SemRegistroException {
		
		this.validarParametrosObrigatorio(parametros);
		
		Integer numeroParticipante = participanteService.findByCodigoParticipante(parametros.getParticipante().getCodigoParticipante());
		
		if (numeroParticipante == null) {
			throw new SemRegistroException(PARTICIPANTE_NAO_ENCONTRADO);
		}
		
		ContratoDO contrato = this.contratoService.findByCodigoContrato(parametros.getContrato().getCodigoContrato());
		
		if (contrato == null || contrato.getNumeroContrato() == null) {
			throw new SemRegistroException(CONTRATO_NAO_ENCONTRADO);
		}
		
		StatusMensagemContrato statusMensagemContrato = new StatusMensagemContrato(numeroParticipante, contrato.getNumeroContrato(), null, null, parametros.getValorTransferencia()
				, parametros.getMotivoSituacaoMovimentacaoFinanceira().getNumeroMotivoSituacaoMovimentacaoFinanceira());
		gerenciaRecursoService.receberRecursos(statusMensagemContrato);
		
		return new CriacaoMovimentoFinanceiroDTO(CREDITO_CRIADO);
		
	}
	
	private void validarParametrosObrigatorio(MovimentoFinanceiroDTO parametros) throws ParametroObrigatorioException {
		
		if (parametros == null) {
			throw new ParametroObrigatorioException(DADOS_INVALIDOS);
		}
		
		if (parametros.getParticipante() == null || parametros.getParticipante().getCodigoParticipante() == null) {
			throw new ParametroObrigatorioException(PARTICIPANTE_OBRIGATORIO);
		}
		
		if (parametros.getContrato() == null || StringUtils.isEmpty(parametros.getContrato().getCodigoContrato())) {
			throw new ParametroObrigatorioException(CODIGO_CONTRATO_OBRIGATORIO);
		}
		
		if (parametros.getValorTransferencia() == null) {
			throw new ParametroObrigatorioException(VALOR_OBRIGATORIO);
		}
	}
}