package dtos;

import entities.Conference;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Conference} entity
 */
public class ConferenceDTO implements Serializable {
    @Size(max = 45)
    private final String name;
    @Size(max = 45)
    private final String location;
    private final Integer capacity;
    private final LocalDate date;
    private final LocalTime time;
    private final Set<UserDTO> users;
    private final TalkDTO talk;

    public ConferenceDTO(String name, String location, Integer capacity, LocalDate date, LocalTime time, Set<UserDTO> users, TalkDTO talk) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
        this.users = users;
        this.talk = talk;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Set<UserDTO> getUsers() {
        return users;
    }

    public TalkDTO getTalk() {
        return talk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceDTO entity = (ConferenceDTO) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.location, entity.location) &&
                Objects.equals(this.capacity, entity.capacity) &&
                Objects.equals(this.date, entity.date) &&
                Objects.equals(this.time, entity.time) &&
                Objects.equals(this.users, entity.users) &&
                Objects.equals(this.talk, entity.talk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, capacity, date, time, users, talk);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "location = " + location + ", " +
                "capacity = " + capacity + ", " +
                "date = " + date + ", " +
                "time = " + time + ", " +
                "users = " + users + ", " +
                "talk = " + talk + ")";
    }
}