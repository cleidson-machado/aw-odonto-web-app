package br.com.odonto.app.controller.contratante;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.odonto.domain.model.Contratante;
import br.com.odonto.domain.service.contratante.ContratanteBasicService;
import br.com.odonto.domain.service.contratante.ContratanteRules;

@Controller
@RequestMapping(path="/contratante")
public class ContratanteController {
	
	@Autowired
	private ContratanteRules contratanteRules;
	
	@Autowired
	private ContratanteBasicService contratanteBasicService;
	
	@RequestMapping(path={""}, method=RequestMethod.GET)
	public String listAll(Model model) {
		
		//AQUI FAZ UM SELECT ALL NO DATABASE.. USANDO A CLASSE CRIADA PARA ARMAZENAR AS REGRAS DE NEGÓCIO...
		model.addAttribute("listagem", contratanteRules.getAllContratantes());		
		
		//EXEMPLO DE RETORNO DIRETO A VIEW SEM PASSAR PELO PAGINADOR!
		//return "/contratante/Index";
		
		//PARA TESTE DA PESQUISA
		//String keyword = "ana";
		String keyword = null;
		
		//AQUI REPASSA AO "FILTRO" DO PAGINADOR...
		return findPaginated(model, 1, "nome", "asc", keyword);
	}
	
	@RequestMapping(path={"/"}, method=RequestMethod.GET)
	public String redirectRootPath() {
		return "redirect:/contratante";		
	}	
	
//	@RequestMapping(path={"/saveOrUpdate", "contratante/saveOrUpdate"}, method=RequestMethod.POST)
//	public String saveOrUpdade(Contratante contratante) {
//		  contratanteRules.saveContratante(contratante);
//		return "redirect:/contratante";
//	}
	
	@RequestMapping(path={"/saveOrUpdate", "contratante/saveOrUpdate"}, method=RequestMethod.POST)
	public String saveOrUpdade(@Valid Contratante contratante, BindingResult bidingResult) {
			if (bidingResult.hasErrors()) {			
				bidingResult.addError(new FieldError("contratante", "email1", "A CARALHA DO E-MAIL DEVE SER INFORMADO!"));			
				//return "/contratante/Index :: myModalFragment";
				//return "redirect:/";
				//return "redirect:/contratanteForms/AddNew";
				return "/contratante/IndexFormRouteViewCreateEdit";
			}
		
		contratanteRules.saveContratante(contratante);		
		return "redirect:/contratante";
	}
	
	@RequestMapping(path={"/deleteById"}, method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteOne(long codigo) {
		contratanteRules.deleteContratanteById(codigo);
		return "redirect:/contratante";
	}	
	
	@RequestMapping(path={"/selectById"}, method=RequestMethod.GET)
	@ResponseBody //COM UM LINK NO PADRÃO DE UMA API QUE É CAPTURADO PELO JAVASCRIPT DA PAGINA!
	public Optional<Contratante> modalViewSelectById (long codigo) {
		return contratanteRules.getOne(codigo);
	}
	
	@RequestMapping(path={"/page/{pageNo}"}, method=RequestMethod.GET)
	public String findPaginated(Model model, 
			@PathVariable(value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			@RequestParam("keyword") String keyword) {
		
		int pageSize = 9;
		
		Page <Contratante> page = contratanteBasicService.findPaginated(pageNo, pageSize, sortField, sortDir, keyword);
		List<Contratante> listagem = page.getContent();
		
		//AQUI PARTE DA PAGINAÇÃO...
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());	    
	    
		//AQUI PARTE DA ORDENAÇÃO...
		model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    
	    //AQUI PARA A PESQUISA
	    model.addAttribute("keyword", keyword);
		
	    //ACESSO DA VIEW HTML A ESSE MÉTODO!
		model.addAttribute("listagem", listagem);
		
		return "/contratante/Index";
	}

}
