import { MensagemService } from './../../../service/mensagem.service';
import { PostService } from './../../../service/post/post.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges, OnChanges, ElementRef, ViewChild } from '@angular/core';
import { Post } from '../../../models/post';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.scss']
})
export class PostFormComponent implements OnInit, OnChanges {

  @ViewChild('focoTexto') foco: ElementRef;

  @Input() abriuModal = false;
  @Output() onSalvar = new EventEmitter();
  public form: FormGroup;
  public post: Post = new Post();

  constructor(private fb: FormBuilder,
    private service: PostService,
    private mensagemService: MensagemService) {
    this.form = fb.group({
        id: [null],
        texto: [null, Validators.compose([Validators.required])],
    });
   }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes) {
        if (this.abriuModal === true) {
            this.form.reset();
        }
    }
  }

  public salvar() {
    this.post = this.form.getRawValue();
    this.service.salvarPost(this.post).subscribe(
        (response) => {
            this.form.patchValue(response);
            this.mensagemService.sucesso(':)', 'Novo post adicionado!');
            this.onSalvar.emit(this.post);
        });
  }

}
