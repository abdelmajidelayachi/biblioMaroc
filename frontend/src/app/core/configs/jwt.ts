
export class Jwt {
  
  static setTokenToLocalStorage(token: string) {
    localStorage.setItem('token', token);
  }

  static getTokenFromLocalStorage() {
    return localStorage.getItem('token');
  }

  static removeTokenFromLocalStorage() {
    localStorage.removeItem('token');
  }

  static decodeTokenGetPayload(token: string) {
    return JSON.parse(atob(token.split('.')[1]));
  }

  static checkOfTokenExpiration(token: string) {
    const payload = this.decodeTokenGetPayload(token);
    return payload.exp > Date.now() / 1000;
  }
}