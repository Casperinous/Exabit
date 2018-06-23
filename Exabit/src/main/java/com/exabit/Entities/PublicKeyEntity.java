package main.java.com.exabit.Entities;

import javax.persistence.*;

/**
 * Created by nikostot on 3/9/2016.
 */
@Entity
@Table(name = "PublicKey", schema = "Exabit", catalog = "")
public class PublicKeyEntity {
    private int idPublicKey;
    private int idUsers;
    private String publicKey;
    private String extension;
    private boolean isVisible;

    @Id
    @GeneratedValue
    @Column(name = "idPublicKey", nullable = false)
    public int getIdPublicKey() {
        return idPublicKey;
    }

    public void setIdPublicKey(int idPublicKey) {
        this.idPublicKey = idPublicKey;
    }

    @Basic
    @Column(name = "idUsers", nullable = false)
    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "PublicKey", columnDefinition = "text", nullable = false, length = -1)
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Basic
    @Column(name = "Extension", nullable = false, length = 10)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "IsVisible", nullable = false)
    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublicKeyEntity that = (PublicKeyEntity) o;

        if (idPublicKey != that.idPublicKey) return false;
        if (idUsers != that.idUsers) return false;
        if (isVisible != that.isVisible) return false;
        if (publicKey != null ? !publicKey.equals(that.publicKey) : that.publicKey != null) return false;
        if (extension != null ? !extension.equals(that.extension) : that.extension != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPublicKey;
        result = 31 * result + idUsers;
        result = 31 * result + (publicKey != null ? publicKey.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (isVisible ? 1 : 0);
        return result;
    }
}
