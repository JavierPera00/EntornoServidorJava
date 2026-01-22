import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Home } from "./home/home";
import { Menu } from './menu/menu';
import { Rick } from "./rick/rick";
import { Episodios } from "./episodios/episodios";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Menu, Home, Rick,Episodios],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {


}
