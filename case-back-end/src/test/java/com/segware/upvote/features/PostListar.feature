#language: pt

  Funcionalidade: Listar post

    Como aplicação eu preciso listar os posts cadastrados.

    Esquema do Cenario: Listar post
      Dado que possuo um campo para buscar um post "<texto>"
      Quando confirmar a busca
      Então deve me retornar a quantidade de posts "<quantidade>"

      Exemplos:
      | texto       | quantidade    |
      | trabalho    | 2             |
      | tempo       | 1             |
      | invalida    | 0             |
      |             | 3             |
