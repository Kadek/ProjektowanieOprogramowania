import { Component } from '@angular/core';
import { DataService } from './services/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'payment-simulation';
  status1: string = "Porażka";
  status2: string = "Sukcess";

  constructor(public dataService: DataService) { }
  ngOnInit() { }

  onSubmit() {
    this.radioChangeHandler(event);
    console.log(status);
    this.dataService.sendStatus(status);
  }

  radioChangeHandler(event: any) {
    status = event.target.value;
  }

}