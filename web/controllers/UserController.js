/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class UserController {
    constructor() {
        this.userService = new UserService();
    }
    
    getAllUser() {
        const list = this.userService.getAllUser();
        var element = document.getElementById("users");
        var html = "";
        for(let i = 0; i < list.length; ++i) {
            const user = {
                id: list[i].id,
                email: list[i].email,
                firstName: list[i].firstName,
                lastName: list[i].lastName
            }
            html += "<div class='row'>"+
                    "<div class='col-sm-12 col-md-12'>"+
                     " <div class='thumbnail' onclick='userClicked("+user.id+")'>"+
                       " <div class='caption'>"+
                         " <h3>"+user.email+"</h3>"+
                         " <p>"+user.firstName+"</p>"+
                          " <p align='right'>"+user.lastName+"</p>"+
                      "</div>"+
                     " </div>"+
                    "</div>"+
                "</div>";
        }
        html += "";
        element.innerHTML = html;
    }
    
    getIdByEmail(email) {
        const userService = new UserService();
        return userService.getIdByEmail(email);
    }
}
