/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class AuthenticationService {
    constructor() {
        
    }
    
    insertUser(json) {
        var request = new XMLHttpRequest();
        request.open('GET', 'http://localhost:8084/SciStorage/InsertUser?json='+json, false);
        request.send();
        if(request.status === 200) {
            let count = JSON.parse(request.responseText);
            return count;
        }
        return null;
    }
}
