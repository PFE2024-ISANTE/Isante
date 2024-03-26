import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../Models/User';
import { Observable } from 'rxjs';
import { ERole } from '../Models/Role';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private apiUrl = 'http://localhost:8034/api/utilisateurs';

  constructor(private http: HttpClient) {}

  getUtilisateursByRole(role: ERole): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/byRole/${role}`);
  }


  getUtilisateursByMat(mat: string): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/byMat/${mat}`);
  }

  ajouterRoleAUtilisateur(utilisateurId: number, role: ERole): Observable<any> {
    return this.http.post(`${this.apiUrl}/ajouterRole?utilisateurId=${utilisateurId}&role=${role}`, {});
  }

  supprimerRoleUtilisateur(utilisateurId: number, role: ERole): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${utilisateurId}/roles/${role}`);
  }

  ajouterUtilisateur(utilisateur: User, roleName: string): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/${roleName}`, utilisateur);
  }
  desactiverCompte(userId: number): Observable<string> {
    return this.http.put<string>(`${this.apiUrl}/disable/${userId}`, {});
  }

  activerCompte(userId: number): Observable<string> {
    return this.http.put<string>(`${this.apiUrl}/able/${userId}`, {});
  }

  deleteUtilisateur(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/`);
  }

  getAllUsersNotadmin(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/Notadmin`);
  }









}
