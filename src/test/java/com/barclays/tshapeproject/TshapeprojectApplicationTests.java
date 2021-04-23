package com.barclays.tshapeproject;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TshapeprojectApplicationTests {

	public TicketRepository ticketRepository;
	public TicketRestController ticketRestController;
	public TicketService ticketService;


	@BeforeEach
	public void beforeTest(){
		ticketRepository = Mockito.spy(TicketRepository.class);
		ticketService = new TicketService(ticketRepository);
		ticketRestController = new TicketRestController(ticketService);

	}

	@Test
	public void getAllTicketsTest() {

		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());
		Tickets ticket2 = new Tickets("TEST2", " I REALLY HATE JIRA",TshapeprojectApplication.Status.UAT_TESTING, "I SHOULD WORK BUT DONT", LocalDate.now());
		Tickets ticket3 = new Tickets("TEST3", "JIRA WAS DEVELOPED TO ANNOY ME", TshapeprojectApplication.Status.CLOSED, "I DO WORK",LocalDate.now());
		List<Tickets> ticketList = new ArrayList<Tickets>() {};
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		ticketList.add(ticket3);
		Mockito.when(ticketRepository.findAll()).thenReturn(ticketList);
		ResponseEntity response = ticketRestController.getAllTickets();

		ResponseEntity tickets = new ResponseEntity<>( ticketList, HttpStatus.OK);
		assertEquals(response,tickets);
	}

	@Test
	public void getTicketByIdTest() {

		Tickets ticket2 = new Tickets("TEST2", " I REALLY HATE JIRA",TshapeprojectApplication.Status.UAT_TESTING, "I SHOULD WORK BUT DONT", LocalDate.now());
		Mockito.when(ticketRepository.findById(Long.valueOf(2))).thenReturn(Optional.of(ticket2));
		ResponseEntity response = ticketRestController.getTicketById(2);

		ResponseEntity tickets = new ResponseEntity<>(ticket2,HttpStatus.ACCEPTED);
		assertEquals(response,tickets);

	}

	@Test
	public void getTicketByStatusTest() {

		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());
		List<Tickets> ticketList = new ArrayList<Tickets>() {};
		ticketList.add(ticket1);
		Mockito.when(ticketRepository.findTicketsByStatus(TshapeprojectApplication.Status.DEVELOPMENT)).thenReturn(ticketList);
		ResponseEntity response = ticketRestController.getTicketByStatus("DEVELOPMENT");

		ResponseEntity tickets = new ResponseEntity<>( ticketList, HttpStatus.OK);
		assertEquals(response,tickets);
	}

	@Test
	public void getTicketByStatusPendingTest() {

		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.PENDING, "I DONT WORK", LocalDate.now());
		List<Tickets> ticketList = new ArrayList<Tickets>() {};
		ticketList.add(ticket1);
		Mockito.when(ticketRepository.findTicketsByStatus(TshapeprojectApplication.Status.PENDING)).thenReturn(ticketList);
		ResponseEntity response = ticketRestController.getTicketByStatus("PENDING");

		ResponseEntity tickets = new ResponseEntity<>( ticketList, HttpStatus.OK);
		assertEquals(response,tickets);
	}
	@Test
	public void addTicketTest() throws JSONException {
		Tickets ticket4= new Tickets("TEST4", "I HATE FRONTEND", TshapeprojectApplication.Status.CLOSED, "FRONTEND IS THE WORST",LocalDate.now());
		String json = new JSONObject().put("author", ticket4.getAuthor()).put("title",ticket4.getTitle()).put("status",ticket4.getStatus()).put("description",ticket4.getDescription()).toString();
		Mockito.doReturn(ticket4).when(ticketRepository).save(Mockito.any(Tickets.class)); //even when exactly the same does not properly mock tickets due to reliance on pointers
		ResponseEntity response = ticketRestController.addTicket(json);

		ResponseEntity responseTest=  ResponseEntity.status(HttpStatus.CREATED).body("Ticket created");
		assertEquals(response,responseTest);
	}

	@Test
	public void addTicketExceptionTest() throws JSONException {
		String json = "randomcrap";
		try{
			ResponseEntity response = ticketRestController.addTicket(json);
			fail();
		}catch(ResponseStatusException e){

			assertEquals(e.toString(), (new ResponseStatusException(HttpStatus.BAD_REQUEST,"INVALID JSON REQUEST")).toString());
			return;
		}
		fail();
	}


	@Test
	public void editTicketTest() {
		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());

		Tickets ticket4 = new Tickets("TEST4","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());
		Mockito.when(ticketRepository.save(ticket4)).thenReturn(ticket4);
		Mockito.when(ticketRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(ticket1));
		ResponseEntity response = ticketRestController.editTicket(1,"author","TEST4");

		ResponseEntity tickets =ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket edited");
		assertEquals(response,tickets);
	}

	@Test
	public void editTicketTestAuthor() {
		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());

		Tickets ticket4 = new Tickets("TEST4","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());
		Mockito.when(ticketRepository.save(ticket4)).thenReturn(ticket4);
		Mockito.when(ticketRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(ticket1));
		ResponseEntity response = ticketRestController.editTicket(1,"author","TEST4");

		ResponseEntity tickets =ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket edited");
		assertEquals(response,tickets);
	}
	@Test
	public void editTicketTestTitle() {
		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());

		Tickets ticket4 = new Tickets("TEST1","I HATE JUNIT", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());
		Mockito.when(ticketRepository.save(ticket4)).thenReturn(ticket4);
		Mockito.when(ticketRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(ticket1));
		ResponseEntity response = ticketRestController.editTicket(1,"title","I HATE JUNIT");

		ResponseEntity tickets =ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket edited");
		assertEquals(response,tickets);
	}

	@Test
	public void editTicketTestDescription() {
		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());

		Tickets ticket4 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I HATE JAVASCRIPT MORE", LocalDate.now());
		Mockito.when(ticketRepository.save(ticket4)).thenReturn(ticket4);
		Mockito.when(ticketRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(ticket1));
		ResponseEntity response = ticketRestController.editTicket(1,"description","I HATE JAVASCRIPT MORE");

		ResponseEntity tickets =ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket edited");
		assertEquals(response,tickets);
	}

	@Test
	public void editTicketTestStatus() {
		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.PENDING, "I DONT WORK", LocalDate.now());

		Tickets ticket4 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.UAT_TESTING, "I DONT WORK", LocalDate.now());
		Mockito.when(ticketRepository.save(ticket4)).thenReturn(ticket4);
		Mockito.when(ticketRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(ticket1));
		ResponseEntity response = ticketRestController.editTicket(1,"status","UAT_TESTING");

		ResponseEntity tickets =ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket edited");
		assertEquals(response,tickets);
	}
	@Test
	public void deleteTicketTest() {

		Tickets ticket1 = new Tickets("TEST1","I HATE JIRA", TshapeprojectApplication.Status.DEVELOPMENT, "I DONT WORK", LocalDate.now());
		Tickets ticket2 = new Tickets("TEST2", " I REALLY HATE JIRA",TshapeprojectApplication.Status.UAT_TESTING, "I SHOULD WORK BUT DONT", LocalDate.now());
		Tickets ticket3 = new Tickets("TEST3", "JIRA WAS DEVELOPED TO ANNOY ME", TshapeprojectApplication.Status.CLOSED, "I DO WORK",LocalDate.now());
		List<Tickets> ticketList = new ArrayList<Tickets>() {};
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		ticketList.add(ticket3);
		Mockito.doAnswer(i -> i.getArguments()[0]).when(ticketRepository).deleteById(Long.valueOf(2));
		ResponseEntity response = ticketRestController.deleteTicket(2);

		ResponseEntity tickets = ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket deleted");
		assertEquals(response,tickets);
	}
}
