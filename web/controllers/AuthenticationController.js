/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class AuthenticationController {
    constructor() {
    }
    
    register() {
        let authService = new AuthenticationService();
        const userData = {
            email: document.Register_Form.Email.value,
            password: document.Register_Form.Password.value,
            confirmPassword: document.Register_Form.ConfirmPassword.value,
            firstName: document.Register_Form.FirstName.value,
            lastName: document.Register_Form.LastName.value,
        };
        if(userData.password == userData.confirmPassword) {
            const object = {
                email: userData.email,
                password: userData.password,
                firstName: userData.firstName,
                lastName: userData.lastName
            };
            const json = JSON.stringify(object);
            let count = authService.insertUser(json);
            return count;
        } else {
            alert('Password confirm not equals');
        }
        return 0;
    }
    
    login() {
        if(this.authentication() == 1) {
            const userData = {
                email: document.Login_Form.Email.value,
                password: document.Login_Form.Password.value
            };

            document.cookie = "email="+userData.email+";path=/";
            document.cookie = "password="+userData.password+";path=/";
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
