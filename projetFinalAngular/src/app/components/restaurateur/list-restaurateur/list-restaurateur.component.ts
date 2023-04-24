import { Component } from '@angular/core';
import { Utilisateur } from 'src/app/model/utilisateur';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-list-restaurateur',
  templateUrl: './list-restaurateur.component.html',
  styleUrls: ['./list-restaurateur.component.css'],
})
export class ListRestaurateurComponent {
  restaurateurs: Utilisateur[] = [];

  constructor(private restaurateurSrv: RestaurateurService) {}
  ngOnInit(): void {
    this.initClient();
  }

  initClient() {
    this.restaurateurSrv.allRestaurateur().subscribe((datas: Utilisateur[]) => {
      this.restaurateurs = datas;
    });
  }

  delete(id: number) {
    this.restaurateurSrv.delete(id).subscribe(() => {
      this.initClient();
    });
  }
}
