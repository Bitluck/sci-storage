/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class ArticleController {
    constructor() {
        this.articleService = new ArticleService();
    }
    
    getAllArticle() {
        const list = this.articleService.getAllArticle();
        var element = document.getElementById("articles");
        
        let html = this.generateArticlesBlock(list);
        element.innerHTML = html;
    }
    
    getArticleByCategory(categoryId) {
        const list = this.articleService.getArticleByCategory(categoryId);
        var element = document.getElementById("articles");
        
        let html = this.generateArticlesBlock(list);
        element.innerHTML = html;
    }
    
    getArticleByTitle(keyword) {
        const list = this.articleService.getArticleByTitle(keyword);
        var element = document.getElementById("articles");
        
        let html = this.generateArticlesBlock(list);
        element.innerHTML = html;
    }
    
    getArticleByTags(tags) {
        const list = this.articleService.getArticleByTags(tags);
        let element = document.getElementById('articles');
        
        let html = this.generateArticlesBlock(list);
        element.innerHTML = html;
    }
    
    generateArticlesBlock(list) {
        let html = "";
        html += "<div>"+
                "<h3>Search result: "+ list.length +" articles</h3>"+
                "</div>";
        for(let i = 0; i < list.length; ++i) {
            const article = {
                id: list[i].id,
                title: list[i].title,
                authors: list[i].authors,
                annotation: list[i].annotation,
                uploadDate: new Date(list[i].uploadDate).toDateString(),
                path: list[i].path,
                ownerName: list[i].ownerName,
                tags: list[i].tags
            };
            html += "<div class='row'>"+
                    "<div class='col-sm-12 col-md-12'>"+
                     " <div class='thumbnail' onclick='articleClicked("+article.id+")'>"+
                       " <div class='caption'>"+
                          "<a href=\"localhost:8084/SciStorage/DownloadArticle?filename="+ article.path +"\"><h3>"+article.title+"</h3></a>"+
                          " <p>Authors: "+article.authors+"</p>"+
                          " <p style=\"word-break: break-all;\">Annotation: "+article.annotation+"</p>"+
                          " <p align='right'>"+article.uploadDate+"</p>"+
                          " <p align='right'>Owner: "+article.ownerName+"</p>"+
                          " <p align='right'>Tags: "+article.tags+"</p>"+
                      "</div>"+
                     " </div>"+
                    "</div>"+
                "</div>";
        }
        html += "";
        return html;
    }
}
