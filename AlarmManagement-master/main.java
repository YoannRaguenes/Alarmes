

public class main {

	public static void main(String[] args){
		Moniteur pompier = new Moniteur("A");
		Moniteur ecologie = new Moniteur("B");

		
		  Simulation fen = new Simulation();
		  Monitoring mon = new Monitoring();
		  
		  mon.addMoniteur(pompier);
		  mon.addMoniteur(ecologie);
		  
		  fen.addMonitor(mon);
		  
	}

}
