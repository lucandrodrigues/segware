import { endpointBackend } from './../../util/endpoint-config';
import { Page } from './../../util/page';
import { Observable } from 'rxjs';
import { FiltroUtil } from './../../util/filtro-util';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../../models/post';

@Injectable({
    providedIn: 'root'
})
export class PostResource {
    constructor(private http: HttpClient) {
    }

    public listarPosts(filtro: FiltroUtil): Observable<Page<Post>> {
        return this.http.post<Page<Post>>(endpointBackend + 'post/listar', filtro);
    }

    public salvarPost(post: Post): Observable<Post> {
        return this.http.post<Post>(endpointBackend + 'post', post);
    }

    public adicionarVoto(postId: number): Observable<Post> {
        return this.http.put<Post>(endpointBackend + 'post/adicionar/'+ postId.toString(), null);
    }

    public removerVoto(postId: number): Observable<Post> {
        return this.http.put<Post>(endpointBackend + 'post/remover/'+ postId.toString(), null);
    }

}