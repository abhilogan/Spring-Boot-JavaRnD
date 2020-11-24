package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TicketDao;
import com.example.demo.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;

	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets) {
		dao.saveAll(tickets);
		return "ticket booked : " + tickets.size();
	}

	@PutMapping("/updateTickets")
	public String updateTicket(@RequestBody Ticket tickets) {

			for(Ticket ticket : dao.findAll()) {
				if(ticket.getId() == tickets.getId()) {
					ticket.setAmount(tickets.getAmount());
					ticket.setCatagory(tickets.getCatagory());
					
					dao.save(ticket);
				}
			}
		
		return "ticket updated successfully ";
	}
	
	@GetMapping("/getTickets")
	public List<Ticket> getTickets() {
		return (List<Ticket>) dao.findAll();
	}
	
	@DeleteMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable int id) {
		
		for(Ticket ticket : dao.findAll()) {
			if(ticket.getId() == id) {
				
				dao.deleteById(id);
				
			}
		}
		return "Successfully deleted";
		
	}
}
