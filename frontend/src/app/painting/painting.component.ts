import { Component } from '@angular/core';
import { ProviderService } from '../provider.service';

@Component({
  selector: 'app-painting',
  templateUrl: './painting.component.html',
  styleUrl: './painting.component.css'
})
export class PaintingComponent {
  paintings:any;
  constructor(public _provider:ProviderService) { }
ngOnInit(): void{
  this._provider.get_paintings().subscribe(
    res=>{
      console.log(res);
      this.paintings=res;
  },
    err=>{
     console.log(err); 
    }
  )
}
}


