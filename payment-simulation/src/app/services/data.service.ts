import { Injectable } from '@angular/core';
import { Headers, RequestOptions, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DataService {

    constructor(public http: HttpClient) { }

    id:string; 

    sendStatus(status) {
        this.id = window.location.href.split("/")[3];
        if (status === "Porażka") {
            console.log('wysłana Porażka');
            return this.http.get(`http://localhost:9093/failure?id=${this.id}`).subscribe(res => console.log(res));
        } else {
            console.log('wysłany Sukces');
            return this.http.get(`http://localhost:9093/success?id=${this.id}`).subscribe(res => console.log(res));
        }
    }
}
