package alarm;

import java.util.Date;

// The class alarm is used to store the alarm information
public class Alarm {

	private Date time;
	private String alertMessage;
	private String priority;

	public static String LOW = "Low"; // Low Priority
	public static String MED = "Medium"; // Medium Priority
	public static String HIGH = "High"; // High Priority

	// Constructor
	public Alarm(Date time, String alertMessage, String priority) {
		this.time = time;
		this.alertMessage = alertMessage;
		this.priority = priority;
	}

	// Get the time of the alarm
	public Date getTime() {
		return time;
	}

	// Set the time of the alarm
	public void setTime(Date time) {
		this.time = time;
	}

	// Get the alert message
	public String getAlertMessage() {
		return alertMessage;
	}

	// Set the alert message
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	// Get the priority of the alarm
	public String getPriority() {
		return priority;
	}

	// Set the priority of the alarm
	public void setPriority(String priority) {
		this.priority = priority;
	}
}
