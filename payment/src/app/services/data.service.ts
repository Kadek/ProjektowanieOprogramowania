import { Injectable } from '@angular/core';
import { Headers, RequestOptions, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Payment } from '../models/Payment';
import { Status } from '../models/Status';

@Injectable()
export class DataService {

    constructor(public http: HttpClient) { }

    id: string;

    pay(payment: Payment) {
        payment.id_klienta = 1;
        payment.id_zamowienia = 1;
        payment.suma = 30;
        return this.http.post('http://localhost:9092/zaplac', payment).subscribe(res => this.processLink(res));
    }

    processLink(res) {
        window.open(res["redirectLink"], "_blank")
        this.id = res["redirectLink"].split("/")[3];
        console.log(this.id);
    }

    
    getStatus() {
        return this.http.get(`http://localhost:9092/pobierz_status?id=${this.id}`)
            .subscribe(res => console.log(res));
    } 
}
