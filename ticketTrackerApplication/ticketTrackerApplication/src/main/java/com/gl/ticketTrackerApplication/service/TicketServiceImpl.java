package com.gl.ticketTrackerApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.ticketTrackerApplication.entity.Ticket;
import com.gl.ticketTrackerApplication.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public void saveOrUpdate(Ticket ticket) {
		// TODO Auto-generated method stub
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicketById(int Id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(Id);
	}

	@Override
	public Ticket getTicketById(int Id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(Id).get();
	}

	@Override
	public List<Ticket> getByKeyword(String query) {
		// TODO Auto-generated method stub
		return ticketRepository.getByKeyword(query);
	}

}
