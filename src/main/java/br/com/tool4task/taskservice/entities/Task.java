package br.com.tool4task.taskservice.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Task is something that you have to do or that you have done.
 * @author Werinton
 *
 */
@Entity
public class Task {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private TaskStatus status;
	private Boolean active;
	private Date creationDate;
	private Date lastUpdateDate;
	private Date removalDate;
	private Date conclusionDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public Date getRemovalDate() {
		return removalDate;
	}
	public void setRemovalDate(Date removalDate) {
		this.removalDate = removalDate;
	}
	public Date getConclusionDate() {
		return conclusionDate;
	}
	public void setConclusionDate(java.util.Date conclusionDate) {
		this.conclusionDate = conclusionDate;
	}
	
}
