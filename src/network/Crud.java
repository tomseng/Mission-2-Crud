package network;

import java.sql.Connection;
import java.sql.ResultSet;


public class Crud {

	
	private String ipRegistre;
	private String ipServeurBDD = "jdbc:mysql://localhost/formaton";
	private String login = "root";
	private String password = "";
	private String nomDB;
	private String tableEnregistrements;
	public Connection cn;
	java.sql.Statement st;
	ResultSet rs;
	
	//Class.forName("com.mysql.jdbc.Driver");
	

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

}
