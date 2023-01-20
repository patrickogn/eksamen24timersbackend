package entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "conference")
public class Conference {
    @Id
    @Column(name = "id_conference")
    private Integer id;

    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;

    @Size(max = 45)
    @Column(name = "location", length = 45)
    private String location;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;


    @Column(name = "time")
    private Time time;

    public Conference() {
    }

    @ManyToMany
    @JoinTable(name = "users_has_conference",
            joinColumns = @JoinColumn(name = "conference_id_conference"),
            inverseJoinColumns = @JoinColumn(name = "users_user_name"))
    private Set<User> users = new LinkedHashSet<>();

    @OneToOne(mappedBy = "conference")
    private Talk talk;



    public Conference(Integer id, String name, String location, Integer capacity, Date date, Time time) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

}