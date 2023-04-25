import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-moncompte-restaurateur',
  templateUrl: './moncompte-restaurateur.component.html',
  styleUrls: ['./moncompte-restaurateur.component.css'],
})
export class MoncompteRestaurateurComponent implements OnInit {
  restaurateur!: Utilisateur;

  constructor(
    private restaurateurSrv: RestaurateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.restaurateur = new Utilisateur();
    if (this.isRestaurateur) {
      this.restaurateurSrv
        .getById(this.IdUtilisateur)
        .subscribe((datas: Utilisateur) => {
          this.restaurateur = datas;
        });
    }
  }

  delete(id: number) {
    this.restaurateurSrv.delete(id).subscribe(() => {
      sessionStorage.clear();
      this.router.navigateByUrl('/home');
    });
  }

  get IdUtilisateur(): number {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.id!;
    }
    return 0;
  }

  get isRestaurateur(): boolean {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.role == Role.ROLE_RESTAURATEUR;
    }
    return false;
  }
}
