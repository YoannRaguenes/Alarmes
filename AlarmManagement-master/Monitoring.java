import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;	


public class Monitoring extends JFrame implements ListSelectionListener, ActionListener {
	
	// taille de l'écran
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	// taille de la fenetre
	private Dimension frameSize = new Dimension(screenSize.width*2/3, screenSize.height*2/3);
	
	JPanel listeAlarme = new JPanel();
	JPanel detailsAlarme = new JPanel(new GridBagLayout());	
	JList liste;
	
	JTextArea etiquette = new JTextArea("Aucune alame déclenchées",250,400);
	
	ArrayList<String> choix = new ArrayList<String>();
	
	
	ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
	
	
	public Monitoring() {

	    detailsAlarme.add(etiquette);
	    this.etiquette.setEditable(false);
	    this.add(detailsAlarme, BorderLayout.CENTER);
	    
	    
	    
	    this.liste = new JList(choix.toArray());
	    listeAlarme.add(liste);
	    this.add(listeAlarme, BorderLayout.WEST);
	    
		//fenetre
	    this.setTitle("Simulateur Moniteur");
	    this.setSize(400, 250);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    setVisible(true);

	  
	
		
	}

	public void addAlarmeSign(String info) {
		
		this.choix.add(info);
		this.listeAlarme.remove(this.liste);
		this.liste = new JList(choix.toArray());
		this.remove(this.listeAlarme);
		this.listeAlarme.add(this.liste, BorderLayout.WEST);
		this.add(this.listeAlarme, BorderLayout.WEST);
		this.listeAlarme.updateUI();
		JOptionPane.showMessageDialog(this, info, "Alarme déclenchée", JOptionPane.ERROR_MESSAGE);
		
		
	}
	
	public void addMoniteur(Moniteur moni) {
		this.listeMoni.add(moni);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


	
}
