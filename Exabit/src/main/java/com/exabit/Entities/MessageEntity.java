package main.java.com.exabit.Entities;

import javax.persistence.*;

/**
 * Created by nikostot on 3/9/2016.
 */
@Entity
@Table(name = "Message", schema = "Exabit", catalog = "")
public class MessageEntity {
    private int idMessage;
    private int fromUserId;
    private int toUserId;
    private String title;
    private String message;
    private boolean isEncrypted;

    @Id
    @GeneratedValue
    @Column(name = "idMessage", nullable = false)
    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    @Basic
    @Column(name = "FromUserId", nullable = false)
    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Basic
    @Column(name = "ToUserId", nullable = false)
    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Message", columnDefinition = "mediumtext", nullable = false, length = -1)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "IsEncrypted", nullable = false)
    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (idMessage != that.idMessage) return false;
        if (fromUserId != that.fromUserId) return false;
        if (toUserId != that.toUserId) return false;
        if (isEncrypted != that.isEncrypted) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessage;
        result = 31 * result + fromUserId;
        result = 31 * result + toUserId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (isEncrypted ? 1 : 0);
        return result;
    }
}
