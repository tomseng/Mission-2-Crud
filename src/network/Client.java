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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;


public class Client implements ActionListener{
	private static JTable listeWS;
	private static JTable contentWS;
	private static String ipServeurBDD = "jdbc:mysql://192.168.0.74/mission2registry";
	private static String login = "root";
	private static String password = "root";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		final JFrame jf1 = new JFrame();
		JPanel jp1 = new JPanel();
		jp1.setName("panel1");
		jf1.setSize(600, 350);
		jf1.setTitle("GUI Client");
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.setVisible(true);
		jf1.setLocation(400, 200);
		jf1.getContentPane().setLayout(null);
		contentWS=new JTable();
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
		
		final JTextPane txtpnBox = new JTextPane();
		txtpnBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println(txtpnBox.getText().toString());
			}
		});
		
		JButton btnCrerUneEntre = new JButton("Creer une entree");
		btnCrerUneEntre.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e)  {
				//System.out.println("Cr�er une entr�e");
				//System.out.println(txtpnBox.getText().toString());
				String[] donnees=txtpnBox.getText().toString().split("\n");
				String table=(String) listeWS.getValueAt(listeWS.getSelectedRow(), 2);
				//System.out.println(donnees.length);
				try {
					webService("create", table, donnees);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCrerUneEntre.setBounds(6, 170, 172, 29);
		jf1.getContentPane().add(btnCrerUneEntre);
		
		
		txtpnBox.setText("Box");
		txtpnBox.setBounds(6, 211, 172, 111);
		jf1.getContentPane().add(txtpnBox);
		
		 
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//listeWS.get(listeWS.getSelectedColumn();
				String table;
				String[] donnee=new String[1];
				table=(String) listeWS.getValueAt(listeWS.getSelectedRow(), 2);
				//System.out.println(table);
				donnee[0]=(String) contentWS.getValueAt(contentWS.getSelectedRow() !=-1 ?
					contentWS.getSelectedRow() : 0, 0);
				//System.out.println(donnee[0]);
				try {
					webService("delete", table, donnee);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(443, 277, 117, 29);
		jf1.getContentPane().add(btnDelete);
	    
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table;
				table=(String) listeWS.getValueAt(listeWS.getSelectedRow(), 2);
				//System.out.println(txtpnBox.getText().toString());
				String[] donnee=new String[txtpnBox.getText().toString().split("\n").length+1];				
				//System.out.println(donnee.length);
				String[] donneebis=txtpnBox.getText().toString().split("\n");
				//System.out.println(donneebis.length);
				for(int i=0; i<donneebis.length; i++)
				{
					donnee[i]=donneebis[i];
				}
				donnee[donneebis.length]=(String) contentWS.getValueAt(contentWS.getSelectedRow() != -1 ?
						contentWS.getSelectedRow() : 0, 0);				
				try {
					webService("update", table, donnee);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(266, 277, 117, 29);
		jf1.getContentPane().add(btnUpdate);
		
		/*DefaultTableModel model;
		Vector<String> columnNames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> v = new Vector<String>();
		v.add("Choix 1");
		v.add("Choix 2");
		v.add("Choix 3");
		data.add(v);
		columnNames.add("entete1");
		columnNames.add("entete2");
		columnNames.add("entete3");
		model = new DefaultTableModel(data,columnNames);
		//model.setRowCount(0);
		contentWS.setModel(model);
		//model.fireTableDataChanged();
		//contentWS.setBounds(201, 65, 393, 200);
		//jf1.getContentPane().add(contentWS);
		JScrollPane scrollPane = new JScrollPane(contentWS);
		scrollPane.setBounds(217, 67, 316, 166);
		jf1.getContentPane().add(scrollPane);*/
		
		Socket socket;

		try {
		      socket = new Socket("192.168.0.85",4490);
		      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		      Object[][] donne = (Object[][]) ois.readObject();
		      System.out.println("reçue du client     << "+donne[0][0]);
		      //listWS
		      //Les titres des colonnes
			  String  title[] = {"IP", "Port", "Nom"};
			   listeWS = new JTable(donne, title);
			   listeWS.addMouseListener(new MouseAdapter() {
			   	@Override
			   	public void mouseClicked(MouseEvent arg0) {
			   		//System.out.println("ListWS clicked !");
			   		ArrayList<String[]> donnees=new ArrayList<String[]>();
					ArrayList<String[]> titres=new ArrayList<String[]>();
					String table=(String) listeWS.getValueAt(listeWS.getSelectedRow()!=-1 ? 
					listeWS.getSelectedRow() : 0, 2);
					String[] donn=new String[0];
					try {
						donnees=webService("read", table, donn);
						titres=webService("titres", table, donn);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Object[][] donneesObject=getArrayListToObjectsDonnees(donnees);
					String  titreTab[] = getArrayListToObjectsTitres(titres);
					DefaultTableModel model;
					Vector<String> columnNames = new Vector<String>();
					Vector<Vector<String>> data = new Vector<Vector<String>>();
					if(donneesObject.length!=0)
					{
						for(Object[] objTab:donneesObject)
						{
							Vector<String> v=new Vector<String>();
							for(int i=0; i<objTab.length; i++){							
								v.add(""+objTab[i]);
							}
							data.addElement(v);
						}
						for(String str:titreTab)
						{
							columnNames.addElement(str);
						}
						model = new DefaultTableModel(data,columnNames);
					}
					else
					{
						data.clear();
						columnNames.clear();
						model = new DefaultTableModel(data,columnNames);
						model.setRowCount(0);
					}
					contentWS.setModel(model);
					model.fireTableDataChanged();
					//contentWS.setBounds(201, 65, 393, 200);
					//jf1.getContentPane().add(contentWS);
					JScrollPane scrollPane = new JScrollPane(contentWS);
					scrollPane.setBounds(201, 65, 393, 200);
					jf1.getContentPane().add(scrollPane);
			   	}
			   });
			   listeWS.setBounds(6, 65, 172, 93);
				jf1.getContentPane().add(listeWS);
				//contentWS
				DefaultTableModel model;
				Vector<String> columnNames = new Vector<String>();
				Vector<Vector<String>> data = new Vector<Vector<String>>();
				data.clear();
				columnNames.clear();
				model = new DefaultTableModel(data,columnNames);
				model.setRowCount(0);
				contentWS.setModel(model);
				model.fireTableDataChanged();
				contentWS.setBounds(201, 65, 393, 200);
				//jf1.getContentPane().add(contentWS);
				
				JLabel lblContenuDuWebservic = new JLabel("Contenu du WebService");
				lblContenuDuWebservic.setBounds(325, 40, 152, 16);
				jf1.getContentPane().add(lblContenuDuWebservic);
				
				JScrollPane scrollPane = new JScrollPane(contentWS);
				scrollPane.setBounds(217, 67, 316, 166);
				jf1.getContentPane().add(scrollPane);

		     //}
	         socket.close();

		}catch (UnknownHostException e) {
			
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String[]> webService(String type, String table, String[] donnees) throws SQLException{
		ArrayList<String[]> retour=new ArrayList<String[]>();
		Connection conn = DriverManager.getConnection(ipServeurBDD, login, password);
		ResultSet rs;
		PreparedStatement preparedstmt;
		Statement stmt;
		String req;
		switch(type)
		{
			case "create":
				req="INSERT INTO "+table+" VALUES (0, ";
				for(int i=0; i<donnees.length; i++)
				{
					if(i<donnees.length-1){
						req+="'"+donnees[i]+"', ";
					}
					else if(i==donnees.length-1)
					{
						req+="'"+donnees[i]+"');";
					}				
				}
				//System.out.println(req);
				stmt = conn.createStatement();   
				stmt.execute(req);
				stmt.close();
				break;
			case "read":
				preparedstmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM "+table+";");
				rs = preparedstmt.executeQuery();
				while(rs.next()){
					String[] tab=new String[rs.getMetaData().getColumnCount()];
		        	for(int i=0; i<rs.getMetaData().getColumnCount(); i++){
		        		tab[i]= ""+rs.getObject(i+1);
		        	}
		        	retour.add(tab);
		        }
				rs.close();
				preparedstmt.close();
				break;
			case "update":
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM "+table+" LIMIT 1;");
				req="UPDATE "+table+" SET ";
				for(int i=0; i<donnees.length; i++)
				{
					if(i==0)
					{
						req+=rs.getMetaData().getColumnName(i+1)+"="+donnees[donnees.length-1];
					}
					else if(i<donnees.length-1)
					{
						req+=", "+rs.getMetaData().getColumnName(i+1)+"='"+donnees[i-1]+"'";
					}
					else if(i==donnees.length-1)
					{
						req+=", "+rs.getMetaData().getColumnName(i+1)+"='"+donnees[i-1]+"' WHERE "+rs.getMetaData().getColumnName(1)+"="+donnees[donnees.length-1]+";";
					}	
				}
				rs.close();
				//System.out.println(req);
				stmt.execute(req);
				stmt.close();
				//System.out.println(req);
				break;
			case "delete":
				String col = null;
				stmt = conn.createStatement();
				preparedstmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM "+table+" LIMIT 1;");
				rs = preparedstmt.executeQuery();
				while(rs.next()){
					col=rs.getMetaData().getColumnName(1);
				}
				stmt.execute("DELETE FROM "+table+" WHERE "+col+"="+donnees[0]+";");
				stmt.close();
				 /*while(rs.next()){
			        	//retour=rs.getInt(1);
			    }*/
				break;
			case "titres":
				preparedstmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM "+table+" LIMIT 1;");
				rs = preparedstmt.executeQuery();
				while(rs.next()){
					String[] tab=new String[rs.getMetaData().getColumnCount()];
		        	for(int i=0; i<rs.getMetaData().getColumnCount(); i++){
		        		tab[i]= rs.getMetaData().getColumnName(i+1);
		        	}
		        	retour.add(tab);
		        }
				rs.close();
				preparedstmt.close();
				break;
			default:
				break;
		}
		return retour;
	}
	
	public static Object[][] getArrayListToObjectsDonnees(ArrayList<String[]> in) {
		Object[][] retour=new Object[in.size()][];
		//System.out.println(in.size());
		int i=0;
		for(String[] t:in){
			Object[] r=new Object[t.length];
			//System.out.println(t.length);
			r=in.get(i);
			retour[i]=r;
			i++;
		}
		return retour;
	}
	
	public static String[] getArrayListToObjectsTitres(ArrayList<String[]> in) {
		String[] retour = null;
		int i=0;
		for(String[] t:in){
			retour=new String[t.length];
			retour=t;
			i++;
		}
		return retour;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
