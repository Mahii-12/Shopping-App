package com.example.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name="Project")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long project_id;
	@NotBlank(message = "Please provide a Title")
	private String title;
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	//   A project can have multiple users working on it (if needed).
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore 
	private Users users;

	
	//   A project can have multiple tasks.
	 @OneToMany(mappedBy = "project")
	 @JsonIgnore 
	 private List<Task> tasks = new ArrayList<>();

	/**
	 * @param project_id
	 * @param title
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @param users
	 * @param tasks
	 */
	public Project(Long project_id, String title, LocalDate startDate, LocalDate endDate, Status status, Users users,
			List<Task> tasks) {
		super();
		this.project_id = project_id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.users = users;
		this.tasks = tasks;
	}
	 
	 
	
}























