/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class UserService {
    getAllUser() {
        var request = new XMLHttpRequest();
        request.open('GET', 'http://localhost:8084/SciStorage/GetAllUser', false);
        request.send();
        if(request.status === 200) {
            const users = JSON.parse(request.responseText);
            return users;
        }
    }
    
    getIdByEmail(email) {
        var request = new XMLHttpRequest();
        request.open('GET', 'http://localhost:8084/SciStorage/GetUserByEmail?email=' + email, false);
        request.send();
        if(request.status === 200) {
            const user = JSON.parse(request.responseText);
            return user.id;
        }
    }
    
    insertUser(user) {
        var request = new XMLHttpRequest();
        request.open('POST', 'http://localhost:8084/SciStorage/InsertUser?', false);
        request.send();
    }
}
