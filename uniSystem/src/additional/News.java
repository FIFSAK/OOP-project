package additional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import users.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The News class represents a news article with a title, content, publication date, topic, and associated comments.
 */
public class News {

    /** The title of the news article. */
    private String title;

    /** The content of the news article. */
    private String content;

    /** The date when the news article was published. */
    private Date datePublished;

    /** The topic or category of the news article. */
    private String topic;

    /** A flag indicating whether the news article is pinned or not. */
    private boolean isPinned;

    /** The list of comments associated with the news article. */
    private List<Comment> comments;

    /** The latest comment associated with the news article. */
    private Comment comment;

    /**
     * Constructs a News object with the specified title, content, publication date, topic, and pin status.
     *
     * @param title         The title of the news article.
     * @param content       The content of the news article.
     * @param datePublished The date when the news article was published.
     * @param topic         The topic or category of the news article.
     * @param isPinned      True if the news article is pinned; otherwise, false.
     */
    public News(String title, String content, Date datePublished, String topic, boolean isPinned) {
        this.title = title;
        this.content = content;
        this.datePublished = datePublished;
        this.topic = topic;
        this.isPinned = isPinned;
        this.comments = new ArrayList<>();
    }

    /**
     * Gets the title of the news article.
     *
     * @return The title of the news article.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the news article.
     *
     * @param title The title of the news article.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the content of the news article.
     *
     * @return The content of the news article.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the news article.
     *
     * @param content The content of the news article.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the publication date of the news article as a LocalDate.
     *
     * @return The publication date of the news article.
     */
    public LocalDate getDatePublished() {
        return LocalDate.from(datePublished.toInstant().atZone(ZoneId.systemDefault()));
    }

    /**
     * Sets the publication date of the news article.
     *
     * @param datePublished The publication date of the news article.
     */
    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    /**
     * Gets the topic or category of the news article.
     *
     * @return The topic or category of the news article.
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets the topic or category of the news article.
     *
     * @param topic The topic or category of the news article.
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Checks if the news article is pinned.
     *
     * @return True if the news article is pinned; otherwise, false.
     */
    public boolean isPinned() {
        return isPinned;
    }

    /**
     * Sets the pin status of the news article.
     *
     * @param isPinned True to pin the news article; false to unpin.
     */
    public void setPinned(boolean isPinned) {
        this.isPinned = isPinned;
    }

    /**
     * Gets the list of comments associated with the news article.
     *
     * @return The list of comments.
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Sets the list of comments associated with the news article.
     *
     * @param comments The list of comments.
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Adds a comment to the list of comments associated with the news article.
     *
     * @param comment The comment to add.
     */
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    /**
     * Gets the latest comment associated with the news article.
     *
     * @return The latest comment.
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Sets the latest comment associated with the news article.
     *
     * @param comment The latest comment.
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }

    /**
     * Checks if two News objects are equal based on their title and publication date.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal; otherwise, false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        News news = (News) obj;
        return Objects.equals(title, news.title) &&
               Objects.equals(datePublished, news.datePublished);
    }

    /**
     * Generates the hash code for the News object based on its title and publication date.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, datePublished);
    }
}
