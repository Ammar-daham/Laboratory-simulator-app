package simu.model;

/**
 * Date: March 10-2021.
 *
 * This is a class contains all the results variabals. 
 * @author Ammar Daham
 * 
 */
public class Tulokset {
		
	/**
	 * double simulointikesto shows the simulation duration
	 */
	private double simulointiKesto;
	/**
	 * int asiakasLkm shows the number of all custmores.
	 */
	private int asiakasLkm;
	
	/**
	 * This variable shows the Customer Lead TimeAverage
	 */
	private int asiakkaanSaapuminen;
	private double asiakaidenLapimenoaikaKeskiarvo;
	private int verikoeLkm;
	private int rontgenLkm;
	private int nayteLkm;
	private double respaAktiiviaika;
	private double verikoeAktiiviaika;
	private double rontgenAktiiviaika;
	private double nayteAktiiviaika;
	private double respaKeskiarvo;
	private double verikoeKeskiarvo;
	private double rontgenKeskiarvo;
	private double nayteKeskiarvo;
	
	
	
	/**
	 * This constructor contains all the parameters below:
	 * @param simulointiKesto
	 * @param asiakasLkm
	 * @param asiakaidenLapimenoaikaKeskiarvo
	 * @param verikoeLkm
	 * @param rontgenLkm
	 * @param nayteLkm
	 * @param respaAktiiviaika
	 * @param rontgenAktiiviaika
	 * @param nayteAktiiviaika
	 * @param respaKeskiarvo
	 * @param verikoeKeskiarvo
	 * @param rontgenKeskiarvo
	 * @param nayteKeskiarvo
	 */
	public Tulokset(double simulointiKesto, int asiakasLkm, int asiakkaanSaapuminen,  double asiakaidenLapimenoaikaKeskiarvo, int verikoeLkm, int rontgenLkm,
			int nayteLkm, double respaAktiiviaika, double verikoeAktiiviaika, double rontgenAktiiviaika, double nayteAktiiviaika,
			double respaKeskiarvo, double verikoeKeskiarvo, double rontgenKeskiarvo, double nayteKeskiarvo) {
		
		this.simulointiKesto = simulointiKesto;
		this.asiakasLkm = asiakasLkm;
		this.asiakkaanSaapuminen = asiakkaanSaapuminen;
		this.asiakaidenLapimenoaikaKeskiarvo = asiakaidenLapimenoaikaKeskiarvo;
		this.verikoeLkm = verikoeLkm;
		this.rontgenLkm = rontgenLkm;
		this.nayteLkm = nayteLkm;
		this.respaAktiiviaika = respaAktiiviaika;
		this.verikoeAktiiviaika = verikoeAktiiviaika;
		this.rontgenAktiiviaika = rontgenAktiiviaika;
		this.nayteAktiiviaika = nayteAktiiviaika;
		this.respaKeskiarvo = respaKeskiarvo;
		this.verikoeKeskiarvo = verikoeKeskiarvo;
		this.rontgenKeskiarvo = rontgenKeskiarvo;
		this.nayteKeskiarvo = nayteKeskiarvo;
		
	}
	
	/**
	 * parameterless constructor
	 */
	public Tulokset() {
		
	}
	

	public int getAsiakkaanSaapuminen() {
		return asiakkaanSaapuminen;
	}

	public void setAsiakkaanSaapuminen(int asiakkaanSaapuminen) {
		this.asiakkaanSaapuminen = asiakkaanSaapuminen;
	}

	
	/**
	 * This method for getting Customer Lead TimeAverage.
	 * @return returning double value of asiakaidenLapimenoaikaKeskiarvo.
	 */
	public double getAsiakaidenLapimenoaikaKeskiarvo() {
		return asiakaidenLapimenoaikaKeskiarvo;
	}

	
	/**
	 * This method sets the Customer Lead TimeAverage.
	 * @param asiakaidenLapimenoaikaKeskiarvo double value
	 */
	public void setAsiakaidenLapimenoaikaKeskiarvo(double asiakaidenLapimenoaikaKeskiarvo) {
		this.asiakaidenLapimenoaikaKeskiarvo = asiakaidenLapimenoaikaKeskiarvo;
	}

	
	
	/**
	 * This method for getting the simulation duration.
	 * @return returning double value result of simulation duration.
	 */
	public double getSimulointiKesto() {
		return simulointiKesto;
	}

	/**
	 * This method sets the simulation duration.
	 * @param simulointiKesto double value.
	 */
	public void setSimulointiKesto(double simulointiKesto) {
		this.simulointiKesto = simulointiKesto;
	}

	/**
	 * This method for getting the number of customers
	 * @return returning int value of asiakasLkm.
	 */
	public int getAsiakasLkm() {
		return asiakasLkm;
	}

	/**
	 * This method sets the number of customers.
	 * @param asiakasLkm int value.
	 */
	public void setAsiakasLkm(int asiakasLkm) {
		this.asiakasLkm = asiakasLkm;
	}

	/**
	 * This method for getting the number of customers of the blood test service point.
	 * @return returning int value of verikoeLkm.
	 */
	public int getVerikoeLkm() {
		return verikoeLkm;
	}

	/**
	 * This method sets the number of customers of the blood test service point.
	 * @param verikoeLkm int value.
	 */
	public void setVerikoeLkm(int verikoeLkm) {
		this.verikoeLkm = verikoeLkm;
	}

	/**
	 * This method for getting the number of customers of the X-ray service point.
	 * @return returning int value of rontgenLkm.
	 */
	public int getRontgenLkm() {
		return rontgenLkm;
	}

