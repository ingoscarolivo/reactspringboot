import React ,{ useState, useEffect } from "react";
import UserService from '../services/UserService';


function UserComponent () {

   
     
    const [state, setState] = useState({users:[]});
   

    useEffect(() => {
        console.log("mensaje");
        
        UserService().then((response) => {
            setState({ users: response.data})
        });

    },[]);
/*
    ComponentDidMount(){
        UserService().then((response) => {
            this.setState({ users: response.data})
        });
    }
  */  

    
        return (
            <>
                <h1 className = "text-center"> Users List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>

                            <td> User Id</td>
                            <td> User First Name</td>
                            <td> User Last Name</td>
                            <td> User Email Id</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            state.users.map(
                                user => 
                                <tr key = {user.id}>
                                     <td> {user.id}</td>   
                                     <td> {user.firstName}</td>   
                                     <td> {user.lastName}</td>   
                                     <td> {user.email}</td>   
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </>

        )
    
}

export default UserComponent