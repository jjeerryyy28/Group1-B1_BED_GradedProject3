package com.gl.ticketTrackerApplication.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.ticketTrackerApplication.entity.Ticket;
import com.gl.ticketTrackerApplication.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	TicketService service;
	 
	@GetMapping("/home/tickets")
	public String getAllTickets(Model model) {
		List<Ticket> result = service.getAllTickets();
		model.addAttribute("tickets", result);
		return "tickets";
	}

	@GetMapping("/home/tickets/newTicket")
	public String addNewTicket(Model model) {
		Ticket result = new Ticket();
		model.addAttribute("ticket", result);
		return "create_ticket";
	}

	@GetMapping("/home/tickets/edit/{id}")
	public String UpdateTicket(Model model, @PathVariable("id") int id) {
		Ticket result = service.getTicketById(id);
		model.addAttribute("ticket", result);
		return "edit_ticket";
	}

	@GetMapping("/home/tickets/view/{id}")
	public String ViewTicket(Model model, @PathVariable("id") int id) {
		Ticket result = service.getTicketById(id);
		model.addAttribute("ticket", result);
		return "view_ticket";
	}

	@GetMapping("/home/tickets/delete/{id}")
	public String deleteTicket(Model model, @PathVariable("id") int id) {
		service.deleteTicketById(id);
		return "redirect:/home/tickets";
	}

	@PostMapping("/home/tickets")
	public String saveNewTicket(@ModelAttribute("tickets") Ticket ticket) {
		ticket.setTicketCreatedOn(new Date());
		service.saveOrUpdate(ticket);
		return "redirect:/home/tickets";
	}

	@PostMapping("/home/tickets/{id}")
	public String updateEmployee(@ModelAttribute("ticket") Ticket ticket, @PathVariable("id") int id) {
		Ticket existingticket = service.getTicketById(id);
		existingticket.setTicketName(ticket.getTicketName());
		existingticket.setTicketShortDescription(ticket.getTicketShortDescription());
		existingticket.setTicketDescription(ticket.getTicketDescription());
		service.saveOrUpdate(existingticket);

		return "redirect:/home/tickets";
	}

	@GetMapping("/home/tickets/search")
	public String searchTickets(Model model, String query) {
		if (query != null) {
			List<Ticket> result = service.getByKeyword(query);
			model.addAttribute("tickets", result);
		}
		return "tickets";
	}

}