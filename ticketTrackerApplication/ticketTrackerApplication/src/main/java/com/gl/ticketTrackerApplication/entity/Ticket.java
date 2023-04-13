package com.gl.ticketTrackerApplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	public int id;

	@Column(name = "ticket_name")
	public String ticketName;

	@Column(name = "ticket_created_on")
	public Date ticketCreatedOn;

	@Column(name = "ticket_short_desc")
	public String ticketShortDescription;

	@Column(name = "ticket_description")
	private String ticketDescription;

	
}
