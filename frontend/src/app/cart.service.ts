// cart.service.ts
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartItemsSubject = new BehaviorSubject<any[]>([]);
  cartItems$ = this.cartItemsSubject.asObservable();

  addToCart(item: any) {
    // Add logic to check if item is already in cart, update quantity
    // Otherwise, add the item to the cart
    // Emit the updated cartItems to subscribers
    const updatedCart = [...this.cartItemsSubject.value, item];
    this.cartItemsSubject.next(updatedCart);
  }

  removeFromCart(index: number) {
    // Remove item at the specified index from cart
    // Emit the updated cartItems to subscribers
    const updatedCart = [...this.cartItemsSubject.value];
    updatedCart.splice(index, 1);
    this.cartItemsSubject.next(updatedCart);
  }

  updateQuantity(index: number, quantity: number) {
    // Update quantity of the item at the specified index
    // Emit the updated cartItems to subscribers
    const updatedCart = [...this.cartItemsSubject.value];
    updatedCart[index].quantity = quantity;
    this.cartItemsSubject.next(updatedCart);
  }

  clearCart() {
    // Clear all items from the cart
    // Emit an empty array to subscribers
    this.cartItemsSubject.next([]);
  }
}
