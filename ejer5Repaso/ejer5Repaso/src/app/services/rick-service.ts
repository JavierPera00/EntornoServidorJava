import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Results } from '../model/Personaje';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RickService {

  url:string = "https://rickandmortyapi.com/api/character/";

  constructor(private http:HttpClient){}

  mostrarPersonajes(): Observable<Results>{

    return this.http.get<Results>(this.url)
    
  }


  
}
