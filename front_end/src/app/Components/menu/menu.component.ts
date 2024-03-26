import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {



  ngOnInit(): void {

    const hamBurger = document.querySelector(".toggle-btn");

    // Check if hamBurger is not null before adding event listener
    if (hamBurger) {
      hamBurger.addEventListener("click", function () {
        document.querySelector("#sidebar").classList.toggle("expand");
      });
    }
  }
  }



