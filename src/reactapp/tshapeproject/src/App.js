import './App.css';
import HeaderComponent from './components/HeaderComponent';
import ListTicketComponent from "./components/ListTickets";
import  {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import CreateTicketComponent from "./components/CreateTicketComponent"
import UpdateTicketComponent from "./components/UpdateTicketComponent"
import TicketByIDComponent from ".//components/TicketByIdComponent.jsx"
import ListSingularTicketIDComponent from './components/ListSingularTicketIDComponent';
import TicketByStatusComponent from './components/TicketByStatusComponent';
import ListSingularTicketStatusComponent from './components/ListSingularTicketStatusComponent';
import DeleteTicketComponent from './components/DeleteTicketComponent'

function App() {
  return (
    <div>
      <Router>
        <div className="container">
          <HeaderComponent /> 
            <div className="container">
              <Switch> 
                <Route exact path = "/"  component = {ListTicketComponent}></Route>
                <Route path = "/getAllTickets"  component = {ListTicketComponent}></Route>
                <Route path = "/addTicket"  component = {CreateTicketComponent}></Route>
                <Route path = "/editTicket"  component = {ListTicketComponent}></Route>
                <Route path = "/deleteTicket"  component = {DeleteTicketComponent}></Route>
                <Route path = "/updateTicket"  component = {UpdateTicketComponent}></Route>
                <Route path = "/getTicketById"  component = {TicketByIDComponent}></Route>
                <Route path = "/statusTicket"  component = {TicketByStatusComponent}></Route>
                <Route path = "/ListSingularTicketID/:id"  component = {ListSingularTicketIDComponent}></Route>
                <Route path = "/ListSingularTicketStatus/:status"  component = {ListSingularTicketStatusComponent}></Route>
              </Switch>
          </div>
        </div>
      </Router>
    </div>
    
  );
}

export default App;
