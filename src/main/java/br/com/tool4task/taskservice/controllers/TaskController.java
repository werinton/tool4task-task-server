package br.com.tool4task.taskservice.controllers;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tool4task.taskservice.entities.Task;
import br.com.tool4task.taskservice.entities.TaskStatus;
import br.com.tool4task.taskservice.repositories.TaskRepository;

/**
 * This is the view layer of the Task entity.
 * @author Werinton
 *
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepo;

	@RequestMapping
	public List<Task> list() {
		return taskRepo.retrieveActives();
	}
	
	@RequestMapping("/{id}")
	public Task findById(@PathVariable long id) {
		return taskRepo.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void insert(@RequestBody Task task) {
		task.setCreationDate(GregorianCalendar.getInstance().getTime());
		taskRepo.save(task);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody Task task) {
		Task taskDB = taskRepo.findOne(task.getId().longValue());
		task.setCreationDate(taskDB.getCreationDate());
		task.setLastUpdateDate(GregorianCalendar.getInstance().getTime());
		if(task.getStatus() == TaskStatus.CLOSED) {
			task.setConclusionDate(GregorianCalendar.getInstance().getTime());
		}
		
		if(taskDB.getConclusionDate() != null) {
			task.setConclusionDate(taskDB.getConclusionDate());
		}
		
		taskRepo.save(task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable long id) {
		Task task = taskRepo.findOne(id);
		task.setActive(false);
		task.setRemovalDate(GregorianCalendar.getInstance().getTime());
		taskRepo.save(task);
	}
	
}
