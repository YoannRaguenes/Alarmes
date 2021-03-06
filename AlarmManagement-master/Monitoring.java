import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;	


public class Monitoring extends JFrame implements ListSelectionListener, ActionListener {
	
	
	private JTextPane area = new JTextPane();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JPanel panBout = new JPanel();
	JPanel bouton_listeAlarme = new JPanel();
	JList liste;
	JButton suprimer = new JButton("Suprimer");
	JButton details = new JButton("Details");
	JPanel container = new JPanel();
	Box left = Box.createVerticalBox();

	ArrayList<String> liste_info = new ArrayList<String>();
	ArrayList<String> liste_string = new ArrayList<String>();
	
	ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
	
	
	
	public Monitoring() {
		
		
		suprimer.addActionListener(this);
	    panBout.add(suprimer);
	    left.add(panBout);
	    
		details.addActionListener(this);
	    panBout.add(details);
	    left.add(panBout);
	    
	    
	    container.add(left, BorderLayout.CENTER);
	    
	    
	    this.liste = new JList(liste_info.toArray());
	    JScrollPane scroller = new JScrollPane(liste);

	    bouton_listeAlarme.add(scroller);
	   
	    this.add(bouton_listeAlarme, BorderLayout.CENTER);
	    
	    
	    
	    
		//fenetre
	    this.setTitle("Moniteur A");
	    this.setSize(450, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(container);
	    
	    setVisible(true);

	  
	
		
	}

	public void addAlarmeInfo(String info) {
		
		this.liste_info.add(info);
		this.bouton_listeAlarme.remove(this.liste);
		this.liste = new JList(liste_info.toArray());
		this.remove(this.bouton_listeAlarme);
		this.bouton_listeAlarme.add(this.liste, BorderLayout.CENTER);
		this.add(this.bouton_listeAlarme, BorderLayout.CENTER);
		this.bouton_listeAlarme.updateUI();
		JOptionPane Jope = new JOptionPane();
		Jope.showMessageDialog(this, info, "Alarme déclenchée ", JOptionPane.WARNING_MESSAGE);
		
			
	}
	
	public void addAlarmeString(String string) {
		this.liste_string.add(string);
	}
	
	
	public void addMoniteur(Moniteur moni) {
		this.listeMoni.add(moni);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Suprimer"))
		{
			int index = this.liste.getSelectedIndex();
			if(index >= 0) {
				this.liste_info.remove(index);
				this.liste_string.remove(index);
				this.bouton_listeAlarme.remove(this.liste);
				this.liste = new JList(liste_info.toArray());
				this.remove(this.bouton_listeAlarme);
				this.bouton_listeAlarme.add(this.liste, BorderLayout.CENTER);
				this.add(this.bouton_listeAlarme, BorderLayout.CENTER);
				

				
				
			}
			
			this.bouton_listeAlarme.updateUI();
		}
		
		if(e.getActionCommand().contentEquals("Details"))
		{
			int index = this.liste.getSelectedIndex();
			if(index >= 0) {
				JOptionPane Jope = new JOptionPane();
				Jope.showMessageDialog(this, this.liste_string.get(index), "Information sur l'alarme ", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
	}
}


	

