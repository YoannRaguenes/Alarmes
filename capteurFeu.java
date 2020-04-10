import javax.swing.event.EventListenerList;

public class capteurFeu {
	private String location;
	private boolean fummee;
	private int importance;
	
	
	public capteurFeu(String loc, boolean fum) {
		this.location = loc;
		this.fummee = fum;
		this.importance = 0;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public boolean isFummee() {
		return fummee;
	}


	public void setFummee(boolean fummee) {
		this.fummee = fummee;
	}


	public int getImportance() {
		return importance;
	}


	public void setImportance(int importance) {
	}
}

	
	
	