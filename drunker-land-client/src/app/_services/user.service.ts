import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { User } from '../_models';

@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/users`);
    }

    getById(id: number) {
        return this.http.get(`${environment.apiUrl}/users/${id}`);
    }

    register(user: User) {
        if (user.role === 'Consumer') {
          return this.http.post(`${environment.apiUrl}/rest/api/consumers`, user);
        } else if (user.role === 'Supplier') {
          return this.http.post(`${environment.apiUrl}/rest/api/suppliers`, user);
        } else if (user.role === 'Reviewer') {
          return this.http.post(`${environment.apiUrl}/rest/api/reviewers`, user);
        } else if (user.role === 'Vendor') {
          return this.http.post(`${environment.apiUrl}/rest/api/vendors`, user);
        }

    }

    update(user: User) {
        return this.http.put(`${environment.apiUrl}/users/${user.id}`, user);
    }

    delete(id: number) {
        return this.http.delete(`${environment.apiUrl}/users/${id}`);
    }
}
