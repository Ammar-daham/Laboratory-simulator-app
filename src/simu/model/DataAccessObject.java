package simu.model;
import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import simu.framework.Kello;



/**
 * Date: March 10-2021.
 * This is a class for creating and reading data to the database. 
 * 
 * @author Ammar Daham
 *
 */
public class DataAccessObject implements IDataAccessObject{
	
	Tulokset[] tulos;
	
	//tietokannan muuttujat
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		final String URL = "jdbc:mariadb://localhost/laboratorio";
		final String USERNAME = "root";
		final String PWD = "Aljewary89";
		
		
		/**
		 * Parameterless constructor.
		 * 
		 * Here we generate a connection between the database and the java project.
		 */
		public DataAccessObject() {
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PWD);
			}catch(SQLException e) {
				do {
					System.err.println("Viesti: " + e.getMessage());
					System.err.println("Virhekoodi: " + e.getErrorCode());
					System.err.println("SQL-tilakoodi: " + e.getSQLState());
				}while(e.getNextException() != null);
				System.exit(-1); 
			}
		}
		
		
		/**
		 * This method create data on the database.
		 * @return ture if the data saved successfully.
		 * @return false if the data not saved
		 */
		public boolean createData(Tulokset tulos) {
		boolean temp = false;
		try(PreparedStatement createStm = conn.prepareStatement
				("INSERT INTO labratorio VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")){
			
			createStm.setInt(1, tulos.getAsiakkaanSaapuminen());
			createStm.setDouble(2, tulos.getSimulointiKesto());
			createStm.setInt(3, tulos.getAsiakasLkm());
			createStm.setDouble(4, tulos.getAsiakaidenLapimenoaikaKeskiarvo());
			createStm.setInt(5, tulos.getVerikoeLkm());
			createStm.setInt(6, tulos.getRontgenLkm());
			createStm.setInt(7, tulos.getNayteLkm());
			createStm.setDouble(8, tulos.getRespaAktiiviaika());
			createStm.setDouble(9, tulos.getVerikoeAktiiviaika());
			createStm.setDouble(10, tulos.getRontgenAktiiviaika());
			createStm.setDouble(11, tulos.getNayteAktiiviaika());
			createStm.setDouble(12, tulos.getRespaKeskiarvo());
			createStm.setDouble(13, tulos.getVerikoeKeskiarvo());
			createStm.setDouble(14, tulos.getRontgenKeskiarvo());
			createStm.setDouble(15, tulos.getNayteKeskiarvo());
	
			createStm.executeUpdate();
			temp = true;
			
		}catch(SQLException e) {
				do {
					System.err.println("Datan luominen epäonnistui.");
				} while (e.getNextException() != null);
			}
		return temp;
		
		}
		
		/**
		 * This method reads data as a list from the database
		 *	return tulos list
		 */
		public Tulokset[] readTulokset() {
			ArrayList<Tulokset> lista=new ArrayList();
		
			try {
				 stmt = conn.createStatement();
				String query="SELECT * from labratorio";
				
				 rs=stmt.executeQuery(query);
				
				while(rs.next()) {
					
					int rsSaappuminen = rs.getInt("kaikkiAsiakkaat");
					Double rsSimulointiKesto = rs.getDouble("simulointiKesto");
					int rsAsiakasLkm = rs.getInt("AsiakasLkm");
					Double rsAsiakkaidenLapimenoaikojenKeskiarvo = rs.getDouble("AsiakkaidenLapimenoaikojenKeskiarvo");
					int rsVerikoenLkm = rs.getInt("verikoenAsiakasLkm");
					int rsRontgenLkm = rs.getInt("röntgönAsiakasLkm");
					int rsNayteLkm = rs.getInt("näyteAsiakasLkm");
					Double rsRespaAktiiviaika = rs.getDouble("respaAktiiviaika");
					Double rsVerikoeAktiiviaika = rs.getDouble("verikoeAktiiviAika");
					Double rsRontgenAktiiviaika = rs.getDouble("röntgönAktiiviaika");
					Double rsNayteAktiiviaika = rs.getDouble("näyteAktiiviaika");
					Double rsRespaKeskiarvo = rs.getDouble("respaKeskiarvo");
					Double rsVerikoeKeskiarvo = rs.getDouble("verikoeKeskiarvo");
					Double rsRontgenKeskiarvo = rs.getDouble("röntgönKeskiarvo");
					Double rsNayteKeskiarvo = rs.getDouble("näyteKeskiarvo");
				
				lista.add( new Tulokset(rsSimulointiKesto,  rsAsiakasLkm, rsSaappuminen,  rsAsiakkaidenLapimenoaikojenKeskiarvo, rsVerikoenLkm,
						 rsRontgenLkm, rsNayteLkm,  
						rsRespaAktiiviaika, rsVerikoeAktiiviaika,
						rsRontgenAktiiviaika, rsNayteAktiiviaika, rsRespaKeskiarvo, rsVerikoeKeskiarvo,
						rsRontgenKeskiarvo, rsNayteKeskiarvo));

					
				}
			} catch (SQLException e) {
				do {
					System.out.println("Viesti: " + e.getMessage());
					System.out.println("Virhekoodi: " + e.getErrorCode());
					System.out.println("Viesti: " + e.getSQLState());
					
				
			}while(e.getNextException()!=null);
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) {
						rs.close();
					}
					if(stmt!=null) {
						stmt.close();
					}
				} catch(Exception e) {
					System.out.println("Resurssien vapautuksessa virhe");
				}
				tulos=new Tulokset[lista.size()];
				for(int i=0;i<lista.size();i++) {
					tulos[i]=lista.get(i);
				}
				return tulos;

			}

		}
		}
