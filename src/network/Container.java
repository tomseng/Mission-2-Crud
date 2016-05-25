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
	private static String ipServeurBDD = "jdbc:mysql://192.168.0.65/mission2registry";
	private static String login = "root";
	private static String password = "";
	private String nomDB;
	
	public static void main(String[] args) throws SQLException {
		
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		Crud cr1 = new Crud();
		
		ArrayList<String> nomTables = cr1.getTablesNames();
		for(String ws:nomTables)
		{
			new Crud("80", "192.168.1.93", ws);
			Registry reg = new Registry();
			String[] tab=new String[3];
			tab[0]="192.168.1.93";
			tab[1]="80";
			tab[2]=ws;
			reg.addTable(ws, tab);
			HashMap<String, String[]> m=reg.getEnregistrements();
			for(String p:m.get(ws)){
				System.out.println(p);
			}
		}	
		//TestApp();
		try {
		
			socketserver = new ServerSocket(754);
			System.out.println("Le registre écoute les connexions sur le port "  + socketserver.getLocalPort()+"...");

			socketduserveur = socketserver.accept(); 

			System.out.println("Un client s'est connecté !");
		        socketserver.close();
		        socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	// type : CRUD
	// table : nom table
	// donnees : critères de sélection/données à inserer
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
}
