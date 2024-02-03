package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Quiz")
public class Quiz {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne
	    private User user;
	    
	    public Quiz() {}
	    

		/**
		 * @param id
		 * @param user
		 */
		public Quiz(Long id, User user) {
			super();
			this.id = id;
			this.user = user;
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the user
		 */
		public User getUser() {
			return user;
		}

		/**
		 * @param user the user to set
		 */
		public void setUser(User user) {
			this.user = user;
		}
	    
	    
	
}
