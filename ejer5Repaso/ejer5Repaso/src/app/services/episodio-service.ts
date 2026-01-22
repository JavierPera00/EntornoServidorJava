import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Results } from '../model/Episodio';

@Injectable({
  providedIn: 'root',
})
export class EpisodioService {

  constructor(private http:HttpClient){}

  url:string = "https://rickandmortyapi.com/api/episode"

  mostrarEpisodios(): Observable<Results>{

    return this.http.get<Results>(this.url)
    
  }
  
}
