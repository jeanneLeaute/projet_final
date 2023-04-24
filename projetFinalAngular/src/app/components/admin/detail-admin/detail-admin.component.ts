import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Utilisateur } from 'src/app/model/utilisateur';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-detail-admin',
  templateUrl: './detail-admin.component.html',
  styleUrls: ['./detail-admin.component.css'],
})
export class DetailAdminComponent implements OnInit {
  admin!: Utilisateur;

  constructor(
    private adminSrv: AdminService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.admin = new Utilisateur();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.adminSrv.getById(params['id']).subscribe((datas: Utilisateur) => {
          this.admin = datas;
        });
      }
    });
  }

  delete(id: number) {
    this.adminSrv.delete(id).subscribe(() => {
      sessionStorage.clear();
      this.router.navigateByUrl('/home');
    });
  }
}
