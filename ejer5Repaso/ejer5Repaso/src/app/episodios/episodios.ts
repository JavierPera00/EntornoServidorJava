import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Results } from '../model/Episodio';
import { EpisodioService } from '../services/episodio-service';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-episodios',
  imports: [CommonModule,AsyncPipe],
  templateUrl: './episodios.html',
  styleUrl: './episodios.css',
})
export class Episodios implements OnInit{

  listaEpisodios$ = new Observable<Results>

  constructor(private servicioEpisodio: EpisodioService){}

  ngOnInit(): void {

    this.listaEpisodios$ = this.servicioEpisodio.mostrarEpisodios()
    
  }

}
