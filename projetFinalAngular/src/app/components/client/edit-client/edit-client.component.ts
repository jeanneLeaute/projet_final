import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Client } from 'src/app/model/client';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css'],
})
export class EditClientComponent {
  constructor(
    private clientSrv: ClientService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  client!: Utilisateur;

  ngOnInit(): void {
    this.client = new Utilisateur();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.clientSrv.getById(params['id']).subscribe((data: Utilisateur) => {
          this.client = data;
        });
      }
    });
    console.debug(this.client);
  }

  save() {
    if (this.client.id) {
      //update
      this.clientSrv.update(this.client).subscribe(() => {
        this.router.navigateByUrl('/list-client');
      });
    } else {
      //create
      this.clientSrv.create(this.client).subscribe(() => {
        this.router.navigateByUrl('/list-client');
      });
    }
  }
}
