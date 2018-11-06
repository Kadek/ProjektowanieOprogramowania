import { Injectable } from '@angular/core';
import { RequestOptions, Response } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../models/Employee';

@Injectable()
export class DataService {

    private readonly httpOptions = {
            headers: new HttpHeaders({"Content-Type": "application/json"})
    };
    constructor(
        public http: HttpClient
    ) { }

    Dodaj_pracownika(employee: Employee) {
        return this.http.post('http://localhost:9090/dodajPracownika', employee)
        .subscribe((res:Response) => {
            console.log(res);
          });
    }

}
