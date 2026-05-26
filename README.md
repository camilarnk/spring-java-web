## Atividade - Introdução ao Spring Security
Nesta atividade você irá praticar conceitos básicos de configuração do Spring Security em APIs REST utilizando
Spring Boot.
### Parte 1 - Conceitos
1. Explique com suas palavras o que é Spring Security.  
Spring Security é uma biblioteca que fornece segurança extra com autentaticação dos usuários que requisitarão via HTTP.

2. Para que serve o método csrf().disable()?  
Serve para desabilitar a necessidade de utilizar um token de autenticação para realizar requisições API.

3. Explique o que significa SessionCreationPolicy.STATELESS.  
Faz a requisição HTTP não salvar as credenciais utilizadas.

4. Qual a função do permitAll()?  
Permite com que qualquer usuário use os endpoints, estando credenciado ou não.

5. Explique o que faz o requestMatchers().  
Define quais rotas devem aplicar as regras de segurança especificadas.

6. Qual a função do anyRequest().authenticated()?  
Define que requisições exijam autenticação do usuário para serem realizadas, ao menos que uma regra específica já tenha sido atribuída para aquela requisição.

8. O que é uma API Stateless?  
Nenhuma informação sobre as interações do usuário anterior são armazenadas.

9. Explique o que a lambda abaixo faz:
session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
Impede que o servidor armazene a sessão http do usuário, com cada requisição necessitando de autenticação.
