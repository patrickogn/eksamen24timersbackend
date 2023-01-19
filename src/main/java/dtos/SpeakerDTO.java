package dtos;

import entities.Conference;
import entities.Speaker;
import entities.Talk;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Speaker} entity
 */
public class SpeakerDTO implements Serializable {
    private final Integer id;
    @Size(max = 45)
    private final String name;
    @Size(max = 45)
    private final String profession;
    @Size(max = 45)
    private final String gender;
    private final Set<TalkDto> talks;

    public SpeakerDTO(Integer id, String name, String profession, String gender, Set<TalkDto> talks) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.gender = gender;
        this.talks = talks;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getGender() {
        return gender;
    }

    public Set<TalkDto> getTalks() {
        return talks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeakerDTO entity = (SpeakerDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.profession, entity.profession) &&
                Objects.equals(this.gender, entity.gender) &&
                Objects.equals(this.talks, entity.talks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, profession, gender, talks);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "profession = " + profession + ", " +
                "gender = " + gender + ", " +
                "talks = " + talks + ")";
    }

    /**
     * A DTO for the {@link Talk} entity
     */
    public static class TalkDto implements Serializable {
        private final Integer id;
        private final Conference conference;
        @Size(max = 45)
        private final String topic;
        private final LocalTime time;
        @Size(max = 200)
        private final String propslist;
        private final Set<Speaker> speakers;

        public TalkDto(Integer id, Conference conference, String topic, LocalTime time, String propslist, Set<Speaker> speakers) {
            this.id = id;
            this.conference = conference;
            this.topic = topic;
            this.time = time;
            this.propslist = propslist;
            this.speakers = speakers;
        }

        public Integer getId() {
            return id;
        }

        public Conference getConference() {
            return conference;
        }

        public String getTopic() {
            return topic;
        }

        public LocalTime getTime() {
            return time;
        }

        public String getPropslist() {
            return propslist;
        }

        public Set<Speaker> getSpeakers() {
            return speakers;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TalkDto entity = (TalkDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.conference, entity.conference) &&
                    Objects.equals(this.topic, entity.topic) &&
                    Objects.equals(this.time, entity.time) &&
                    Objects.equals(this.propslist, entity.propslist) &&
                    Objects.equals(this.speakers, entity.speakers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, conference, topic, time, propslist, speakers);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "conference = " + conference + ", " +
                    "topic = " + topic + ", " +
                    "time = " + time + ", " +
                    "propslist = " + propslist + ", " +
                    "speakers = " + speakers + ")";
        }
    }
}