#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastrar funcionario

Esquema do Cen�rio: Definir o tipo de contrata��o

Dado Acessar a p�gina de cadastro
E Informar o nome do funcionario <nome>
E Informar a data de nascimento do funcionario <nascimento>
E Informar o rg do funcionario <rg>
E Informar o cpf do funcionario <cpf>
E Selecionar o tipo de processo seletivo <tiposeletivo>
Quando Solicitar o cadastramento do funcionario
Ent�o Sistema informa cadsatro realizado com sucesso

Exemplos: 

|      nome                |  nascimento         | rg         | cpf              |    tiposeletivo                         |
| "Pedro Rocha dos Santos" | "26/08/1975"        | "12587458" | "029.458.325-02" | "Vagas para Estagio em Desenvolvimento" |
| "Fabiana da Silva"       | "15/02/1986"        | "52498763" | "254.458.965-02" | "Vagas para Teste de Software"          |
| "Gustavo de Araujo"      | "05/10/1962"        | "87452169" | "965.452.874-08" | "Vagas para Analista de Requisitos"     |

Cen�rio: Valida��o de campos obrigat�rios
Dado Acessar a p�gina de cadastro
Quando Solicitar o cadastramento do funcionario
Ent�o Sistema informa que os campos s�o obrigat�rios
