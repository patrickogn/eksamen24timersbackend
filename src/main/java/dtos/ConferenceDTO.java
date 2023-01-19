package dtos;

import entities.Conference;
import entities.Talk;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * A DTO for the {@link Conference} entity
 */
public class ConferenceDTO implements Serializable {

    private final String name;
    private final String location;
    private final Integer capacity;
    private final Date date;
    private final Time time;
//    private final TalkDTO talk;

    public ConferenceDTO(String name, String location, Integer capacity, Date date, Time time, TalkDTO talk) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
//        this.talk = talk;
    }

    public ConferenceDTO(Conference rm) {
        this.name = rm.getName();
        this.location = rm.getLocation();
        this.capacity = rm.getCapacity();
        this.date = rm.getDate();
        this.time = rm.getTime();

    }


    public static List<ConferenceDTO> getDtos(List<Conference> rms) {
        List<ConferenceDTO> rmdtos = new ArrayList<>();
        rms.forEach(rm -> rmdtos.add(new ConferenceDTO(rm)));
        return rmdtos;
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

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
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
                Objects.equals(this.time, entity.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, capacity, date, time);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "location = " + location + ", " +
                "capacity = " + capacity + ", " +
                "date = " + date + ", " +
                "time = " + time;
    }
}