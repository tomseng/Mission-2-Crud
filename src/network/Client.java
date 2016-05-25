package network;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTable;


public class Client implements ActionListener{
	private static JTable table;
	private static JTable table_1;
	
	
	public static void main(String[] args) throws SQLException {
		
		
		//Container ct1 = new Container();
		/*ArrayList<String[]> tab =  ct1.webService("read", "table1", new String[0]);
		for(int i=0; i<tab.size(); i++){
			for(int j=0; j<tab.get(i).length; j++){
				System.out.print(tab.get(i)[j]+" ");
			}
			System.out.println(tab.size());
		}*/
		JFrame jf1 = new JFrame();
		JPanel jp1 = new JPanel();
		jp1.setName("panel1");
		jf1.setSize(600, 350);
		jf1.setTitle("GUI Client");
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
		jf1.setLocation(400, 200);
		jf1.getContentPane().setLayout(null);
		
		JLabel lblGestionnaireDeWebservice = new JLabel("Gestionnaire de WebService");
		lblGestionnaireDeWebservice.setBounds(223, 6, 172, 16);
		jf1.getContentPane().add(lblGestionnaireDeWebservice);
		
		JButton btnListerLesWebservices = new JButton("Lister les Webservices");
		btnListerLesWebservices.setBounds(6, 35, 172, 29);
		jf1.getContentPane().add(btnListerLesWebservices);
		
		JLabel lblWebservice = new JLabel("WebService");
		lblWebservice.setBounds(397, 40, 76, 16);
		jf1.getContentPane().add(lblWebservice);
		
		JButton btnCrerUneEntre = new JButton("Créer une entrée");
		btnCrerUneEntre.setBounds(26, 180, 140, 29);
		jf1.getContentPane().add(btnCrerUneEntre);
		
		JTextPane txtpnBox = new JTextPane();
		txtpnBox.setText("Box");
		txtpnBox.setBounds(6, 218, 172, 104);
		jf1.getContentPane().add(txtpnBox);
		
		 //Les données du tableau
	    Object[][] data = {
	      {"Cysboy", "28 ans", "1.80 m"},
	      {"BZHHydde", "28 ans", "1.80 m"},
	      {"IamBow", "24 ans", "1.90 m"},
	      {"FunMan", "32 ans", "1.85 m"}
	    };

	    //Les titres des colonnes
	    String  title[] = {"Pseudo", "Age", "Taille"};
		
		table = new JTable(data,title);
		table.setBounds(223, 76, 371, 246);
		jf1.getContentPane().add(table);
		
		Registry reg = new Registry();
		
		table_1 = new JTable(reg.getEnregistrementsToObjects(),title);
		table_1.setBounds(6, 76, 172, 93);
		jf1.getContentPane().add(table_1);

		Socket socket;

		try {
		     //socket = new Socket(InetAddress.getLocalHost(),4485);	
		     socket = new Socket("192.168.1.81",4485);
		     //socket.connect(endpoint);
		     ObjectInputStream br=new ObjectInputStream(socket.getInputStream());
		     while(br.read()!=-1)
		     {
		    	
		    	System.out.println("recue du client     << "+br.read());
				//System.out.print("a envoyer au client >> ");
				//chaine_a_transmettre = stdin.readLine();
				//fluxEcriture.println(chaine_a_transmettre);

		     }
	          //socket.close();

		}catch (UnknownHostException e) {
			
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
