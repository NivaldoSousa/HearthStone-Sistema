# Bem-vindos ao repositório HearthStone-Sistema

INSTRUÇOES DE USO 


1° PASSO - 
 Import o projeto na IDE, irá carregar as dependencias por ser um projeto Maven.
O projeto está sendo compliado na versao 11 do Java.

2° PASSO -
 Inicialize compilando a classe JogoApplication.

3° PASSO -
 Acesse a URL http://localhost:8080/h2-console 

Nesse terceiro passo você entrará na tela de acesso ao banco de dados H2DataBase,
ele manterá os dados em memória para fazer a consulta, persistencia e delatar os dados, 
por meio das requisições feitas pelo Postman.

4° PASSO - 
 Ainda na tela de Login do H2DataBase, informe os dados no campo JDBC URL, onde se encontra
no arquivo application-test.properties.
DADO A SER COLOCADO NO CAMPO = jdbc:h2:mem:testdb

aperte Connect

5° PASSO - 
 Na tabela CARTA que se encontra no lado esquerdo superior da tela, de um click em cima dele
e um SQL sera feito, click em Run.
Aparecerá alguns registros de cartas ja salva em memória.

OBS. No projeto se encontra um arquivo data.sql, uma instrução SQL de INSERT para semear o banco para realizar um consulta rápida.

6° PASSO - 
 Utilize o Postman para fazer as requisições de POST, GET, DELETE.
Utilize a path “/carta” para acesso as requisições.
No mesmo caminho do README.md se encontra o arquivo HearthStone.postman_collection.json, import ele para o Postman ele contém todas as requisiçoes prontas.

Obrigado!!!


Exemplos de Requisiçoes no Postman

POST Criar Cartas

{
        "nome": "Mago Branco",
        "descricao": "Um grande mago da luz",
        "ataque": 10,
        "defesa": 10,
        "classe": "MAGO",
        "tipo": "MAGIA"
}


POST Filtar Cartas

{"nome": "Mago Branco"}

OU

{"classe": "MAGO"}       

OU

{"tipo": "MAGIA"}       
        
GET Listar Todas as Cartas
http://localhost:8080/carta

DELETE Deletar Cartas
http://localhost:8080/carta/1
ou qualquer outro id que esteja criado no H2dataBase
          

