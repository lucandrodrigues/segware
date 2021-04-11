import { FunctionsUtil } from './../../util/functions-util';
import { PostResource } from './../../rest/post/post-resource';
import { Page } from './../../util/page';
import { Observable, throwError } from 'rxjs';
import { FiltroUtil } from './../../util/filtro-util';
import { Injectable } from '@angular/core';
import { Post } from '../../models/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private resource: PostResource) { }

  public listarPosts(filtro: FiltroUtil): Observable<Page<Post>> {
    if (!filtro || filtro === null) {
        return throwError('Filtros devem ser informados');
    }
    return this.resource.listarPosts(filtro);
  }

  public salvarPost(post: Post): Observable<Post> {
    if (!post || post === null) {
        return throwError('Post deve ser informado');
    }
    return this.resource.salvarPost(post);
  } 

  public adicionarVoto(PostId: number): Observable<Post> {
    if (FunctionsUtil.isEmptyId(PostId)) {
        return throwError('Post deve ser informado');
    }
    return this.resource.adicionarVoto(PostId);
  }
  
  public removerVoto(PostId: number): Observable<Post> {
    if (FunctionsUtil.isEmptyId(PostId)) {
        return throwError('Post deve ser informado');
    }
    return this.resource.removerVoto(PostId);
  } 

}
