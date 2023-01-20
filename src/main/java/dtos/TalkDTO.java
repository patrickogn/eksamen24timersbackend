package dtos;

import entities.Speaker;
import entities.Talk;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Talk} entity
 */
public class TalkDTO implements Serializable {
    private final Integer id;
    @Size(max = 45)
    private final String topic;
    private final Time time;
    @Size(max = 200)
    private final String propslist;
//    private final Set<SpeakerDto> speakers;

    public TalkDTO(Integer id, String topic, Time time, String propslist) {
        this.id = id;
        this.topic = topic;
        this.time = time;
        this.propslist = propslist;
//        this.speakers = speakers;
    }

    public TalkDTO(Talk rm) {
        this.id = rm.getId();
        this.topic = rm.getTopic();
        this.time = rm.getTime();
        this.propslist = rm.getPropslist();
//        this.speakers = rm.getSpeakers();
    }

    public static List<SpeakerDTO> getDtos(List<Speaker> rms) {
        List<SpeakerDTO> rmdtos = new ArrayList<>();
        rms.forEach(rm -> rmdtos.add(new SpeakerDTO(rm)));
        return rmdtos;
    }

    public Integer getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Time getTime() {
        return time;
    }

    public String getPropslist() {
        return propslist;
    }

//    public Set<SpeakerDto> getSpeakers() {
//        return speakers;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TalkDTO entity = (TalkDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.topic, entity.topic) &&
                Objects.equals(this.time, entity.time) &&
                Objects.equals(this.propslist, entity.propslist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, time, propslist);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "topic = " + topic + ", " +
                "time = " + time + ", " +
                "propslist = " + propslist;
    }

    /**
     * A DTO for the {@link Speaker} entity
     */
    public static class SpeakerDto implements Serializable {
        private final Integer id;
        @Size(max = 45)
        private final String name;
        @Size(max = 45)
        private final String profession;
        @Size(max = 45)
        private final String gender;
        private final Set<TalkDto> talks;

        public SpeakerDto(Integer id, String name, String profession, String gender, Set<TalkDto> talks) {
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
            SpeakerDto entity = (SpeakerDto) o;
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
            @Size(max = 45)
            private final String topic;
            private final LocalTime time;
            @Size(max = 200)
            private final String propslist;

            public TalkDto(Integer id, String topic, LocalTime time, String propslist) {
                this.id = id;
                this.topic = topic;
                this.time = time;
                this.propslist = propslist;
            }

            public Integer getId() {
                return id;
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

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                TalkDto entity = (TalkDto) o;
                return Objects.equals(this.id, entity.id) &&
                        Objects.equals(this.topic, entity.topic) &&
                        Objects.equals(this.time, entity.time) &&
                        Objects.equals(this.propslist, entity.propslist);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, topic, time, propslist);
            }

            @Override
            public String toString() {
                return getClass().getSimpleName() + "(" +
                        "id = " + id + ", " +
                        "topic = " + topic + ", " +
                        "time = " + time + ", " +
                        "propslist = " + propslist + ")";
            }
        }
    }
}