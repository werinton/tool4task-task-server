package br.com.tool4task.taskservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tool4task.taskservice.entities.Health;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

	private static final Health HEALTH = new Health();
	
	@RequestMapping
	public Health check() {
		return HEALTH;
	}
}
