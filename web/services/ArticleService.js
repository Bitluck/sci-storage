/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class ArticleService {
    getAllArticle() {
        var request = new XMLHttpRequest();
        request.open('GET', 'http://localhost:8084/SciStorage/GetAllArticle', false);
        request.send();
        if(request.status === 200) {
            let articles = JSON.parse(request.responseText);
                for(let i = 0; i < articles.length; ++i) {
                    var request1 = new XMLHttpRequest();
                    request1.open('GET', 'http://localhost:8084/SciStorage/GetUserById?id=' + articles[i].ownerId, false);
                    request1.send();
                    if(request1.status === 200) {
                        let user = JSON.parse(request1.responseText);
                        articles[i].ownerName = user.firstName + ' ' + user.lastName;
                    }
            }
            return articles;
        }
    }
    
    getArticleByCategory(categoryId) {
        var request = new XMLHttpRequest();
        request.open('GET', 'http://localhost:8084/SciStorage/GetArticleByCategory?categoryId=' + categoryId, false);
        request.send();
        if(request.status === 200) {
            let articles = JSON.parse(request.responseText);
                for(let i = 0; i < articles.length; ++i) {
                    var request1 = new XMLHttpRequest();
                    request1.open('GET', 'http://localhost:8084/SciStorage/GetUserById?id=' + articles[i].ownerId, false);
                    request1.send();
                    if(request1.status === 200) {
                        let user = JSON.parse(request1.responseText);
                        articles[i].ownerName = user.firstName + ' ' + user.lastName;
                    }
                }
            return articles;
        }
    }
    
    getArticleByTitle(keyword) {
        var request = new XMLHttpRequest();
        request.open('GET', `http://localhost:8084/SciStorage/GetArticleByTitle?title=${keyword}`, false);
        request.send();
        if(request.status === 200) {
            let articles = JSON.parse(request.responseText);
                for(let i = 0; i < articles.length; ++i) {
                    var request1 = new XMLHttpRequest();
                    request1.open('GET', 'http://localhost:8084/SciStorage/GetUserById?id=' + articles[i].ownerId, false);
                    request1.send();
                    if(request1.status === 200) {
                        let user = JSON.parse(request1.responseText);
                        articles[i].ownerName = user.firstName + ' ' + user.lastName;
                    }
                }
            return articles;
        }
    }
    
    getArticleByTags(tags) {
        const tagsArray = tags.trim().split(',');
        for(let i = 0; i < tagsArray.length; ++i) {
            tagsArray[i] = tagsArray[i].trim();
        }
        console.log(tagsArray);
        var request = new XMLHttpRequest();
        request.open('GET', `http://localhost:8084/SciStorage/GetArticleByTag?tag=${tagsArray[0]}`, false);
        request.send();
        if(request.status === 200) {
            let articles = JSON.parse(request.responseText);
            let filteredArticles = articles.filter((value) => {
                let articleTagsArray = value.tags.trim().split(',');
                for(let i = 0; i < articleTagsArray.length; ++i) {
                    articleTagsArray[i] = articleTagsArray[i].trim();
                }
                
                console.log('articleTagsArray: [', articleTagsArray, ']');
                return tagsArray.some((tag) => {
                    return articleTagsArray.indexOf(tag) !== -1;
                });
            });
            
            for(let i = 0; i < filteredArticles.length; ++i) {
                var request1 = new XMLHttpRequest();
                request1.open('GET', 'http://localhost:8084/SciStorage/GetUserById?id=' + filteredArticles[i].ownerId, false);
                request1.send();
                if(request1.status === 200) {
                    let user = JSON.parse(request1.responseText);
                    filteredArticles[i].ownerName = user.firstName + ' ' + user.lastName;
                }
            }
            return filteredArticles;
        }
    }
}
