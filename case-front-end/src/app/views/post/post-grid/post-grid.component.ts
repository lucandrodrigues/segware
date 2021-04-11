import { PostService } from '../../../service/post/post.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { FiltroUtil } from './../../../util/filtro-util';
import { Page } from './../../../util/page';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Post } from '../../../models/post';

@Component({
  selector: 'app-post-grid',
  templateUrl: './post-grid.component.html',
  styleUrls: ['./post-grid.component.scss']
})
export class PostGridComponent implements OnInit {

  @ViewChild('foco') foco: ElementRef;

  public posts: Page<Post> = new Page<Post>(new Array<Post>(), 0);
  public filtro: FiltroUtil = new FiltroUtil();
  public postSelecionado = new Post();
  public showSidebar = false;
  public paginaSelecionada = 1;
  public formFiltro: FormGroup;
  
  constructor(
    private service: PostService,
    public fb: FormBuilder
  ) { 
    this.formFiltro = fb.group({
      texto: [null]
  });
  }

  ngOnInit() {
    this.foco.nativeElement.focus();
    this.filtro.obj = new Post();
    this.filtrar();
  }

  private filtrar() {
    this.service.listarPosts(this.filtro).subscribe(
        (response) => {
            this.posts = response;
        });
  }

  public pesquisar() {
    this.filtro.obj = this.formFiltro.getRawValue();
    this.filtrar();
  }

  public paginar(event) {
    this.paginaSelecionada = event.page;
    this.filtro.page = event.page - 1;
    this.filtrar();
  }

  public adicionarVoto(id: number) {
    this.service.adicionarVoto(id).subscribe(
      (response) => {
        this.atualizarVoto(response);
      });
  }

  public removerVoto(id: number) {
    this.service.removerVoto(id).subscribe(
      (response) => {
        this.atualizarVoto(response);
      });
  }

  private atualizarVoto(post: Post) {
    this.posts.content.map(i => {
      if (i.id === post.id) {
        i.voto = post.voto;
      }
      return i;
    });
  }

  public novoPost(){
    this.postSelecionado = new Post();
    this.showSidebar = true;
  }

  public salvarPost(event) {
    this.filtro.obj = event;
    this.formFiltro.patchValue(event);
    this.showSidebar = false;
    this.filtrar();
}


}
