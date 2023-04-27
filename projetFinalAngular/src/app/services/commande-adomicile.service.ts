import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ObjectToJsonService } from './object-to-json.service';
import { CommandeADomicile } from '../model/commande-adomicile';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CommandeADomicileService {
  private url: string =
    'http://localhost:8080/projetFinal/api/commandeADomicile';

  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

  public create(commande: any): Observable<any> {
    console.debug(commande);
    return this.httpClient.post<CommandeADomicile>(
      this.url,
      this.convert.commandeToJson(commande)
    );
  }

  public update(commande: CommandeADomicile): Observable<CommandeADomicile> {
    return this.httpClient.put<CommandeADomicile>(
      `${this.url}/${commande.id}`,
      this.convert.commandeToJson(commande)
    );
  }

  public allCommandeADomicile(): Observable<CommandeADomicile[]> {
    return this.httpClient.get<CommandeADomicile[]>(this.url);
  }

  public getById(id: number): Observable<CommandeADomicile> {
    return this.httpClient.get<CommandeADomicile>(`${this.url}/${id}`);
  }
}
