import { AsyncPipe, CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RickService } from '../services/rick-service';
import { Observable } from 'rxjs';
import { Results } from '../model/Personaje';

@Component({
  selector: 'app-rick',
  imports: [CommonModule,AsyncPipe],
  templateUrl: './rick.html',
  styleUrl: './rick.css',
})
export class Rick {

  buleanoRick:boolean = false;

  numeroEpisodios:number=0;

  constructor(private servicioRick:RickService) {}

  listaPersonajes$ = new Observable<Results>

  mostrarRick(){

    this.listaPersonajes$ = this.servicioRick.mostrarPersonajes();

    this.buleanoRick = true;

  }

}
