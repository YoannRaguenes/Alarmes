
import java.util.Date;
import java.util.EventListener;

public interface AlarmeGazListener extends EventListener  {
	public String receptionGaz(Date dateApparition, String localisation,int type,int importance);
}
