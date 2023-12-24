package additional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import users.*;

public class News {
    
    private String title;
    private String content;
    private Date datePublished;
    private String topic;
    private boolean isPinned;
    private List<Comment> comments;
    private Manager manager;
    private Comment comment;
    
    String newsId;
//    String topic;
    
    News(String newsId, String title) {
        this.newsId = newsId;
        this.title = title;
    }

    public News(String title, String content, Date datePublished, String topic, boolean isPinned) {
        this.title = title;
        this.content = content;
        this.datePublished = datePublished;
        this.topic = topic;
        this.isPinned = isPinned;
        this.comments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean isPinned) {
        this.isPinned = isPinned;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(newsId, news.newsId);
    }

    public int hashCode() {
        return Objects.hash(newsId);
    }
    

    // Operations

    public String toString() {
        // TODO: Implement toString method
        return "";
    }

//    public boolean equals(Object obj) {
//        // TODO: Implement equals method
//        return false;
//    }
//
//    public int compareTo(News news) {
//        // TODO: Implement compareTo method
//        return 0;
//    }
//
//    public int hashCode() {
//        // TODO: Implement hashCode method
//        return 0;
//    }
}
