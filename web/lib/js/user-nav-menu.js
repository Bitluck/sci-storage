class MenuShower {
    constructor() {
        
    }
    
    show() {
        const articleController = new ArticleController();
        const authController = new AuthenticationController();
        if(authController.getCookie('email') != null) {
            document.getElementById("add-article").style.visibility = 'visible';
            document.getElementById("search").style.visibility = 'visible';
            document.getElementById("logout").style.visibility = 'visible';

            document.getElementById("register").style.visibility = 'hidden';
            document.getElementById("login").style.visibility = 'hidden';
        }
    }
}