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
    private Comment comment;

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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    
}
