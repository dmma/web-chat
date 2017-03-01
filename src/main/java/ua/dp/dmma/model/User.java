package ua.dp.dmma.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Dmytro Mazan
 */
@Entity
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "user")
    private Set<Message> userMessages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<Message> getUserMessages() {
        return userMessages;
    }

    public void setUserMessages(Set<Message> userMessages) {
        this.userMessages = userMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        return createdDate != null ? createdDate.equals(user.createdDate) : user.createdDate == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
