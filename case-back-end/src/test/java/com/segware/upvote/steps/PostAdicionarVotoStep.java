package com.segware.upvote.steps;

import com.segware.upvote.SpringIntegrationTest;
import com.segware.upvote.utils.Validators;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;

public class PostAdicionarVotoStep extends SpringIntegrationTest {

    private Response response;
    private Integer postId;
    private String cenario = "Adicionar voto em post";

    @Dado("^que tenho um post para votar \"([^\"]*)\"$")
    public void queTenhoUmPostParaVotar(Integer id) throws Throwable {
        postId = id;
    }

    @Quando("^adionar um voto$")
    public void adicionarUmVoto() throws Throwable {
        response = putMessage( "/post/adicionar/"+ postId);
    }

    @Então("^o status retornado deve ser \"([^\"]*)\"$")
    public void oStatusRetornadoDeveSer(String status) throws Throwable {
        Validators.validaStatus(cenario, response, status);
    }

}
