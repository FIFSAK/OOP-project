package additional;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import users.*;

import users.*;

import java.util.Date;

/**
 * The Message class represents a communication message between two users.
 * It includes information about the sender, receiver, message content, and the date it was sent.
 */
public class Message {
    
    /** The user who sent the message. */
    private User sender;

    /** The user who receives the message. */
    private User receiver;

    /** The content of the message. */
    private String content;

    /** The date and time when the message was sent. */
    private Date dateSent;
    
    /**
     * Constructs a Message object with specified sender, receiver, content, and date sent.
     *
     * @param sender The user who sent the message.
     * @param receiver The user who receives the message.
     * @param content The content of the message.
     * @param dateSent The date and time when the message was sent.
     */
    public Message(User sender, User receiver, String content, Date dateSent) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.dateSent = dateSent;
    }
    
    /**
     * Constructs a Message object with only the content.
     * This constructor is useful when creating simple messages without specifying sender, receiver, or date.
     *
     * @param content The content of the message.
     */
    public Message(String content) {
        this.content = content;
    }

    /**
     * Gets the user who sent the message.
     *
     * @return The sender of the message.
     */
    public User getSender() {
        return sender;
    }

    /**
     * Sets the user who sent the message.
     *
     * @param sender The user who sent the message.
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * Gets the user who receives the message.
     *
     * @return The receiver of the message.
     */
    public User getReceiver() {
        return receiver;
    }

    /**
     * Sets the user who receives the message.
     *
     * @param receiver The user who receives the message.
     */
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    /**
     * Gets the content of the message.
     *
     * @return The content of the message.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the message.
     *
     * @param content The content of the message.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the date and time when the message was sent.
     *
     * @return The date and time when the message was sent.
     */
    public Date getDateSent() {
        return dateSent;
    }

    /**
     * Sets the date and time when the message was sent.
     *
     * @param dateSent The date and time when the message was sent.
     */
    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }
}
