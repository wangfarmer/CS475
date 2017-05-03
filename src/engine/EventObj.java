package calendar;

import java.util.Calendar;

public class EventObj {
	
	private Calendar startDate;
	private Calendar endDate;
	private String description;
	private String accessControl;
	
	public EventObj(){
		super();
	}
	public EventObj(Calendar startDate, Calendar endDate, String description, String accessControl) {
		
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.accessControl = accessControl;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccessControl() {
		return accessControl;
	}

	public void setAccessControl(String accessControl) {
		this.accessControl = accessControl;
	}
	
	@Override
	public String toString() {
		return "[startDate=" + startDate.getTime().toString() + ", endDate=" + endDate.getTime().toString() + ", description=" + description
				+ ", accessControl=" + accessControl + "]";
	}
	
}
