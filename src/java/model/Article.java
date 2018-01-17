/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author Администратор
 */
public class Article {
    private int id;
    private int ownerId;
    private int categoryId;
    private String title;
    private String authors;
    private Timestamp uploadDate;
    private String path;

    public Article() {
    }
    
    public Article(int id,  int ownerId, int categoryId, String title, String authors, Timestamp uploadDate, String path) {
        this.id = id;
        this.ownerId = ownerId;
        this.categoryId = categoryId;
        this.title = title;
        this.authors = authors;
        this.uploadDate = uploadDate;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.categoryId;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.authors);
        hash = 71 * hash + Objects.hashCode(this.uploadDate);
        hash = 71 * hash + Objects.hashCode(this.ownerId);
        hash = 71 * hash + Objects.hashCode(this.path);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.ownerId != other.ownerId) {
            return false;
        }
        if (this.categoryId != other.categoryId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.authors, other.authors)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.uploadDate, other.uploadDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", ownerId=" + ownerId + ", categoryId=" + categoryId + ", title=" + title + ", authors=" + authors + ", uploadDate=" + uploadDate + ", path=" + path + '}';
    }
}
