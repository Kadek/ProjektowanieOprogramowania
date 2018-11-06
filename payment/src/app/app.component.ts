import { Component } from '@angular/core';
import { Payment } from './models/payment';
import { DataService } from './services/data.service';
import { Observable } from 'rxjs';
import { interval } from 'rxjs';
import {  } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'payment';
  payment: Payment = new Payment();
  paymentOptions: any = [
    'BLIK',
    'CARD',
    'PRZELEW'
  ];
  status: string;

  constructor(public dataService: DataService) { }

  ngOnInit() { 
    interval(10000)
    .subscribe(res => {
    this.dataService.getStatus();
    });
  }

  onSubmit() {
    this.dataService.pay(this.payment);
  }

  radioChangeHandler(event: any) {
    this.payment.sposób_zapłaty = event.target.value;
  }
}
