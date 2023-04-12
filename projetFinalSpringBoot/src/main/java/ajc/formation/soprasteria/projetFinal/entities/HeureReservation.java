package ajc.formation.soprasteria.projetFinal.entities;

public enum HeureReservation {
	H11("11h"),H11m30("11h30"),H12("12h"),H12m30("12h30"),H13("13h"),H19("19h"),H19m30("19h30"),H20("20h"),H20m30("20h30"),H21("21h");
	
	private String heure;

	HeureReservation(String heure) {
		this.heure=heure;
	}
	
	public String getHeure() {
		return this.heure;
	}
	
}
