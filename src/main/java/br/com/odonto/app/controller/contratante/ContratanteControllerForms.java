package br.com.odonto.app.controller.contratante;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.odonto.domain.model.Contratante;
import br.com.odonto.domain.service.contratante.ContratanteRules;

@Controller
@RequestMapping(path="/contratanteForms")
public class ContratanteControllerForms {
	
	@Autowired
	private ContratanteRules contratanteRules;
	
	//@GetMapping("/AddNew")
	@RequestMapping(path={"/AddNew"}, method=RequestMethod.GET)
	public String formAddContratante(Contratante contratante, Model model) {
		model.addAttribute("contratante", contratante);
		return "/contratante/IndexFormRouteViewCreateEdit";
	}
	
	//APENAS EXEMPLO COM MODAL CRIADO VIA REDIRECT DO JAVASCRIP!
	@RequestMapping(path={"/AddNewExemplo"}, method=RequestMethod.GET)
	public String formAddContratanteExemplo() {
		return "/contratante/ModalViewFormExemploLinkModal";
	}
	
	@RequestMapping(path={"/saveOrUpdate"}, method=RequestMethod.POST)
	public String saveOrUpdade(@Valid Contratante contratante, BindingResult bidingResult) {

		if (bidingResult.hasErrors()) {
			//ANOTHER WAY TO GET THE ERROR AND INFORM DE MESSANGER
			bidingResult.addError(new FieldError("contratante", "email1", "A CARALHA DO E-MAIL DEVE SER INFORMADO!"));
			//return null;
			//return "redirect:#myModal";
			//return "redirect:/contratanteForms/AddNew";
			//return "/contratante/ModalViewForm"; //RETONA A VIEW MAS COMO EFEITO COLATERAL APAGA OS OUTROS CAMPOS JA PREENCHIDOS!
			return "/contratante/Index :: myModal";
		}
		contratanteRules.saveContratante(contratante);		
		return "redirect:/contratante";
	}


//	@RequestMapping(path={"/saveOrUpdate"}, method=RequestMethod.POST)
//	public void saveOrUpdade(@Valid Contratante contratante, BindingResult bidingResult) {
//
//		if (bidingResult.hasErrors()) {
//			//ANOTHER WAY TO GET THE ERROR AND INFORM DE MESSANGER
//			bidingResult.addError(new FieldError("contratante", "email1", "A CARALHA DO E-MAIL DEVE SER INFORMADO!"));
//			//return null;
//			//return "redirect:#myModal";
//			//return "redirect:/contratanteForms/AddNew";
//			//return "/contratante/ModalViewForm"; //RETONA A VIEW MAS COMO EFEITO COLATERAL APAGA OS OUTROS CAMPOS JA PREENCHIDOS!
//		}
//		contratanteRules.saveContratante(contratante);		
//		//return "redirect:/contratante";
//	}


}
