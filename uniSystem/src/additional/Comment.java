package additional;

import java.util.Date;

import users.User;

public class Comment {
    
    private String content;
    private Date date;
    private User author;
    private CommentType attribute;
    private News news;
    private User user;

    public Comment(String content, Date date, User author) {
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public CommentType getAttribute() {
        return attribute;
    }

    public void setAttribute(CommentType attribute) {
        this.attribute = attribute;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Operations

    public String getContentDetails() {
        // TODO: Implement logic
        return "";
    }

    public Date getCurrentDate() {
        // TODO: Implement logic
        return new Date();
    }

    public User getAuthorDetails() {
        // TODO: Implement logic
        return null;
    }
}

enum CommentType {
    // Define comment types as needed
}
