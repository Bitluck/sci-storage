class CategoryService {
    constructor() {
        
    }
    
    getAllCategory() {
        var request = new XMLHttpRequest();
        request.open('GET', 'http://localhost:8084/SciStorage/GetAllCategory', false);
        request.send();
        if(request.status === 200) {
            let categories = JSON.parse(request.responseText);
            return categories;
        }
    }
    
    upload() {
        
    }
}
