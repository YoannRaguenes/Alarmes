import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EventListener;

public interface listenerFeu extends EventListener {
	public String incendiePresent(Date dateAppa, String loca, int importance);

}
