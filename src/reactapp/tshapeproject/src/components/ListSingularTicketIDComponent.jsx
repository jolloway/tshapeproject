import React, {Component} from 'react'
import TicketService from '../services/TicketService';

class ListSingularTicketIDComponent extends Component{
    constructor(props){
        super(props)
        
    
        this.state = {
            tickets: '',
            id: this.props.match.params.id
            
          };
    }

    componentDidMount(){
        TicketService.getTicketsByID(this.state.id).then((res) => {
            let ticket = res.data
            this.setState({tickets: ticket})
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
                                    <tr key = {this.state.tickets.id}>
                                        <td>{this.state.tickets.id}</td>
                                        <td>{this.state.tickets.author}</td>
                                        <td>{this.state.tickets.description}</td>
                                        <td>{this.state.tickets.title}</td>
                                        <td>{this.state.tickets.status}</td>
                                    </tr>
                                
                            }
                        </tbody>

                    </table>
                </div>
        </div>
        )
    }
    
}

export default ListSingularTicketIDComponent