package ist.meic.cmu.domain;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diogo on 05/04/2017.
 */

@Entity
public class User {

    @Id
    private String username;
    private String password;
    @ElementCollection
    @CollectionTable(name="profile")
    private List<Pair> pairs;
    @ElementCollection
    @CollectionTable(name="userMessages")
    private List<Message> messages;

    // needed for rest calls
    public User(){
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        pairs = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValue(String key){
        for (Pair pair : pairs){
            if (pair.getKey().equals(key))
                return pair.getValue();
        }
        return null;
    }

    public List<Pair> getPairs(){
        return pairs;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pairs=" + pairs +
                ", messages=" + messages +
                '}';
    }
}
