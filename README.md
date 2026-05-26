## Atividade - Introdução ao Spring Security
Nesta atividade você irá praticar conceitos básicos de configuração do Spring Security em APIs REST utilizando
Spring Boot.
### Parte 1 - Conceitos
1. Explique com suas palavras o que é Spring Security.  
Spring Security é uma biblioteca que fornece segurança extra com autentaticação dos usuários que requisitarão via HTTP.

2. Para que serve o método csrf().disable()?  
Serve para desabilitar a necessidade de utilizar um token de autenticação para realizar requisições API.

3. Explique o que significa SessionCreationPolicy.STATELESS.


4. Qual a função do permitAll()?
5. Explique o que faz o requestMatchers().
6. Qual a função do anyRequest().authenticated()?
7. O que é uma API Stateless?
8. Explique o que a lambda abaixo faz:
session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
