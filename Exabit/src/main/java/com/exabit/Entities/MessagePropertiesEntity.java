package main.java.com.exabit.Entities;

import javax.persistence.*;

/**
 * Created by nikostot on 3/9/2016.
 */
@Entity
@Table(name = "MessageProperties", schema = "Exabit", catalog = "")
public class MessagePropertiesEntity {
    private int idMessageProperties;
    private int idUser;
    private int idMessage;
    private boolean isSeen;
    private boolean isDraft;
    private boolean isTrashed;
    private boolean isImportant;

    @Id
    @GeneratedValue
    @Column(name = "idMessageProperties", nullable = false)
    public int getIdMessageProperties() {
        return idMessageProperties;
    }

    public void setIdMessageProperties(int idMessageProperties) {
        this.idMessageProperties = idMessageProperties;
    }

    @Basic
    @Column(name = "idUser", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "idMessage", nullable = false)
    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    @Basic
    @Column(name = "IsSeen", nullable = false)
    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    @Basic
    @Column(name = "IsDraft", nullable = false)
    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    @Basic
    @Column(name = "IsTrashed", nullable = false)
    public boolean isTrashed() {
        return isTrashed;
    }

    public void setTrashed(boolean trashed) {
        isTrashed = trashed;
    }

    @Basic
    @Column(name = "IsImportant", nullable = false)
    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagePropertiesEntity that = (MessagePropertiesEntity) o;

        if (idMessageProperties != that.idMessageProperties) return false;
        if (idUser != that.idUser) return false;
        if (idMessage != that.idMessage) return false;
        if (isSeen != that.isSeen) return false;
        if (isDraft != that.isDraft) return false;
        if (isTrashed != that.isTrashed) return false;
        if (isImportant != that.isImportant) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessageProperties;
        result = 31 * result + idUser;
        result = 31 * result + idMessage;
        result = 31 * result + (isSeen ? 1 : 0);
        result = 31 * result + (isDraft ? 1 : 0);
        result = 31 * result + (isTrashed ? 1 : 0);
        result = 31 * result + (isImportant ? 1 : 0);
        return result;
    }
}
