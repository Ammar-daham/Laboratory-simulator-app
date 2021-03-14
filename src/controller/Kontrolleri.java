package controller;

import javafx.application.Platform;
import simu.framework.Moottori;
import simu.model.DataAccessObject;
import simu.model.IDataAccessObject;
import simu.model.OmaMoottori;
import simu.model.ReadData;
import view.IVisualisointi;
import view.MainGUI;

public class Kontrolleri implements IKontrolleri {
	MainGUI gui;
	OmaMoottori moottori;
	ReadData data = new ReadData();

	public Kontrolleri(MainGUI gui) {
		this.gui=gui;
	}
	//palvelupisteiden palveluajat
	public int saapumisväliaika() {
		return gui.getAsiakasväliAika();
		
	};
	
	public int getRespaika() {
		return gui.getRespaAika();
		
	};
	public int getRespaVarianssi() {
		return gui.getRespavarianssi();
		
	};
	public int getVerikoaika() {
		return gui.getVerikoeAika();
		
	}
	public int getVerikovarianssi() {
		return gui.getVerikoeVarianssi();
		
	}
	public int getRontgenAika() {
		return gui.getRontgenAika();
		
	}
	public int getRontgenVarianssi() {
		return gui.getRontgenVarianssi();
		
	}
	public int getNayteAika() {
		return gui.getNayteAika();
	}
	public int getNayteVarianssi() {
		return gui.getNayteVarianssi();
	}

	@Override
	public void kaynnistaSimulointi() {
		moottori = new OmaMoottori(this); // luodaan uusi moottorisäie jokaista simulointia varten
		moottori.setSimulointiaika(gui.getSimulointiAika());
		Platform.runLater(new Runnable(){
			public void run(){
				gui.getVisualisointi().alustaAnimointi();
			}
		});
		((Thread)moottori).start();
		
	}


	public void naytaAsiakas(int jono, int monesko) {
		Platform.runLater(new Runnable(){
			public void run(){
				gui.getVisualisointi().visualisoiAsiakas(jono, monesko);
			}
		});
	}
	public void piilotaAsiakas(int jono, int monesko) {
		Platform.runLater(new Runnable(){
			public void run(){
				gui.getVisualisointi().poistaVisualisoituAsiakas(jono, monesko);
			}
		});
	}
	
	public String getTulokset(String tulos) {
		Platform.runLater(()->gui.setTulokset(tulos));
		return tulos;
	}
	

	public String[] getHistoria() {
			String historia[] = data.getVaihtoehdot();
			return historia;
		}
	
}
