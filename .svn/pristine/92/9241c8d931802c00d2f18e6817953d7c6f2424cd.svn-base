package simu.framework;

import controller.IKontrolleri;
import simu.model.Palvelupiste;

public abstract class Moottori extends Thread{
	
	private double simulointiaika = 0;
	
	private Kello kello;
	private long viive = 20;
	protected Tapahtumalista tapahtumalista;
	protected Palvelupiste[] palvelupisteet;
	protected IKontrolleri kontrolleri; // UUSI
	

	public Moottori(IKontrolleri kontrolleri){
		this.kontrolleri=kontrolleri;
		kello = Kello.getInstance(); // Otetaan kello muuttujaan yksinkertaistamaan koodia
	
		tapahtumalista = new Tapahtumalista();
		
		// Palvelupisteet luodaan simu.model-pakkauksessa Moottorin aliluokassa 
		
		
	}

	public void setSimulointiaika(double aika) {
		simulointiaika = aika;
	}
	
	public void setViive(long viive) {
		this.viive = viive;
	}
	
	public long getViive() {
		return viive;
	}
	
	
	public void run(){
		alustukset(); // luodaan mm. ensimmäinen tapahtuma
		while (simuloidaan()){
			viive();
			kello.setAika(nykyaika());
			suoritaBTapahtumat();
			yritaCTapahtumat();

		}
		tulokset();
		
	}
	
	private void suoritaBTapahtumat(){
		while (tapahtumalista.getSeuraavanAika() == kello.getAika()){
			suoritaTapahtuma(tapahtumalista.poista());
		}
	}

	private void yritaCTapahtumat(){
		for (Palvelupiste p: palvelupisteet){
			if (!p.onVarattu() && p.onJonossa()){
				p.aloitaPalvelu();
			}
		}
	}

	
	private double nykyaika(){
		return tapahtumalista.getSeuraavanAika();
	}
	
	private boolean simuloidaan(){
		Trace.out(Trace.Level.INFO, "Kello on: " + kello.getAika());
		return kello.getAika() < simulointiaika;
	}
	
	private void viive() { // UUSI
		System.out.println ("Viive " + viive);
		try {
			sleep(viive);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

			

	protected abstract void alustukset(); // Määritellään simu.model-pakkauksessa Moottorin aliluokassa
	
	protected abstract void suoritaTapahtuma(Tapahtuma t);  // Määritellään simu.model-pakkauksessa Moottorin aliluokassa
	
	protected abstract void tulokset(); // Määritellään simu.model-pakkauksessa Moottorin aliluokassa
	
}