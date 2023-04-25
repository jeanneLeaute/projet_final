import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-moncompte-client',
  templateUrl: './moncompte-client.component.html',
  styleUrls: ['./moncompte-client.component.css'],
})
export class MoncompteClientComponent implements OnInit {
  client!: Utilisateur;

  constructor(private clientSrv: ClientService, private router: Router) {}

  ngOnInit(): void {
    this.client = new Utilisateur();
    if (this.isClient) {
      this.clientSrv
        .getById(this.IdUtilisateur)
        .subscribe((datas: Utilisateur) => {
          this.client = datas;
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

  get isClient(): boolean {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.role == Role.ROLE_CLIENT;
    }
    return false;
  }
}
