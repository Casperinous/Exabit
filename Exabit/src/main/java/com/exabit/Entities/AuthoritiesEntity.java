package main.java.com.exabit.Entities;

import javax.persistence.*;

/**
 * Created by nikostot on 3/9/2016.
 */
@Entity
@Table(name = "Authorities", schema = "Exabit", catalog = "")
public class AuthoritiesEntity {
    private int idAuthorities;
    private String name;
    private String authority;
    private int number;

    @Id
    @GeneratedValue
    @Column(name = "idAuthorities", nullable = false)
    public int getIdAuthorities() {
        return idAuthorities;
    }

    public void setIdAuthorities(int idAuthorities) {
        this.idAuthorities = idAuthorities;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Authority", nullable = false, length = 45)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Basic
    @Column(name = "Number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthoritiesEntity that = (AuthoritiesEntity) o;

        if (idAuthorities != that.idAuthorities) return false;
        if (number != that.number) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (authority != null ? !authority.equals(that.authority) : that.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAuthorities;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }
}
