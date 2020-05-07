
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventObject;
import java.util.GregorianCalendar;

public abstract class AlarmeEvent extends EventObject{
	protected LocalDateTime date;
	protected String localisation;
	protected int importance;
	
	public AlarmeEvent(Object source,String localisation,int importance, LocalDateTime localDateTime) {
		super(source);
		if(importance>=1 & importance<=3) {
			this.localisation = localisation;
			this.importance= importance;
			this.date = localDateTime;
			
		}
		else {
			System.out.println("erreur de niveau d'importance il doit être compris en 1 ET 3");
		}
		
	}

	
	public String getLocalisation() {
		return localisation;
	}

	
	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}
	

	
	
	
	public abstract String toString();
	
	
	
	

}