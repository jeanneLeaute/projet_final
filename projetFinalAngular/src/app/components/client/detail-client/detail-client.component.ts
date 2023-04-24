import { Utilisateur } from 'src/app/model/utilisateur';
import { Client } from './../../../model/client';
import { ClientService } from './../../../services/client.service';
import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

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
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.clientSrv.getById(params['id']).subscribe((datas: Utilisateur) => {
          this.client = datas;
        });
      }
    });
  }

  delete(id: number) {
    this.clientSrv.delete(id).subscribe(() => {
      this.router.navigateByUrl('/home');
    });
  }
}
