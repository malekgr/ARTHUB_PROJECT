import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { GalleryComponent } from './gallery/gallery.component';
import { PaintingComponent } from './painting/painting.component';
import { ArtistComponent } from './artist/artist.component';
import{GalleryDescComponent} from './gallery-desc/gallery-desc.component';
import{PaintingDescComponent} from './painting-desc/painting-desc.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'gallery', component: GalleryComponent },
  { path: 'gallery/description', component: GalleryDescComponent },
  { path: 'painting', component: PaintingComponent },
  { path: 'painting/description', component: PaintingDescComponent },
  { path: 'artist', component: ArtistComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }, // Default route
  { path: '**', redirectTo: '/home' }, // Redirect any other route to Home
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
