package simu.model;

import java.util.LinkedList;

import eduni.distributions.ContinuousGenerator;
import simu.framework.Kello;
import simu.framework.Tapahtuma;
import simu.framework.Tapahtumalista;
import simu.framework.Trace;

// TODO:
// Palvelupistekohtaiset toiminnallisuudet, laskutoimitukset (+ tarvittavat muuttujat) ja raportointi koodattava
public class Palvelupiste {

	private LinkedList<Asiakas> jono = new LinkedList<Asiakas>(); // Tietorakennetoteutus
	
	private ContinuousGenerator generator;
	private Tapahtumalista tapahtumalista;
	private TapahtumanTyyppi skeduloitavanTapahtumanTyyppi; 
	private int lkm = 0;
	double aika;
	double sum;
	//JonoStartegia strategia; //optio: asiakkaiden järjestys
	
	private boolean varattu = false;


	public Palvelupiste(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi){
		this.tapahtumalista = tapahtumalista;
		this.generator = generator;
		this.skeduloitavanTapahtumanTyyppi = tyyppi;
				
	}


	public void lisaaJonoon(Asiakas a){   // Jonon 1. asiakas aina palvelussa
		jono.add(a);
		
		
	}

	public Asiakas otaJonosta(){  // Poistetaan palvelussa ollut
		varattu = false;
		return jono.poll();
		
	}

	public void aloitaPalvelu(){  //Aloitetaan uusi palvelu, asiakas on jonossa palvelun aikana
		varattu = true;
		
		double palveluaika = generator.sample();
		if(palveluaika<0) {
			palveluaika=0;
		}
		tapahtumalista.lisaa(new Tapahtuma(skeduloitavanTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		Kello ajat= Kello.getInstance();
		aika = ajat.getAika();
		sum = sum + palveluaika;
	}
	
	public double getAktiiviaika() {
		return sum;
	}
	public int getLkm() {
		return lkm;
	}
	


	public boolean onVarattu(){
		return varattu;
	}


	public boolean onJonossa(){
		return jono.size() != 0;
	}

	
}
