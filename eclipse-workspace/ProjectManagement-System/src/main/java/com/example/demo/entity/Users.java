package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="USERS")
public class Users {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long user_id;
	@NotBlank(message = "Please provide a FullName")
	private String FullName;
	@NotBlank(message = "Please provide a Email")
	private String email;
	@NotBlank(message = "Please provide a Password")
	private String password;

	//  A user can be associated with multiple projects.
	@OneToMany(mappedBy="users",fetch=FetchType.EAGER)
	List<Project> projects;

	/**
	 * @param user_id
	 * @param fullName
	 * @param email
	 * @param password
	 * @param projects
	 */
	public Users(Long user_id, String fullName, String email, String password, List<Project> projects) {
		super();
		this.user_id = user_id;
		FullName = fullName;
		this.email = email;
		this.password = password;
		this.projects = projects;
	}
	
	

}
