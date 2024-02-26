// cart-dropdown.component.ts
import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartItems: any[] = [];

  constructor(private cartService: CartService) { }

  ngOnInit() {
    this.cartService.cartItems$.subscribe(items => {
      this.cartItems = items;
    });
  }


  increaseQuantity(index: number) {
    // Call cart service to increase quantity of the item at the specified index
    this.cartService.updateQuantity(index, this.cartItems[index].quantity + 1);
  }

  decreaseQuantity(index: number) {
    // Call cart service to decrease quantity of the item at the specified index
    const newQuantity = Math.max(1, this.cartItems[index].quantity - 1);
    this.cartService.updateQuantity(index, newQuantity);
  }

  removeItem(index: number) {
    // Call cart service to remove the item at the specified index
    this.cartService.removeFromCart(index);
  }

  confirmOrder() {
    // Implement logic to confirm the order
    // This can involve sending the order to the server, etc.
    // For simplicity, you can just clear the cart for this example
    this.cartService.clearCart();
  }

  clearCart() {
    // Call cart service to clear all items from the cart
    this.cartService.clearCart();
  }
}