import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { GalleryComponent } from './gallery/gallery.component';
import { ArtistComponent } from './artist/artist.component';
import { PaintingComponent } from './painting/painting.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './footer/footer.component';
import { GalleryDescComponent } from './gallery-desc/gallery-desc.component';
import { PaintingDescComponent } from './painting-desc/painting-desc.component';
import { CartComponent } from './cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    GalleryComponent,
    ArtistComponent,
    PaintingComponent,
    HomeComponent,
    UserComponent,
    LoginComponent,
    SignupComponent,
    FooterComponent,
    GalleryDescComponent,
    PaintingDescComponent,
    CartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
