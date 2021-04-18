package com.barclays.tshapeproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository<T> extends JpaRepository<Tickets,Long> {

    List<Tickets> findTicketsByStatus(TshapeprojectApplication.Status status);
}
