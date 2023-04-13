package com.gl.ticketTrackerApplication.service;

import java.util.List;

import com.gl.ticketTrackerApplication.entity.Ticket;

public interface TicketService {

	public List<Ticket> getAllTickets();

	public void saveOrUpdate(Ticket ticket);

	public void deleteTicketById(int Id);

	public Ticket getTicketById(int Id);

	public List<Ticket> getByKeyword(String query);
}
