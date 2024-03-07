import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/dashboard', title: 'Dashboard',  icon: 'dashboard', class: '' },
    { path: '/user-profile', title: 'User Profile',  icon:'person', class: '' },
    { path: '/table-list', title: 'Event',  icon:' bubble_chart', class: '' },
    { path: '/offre', title: 'Offre',  icon:'content_paste', class: '' },
    { path: '/proposition', title: 'proposition',  icon:'library_books', class: '' },
    { path: '/produit', title: 'produit',  icon:'library_books', class: '' },
    { path: '/OffreFournisseur', title: 'OffreFournisseur',  icon:'library_books', class: '' },
    { path: '/upgrade', title: 'SITEWEB',  icon:'unarchive', class: 'active-pro' },
    { path: '/act', title: 'act',  icon:'library_books', class: '' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
      console.log(this.menuItems)
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
