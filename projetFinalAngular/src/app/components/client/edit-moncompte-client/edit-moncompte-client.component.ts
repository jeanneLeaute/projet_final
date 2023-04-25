import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-edit-moncompte-client',
  templateUrl: './edit-moncompte-client.component.html',
  styleUrls: ['./edit-moncompte-client.component.css'],
})
export class EditMoncompteClientComponent {
  constructor(
    private clientSrv: ClientService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  client!: Utilisateur;

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

  save() {
    if (this.client.id) {
      this.clientSrv.update(this.client).subscribe(() => {
        this.router.navigateByUrl('/list-client');
      });
    } else {
      this.clientSrv.create(this.client).subscribe(() => {
        this.router.navigateByUrl('/list-client');
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
