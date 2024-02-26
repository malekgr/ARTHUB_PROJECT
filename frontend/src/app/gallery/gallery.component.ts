import { Component } from '@angular/core';
import { ProviderService } from '../provider.service';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrl: './gallery.component.css'
})
export class GalleryComponent {
  constructor(public _provider:ProviderService) { }
  galleries:any;
  ngOnInit(): void{
    this._provider.get_galleries().subscribe(
      res=>{
        this.galleries=res;
    },
      err=>{
       console.log(err); 
      }
    )
  }
}
