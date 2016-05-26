package network;

import java.awt.EventQueue;
//192.168.0.65
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Crud {

	private String port;
	private String ipRegistre;
	private static String ipServeurBDD = "jdbc:mysql://192.168.0.85/mission2registry";
	private static String login = "root";
	private static String password = "";
	private String nomDB;
	private String nomTable;
	public static ArrayList<String> getTablesNames() throws SQLException{
		  ArrayList<String> retour=new ArrayList<String>();
		  Connection conn = DriverManager.getConnection(ipServeurBDD, login, password);
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SHOW TABLES");
          
          while(rs.next()){
        	  //System.out.println(rs.getString(1));
        	  retour.add(rs.getString(1));      	  
          }
    	  return retour;
	}
	public Crud() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Crud(String port, String ipRegistre, String nomTable) {
		super();
		this.port = port;
		this.ipRegistre = ipRegistre;
		this.nomTable = nomTable;
	}
	@Override
	public String toString() {
		return "Crud [port=" + port + ", ipRegistre=" + ipRegistre + ", nomDB=" + nomDB + ", nomTable=" + nomTable
				+ ", tableEnregistrements=" + tableEnregistrements + ", cn=" + cn + ", st=" + st + ", rs=" + rs + "]";
	}
	private String tableEnregistrements;
	public Connection cn;
	java.sql.Statement st;
	ResultSet rs;
	
	//Class.forName("com.mysql.jdbc.Driver");
	// La méthode qui appelera votre fonction Run
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // L'essaie de connexion à votre base de donées
            	try {
                    getTablesNames();
            		Class.forName("com.mysql.jdbc.Driver");
                    
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    System.exit(0);
                }
            }
        });
    }

	public String getIpRegistre() {
		return ipRegistre;
	}

	public void setIpRegistre(String ipRegistre) {
		this.ipRegistre = ipRegistre;
	}

	public String getIpServeurBDD() {
		return ipServeurBDD;
	}

	public void setIpServeurBDD(String ipServeurBDD) {
		this.ipServeurBDD = ipServeurBDD;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomDB() {
		return nomDB;
	}

	public void setNomDB(String nomDB) {
		this.nomDB = nomDB;
	}

	public String getTableEnregistrements() {
		return tableEnregistrements;
	}

	public void setTableEnregistrements(String tableEnregistrements) {
		this.tableEnregistrements = tableEnregistrements;
	}

	public Crud(String ipRegistre, String ipServeurBDD, String login, String password, String nomDB,
			String tableEnregistrements, String port) {
		super();
		this.ipRegistre = ipRegistre;
		this.ipServeurBDD = ipServeurBDD;
		this.login = login;
		this.password = password;
		this.nomDB = nomDB;
		this.tableEnregistrements = tableEnregistrements; 
		this.port = port;
	}

	private void readAllWS(){
		//requete SQL
	}
	private void createWS(){
		//requete SQL
	}
	private void readWSbyName(){
		//requete SQL
	}
	private void deleteWS(){
		//requete SQL
	}

}
	
	

