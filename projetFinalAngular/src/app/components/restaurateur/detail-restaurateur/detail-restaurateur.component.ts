import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Utilisateur } from 'src/app/model/utilisateur';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-detail-restaurateur',
  templateUrl: './detail-restaurateur.component.html',
  styleUrls: ['./detail-restaurateur.component.css'],
})
export class DetailRestaurateurComponent {
  restaurateur!: Utilisateur;

  constructor(
    private restaurateurSrv: RestaurateurService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.restaurateur = new Utilisateur();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.restaurateurSrv
          .getById(params['id'])
          .subscribe((datas: Utilisateur) => {
            this.restaurateur = datas;
          });
      }
    });
  }

  delete(id: number) {
    this.restaurateurSrv.delete(id).subscribe(() => {
      sessionStorage.clear();
      this.router.navigateByUrl('/home');
    });
  }
}
