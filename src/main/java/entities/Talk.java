package entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "talk")
public class Talk {
    @Id
    @Column(name = "id_talk", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_talk", nullable = false)
    private Conference conference;

    @Size(max = 45)
    @Column(name = "topic", length = 45)
    private String topic;

    @Column(name = "duration")
    private LocalTime duration;

    @Size(max = 200)
    @Column(name = "propslist", length = 200)
    private String propslist;

    public Talk() {
    }

    @ManyToMany
    @JoinTable(name = "speakers",
            joinColumns = @JoinColumn(name = "talk_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private Set<Speaker> speakers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getPropslist() {
        return propslist;
    }

    public void setPropslist(String propslist) {
        this.propslist = propslist;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }

}