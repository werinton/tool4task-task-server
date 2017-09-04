package br.com.tool4task.taskservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.tool4task.taskservice.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query("select t from Task t where t.active = true")
	List<Task> retrieveActives();
}