package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Question")
public class Question {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String text;
	    
	    // Other fields and getters/setters
	    
	    public Question() {}

		/**
		 * @param id
		 * @param text
		 */
		public Question(Long id, String text) {
			super();
			this.id = id;
			this.text = text;
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
		 * @return the text
		 */
		public String getText() {
			return text;
		}

		/**
		 * @param text the text to set
		 */
		public void setText(String text) {
			this.text = text;
		}
	    
	    
}
