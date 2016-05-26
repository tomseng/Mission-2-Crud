package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.PreparedStatement;

public class Container {
	private static String ipServeurBDD = "jdbc:mysql://192.168.0.74/mission2registry";
	private static String login = "root";
	private static String password = "root";
	private String nomDB;
	
	public static void main(String[] args) throws SQLException, IOException {
		
		Socket socket = new Socket("192.168.0.85",4485);
		//Socket socketduserveur=socketserver.accept() ;
		Crud cr1 = new Crud();
		HashMap<String, String[]> m=new HashMap<String, String[]>();
		Registry reg = new Registry();
		ArrayList<String> nomTables = cr1.getTablesNames();
		for(String ws:nomTables)
		{
			new Crud(""+socket.getLocalPort(), socket.getLocalAddress().toString(), ws);
			String[] tab=new String[3];
			tab[0]=socket.getLocalAddress().toString();
			tab[1]=""+socket.getLocalPort();
			tab[2]=ws;
			reg.addTable(ws, tab);
			m=reg.getEnregistrements();
			for(String p:m.get(ws)){
				System.out.println(p);
			}
		}
	}
	// type : CRUD
	// table : nom table
	// donnees : crit�res de s�lection/donn�es � inserer
	public ArrayList<String[]> webService(String type, String table, String[] donnees) throws SQLException{
		ArrayList<String[]> retour=new ArrayList<String[]>();
		Connection conn = DriverManager.getConnection(ipServeurBDD, login, password);
		ResultSet rs;
		PreparedStatement preparedstmt;
		Statement stmt;
		String req;
		switch(type)
		{
			case "create":
				req="INSERT INTO "+table+" VALUES(";
				for(int i=0; i<donnees.length; i++)
				{
					if(i<donnees.length-1)
					{
						req+=" "+donnees[i]+",";
					}
					else
					{
						req+=" "+donnees[i]+");";
					}				
				}
				System.out.println(req);
				stmt = conn.createStatement();   
				rs = stmt.executeQuery(req);
		        while(rs.next()){
		        	//retour=rs.getInt(1);
		        }
				break;
			case "read":
				preparedstmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM "+table+";");
				rs = preparedstmt.executeQuery();
				while(rs.next()){
					String[] tab=new String[rs.getMetaData().getColumnCount()];
		        	for(int i=0; i<rs.getMetaData().getColumnCount(); i++){
		        		tab[i]= (String) rs.getObject(i+1);
		        	}
		        	retour.add(tab);
		        }
				break;
			case "update":
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM "+table+" LIMIT 1;");
				req="UPDATE "+table+" SET ";
				for(int i=0; i<donnees.length; i++)
				{
					if(i<donnees.length-1)
					{
						req+=rs.getMetaData().getColumnName(i+1)+"="+donnees[i]+", ";
					}
					else
					{
						req+=rs.getMetaData().getColumnName(i+1)+"="+donnees[i]+" WHERE id="+donnees[0]+";";
					}	
				}
				rs.close();
				rs = stmt.executeQuery(req);
				System.out.println(req);
		        while(rs.next()){
		        	//retour=rs.getInt(1);
		        }
				break;
			case "delete":
				stmt = conn.createStatement();
				rs = stmt.executeQuery("DELETE FROM "+table+" WHERE id="+donnees[0]+";");
				 while(rs.next()){
			        	//retour=rs.getInt(1);
			    }
				break;
			case "list":
				preparedstmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM "+table+";");
				rs = preparedstmt.executeQuery();
				while(rs.next()){
					String[] tab=new String[rs.getMetaData().getColumnCount()];
		        	for(int i=0; i<rs.getMetaData().getColumnCount(); i++){
		        		tab[i]= (String) rs.getObject(i+1);
		        	}
		        	retour.add(tab);
		        }
				break;
			default:
				break;
		}
		return retour;
	}
	public Container(String adresseIP,String port) throws SQLException {
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
	}
}
