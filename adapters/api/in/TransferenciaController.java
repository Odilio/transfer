package br.com.b3.pip.gerenciarrecurso.adapters.api.in;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.b3.pip.gerenciarrecurso.core.MovimentoFinanceiroService;
import br.com.b3.pip.gerenciarrecurso.core.PrepararFrontService;
import br.com.b3.pip.gerenciarrecurso.dto.MovimentoFinanceiroDTO;
import br.com.b3.pip.gerenciarrecurso.exceptions.ParametroObrigatorioException;
import br.com.b3.pip.gerenciarrecurso.exceptions.SemRegistroException;
import br.com.b3.pip.gerenciarrecurso.model.FrontCredito;

@Controller
@RequestMapping("transferencia")
public class TransferenciaController {
	
	@Autowired
	private PrepararFrontService prepararFrontService;
	
	@Autowired
	private MovimentoFinanceiroService service;
	
	public static final Logger logger = LoggerFactory.getLogger(TransferenciaController.class);

	//PARA TESTES -- INICIO
	@GetMapping("gerarCredito")
	public ModelAndView gerarCredito() {
		return prepararFrontService.gerarCredito();
	}

	@PostMapping("gerarCredito")
	public ModelAndView save(@Valid FrontCredito frontCredito, BindingResult result, Model model) {
		return prepararFrontService.returnarSalvar(frontCredito);
	}
	
	@GetMapping
	public ResponseEntity<Object> getMovimentosFinanceiros(MovimentoFinanceiroDTO parametros, Pageable page) {
		logger.info("Iniciando o método getMovimentosFinanceiros");
		
		try {
			return new ResponseEntity<>(this.service.getMovimentosFinanceiros(parametros, page), HttpStatus.OK);
		} catch (SemRegistroException e) {
			return new ResponseEntity<>(e, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro interto do sistema", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> criarMovimento(@RequestBody MovimentoFinanceiroDTO parametros) {
		logger.info("Iniciando o método criarMovimento");
		try {
			return new ResponseEntity<>(this.service.criarMovimento(parametros), HttpStatus.CREATED);
		} catch (ParametroObrigatorioException | SemRegistroException e) {
			return new ResponseEntity<>(e, HttpStatus.PRECONDITION_FAILED);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro interto do sistema", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}