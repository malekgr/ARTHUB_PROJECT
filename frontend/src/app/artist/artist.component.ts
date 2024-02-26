import { Component } from '@angular/core';
import { ProviderService } from '../provider.service';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrl: './artist.component.css'
})
export class ArtistComponent {
constructor(public _provider:ProviderService){}
}
