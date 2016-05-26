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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Client implements ActionListener{
	private static JTable listeWS;
	private static JTable table_1;
	private static JTable contentWS;
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
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
		btnListerLesWebservices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Lister les webservice");
			}
		});
		btnListerLesWebservices.setBounds(6, 35, 172, 29);
		jf1.getContentPane().add(btnListerLesWebservices);
		
		JButton btnCrerUneEntre = new JButton("Creer une entree");
		btnCrerUneEntre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Créer une entrée");
			}
		});
		btnCrerUneEntre.setBounds(6, 170, 172, 29);
		jf1.getContentPane().add(btnCrerUneEntre);
		
		
		final JTextPane txtpnBox = new JTextPane();
		txtpnBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(txtpnBox.getText().toString());
			}
		});
		
		
		txtpnBox.setText("Box");
		txtpnBox.setBounds(6, 211, 172, 111);
		jf1.getContentPane().add(txtpnBox);
		
		 

	    
		
		//table.setBounds(223, 76, 371, 246);
		//jf1.getContentPane().add(table);
		
		//Registry reg = new Registry();
		
		/*table_1 = new JTable(reg.getEnregistrementsToObjects(),title);
		table_1.setBounds(6, 76, 172, 93);
		jf1.getContentPane().add(table_1);*/

		Socket socket;

		try {
		     //socket = new Socket(InetAddress.getLocalHost(),4485);	
		     socket = new Socket("192.168.0.85",4490);
		     //socket.connect(endpoint);
		     //BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		     //String str=br.readLine();
		     //while(br.readLine() != null)
		     //{
		    	Object[][] donne = (Object[][]) ois.readObject();
		    	System.out.println("reçue du client     << "+donne[0][0]);
				//System.out.print("a envoyer au client >> ");
				//chaine_a_transmettre = stdin.readLine();
				//fluxEcriture.println(chaine_a_transmettre);
		    	//Les titres des colonnes
			    String  title[] = {"IP", "Port", "Nom"};
		    	
		    	listeWS = new JTable(donne, title);
				listeWS.setBounds(6, 65, 172, 93);
				jf1.getContentPane().add(listeWS);
				
				contentWS = new JTable();
				contentWS.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						System.out.println("property changed");
					}
				});
				contentWS.setBounds(201, 65, 393, 200);
				jf1.getContentPane().add(contentWS);
				
				JLabel lblContenuDuWebservic = new JLabel("Contenu du WebServic");
				lblContenuDuWebservic.setBounds(325, 40, 152, 16);
				jf1.getContentPane().add(lblContenuDuWebservic);
				
				JButton btnDelete = new JButton("Delete");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnDelete.setBounds(443, 277, 117, 29);
				jf1.getContentPane().add(btnDelete);
				
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnUpdate.setBounds(266, 277, 117, 29);
				jf1.getContentPane().add(btnUpdate);

		     //}
	         socket.close();

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
