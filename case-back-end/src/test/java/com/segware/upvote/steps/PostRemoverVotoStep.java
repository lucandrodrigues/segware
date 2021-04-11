package com.segware.upvote.steps;

import com.segware.upvote.SpringIntegrationTest;
import com.segware.upvote.utils.Validators;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;

public class PostRemoverVotoStep extends SpringIntegrationTest {

    private Response response;
    private Integer postId;
    private String cenario = "Remover voto em post";

    @Dado("^que possuo um post para votar \"([^\"]*)\"$")
    public void quePossuoUmPostParaVotar(Integer id) throws Throwable {
        postId = id;
    }

    @Quando("^remover um voto$")
    public void removerUmVoto() throws Throwable {
        response = putMessage("/post/remover/"+ postId);
    }

    @Então("^o status retornado deve ser um \"([^\"]*)\"$")
    public void oStatusRetornadoDeveSerUm(String status) throws Throwable {
        Validators.validaStatus(cenario, response, status);
    }

}
