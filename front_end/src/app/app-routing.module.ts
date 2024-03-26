import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './Components/main/main.component';
import { MenuComponent } from './Components/menu/menu.component';
import { ListePsComponent } from './Components/Admin/liste-ps/liste-ps.component';

const routes: Routes = [

  {
    path: 'user',
    component: MenuComponent,
    children: [
      {
        path: 'ps',
        component: ListePsComponent,
      },

    ]},






] ;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
