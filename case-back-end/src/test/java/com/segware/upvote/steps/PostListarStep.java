package com.segware.upvote.steps;

import com.segware.upvote.SpringIntegrationTest;
import com.segware.upvote.dto.FiltroDTO;
import com.segware.upvote.dto.PostTesteDTO;
import com.segware.upvote.utils.Validators;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;

public class PostListarStep extends SpringIntegrationTest {

    private Response response;
    private FiltroDTO<PostTesteDTO> filtro;
    private PostTesteDTO dto;
    private String cenario = "Listar cidades";

    @Dado("^que possuo um campo para buscar um post \"([^\"]*)\"$")
    public void quePossuoUmCampoParaBuscarUmPost(String nome) throws Throwable {
        dto = new PostTesteDTO(nome);
        filtro = new FiltroDTO<>();
        filtro.setObj(dto);
    }

    @Quando("^confirmar a busca")
    public void confirmarABusca() throws Throwable {
        response = postMessage(filtro, "/post/listar");
    }

    @Então("^deve me retornar a quantidade de posts \"([^\"]*)\"$")
    public void deveMeRetornarAQuantidadeDePosts(int quantidade) throws Throwable {
        Validators.validaQuantidadeRegistros(cenario, response, quantidade);
    }
}
