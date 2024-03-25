import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

const routes: Routes = [
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: '', redirectTo: '/forgot-password', pathMatch: 'full' } // Redirige vers forgot-password par défaut
];
@NgModule({
  imports: [RouterModule.forRoot(routes , { useHash : true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
