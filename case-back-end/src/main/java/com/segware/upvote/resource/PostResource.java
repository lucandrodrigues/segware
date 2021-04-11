package com.segware.upvote.resource;

import com.segware.upvote.dto.FiltroDTO;
import com.segware.upvote.dto.PostDTO;
import com.segware.upvote.exception.ServiceException;
import com.segware.upvote.exception.ValidMessages;
import com.segware.upvote.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
@Api("/post")
@CrossOrigin()
public class PostResource {

    private final PostService service;

    @Autowired
    public PostResource(PostService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Cadastrar post", response = PostDTO.class, notes = "Cadastra um post para poder visualizar seus votos")
    public ResponseEntity<?> cadastrarPost(@Valid @ApiParam(value = "Parâmetros do cadastro do post") @RequestBody PostDTO dto, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidMessages.retornaMensagemErro(bindingResult));
        }
        return ResponseEntity.ok(service.cadastrarPost(dto.getTexto()));
    }

    @PostMapping("/listar")
    @ApiOperation(value = "Listar posts", response = PostDTO.class, notes = "Retorna os posts cadastrados")
    public ResponseEntity<?> listarPosts(@Valid @ApiParam(value = "Filtros e valores da paginação") @RequestBody FiltroDTO<PostDTO> filtro, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidMessages.retornaMensagemErro(bindingResult));
        }
        return ResponseEntity.ok(service.listarPosts(filtro));
    }

    @PutMapping("/adicionar/{id}")
    @ApiOperation(value = "Adicionar voto no post", response = PostDTO.class, notes = "Vota positivo em post a partir do identificador do post")
    public ResponseEntity<?> adicionarVoto(@ApiParam(value = "Identificador do post") @PathVariable("id") Integer id) throws ServiceException {
        return ResponseEntity.ok(service.adicionarVoto(id));
    }

    @PutMapping("/remover/{id}")
    @ApiOperation(value = "Remover voto no post", response = PostDTO.class, notes = "Vota negativo em post a partir do identificador do post")
    public ResponseEntity<?> removerVoto(@ApiParam(value = "Identificador do post") @PathVariable("id") Integer id) throws ServiceException {
        return ResponseEntity.ok(service.removerVoto(id));
    }
}
