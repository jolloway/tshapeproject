package com.barclays.tshapeproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository<T> extends JpaRepository<TicketEntity,Long> {
}
