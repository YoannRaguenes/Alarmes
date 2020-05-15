
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventObject;
import java.util.GregorianCalendar;

public abstract class AlarmeEvent extends EventObject{
	protected LocalDateTime date;
	protected String localisation;
	protected int importance;
	protected boolean traite;
	public AlarmeEvent(Object source,String localisation,int importance, LocalDateTime localDateTime, boolean traite) {
		super(source);
		if(importance>=1 & importance<=3) {
			this.localisation = localisation;
			this.importance= importance;
			this.date = localDateTime;
			this.traite = traite;
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