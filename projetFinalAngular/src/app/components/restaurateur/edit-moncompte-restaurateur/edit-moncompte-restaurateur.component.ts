import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-edit-moncompte-restaurateur',
  templateUrl: './edit-moncompte-restaurateur.component.html',
  styleUrls: ['./edit-moncompte-restaurateur.component.css'],
})
export class EditMoncompteRestaurateurComponent implements OnInit {
  constructor(
    private restaurateurSrv: RestaurateurService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  restaurateur!: Utilisateur;

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

  save() {
    if (this.restaurateur.id) {
      //update
      this.restaurateurSrv.update(this.restaurateur).subscribe(() => {
        this.router.navigateByUrl('/list-restaurateur');
      });
    } else {
      //create
      this.restaurateurSrv.create(this.restaurateur).subscribe(() => {
        this.router.navigateByUrl('/list-restaurateur');
      });
    }
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
