import { Routes } from '@angular/router';
import { Rick } from './rick/rick';
import { Episodios } from './episodios/episodios';
import { Menu } from './menu/menu';
import { Home } from './home/home';

export const routes: Routes = [

    {path:"rick",component:Rick},
    {path:"episodios",component:Episodios},
    
];
