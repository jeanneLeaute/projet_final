import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/client';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.css'],
})
export class ListClientComponent implements OnInit {
  clients: Utilisateur[] = [];

  constructor(private clientSrv: ClientService) {}
  ngOnInit(): void {
    this.initClient();
  }

  initClient() {
    this.clientSrv.allClient().subscribe((datas: Utilisateur[]) => {
      this.clients = datas;
    });
  }

  delete(id: number) {
    this.clientSrv.delete(id).subscribe(() => {
      this.initClient();
    });
  }
}
