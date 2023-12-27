package additional;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import users.*;

import users.*;

public class Message implements Serializable {
    
    private User sender;
    private User receiver;
    private String content;
    private Date dateSent;
    
    public Message(User sender, User receiver, String content, Date dateSent) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.dateSent = dateSent;
    }
    
    public Message(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }
    

}
