package br.com.b3.pip.gerenciarrecurso.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.b3.pip.gerenciarrecurso.dto.ContratoDTO;
import br.com.b3.pip.gerenciarrecurso.dto.MotivoSituacaoContratoDTO;
import br.com.b3.pip.gerenciarrecurso.dto.MovimentoFinanceiroDTO;
import br.com.b3.pip.gerenciarrecurso.dto.ParticipanteDTO;
import br.com.b3.pip.gerenciarrecurso.model.ContratoDO;
import br.com.b3.pip.gerenciarrecurso.model.MotivoSituacaoContratoDO;
import br.com.b3.pip.gerenciarrecurso.model.MovimentoFinanceiroDO;
import br.com.b3.pip.gerenciarrecurso.model.ParticipanteDO;

@Component
public class MovimentoFinanceiroMapper {

	public MovimentoFinanceiroDTO toDTO (MovimentoFinanceiroDO entidade) {
		MovimentoFinanceiroDTO dto = new MovimentoFinanceiroDTO();
		
		if (entidade == null) {
			return null;
		}
		
		dto.setDataHoraInicioMovimento(this.converterLocalDateTimeEmDate(entidade.getDataHoraInicioMovimento()));
		dto.setDataHoraFimMovimento(this.converterLocalDateTimeEmDate(entidade.getDataHoraFimMovimento()));
		dto.setIndicadorCreditoDebito(entidade.getIndicadorCreditoDebito());
		
		if (!StringUtils.isEmpty(entidade.getIndicadorCreditoDebito())) {
			if (entidade.getIndicadorCreditoDebito().equals("C")) {
				dto.setTipo("Crédito");
			} else {
				dto.setTipo("Débito");
			}
				
		}
		
		dto.setNumeroMovimentoFinanceiro(entidade.getNumeroMovimentoFinanceiro());
		dto.setValorTransferencia(entidade.getValorTransferencia());
		dto.setParticipante(this.getParticipanteDTO(entidade.getParticipante()));
		dto.setContrato(this.getContratoDTO(entidade.getContrato()));
		
		return dto;
	}
	
	private ParticipanteDTO getParticipanteDTO(ParticipanteDO entidade) {
		ParticipanteDTO dto = new ParticipanteDTO();
		
		if (entidade == null) {
			return null;
		}
		
		dto.setCodigoContaPi(entidade.getCodigoContaPi());
		dto.setCodigoContaSelic(entidade.getCodigoContaSelic());
		dto.setCodigoDocumento(entidade.getCodigoDocumento());
		dto.setCodigoParticipante(entidade.getCodigoParticipante());
		dto.setNomeParticipante(entidade.getNomeParticipante());
		dto.setNumeroCategoriaParticipante(entidade.getNumeroParticipante());
		dto.setNumeroParticipante(entidade.getNumeroParticipante());
		dto.setNumeroSituacaoParticipante(entidade.getNumeroSituacaoParticipante());
		
		return dto;
	}
	
	
	private ContratoDTO getContratoDTO (ContratoDO entidade) {
		ContratoDTO dto = new ContratoDTO();
		
		if (entidade == null) {
			return null;
		}
		
		dto.setCodigoContrato(entidade.getCodigoContrato());
		dto.setDataHoraExpiracao(this.converterLocalDateTimeEmDate(entidade.getDataHoraExpiracao()));
		dto.setDataHoraInclusao(this.converterLocalDateTimeEmDate(entidade.getDataHoraInclusao()));
		dto.setDataHoraLiquidacaoIda(this.converterLocalDateTimeEmDate(entidade.getDataHoraLiquidacaoIda()));
		dto.setDataHoraLiquidacaoVolta(this.converterLocalDateTimeEmDate(entidade.getDataHoraLiquidacaoVolta()));
		dto.setNumeroContrato(entidade.getNumeroContrato());
		dto.setNumeroOferta(entidade.getNumeroOferta());
		dto.setNumeroOperacao(entidade.getNumeroOperacao());
		
		dto.setMotivoSituacaoContrato(this.getMotivoSituacaoContratoDTO(entidade.getMotivoSituacaoContrato()));
		
		return dto;
	}
	
	private MotivoSituacaoContratoDTO getMotivoSituacaoContratoDTO(MotivoSituacaoContratoDO entidade) {
		MotivoSituacaoContratoDTO dto = new MotivoSituacaoContratoDTO();
		
		if (entidade == null) {
			return null;
		}
		
		dto.setDescricaoMotivoSituacaoContrato(entidade.getDescricaoMotivoSituacaoContrato());
		dto.setNomeMotivoSituacaoContrato(entidade.getNomeMotivoSituacaoContrato());
		dto.setNumeroMotivoSituacaoContrato(entidade.getNumeroMotivoSituacaoContrato());
		
		return dto;
	}
	
	private Date converterLocalDateTimeEmDate(LocalDateTime localDateTime) {
		
		if (localDateTime == null) {
			return null;
		}
		
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
}
