/* ################################################################# */
/* MUDANÇA EFETUADA EM TODAS AS COLUNAS DE VARCHAR AFIM DE DEIXAR 
   A TABELA SEM RESTRIÇÕES DE QUANTIDADE MÁXIMA DE CARACTERES DE TEXTO */
/* ################################################################# */
ALTER TABLE contratante
ALTER num_cnpj TYPE varchar(255),
ALTER num_cpf TYPE varchar(255),
ALTER email1 TYPE varchar(255),
ALTER email2 TYPE varchar(255),
ALTER email3 TYPE varchar(255),
ALTER est_civil TYPE varchar(255),
ALTER fone1 TYPE varchar(255),
ALTER fone2 TYPE varchar(255),
ALTER fone3 TYPE varchar(255),
ALTER nome TYPE varchar(255),
ALTER num_ramal TYPE varchar(255),
ALTER num_rg TYPE varchar(255),
ALTER sexo TYPE varchar(255),
ALTER sobre_nome TYPE varchar(255),
ALTER tipo_cadastro TYPE varchar(255),
ALTER camada_funcional TYPE varchar(255),
ALTER contratante_status TYPE varchar(255),
ALTER registro_nativo TYPE varchar(255);