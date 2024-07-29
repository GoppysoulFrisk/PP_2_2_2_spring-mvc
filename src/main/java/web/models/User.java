package web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max = 30, message = "name should be between 2 and 30 char")
    private String name;

    @Column(name = "lastname")
    @NotEmpty(message = "lastname should not be empty")
    @Size(min = 2, max = 30, message = "name should be between 2 and 30 char")
    private String lastname;

    @Column(name = "age")
    @Min(value = 0, message = "age should be greater than 0")
    private int age;

    public User(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public User() {
    }

    @Min(value = 0, message = "age should be greater than 0")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 0, message = "age should be greater than 0") int age) {
        this.age = age;
    }

    public @NotEmpty(message = "lastname should not be empty") @Size(min = 2, max = 30, message = "name should be between 2 and 30 char") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotEmpty(message = "lastname should not be empty") @Size(min = 2, max = 30, message = "name should be between 2 and 30 char") String lastname) {
        this.lastname = lastname;
    }

    public @NotEmpty(message = "name should not be empty") @Size(min = 2, max = 30, message = "name should be between 2 and 30 char") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "name should not be empty") @Size(min = 2, max = 30, message = "name should be between 2 and 30 char") String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
