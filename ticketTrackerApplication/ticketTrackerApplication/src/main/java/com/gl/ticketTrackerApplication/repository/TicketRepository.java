package com.gl.ticketTrackerApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.ticketTrackerApplication.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query(value = "SELECT * FROM tickets t WHERE " + "LOWER(t.ticket_name) LIKE LOWER(CONCAT('%',:query, '%')) OR "
			+ "LOWER(t.ticket_short_desc) LIKE LOWER(CONCAT('%',:query, '%'))", nativeQuery = true)

	List<Ticket> getByKeyword(@Param("query") String query);
}
