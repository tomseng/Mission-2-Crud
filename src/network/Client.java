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


public class Client implements ActionListener{
	
	
	public static void main(String[] args) {
		
		JFrame jf1 = new JFrame();
		JPanel jp1 = new JPanel();
		jp1.setName("panel1");
		jf1.setSize(600, 350);
		jf1.setTitle("GUI Client");
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton jb1 = new JButton("Inscrire un WS");
		jb1.setSize(40,40);
		//jf1.add(jb1);
		jf1.getContentPane().add(jb1);
		jf1.setVisible(true);
		jf1.setLocation(400, 200);

		Socket socket;

		try {
		     //socket = new Socket(InetAddress.getLocalHost(),4485);	
		     socket = new Socket("192.168.3.71",4485);	

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
