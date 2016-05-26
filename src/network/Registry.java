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

	
	public static void main(String[] zero) throws SQLException, InterruptedException, ClassNotFoundException {
		
		ServerSocket socketServerContainer  ;
		Socket socketduserveur ;
				
		//TestApp();
		try {
			//ct1.main(args);
			socketServerContainer = new ServerSocket(4485);

			//Container ct1=new Container(socketServerContainer.getInetAddress().toString(), "4485");
			System.out.println("Le registre écoute les connexions sur le port "  + socketServerContainer.getLocalPort()+"...");

			socketduserveur = socketServerContainer.accept();
			ObjectInputStream ois = new ObjectInputStream(socketduserveur.getInputStream());
			Object[][] donne = (Object[][]) ois.readObject();
	    	System.out.println("recue du container     << "+donne[0][0]);
			
	    	/**ObjectOutputStream fluxEcriture = new ObjectOutputStream(socketduserveur.getOutputStream());
			//PrintWriter pw=new PrintWriter(socketduserveur.getOutputStream());
			System.out.println("Un client s'est connecté !");
			//for (int i=0; i<10; i++)
			//{
			//	System.out.println(getEnregistrementsToObjects()[0][2]);
				fluxEcriture.writeObject(donne);
				//pw.println("dsvffbf");
				Thread.currentThread().sleep(2000);*/
				//fluxEcriture.close();
			//}
			
		       socketServerContainer.close();
			ServerSocket socketServeurClient = new ServerSocket(4490);
			System.out.println("Le registre écoute les connexions sur le port "  + socketServeurClient.getLocalPort()+"...");

			socketduserveur = socketServeurClient.accept();
			ObjectOutputStream fluxEcriture = new ObjectOutputStream(socketduserveur.getOutputStream());
			//PrintWriter pw=new PrintWriter(socketduserveur.getOutputStream());
			System.out.println("Un client s'est connecté !");
			//for (int i=0; i<10; i++)
			//{
			//	System.out.println(getEnregistrementsToObjects()[0][2]);
				fluxEcriture.writeObject(donne);
				//pw.println("dsvffbf");
				Thread.currentThread().sleep(2000);
		       socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
