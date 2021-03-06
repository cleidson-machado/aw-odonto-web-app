package br.com.odonto.app.controller.contratante;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.odonto.domain.model.Contratante;
import br.com.odonto.domain.service.contratante.ContratanteRules;

@Controller
@RequestMapping(path="/contratanteDataTable")
public class ContratanteControllerDataTableOne {
	
	@Autowired
	private ContratanteRules contratanteRules;
	
	@RequestMapping(path={"/"}, method=RequestMethod.GET)
	public String redirectRootPath() {
		return "redirect:/contratanteDataTable";		
	}
	
	@RequestMapping(path={""}, method=RequestMethod.GET)
	public String listAll(Model model) {		
		model.addAttribute("listagemDataTable", contratanteRules.getAllContratantes());		
		return "/contratante/IndexDataTableJs";		
	}	
	
	@RequestMapping(path={"/saveOrUpdate", "contratanteDataTable/saveOrUpdate"}, method=RequestMethod.POST)
	public String saveOrUpdade(Contratante contratante) {		
		contratanteRules.saveContratante(contratante);		
		return "redirect:/contratanteDataTable";
	}
	
	@RequestMapping(path={"/deleteById"}, method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteOne(long codigo) {
		contratanteRules.deleteContratanteById(codigo);
		return "redirect:/contratanteDataTable";
	}	
	
	@RequestMapping(path={"/selectById"}, method=RequestMethod.GET)
	@ResponseBody //COM UM LINK NO PADRÃO DE UMA API QUE É CAPTURADO PELO JAVASCRIPT DA PAGINA!
	public Optional<Contratante> modalViewSelectById (long codigo) {
		return contratanteRules.getOne(codigo);
	}

}
