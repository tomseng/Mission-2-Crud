package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Registry {
	//List<String> listeEnregistrements = new ArrayList<>();
    private static HashMap<String, String[]> enregistrements;
    
    
	 
	public static HashMap<String, String[]> getEnregistrements() {
		return enregistrements;
	}
	
	public static Object[][] getEnregistrementsToObjects() {
		Object[][] retour=new Object[getEnregistrements().size()][];
		//System.out.println(enregistrements.size());
		int i=0;
		System.out.println("ok ");
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
	public void addTable(String nomTable, String[] Ipport){
		enregistrements.put(nomTable, Ipport);
	}

	public Registry() {
		super();
		enregistrements=new HashMap<String, String[]>();
		// TODO Auto-generated constructor stub
	}

	public Registry(HashMap<String, String[]> enregistrements) {
		super();
		this.enregistrements = enregistrements;
	}

	public void setEnregistrements(HashMap<String, String[]> enregistrements) {
		this.enregistrements = enregistrements;
	}

	public String readRecords(){
				return null; 
	}

	
	public static void main(String[] zero) throws SQLException {
		
		ServerSocket socketserver  ;
		Socket socketduserveur ;
				
		//TestApp();
		try {
			Container ct1=new Container();
			//ct1.main(args);
			socketserver = new ServerSocket(4485);
			System.out.println("Le registre écoute les connexions sur le port "  + socketserver.getLocalPort()+"...");

			socketduserveur = socketserver.accept(); 
			ObjectOutputStream fluxEcriture = new ObjectOutputStream(socketduserveur.getOutputStream());

			System.out.println("Un client s'est connect� !");
			//while(true)
			//{
				System.out.println(getEnregistrementsToObjects()+"ok");
				//fluxEcriture.writeObject(getEnregistrementsToObjects());
			//}
			
		        socketserver.close();
		        socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
