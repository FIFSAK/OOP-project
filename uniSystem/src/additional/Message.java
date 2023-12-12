package additional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import users.*;

public class Message {
    
    private User sender;
    private User receiver;
    private String content;
    private Date dateSent;
    private List<Attachment> attachments;
    
    public Message(User sender, User receiver, String content, Date dateSent, List<Attachment> attachments) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.dateSent = dateSent;
        this.attachments = attachments;
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

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public void addAttachment(Attachment attachment) {
        if (this.attachments == null) {
            this.attachments = new ArrayList<>();
        }
        this.attachments.add(attachment);
    }

    public void removeAttachment(Attachment attachment) {
        if (this.attachments != null) {
            this.attachments.remove(attachment);
        }
    }
}
