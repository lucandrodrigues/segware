#language: pt

  Funcionalidade: Adicionar voto em post

    Como aplicação eu preciso adicionar um voto a um post.

    Esquema do Cenario: Adicionar voto em post
      Dado que tenho um post para votar "<id>"
      Quando adionar um voto
      Então o status retornado deve ser "<status>"

      Exemplos:
      | id  | status    |
      | 1   | 200       |
      | 9   | 404       |
      |     | 400       |
