package com.segware.upvote.repository;

import com.segware.upvote.dto.PostDTO;
import com.segware.upvote.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT new com.segware.upvote.dto.PostDTO(" +
            "p.id, p.texto, p.voto) " +
            "FROM Post p " +
            "WHERE (:texto is null or p.texto like CONCAT('%', :texto, '%')) " +
            "ORDER BY p.dataCriacao DESC")
    Page<PostDTO> listarPosts(String texto, Pageable pageable);

}
