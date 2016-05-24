package network;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Crud {

	
	private String ipRegistre;
	private static String ipServeurBDD = "jdbc:mysql://192.168.3.62/mission2registry";
	private static String login = "root";
	private static String password = "";
	private String nomDB;
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
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(ipServeurBDD, login, password);
                    System.out.println("Connecté");
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
			String tableEnregistrements) {
		super();
		this.ipRegistre = ipRegistre;
		this.ipServeurBDD = ipServeurBDD;
		this.login = login;
		this.password = password;
		this.nomDB = nomDB;
		this.tableEnregistrements = tableEnregistrements; 
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
	
	

