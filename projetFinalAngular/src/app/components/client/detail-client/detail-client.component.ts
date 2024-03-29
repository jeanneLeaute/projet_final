import { Utilisateur } from 'src/app/model/utilisateur';
import { Client } from './../../../model/client';
import { ClientService } from './../../../services/client.service';
import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Role } from 'src/app/model/role';

@Component({
  selector: 'app-detail-client',
  templateUrl: './detail-client.component.html',
  styleUrls: ['./detail-client.component.css'],
})
export class DetailClientComponent implements OnInit {
  client!: Utilisateur;

  constructor(
    private clientSrv: ClientService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.client = new Utilisateur();
    if (this.isAdmin) {
      this.activatedRoute.params.subscribe((params) => {
        if (params['id']) {
          this.clientSrv
            .getById(params['id'])
            .subscribe((datas: Utilisateur) => {
              this.client = datas;
            });
        }
      });
    }
  }

  delete(id: number) {
    this.clientSrv.delete(id).subscribe(() => {
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

  get isAdmin(): boolean {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.role == Role.ROLE_ADMIN;
    }
    return false;
  }
}
