import { PostGridComponent } from './post-grid/post-grid.component';
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

const routes: Routes = [
    {
        path: '',
        component: PostGridComponent,
        data: {
          title: 'Post'
        }
      }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PostRoutingModule {
}
