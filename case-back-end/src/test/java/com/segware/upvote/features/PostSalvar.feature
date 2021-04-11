#language: pt

  Funcionalidade: Salvar um post

    Como aplicação eu preciso salvar um post.

    Esquema do Cenario: Salvar um post
      Dado que possuo um post para salvar "<texto>"
      Quando salvar o post
      Então deve me retornar o status "<status>"

      Exemplos:
      | texto       | status    |
      | texto       | 200       |
      |             | 400       |
