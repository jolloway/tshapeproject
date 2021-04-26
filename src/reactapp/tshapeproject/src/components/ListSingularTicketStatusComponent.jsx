import React, {Component} from 'react'
import TicketService from '../services/TicketService';

class ListSingularTicketStatusComponent extends Component{
    constructor(props){
        super(props)
        
    
        this.state = {
            tickets: [],
            status: this.props.match.params.status
            
          };
    }

    componentDidMount(){
        var ticketstemp = []; 

        TicketService.getTicketsByStatus(this.state.status).then((res) => {
            for (var i=0; i < res.data.length; i++){
                ticketstemp.push(res.data[i])
            }
            this.setState({tickets: ticketstemp})
            console.log(res)
        });
        
    }

    render(){
        return(
        <div>
            <h2 className="text-centre"> Tickets</h2>
            
                <div className = "row"> 
                    <table className ="table table-striped table-bordered" >
                        <thead> 
                            <tr>
                                <th>id </th>
                                <th>author </th>
                                <th>description </th>
                                <th>title </th>
                                <th>status </th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.tickets.map(
                                    tickets =>
                                    <tr key = {tickets.id}>
                                        <td>{tickets.id}</td>
                                        <td>{tickets.author}</td>
                                        <td>{tickets.description}</td>
                                        <td>{tickets.title}</td>
                                        <td>{tickets.status}</td>
                                    </tr>
                                )
                            }
                        </tbody>

                    </table>
                </div>
        </div>
        )
    }
    
}

export default ListSingularTicketStatusComponent