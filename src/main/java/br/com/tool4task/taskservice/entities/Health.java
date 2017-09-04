package br.com.tool4task.taskservice.entities;

public class Health {

	private String status;

	public Health() {
		this.status = "UP";
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
