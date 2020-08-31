$(document).ready(function() {
	contratanteJsDataTable();
} );

function  contratanteJsDataTable() {
    $('#contratanteTable').DataTable( {

	"language": {
		"emptyTable":			"<i>NÃO HÁ REGISTROS NA TABELA de Banco de Dados.</i>",
		"info":		   			"| Exibindo de _START_ a _END_ | _TOTAL_ ",
		"infoEmpty":			"Exibindo 0 registros do total de 0.",
		"infoFiltered":			"( Filtrados de um total de _MAX_ )",
		"infoPostFix":			"( Registros ) |",
		"lengthMenu":			"Exibindo: _MENU_ Registros",
		"loadingRecords":		"Carregando...",
		"processing":			"Processando...",
		"search":				"<span style='font-size:15px;'>Pesquisar:</span>",
		"searchPlaceholder":		"em qualquer coluna",
		"zeroRecords":			"NÃO FORAM ENCONTRADOS REGISTROS Segundo Parâmetros de Pesquisa Fornecidos.",
				
	"paginate": {
		"first":			"Primero",
		"last":				"Último",
		"next":				"Próximo",
		"previous":			"Anterior"
		},
					
	"aria": {
		"sortAscending":	"Ordem Crescente",
		"sortDescending":	"Ordem Decrescente"
			}
		},

	"lengthMenu":		[[3, 6, 9, 12, 24, 48, 100, -1], [3, 6, 9, 12, 24, 48, 100, "Todos"]],
	"iDisplayLength":	6,

	//ADD NOVAS FUNCOES AQUI!
	
    } );
}