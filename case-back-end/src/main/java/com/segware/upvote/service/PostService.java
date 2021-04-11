package com.segware.upvote.service;

import com.segware.upvote.dto.FiltroDTO;
import com.segware.upvote.dto.PostDTO;
import com.segware.upvote.entity.Post;
import com.segware.upvote.exception.EnumErrorException;
import com.segware.upvote.exception.ServiceException;
import com.segware.upvote.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    /**
     * @param 'FiltroDTO<PostDTO>' - filtro genérico para busca de posts
     * @return 'Page<PostDTO>' - Pagina de dto de posts
     * @throws ServiceException
     * @author Lucas Andrade
     * @method Método responsável por listar os posts cadastrados
     */
    public Page<PostDTO> listarPosts(FiltroDTO<PostDTO> filtro) throws ServiceException {
        if (ObjectUtils.isEmpty(filtro)) {
            throw new ServiceException(EnumErrorException.PARAMETROS_INVALIDOS);
        }

        try {
            return repository.listarPosts(filtro.getObj().getTexto(), PageRequest.of(filtro.getPage(), filtro.getSize()));
        } catch (Exception e) {
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Falha ao buscar posts no banco de dados."});
        }
    }

    /**
     * @param 'String' - Texto do post a ser cadastrado
     * @return 'PostDTO' -  Dto do post
     * @throws ServiceException
     * @author Lucas Andrade
     * @method Método responsável por cadastrar uma post
     */
    public PostDTO cadastrarPost(String texto) throws ServiceException {
        try {
            Post post = new Post();
            post.setTexto(texto);
            return salvar(post);
        } catch (Exception e) {
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Falha ao cadastrar posts no banco de dados."});
        }
    }

    /**
     * @param 'Integer' - Identificador do post
     * @return 'PostDTO' -  Dto do post
     * @throws ServiceException
     * @author Lucas Andrade
     * @method Método responsável por adicionar voto em um post
     */
    public PostDTO adicionarVoto(Integer id) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new ServiceException(EnumErrorException.NAO_LOCALIZADO, new Object[]{"Post não localizado"}));

        post.adicionarVoto();
        return salvar(post);
    }

    /**
     * @param 'Integer' - Identificador do post
     * @return 'PostDTO' -  Dto do post
     * @throws ServiceException
     * @author Lucas Andrade
     * @method Método responsável remover voto em um post
     */
    public PostDTO removerVoto(Integer id) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new ServiceException(EnumErrorException.NAO_LOCALIZADO, new Object[]{"Post não localizado"}));

        post.removerVoto();
        return salvar(post);
    }

    private PostDTO salvar(Post post) {
        post = repository.save(post);
        PostDTO dto = new PostDTO();
        BeanUtils.copyProperties(post, dto);
        return dto;
    }

}
