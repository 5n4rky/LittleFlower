import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isAuthenticated: boolean = false;
  private username: string | null = null;
  private password: string | null = null;

  constructor() { }

  login(username: string, password: string): boolean {
    // Perform actual login logic here (e.g., check credentials with an API)
    // For simplicity, we will use hardcoded credentials
    if (username === 'sai' && password === 'hackathon') {
      this.isAuthenticated = true;
      this.username = username;
      this.password = password;
      return true;
    } else {
      this.isAuthenticated = false;
      this.username = null;
      this.password = null;
      return false;
    }
  }

  logout(): void {
    this.isAuthenticated = false;
    this.username = null;
    this.password = null;
  }

  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }

  getUsername(): string | null {
    return this.username;
  }

  getPassword(): string | null {
    return this.password;
  }
}
