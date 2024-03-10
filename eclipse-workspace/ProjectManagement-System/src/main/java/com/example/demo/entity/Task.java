package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Task")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long task_id;
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	private Status status; // TRUE=Completed  &&   FALSE=InCompleted
	
	//A task belongs to a single project.
	@ManyToOne
    @JoinColumn(name = "project_id")
	@JsonIgnore 
    private Project project;
	
	

	/**
	 * @param task_id
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param project
	 */
	public Task(Long task_id, LocalDate startDate, LocalDate endDate, Status status, Project project) {
		super();
		this.task_id = task_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.project = project;
	}
	 
	 
}
