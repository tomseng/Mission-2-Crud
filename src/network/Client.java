package network;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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
	
	
	public static void main(String[] args) {
		
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
		
		table = new JTable();
		table.setBounds(223, 76, 371, 246);
		jf1.getContentPane().add(table);

		Socket socket;

		try {
		     //socket = new Socket(InetAddress.getLocalHost(),4485);	
		     socket = new Socket("192.168.0.85",4485);	

	             socket.close();

		}catch (UnknownHostException e) {
			
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
