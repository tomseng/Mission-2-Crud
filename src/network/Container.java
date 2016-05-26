package network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import com.mysql.jdbc.PreparedStatement;

public class Container {
	private static String ipServeurBDD = "jdbc:mysql://192.168.0.74/mission2registry";
	private static String login = "root";
	private static String password = "root";
	private String nomDB;
	private static HashMap<String, String[]> enregistrements;
    	 
	public static HashMap<String, String[]> getEnregistrements() {
		return enregistrements;
	}
	public static void main(String[] args) throws SQLException, IOException, InterruptedException {
		//Socket socketduserveur=socketserver.accept() ;
		Socket socket = new Socket("192.168.0.85",4485);
		Crud cr1 = new Crud();
		enregistrements=new HashMap<String, String[]>();
		Registry reg = new Registry();
		ArrayList<String> nomTables = cr1.getTablesNames();
		for(String ws:nomTables)
		{
			new Crud(""+ThreadLocalRandom.current().nextInt(4, 1200 + 1), socket.getLocalAddress().toString(), ws);
			String[] tab=new String[3];
			tab[0]=socket.getLocalAddress().toString();
			tab[1]=""+ThreadLocalRandom.current().nextInt(4, 1200 + 1);
			tab[2]=ws;
			addTable(ws, tab);
			enregistrements=getEnregistrements();
			for(String p:enregistrements.get(ws)){
				System.out.println(p);
			}
		}
		ObjectOutputStream fluxEcriture = new ObjectOutputStream(socket.getOutputStream());
		fluxEcriture.writeObject(getEnregistrementsToObjects());
		Thread.currentThread().sleep(2000);
		socket.close();
	}
	// type : CRUD
	// table : nom table
	// donnees : crit�res de s�lection/donn�es � inserer
	
	public static Object[][] getEnregistrementsToObjects() {
		Object[][] retour=new Object[getEnregistrements().size()][];
		System.out.println(enregistrements.size());
		int i=0;
		//System.out.println("ok ");
		for(String key:enregistrements.keySet()){
			Object[] r=new Object[enregistrements.get(key).length];
			for(int j=0; j<enregistrements.get(key).length; j++){
				r=enregistrements.get(key);			
				//System.out.println("ok "+retour[i][j]);
			}
			retour[i]=r;
			i++;
		}
		return retour;
	}
	/*public Container(String adresseIP,String port) throws SQLException {
		super();
		ServerSocket socketserver = null ;
		Socket socketduserveur ;
		Crud cr1 = new Crud();
		HashMap<String, String[]> m=new HashMap<String, String[]>();
		Registry reg = new Registry();
		ArrayList<String> nomTables = cr1.getTablesNames();
		for(String ws:nomTables)
		{
			new Crud(port, adresseIP, ws);
			String[] tab=new String[3];
			tab[0]=adresseIP;
			tab[1]=port;
			tab[2]=ws;
			reg.addTable(ws, tab);
			m=reg.getEnregistrements();
			for(String p:m.get(ws)){
				System.out.println(p);
			}
		}
	}*/
	public static void addTable(String nomTable, String[] Ipport){
		enregistrements.put(nomTable, Ipport);
	}
}
