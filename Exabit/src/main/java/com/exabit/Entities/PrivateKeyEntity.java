package main.java.com.exabit.Entities;

import javax.persistence.*;

/**
 * Created by nikostot on 3/9/2016.
 */
@Entity
@Table(name = "PrivateKey", schema = "Exabit", catalog = "")
public class PrivateKeyEntity {
    private int idPrivateKey;
    private int idUsers;
    private String privateKey;
    private String password;
    private String extension;
    private int idPublicKey;

    @Id
    @GeneratedValue
    @Column(name = "idPrivateKey", nullable = false)
    public int getIdPrivateKey() {
        return idPrivateKey;
    }

    public void setIdPrivateKey(int idPrivateKey) {
        this.idPrivateKey = idPrivateKey;
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
    @Column(name = "PrivateKey", columnDefinition = "mediumtext", nullable = false, length = -1)
    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Basic
    @Column(name = "Password", columnDefinition = "char", nullable = false, length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Extension", nullable = false, length = 10)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivateKeyEntity that = (PrivateKeyEntity) o;

        if (idPrivateKey != that.idPrivateKey) return false;
        if (idUsers != that.idUsers) return false;
        if (idPublicKey != that.idPublicKey) return false;
        if (!privateKey.equals(that.privateKey)) return false;
        if (!password.equals(that.password)) return false;
        return extension.equals(that.extension);

    }

    @Override
    public int hashCode() {
        int result = idPrivateKey;
        result = 31 * result + idUsers;
        result = 31 * result + privateKey.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + extension.hashCode();
        result = 31 * result + idPublicKey;
        return result;
    }

    @Basic
    @Column(name = "idPublicKey", nullable = false)
    public int getIdPublicKey() {
        return idPublicKey;
    }

    public void setIdPublicKey(int idPublicKey) {
        this.idPublicKey = idPublicKey;
    }
}
