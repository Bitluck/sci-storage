/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class AuthenticationController {
    constructor() {
        this.AuthenticationService = new AuthenticationService();
    }
    
    register(json) {
        
    }
    
    
    login() {
        if(this.authentication() == 1) {
            const userData = {
                email: document.Login_Form.Email.value,
                password: document.Login_Form.Password.value
            };

            document.cookie = "email="+userData.email+";path=/";
            document.cookie = "password="+userData.password+";path=/";
            alert(document.cookie);
            return true;
        }
        return false;
    }
    
    getCookie(name) {
        var matches = document.cookie.match(new RegExp(
          "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
        ));
        return matches ? decodeURIComponent(matches[1]) : undefined;
    }
    
    getAllUser() {
        const userService = new UserService();
        return userService.getAllUser();
    }
    
    authentication() {
        const users = this.getAllUser();
        const userData = {
            email: document.Login_Form.Email.value,
            password: document.Login_Form.Password.value
        };
        for(let i = 0; i < users.length; ++i) {
            if(userData.email === users[i].email &&
               userData.password === users[i].password) {
               return 1;
            }
        }
        return 0;
    }
    
    logout() {
        document.cookie.split(";").forEach(function(c) { document.cookie = c.replace(/^ +/, "").replace(/=.*/, "=;expires=" + new Date().toUTCString() + ";path=/"); });
        location.reload();
    }
}
