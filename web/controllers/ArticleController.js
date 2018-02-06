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
    
    articleClicked(filename) {
        return this.articleService.downloadArticle(filename);
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
            /*html += "<div class='row'>"+
                    "<div class='col-sm-12 col-md-12'>"+
                     " <div class='thumbnail' onclick='articleClicked("+article.id+")'>"+
                       " <div class='caption'>"+
                          "<a href=\"http://localhost:8084/SciStorage/DownloadArticle?filename="+ article.path +"\"><h3>"+article.title+"</h3></a>"+
                          " <p>Authors: "+article.authors+"</p>"+
                          " <p style=\"word-break: break-all;\">Annotation: "+article.annotation+"</p>"+
                          " <p align='right'>"+article.uploadDate+"</p>"+
                          " <p align='right'>Owner: "+article.ownerName+"</p>"+
                          " <p align='right'>Tags: "+article.tags+"</p>"+
                      "</div>"+
                     " </div>"+
                    "</div>"+
                "</div>";*/
                
            html += "<div class=\"card\">"+
                        "<h3 class=\"card-header\">" + article.title + "</h3>"+
                        "<div class=\"card-block\">"+
                            "<h4 class=\"card-title\">Authors: "+article.authors+"</h4>"+
                            "<p class=\"card-text annotation\">Annotation: "+article.annotation+"</p>"+
                            "<p class=\"card-text uploadDate\">Upload: "+article.uploadDate+"</p>"+
                            "<p class=\"card-text ownerName\">Owner: "+article.ownerName+"</p>"+
                            "<p class=\"card-text tags\">Tags: "+article.tags+"</p>"+
                            "<a class=\"btn btn-primary\" onclick=\"articleClicked('"+article.path+"');\">"+
                                "Download"+
                            "</a>"+
                        "</div>"+
                    "</div>";
                
        }
        html += "";
        return html;
    }
}
