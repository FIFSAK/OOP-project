package additional;

import java.util.Date;

import users.User;

/**
 * The {@code Comment} class represents a comment on a news article.
 * It includes information about the content, date, author, comment type,
 * and the associated news article.
 */
public class Comment {

    /**
     * The content of the comment.
     */
    private String content;

    /**
     * The date and time when the comment was posted.
     */
    private Date date;

    /**
     * The user who authored the comment.
     */
    private User author;

    /**
     * The type or category of the comment.
     */
    private CommentType attribute;

    /**
     * The news article associated with the comment.
     */
    private News news;

    /**
     * Constructs a new comment with the given content, date, and author.
     *
     * @param content The content of the comment.
     * @param date    The date and time when the comment was posted.
     * @param author  The user who authored the comment.
     */
    public Comment(String content, Date date, User author) {
        this.content = content;
        this.date = date;
        this.author = author;
    }

    /**
     * Gets the content of the comment.
     *
     * @return The content of the comment.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the comment.
     *
     * @param content The content of the comment.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the date and time when the comment was posted.
     *
     * @return The date and time when the comment was posted.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date and time when the comment was posted.
     *
     * @param date The date and time when the comment was posted.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the author of the comment.
     *
     * @return The user who authored the comment.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Sets the author of the comment.
     *
     * @param author The user who authored the comment.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Gets the type or category of the comment.
     *
     * @return The type or category of the comment.
     */
    public CommentType getAttribute() {
        return attribute;
    }

    /**
     * Sets the type or category of the comment.
     *
     * @param attribute The type or category of the comment.
     */
    public void setAttribute(CommentType attribute) {
        this.attribute = attribute;
    }

    /**
     * Gets the news article associated with the comment.
     *
     * @return The news article associated with the comment.
     */
    public News getNews() {
        return news;
    }

    /**
     * Sets the news article associated with the comment.
     *
     * @param news The news article associated with the comment.
     */
    public void setNews(News news) {
        this.news = news;
    }

    // Operations

    /**
     * Retrieves additional details about the content of the comment.
     *
     * @return Additional details about the content of the comment.
     */
    public String getContentDetails() {
        // TODO: Implement logic
        return "";
    }

    /**
     * Retrieves the current date and time.
     *
     * @return The current date and time.
     */
    public Date getCurrentDate() {
        // TODO: Implement logic
        return new Date();
    }

    /**
     * Retrieves additional details about the author of the comment.
     *
     * @return Additional details about the author of the comment.
     */
    public User getAuthorDetails() {
        // TODO: Implement logic
        return null;
    }
}

/**
 * Enumeration representing different types or categories of comments.
 */
enum CommentType {
    // Define comment types as needed
}
