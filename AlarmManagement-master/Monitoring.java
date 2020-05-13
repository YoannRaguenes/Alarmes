import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;	


public class Monitoring extends JFrame implements ListSelectionListener, ActionListener {
	

	JPanel panBout = new JPanel();
	JPanel listeAlarme = new JPanel();
	JList liste;
	JButton archiver = new JButton("Archiver");
	JButton details = new JButton("Details");
	JPanel container = new JPanel();
	Box left = Box.createVerticalBox();
	
	
	ArrayList<String> liste_info = new ArrayList<String>();
	ArrayList<String> liste_string = new ArrayList<String>();
	
	ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
	
	ArrayList<String> Archives = new ArrayList<String>();
	
	public Monitoring() {
		
		archiver.addActionListener(this);
	    panBout.add(archiver);
	    left.add(panBout);
	    
		details.addActionListener(this);
	    panBout.add(details);
	    left.add(panBout);
	    
	    
	    container.add(left, BorderLayout.CENTER);
	    
	    
	    this.liste = new JList(liste_info.toArray());
	 
	    listeAlarme.add(liste);
	    this.add(listeAlarme, BorderLayout.WEST);
	    
	    
	    
	    
		//fenetre
	    this.setTitle("Simulateur Moniteur");
	    this.setSize(400, 250);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setContentPane(container);
	    
	    setVisible(true);

	  
	
		
	}

	public void addAlarmeInfo(String info) {
		
		this.liste_info.add(info);
		this.listeAlarme.remove(this.liste);
		this.liste = new JList(liste_info.toArray());
		this.remove(this.listeAlarme);
		this.listeAlarme.add(this.liste, BorderLayout.WEST);
		this.add(this.listeAlarme, BorderLayout.WEST);
		this.listeAlarme.updateUI();
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
		
		if(e.getActionCommand().equals("Archiver"))
		{
			int index = this.liste.getSelectedIndex();
			if(index >= 0) {
				this.Archives.add(this.liste_info.get(index));
				this.liste_info.remove(index);
				this.listeAlarme.remove(this.liste);
				this.liste = new JList(liste_info.toArray());
				this.remove(this.listeAlarme);
				this.listeAlarme.add(this.liste, BorderLayout.WEST);
				this.add(this.listeAlarme, BorderLayout.WEST);
				
				
				
			}
			
			this.listeAlarme.updateUI();
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


	

