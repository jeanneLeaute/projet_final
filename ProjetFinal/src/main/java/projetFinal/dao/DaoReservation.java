package projetFinal.dao;

import java.util.List;

import projetFinal.entities.Client;
import projetFinal.entities.Reservation;
import projetFinal.entities.Restaurant;

public interface DaoReservation extends DaoGenerique<Reservation, Long>{
	public List<Reservation> findByRestaurant(Restaurant restaurant) ;
	public List<Reservation> findByClient(Client client);
}
