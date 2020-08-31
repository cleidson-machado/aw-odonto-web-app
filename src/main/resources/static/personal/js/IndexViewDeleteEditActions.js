 $(document).ready(function(){
		    	
  //INICIO CAPTURA DO LINK DA AÇÃO DE AUTO-PREENCHIMENTO DO MODAL COM OS DADOS DA ENTIDADE
  //SEQUENCIA CORRETA: ID-TABELA --> CLICK ---> ID-LINK
  $("#contratanteTable").on("click", "#editlink", function(e){			
	e.preventDefault();

	var href = $(this).attr("href");

   	$("#addEntityEditModal").modal();

	$.get(href, function(contratante){
	$("#addEntityEditModal #doCodigo").val(contratante.codigo);
	$("#addEntityEditModal #doNome").val(contratante.nome);
	$("#addEntityEditModal #doSobreNome").val(contratante.sobreNome); 
	$("#addEntityEditModal #doCpfnum").val(contratante.cpf);
	$("#addEntityEditModal #doEmail").val(contratante.email1);

   })
 
	});//FIM DO ADD
	
	//INICIO CAPTURA DO LINK DA AÇÃO DE DELETE
	//SEQUENCIA CORRETA: ID-TABELA --> CLICK ---> ID-LINK
	$("#contratanteTable").on("click", "#deletelink", function(e){			
	e.preventDefault();
	
	var href = $(this).attr("href");
				
	$("#deleteModal").modal();
	
	//IMPORTANTE REFERÊNCIA DIRETA AO LINK DA VIEW... CASO CONTRÁRIO.. USANDO BOTÕES SIMPLES A REFERÊNCIA FICA RELATIVA E FERRA AS ROTAS DA CONTROLLER
	//REPASSANDO O LINK DO DELETE QUE VEM DO LINK-BTN NA LIST VIEW PARA O BTN-HREF DO MODAL DE DELETE
	$("#deleteModal #deleteLinkBtnTrigger").attr("href", href);

	});//FIM DO DELETE	
	
	/*! ADD ANOTHER ACTIONS METHODS HERE */
				
});