	/**
	 * This method sets the number of customers of the x-ray service point.
	 * @param rontgen int value.
	 */
	public void setRontgenLkm(int rontgenLkm) {
		this.rontgenLkm = rontgenLkm;
	}

	/**
	 * This method for getting the number of customers of the sample service point.
	 * @return returning int value of nayteLkm.
	 */
	public int getNayteLkm() {
		return nayteLkm;
	}

	/**
	 * This method sets the number of customers of the sample service point.
	 * @param nayteLkm int value.
	 */
	public void setNayteLkm(int nayteLkm) {
		this.nayteLkm = nayteLkm;
	}

	/**
	 * This method for getting the reception service point active time.
	 * @return returning double value of respaAktiiviaika.
	 */
	public double getRespaAktiiviaika() {
		return respaAktiiviaika;
	}

	/**
	 * This method sets the reception service point active time.
	 * @param respaAktiiviaika double value.
	 */
	public void setRespaAktiiviaika(double respaAktiiviaika) {
		this.respaAktiiviaika = respaAktiiviaika;
	}

	/**
	 * This method for getting the blood test service point active time.
	 * @return returning double value of verikoeAktiiviaika.
	 */
	public double getVerikoeAktiiviaika() {
		return verikoeAktiiviaika;
	}

	/**
	 * This method sets the blood test service point active time.
	 * @param verikoeAktiiviaika double value.
	 */
	public void setVerikoeAktiiviaika(double verikoeAktiiviaika) {
		this.verikoeAktiiviaika = verikoeAktiiviaika;
	}

	/**
	 * This method for getting the x-ray service point active time.
	 * @return returning double value of rontgenAktiiviaika.
	 */
	public double getRontgenAktiiviaika() {
		return rontgenAktiiviaika;
	}

	/**
	 * This method sets the x-ray service point active time.
	 * @param rontgenkoeAktiiviaika double value.
	 */
	public void setRontgenAktiiviaika(double rontgenAktiiviaika) {
		this.rontgenAktiiviaika = rontgenAktiiviaika;
	}

	/**
	 * This method for getting the sample service point active time.
	 * @return returning double value of nayteAktiiviaika.
	 */
	public double getNayteAktiiviaika() {
		return nayteAktiiviaika;
	}

	/**
	 * This method sets the sample service point active time.
	 * @param naytekoeAktiiviaika double value.
	 */
	public void setNayteAktiiviaika(double nayteAktiiviaika) {
		this.nayteAktiiviaika = nayteAktiiviaika;
	}

	/**
	 * This method for getting the average time of reception service point.
	 * @return returning double value of respaKeskiarvo.
	 */
	public double getRespaKeskiarvo() {
		return respaKeskiarvo;
	}

	/**
	 * This method sets the average time of reception service point.
	 * @param respaKeskiarvo double value.
	 */
	public void setRespaKeskiarvo(double respaKeskiarvo) {
		this.respaKeskiarvo = respaKeskiarvo;
	}

	/**
	 * This method for getting the average time of blood test service point.
	 * @return returning double value of verikoeKeskiarvo.
	 */
	public double getVerikoeKeskiarvo() {
		return verikoeKeskiarvo;
	}

	/**
	 * This method sets the average time of blood test service point.
	 * @param verikoeKeskiarvo double value.
	 */
	public void setVerikoeKeskiarvo(double verikoeKeskiarvo) {
		this.verikoeKeskiarvo = verikoeKeskiarvo;
	}

	/**
	 * This method for getting the average time of x-ray service point.
	 * @return returning double value of rontgenKeskiarvo.
	 */
	public double getRontgenKeskiarvo() {
		return rontgenKeskiarvo;
	}

	/**
	 * This method sets the average time of x-ray service point.
	 * @param rontgenKeskiarvo double value.
	 */
	public void setRontgenKeskiarvo(double rontgenKeskiarvo) {
		this.rontgenKeskiarvo = rontgenKeskiarvo;
	}

	/**
	 * This method for getting the average time of sample service point.
	 * @return returning double value of nayteKeskiarvo.
	 */
	public double getNayteKeskiarvo() {
		return nayteKeskiarvo;
	}

	/**
	 * This method sets the average time of sample service point.
	 * @param nayteKeskiarvo double value.
	 */
	public void setNayteKeskiarvo(double nayteKeskiarvo) {
		this.nayteKeskiarvo = nayteKeskiarvo;
	}

	
	/**
	 * This method for printing the results
	 * @return all the results
	 */
	public String toString() {
		return "Simuloinnin p‰‰ttyi: " + getSimulointiKesto() + ". Asiakaiden lukumaara: " + getAsiakkaanSaapuminen() + ".\n" 
				+ "palveltun asiakkaiden lukumaara on: " + getAsiakasLkm() + ", Asiakkaiden lapimenoaikojen keskiarvo: " + getAsiakaidenLapimenoaikaKeskiarvo() + ", vastanoton aktiiviaika: " + getNayteAktiiviaika() + ".\n" 
				+ "Verikoe asiakkaiden lukumaara: " + getVerikoeLkm() + ", verikoe aktiiviaika " + getVerikoeAktiiviaika() + ", verikoe keskimaarainen palveluaika: " + getVerikoeKeskiarvo() + ".\n"
				+ "Rontgen asiakkaiden lukumaara: " + getRontgenLkm() + ", rontgen aktiiviaika: " + getRespaAktiiviaika() + ", rontgen keskimaarainen palveluaika: " + getRontgenKeskiarvo() + ".\n" 
				+"Natye asiakkaiden lukumaara: " + getNayteLkm() + ", nayte aktiiviaika: " +  getNayteAktiiviaika() + ", nayte keskimaaarainen palveluaika: " + getNayteKeskiarvo() + ".";
	}
	
}
