class CategoryController {
    constructor() {
    }
    
    getAllCategory() {
        const categoryService = new CategoryService();
        return categoryService.getAllCategory();
    }
    
    upload() {
        
    }
}
