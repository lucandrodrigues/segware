#language: pt

  Funcionalidade: Remover voto em post

    Como aplicação eu preciso remover um voto a um post.

    Esquema do Cenario: Remover voto em post
      Dado que possuo um post para votar "<id>"
      Quando remover um voto
      Então o status retornado deve ser um "<status>"

      Exemplos:
      | id  | status    |
      | 1   | 200       |
      | 9   | 404       |
      |     | 400       |
