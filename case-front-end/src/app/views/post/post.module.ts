import { ReactiveFormsModule } from '@angular/forms';
import { FormValidatorDirective } from './../../util/form-validator.directive';
import { OverlayComponent } from './../../componentes/overlay/overlay.component';
import { VsmGridModule } from './../../componentes/vsm-grid/vsm-grid.module';
import { PostRoutingModule } from './post-routing.module.';
import { PostGridComponent } from './post-grid/post-grid.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostFormComponent } from './post-form/post-form.component';
import { TooltipModule } from 'ngx-bootstrap/tooltip';

@NgModule({
  declarations: [
    PostGridComponent,
    PostFormComponent,
    OverlayComponent,
    FormValidatorDirective
  ],
  imports: [
    CommonModule,
    VsmGridModule,
    PostRoutingModule,
    ReactiveFormsModule,
    TooltipModule.forRoot()
  ],
  exports: [
    PostGridComponent,
    PostFormComponent,
    TooltipModule
  ]
})
export class PostModule { }
