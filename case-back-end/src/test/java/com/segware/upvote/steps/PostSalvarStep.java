package com.segware.upvote.steps;

import com.segware.upvote.SpringIntegrationTest;
import com.segware.upvote.dto.PostTesteDTO;
import com.segware.upvote.utils.Validators;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;

public class PostSalvarStep extends SpringIntegrationTest {

    private Response response;
    private PostTesteDTO dto;
    private String cenario = "Salvar um post";

    @Dado("^que possuo um post para salvar \"([^\"]*)\"$")
    public void quePossuoUmPostParaSalvar(String texto) throws Throwable {
        dto = new PostTesteDTO(texto);
    }

    @Quando("^salvar o post$")
    public void salvarOPost() throws Throwable {
        response = postMessage(dto, "/post");
    }

    @Então("^deve me retornar o status \"([^\"]*)\"$")
    public void deveMeRetornarOStatus(String status) throws Throwable {
        Validators.validaStatus(cenario, response, status);
    }

}
