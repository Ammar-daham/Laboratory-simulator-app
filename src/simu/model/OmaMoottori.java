package simu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.IKontrolleri;
import controller.Kontrolleri;
import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import eduni.distributions.Uniform;
import simu.framework.Kello;
import simu.framework.Moottori;
import simu.framework.Saapumisprosessi;
import simu.framework.Tapahtuma;
/**
 * 
 * @author Ammar Daham
 * 
 */
public class OmaMoottori extends Moottori{
	
	private Saapumisprosessi saapumisprosessi;
	int asiakanSaappuminen = 0;
	int verikoeLkm = 0;
	int rontgenLkm = 0;
	int nayteLkm = 0;
	int respaLkm = 0;
	String tulokset = "";
	String historia = "";
	public static final int JONOLKM=4;
	public static final int MAXJONOPITUUS=18;
	int[] jonossa = new int[JONOLKM];
	Tulokset tulos = new Tulokset();
	static IDataAccessObject DataDAO = new DataAccessObject();
	double keskiarvo;
	private ArrayList<Tulokset> tulokset1 = new ArrayList<>();
		
	
	Kontrolleri kontrolleri;
	
	public OmaMoottori(Kontrolleri kontrolleri){
		super(kontrolleri);
		palvelupisteet = new Palvelupiste[4];
		this.kontrolleri=kontrolleri;
	
		palvelupisteet[0]=new Palvelupiste(new Normal(kontrolleri.getRespaika(),kontrolleri.getRespaVarianssi()), tapahtumalista, TapahtumanTyyppi.DEP1);	
		palvelupisteet[1]=new Palvelupiste(new Normal(kontrolleri.getVerikoaika(),kontrolleri.getVerikovarianssi()), tapahtumalista, TapahtumanTyyppi.DEP2);
		palvelupisteet[2]=new Palvelupiste(new Normal(kontrolleri.getRontgenAika(),kontrolleri.getRontgenVarianssi()), tapahtumalista, TapahtumanTyyppi.DEP3);
		palvelupisteet[3]=new Palvelupiste(new Normal(kontrolleri.getNayteAika(),kontrolleri.getNayteVarianssi()), tapahtumalista, TapahtumanTyyppi.DEP4);
		
		
		saapumisprosessi = new Saapumisprosessi(new Normal(kontrolleri.saapumisv√§liaika(),2), tapahtumalista, TapahtumanTyyppi.ARR1);
		
	}

	
	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava(); // EnsimmÔøΩinen saapuminen jÔøΩrjestelmÔøΩÔøΩn
	}
	
	protected int generoiSatunaispalvelu() {
		Uniform ui= new Uniform(1, 10);
		int luku = (int)(ui.sample());
		if(luku >= 1 && luku <= 3) {
			return 1;
		} else if(luku >= 4 && luku <= 6) {
			return 2;
		}else {
		return 3;
		}
	}
	
	
	
	
	@Override
	protected void suoritaTapahtuma(Tapahtuma t){  // B-vaiheen tapahtumat
		
		Asiakas a;
		switch (t.getTyyppi()){
						//lis√§√§ respan jonoon
			case ARR1: palvelupisteet[0].lisaaJonoon(new Asiakas());	
				       saapumisprosessi.generoiSeuraava();
				       //visualisointi
				       if (jonossa[0]<MAXJONOPITUUS) {
							kontrolleri.naytaAsiakas(0,++jonossa[0]);
						};
						asiakanSaappuminen++;
				break;
				//Respa ,jono 0
			case DEP1: a = palvelupisteet[0].otaJonosta();
						int seuraavaPalvelu=generoiSatunaispalvelu();
		   	   			palvelupisteet[seuraavaPalvelu].lisaaJonoon(a);
		   	   			//seuraavan palvelun jonon visualisointi
		   	   		if (jonossa[seuraavaPalvelu]<MAXJONOPITUUS) {
						kontrolleri.naytaAsiakas(seuraavaPalvelu,++jonossa[seuraavaPalvelu]);
					}
		   	   		//respasta poisto samalla
		   	   		if(jonossa[0]>0) {
		   	   			kontrolleri.piilotaAsiakas(0, jonossa[0]--);
		   	   			};
		   	   			break;
				//verikoe	jono 1
			case DEP2: a = palvelupisteet[1].otaJonosta();
					   a.setPoistumisaika(Kello.getInstance().getAika());
					   //jonosta poisto
				   	 if(jonossa[1]>0) {
			   	   			kontrolleri.piilotaAsiakas(1, jonossa[1]--);
			   	   			}
				   	   	a.raportti(); 
				   	   	keskiarvo = a.getkeskiarvo();
				   	   	verikoeLkm++;
				   	   	break;
			    //Rong jono 2
			case DEP3: a = palvelupisteet[2].otaJonosta();
					   a.setPoistumisaika(Kello.getInstance().getAika());
					   //jonosta poisto
				   	   if(jonossa[2]>0) {
		   	   			kontrolleri.piilotaAsiakas(2, jonossa[2]--);
		   	   			}
			           a.raportti();
			           keskiarvo = a.getkeskiarvo();
			           rontgenLkm++;
			           break;  
			     //Nayte jono 3
			case DEP4: a = palvelupisteet[3].otaJonosta();
					   a.setPoistumisaika(Kello.getInstance().getAika());
					   //jonosta poisto
					   if(jonossa[3]>0) {
			   	   		kontrolleri.piilotaAsiakas(3, jonossa[3]--);
			   	   		}
			           a.raportti();
			           keskiarvo = a.getkeskiarvo();
			           nayteLkm++;
			           break;
		}	
	}

	
	
	@Override
	protected void tulokset() {	
		
		respaLkm = verikoeLkm + rontgenLkm + nayteLkm;
		
		tulokset = "Simuloinnin p‰‰ttyi: " + Kello.getInstance().getAika() + ", Asiakaiden lukumaara: " + asiakanSaappuminen + ".\n"
					+ "Palveltujen asiakkaiden lukumaara on: " + respaLkm + ", Asiakkaiden lapimenoaikojen keskiarvo: " + keskiarvo + ", vastanoton asiakkaiden aktiiviaika: " + palvelupisteet[0].getAktiiviaika() + ".\n"  
					+ "Verikoe asiakkaiden lukumaara: " + verikoeLkm + ", verikoe aktiiviaika " + palvelupisteet[1].getAktiiviaika() + ", verikoe keskimaarainen palveluaika: " + palvelupisteet[1].getAktiiviaika()/verikoeLkm + ".\n"
					+ "Rontgen asiakkaiden lukumaara: " + rontgenLkm + ", rontgen aktiiviaika: " + palvelupisteet[2].getAktiiviaika() + ", rontgen keskimaarainen palveluaika: " + palvelupisteet[2].getAktiiviaika()/rontgenLkm + ".\n" 
					+"Nayte asiakkaiden lukumaara: " + nayteLkm + ", nayte aktiiviaika: " +  palvelupisteet[3].getAktiiviaika() + ", nayten keskimaaarainen palveluaika: " + palvelupisteet[3].getAktiiviaika()/nayteLkm + ".";
		
		
		
		tulos.setSimulointiKesto(Kello.getInstance().getAika());
		tulos.setAsiakasLkm(respaLkm);
		tulos.setAsiakkaanSaapuminen(asiakanSaappuminen);
		tulos.setAsiakaidenLapimenoaikaKeskiarvo(keskiarvo);
		tulos.setVerikoeLkm(verikoeLkm);
		tulos.setRontgenLkm(rontgenLkm);
		tulos.setNayteLkm(nayteLkm);
		tulos.setRespaAktiiviaika(palvelupisteet[0].getAktiiviaika());
		tulos.setVerikoeAktiiviaika(palvelupisteet[1].getAktiiviaika());
		tulos.setRontgenAktiiviaika(palvelupisteet[2].getAktiiviaika());
		tulos.setNayteAktiiviaika(palvelupisteet[3].getAktiiviaika());
		tulos.setRespaKeskiarvo(palvelupisteet[0].getAktiiviaika()/respaLkm);
		tulos.setVerikoeKeskiarvo(palvelupisteet[1].getAktiiviaika()/verikoeLkm);
		tulos.setRontgenKeskiarvo(palvelupisteet[2].getAktiiviaika()/rontgenLkm);
		tulos.setNayteKeskiarvo(palvelupisteet[3].getAktiiviaika()/nayteLkm);
	
		DataDAO.createData(tulos);
		kontrolleri.getTulokset(tulokset);
	}


}