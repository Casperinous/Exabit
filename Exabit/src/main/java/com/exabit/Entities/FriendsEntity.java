package main.java.com.exabit.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by nikostot on 3/9/2016.
 */
@Entity
@Table(name = "Friends", schema = "Exabit", catalog = "")
public class FriendsEntity {
    private int idFriends;
    private int fromUserId;
    private int toUserId;
    private Date date;

    @Id
    @GeneratedValue
    @Column(name = "idFriends", nullable = false)
    public int getIdFriends() {
        return idFriends;
    }

    public void setIdFriends(int idFriends) {
        this.idFriends = idFriends;
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
    @Column(name = "Date")
    @JsonIgnore
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendsEntity that = (FriendsEntity) o;

        if (idFriends != that.idFriends) return false;
        if (fromUserId != that.fromUserId) return false;
        if (toUserId != that.toUserId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFriends;
        result = 31 * result + fromUserId;
        result = 31 * result + toUserId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
