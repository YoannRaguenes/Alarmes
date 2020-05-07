import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Simulation extends JFrame implements ActionListener{
	
	  private JPanel container = new JPanel();
	  private Box left = Box.createVerticalBox();
    
	  private JLabel labelBat = new JLabel("Batiment :");
	  private JComboBox comboBat = new JComboBox();
	  
	  private JLabel labelType = new JLabel("Type d'alarme :") ;
	  private JComboBox comboType = new JComboBox();
	  
	  private JLabel labelNiveau = new JLabel("Niveau d'importance :") ;
	  private JComboBox comboNiveau = new JComboBox();
	  
	 
	  private JPanel spe = new JPanel();
	  private JLabel labelSpe = new JLabel(" ");
	  private JTextField speField = new JTextField("",10);
	  
	  private JButton bouton = new JButton("Valider");
	  
	  private Monitoring monitors;
	  
	  JPanel batiment = new JPanel();
	  JPanel type = new JPanel();
	  JPanel niveau = new JPanel();
	  JPanel panBout = new JPanel();
	  
	
	  public Simulation() {
			 
			//fenetre
		    this.setTitle("Simulateur alarme");
		    this.setSize(800, 500);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);

		    //batiment
		    comboBat.setPreferredSize(new Dimension(100, 20));
		    String[] tabBat = {"C203", "C204", "Option 3", "Option 4"}; //TODO : recuperer liste batiments
		    comboBat = new JComboBox(tabBat);
		    batiment.add(labelBat);
		    batiment.add(comboBat);
		    
		    //type alarme
		    comboType.setPreferredSize(new Dimension(100, 20));
		    String[] tabType = {"Incendie", "Gaz", "Radiation"};
		    comboType = new JComboBox(tabType);
		    type.add(labelType);
		    type.add(comboType);
		    
		    //Niveau importance
		    comboNiveau.setPreferredSize(new Dimension(100, 20));
		    String[] tabNiveau = {"1", "2", "3"};
		    comboNiveau = new JComboBox(tabNiveau);
		    niveau.add(labelNiveau);
		    niveau.add(comboNiveau);
		    
		    //bouton valider
		    panBout.add(bouton);
		    
		    
		    bouton.addActionListener(this);
		    comboType.addActionListener(this);
		    
		    
		  //affichage
		    left.add(batiment);
		    left.add(type);
		    left.add(niveau);

		    left.add(panBout);
		    container.add(left, BorderLayout.CENTER);
		    this.setContentPane(container);
		    this.setVisible(true);        
		    
		  }

	  @Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().toString() == "comboBoxChanged") {
		    	Integer getBat = (Integer) comboBat.getSelectedIndex();
		    	String getType = (String)comboType.getSelectedItem();
		    	Integer getNiveau = (Integer)comboNiveau.getSelectedIndex();
		        if(getType.equals("Gaz")) {
		        	left.removeAll();
	        		labelSpe.setText("Type de gaz :");
	        		spe.add(labelSpe);
	        		spe.add(speField);
	        		left.add(batiment);
	        		left.add(type);
	        		left.add(niveau);
	        		left.add(spe);
	        		left.add(panBout);
	        		
	        		container.updateUI();
		        }else if(getType.equals("Radiation")) {
		        	left.removeAll();
		        	labelSpe.setText("Niveau de radiation :");
		        	spe.add(labelSpe);
		        	spe.add(speField);
		        	left.add(batiment);
		    	    left.add(type);
		    	    left.add(niveau);
		        	left.add(spe);
		    	    left.add(panBout);
		        	
		        	container.updateUI();
		        } 
			}else {
				String getType = (String)comboType.getSelectedItem();
		        if(getType.equals("Gaz")) {
		        	SourceGaz sg = new SourceGaz();
		            Moniteur ecologie = new Moniteur("B");	
		            sg.addGazListener(ecologie);
		            GazEvent ae = sg.generateGazEvent(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()),speField.getText().toString(),comboBat.getSelectedItem().toString());
		            this.monitors.addAlarmeSign(sg.toString());
		            
		            
		            
		        }else if(getType.equals("Radiation")) {
		        	SourceRadiation rad = new SourceRadiation();
		            Moniteur ecologie = new Moniteur("B");	
		            rad.addRadiationListener(ecologie);
		            if(Integer.parseInt(speField.getText().toString()) >= 0 && Integer.parseInt(speField.getText().toString()) <= 100) {
		            	RadiationEvent re = rad.generateRadiationEvent(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()), Integer.parseInt(speField.getText().toString()),comboBat.getSelectedItem().toString());
			            this.monitors.addAlarmeSign(re.toString());
			           
		            }else {
		            	JOptionPane.showMessageDialog(this,
		            		  	"Les radiations doivent être comprises entre 0 et 100 !",
		            		    "Erreur sur la valeur",
		            		    JOptionPane.ERROR_MESSAGE);
		            }
		            
		            
		        }else {
		        	SourceIncendie feu = new SourceIncendie();
		            Moniteur ecologie = new Moniteur("A");	
		            feu.addIncendieListener(ecologie);
		            IncendieEvent ie = feu.generateIncendieEvent( comboBat.getSelectedItem().toString(), Integer.parseInt(comboNiveau.getSelectedItem().toString()),java.time.LocalDateTime.now());
		            this.monitors.addAlarmeSign(ie.toString());
		            
		        }
			}
		}
		  
		
		public void addMonitor(Monitoring mon) {
			this.monitors = mon;	
		}
		
	}

