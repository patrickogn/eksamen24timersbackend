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

    private final Integer id;
    private final String name;
    private final String location;
    private final Integer capacity;
    private final Date date;
    private final Time time;
//    private final TalkDTO talk;

    public ConferenceDTO(Integer id, String name, String location, Integer capacity, Date date, Time time, TalkDTO talk) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
//        this.talk = talk;
    }

    public ConferenceDTO(Conference rm) {
        this.id = rm.getId();
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

    public Integer getId() {
        return id;
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
        if (!(o instanceof ConferenceDTO)) return false;
        ConferenceDTO that = (ConferenceDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getCapacity(), that.getCapacity()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getTime(), that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLocation(), getCapacity(), getDate(), getTime());
    }

    @Override
    public String toString() {
        return "ConferenceDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}

