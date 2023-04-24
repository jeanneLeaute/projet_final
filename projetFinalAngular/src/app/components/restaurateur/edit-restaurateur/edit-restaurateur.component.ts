import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Utilisateur } from 'src/app/model/utilisateur';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-edit-restaurateur',
  templateUrl: './edit-restaurateur.component.html',
  styleUrls: ['./edit-restaurateur.component.css'],
})
export class EditRestaurateurComponent {
  constructor(
    private restaurateurSrv: RestaurateurService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  restaurateur!: Utilisateur;

  ngOnInit(): void {
    this.restaurateur = new Utilisateur();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.restaurateurSrv
          .getById(params['id'])
          .subscribe((data: Utilisateur) => {
            this.restaurateur = data;
          });
      }
    });
    console.debug(this.restaurateur);
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
}
