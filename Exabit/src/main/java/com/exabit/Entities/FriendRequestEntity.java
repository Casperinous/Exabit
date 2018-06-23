package main.java.com.exabit.Entities;

import javax.persistence.*;

/**
 * Created by nikostot on 3/9/2016.
 */
@Entity
@Table(name = "FriendRequest", schema = "Exabit", catalog = "")
public class FriendRequestEntity {
    private int idFriendRequest;
    private int fromUserId;
    private int toUserId;
    private boolean isAccepted;

    @Id
    @GeneratedValue
    @Column(name = "idFriendRequest", nullable = false)
    public int getIdFriendRequest() {
        return idFriendRequest;
    }

    public void setIdFriendRequest(int idFriendRequest) {
        this.idFriendRequest = idFriendRequest;
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
    @Column(name = "IsAccepted", nullable = false)
    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendRequestEntity that = (FriendRequestEntity) o;

        if (idFriendRequest != that.idFriendRequest) return false;
        if (fromUserId != that.fromUserId) return false;
        if (toUserId != that.toUserId) return false;
        if (isAccepted != that.isAccepted) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFriendRequest;
        result = 31 * result + fromUserId;
        result = 31 * result + toUserId;
        result = 31 * result + (isAccepted ? 1 : 0);
        return result;
    }
}
