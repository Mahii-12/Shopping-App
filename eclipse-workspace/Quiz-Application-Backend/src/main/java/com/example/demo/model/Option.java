package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Option")
public class Option {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String text;
    
    @ManyToOne
    private Question question;
    
    public Option() {}

	/**
	 * @param id
	 * @param text
	 * @param question
	 */
	public Option(Long id, String text, Question question) {
		super();
		this.id = id;
		this.text = text;
		this.question = question;
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

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
    

}
