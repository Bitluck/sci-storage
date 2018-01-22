function register() {
    const authController = new AuthenticationController();
    const result = authController.register();
    if(result != 0) {
        setTimeout(() => { location.replace("http://localhost:8084/SciStorage"); }, 0);
    }
}

function login() {
    const authController = new AuthenticationController();
    const loginResult = authController.login();
    if(loginResult == true) {
        setTimeout(() => { location.replace("http://localhost:8084/SciStorage"); }, 0);
    }
}

function logout() {
    const authController = new AuthenticationController();
    authController.logout();
    location.replace("http://localhost:8084/SciStorage");
}
