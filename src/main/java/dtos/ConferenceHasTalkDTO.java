package dtos;

import entities.Conference;
import entities.ConferenceHasTalk;
import entities.Speaker;
import entities.Talk;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link ConferenceHasTalk} entity
 */
public class ConferenceHasTalkDTO implements Serializable {
    private final ConferenceDto conference;
    private final TalkDto talk;

    public ConferenceHasTalkDTO(ConferenceDto conference, TalkDto talk) {
        this.conference = conference;
        this.talk = talk;
    }

    public ConferenceDto getConference() {
        return conference;
    }

    public TalkDto getTalk() {
        return talk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceHasTalkDTO entity = (ConferenceHasTalkDTO) o;
        return Objects.equals(this.conference, entity.conference) &&
                Objects.equals(this.talk, entity.talk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conference, talk);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "conference = " + conference + ", " +
                "talk = " + talk + ")";
    }

    /**
     * A DTO for the {@link Conference} entity
     */
    public static class ConferenceDto implements Serializable {
        private final Integer id;
        @Size(max = 45)
        private final String name;
        @Size(max = 45)
        private final String location;
        private final Integer capacity;
        private final Date date;
        private final Time time;

        public ConferenceDto(Integer id, String name, String location, Integer capacity, Date date, Time time) {
            this.id = id;
            this.name = name;
            this.location = location;
            this.capacity = capacity;
            this.date = date;
            this.time = time;
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
            if (o == null || getClass() != o.getClass()) return false;
            ConferenceDto entity = (ConferenceDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.name, entity.name) &&
                    Objects.equals(this.location, entity.location) &&
                    Objects.equals(this.capacity, entity.capacity) &&
                    Objects.equals(this.date, entity.date) &&
                    Objects.equals(this.time, entity.time);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, location, capacity, date, time);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "name = " + name + ", " +
                    "location = " + location + ", " +
                    "capacity = " + capacity + ", " +
                    "date = " + date + ", " +
                    "time = " + time + ")";
        }
    }

    /**
     * A DTO for the {@link Talk} entity
     */
    public static class TalkDto implements Serializable {
        private final Integer id;
        @Size(max = 45)
        private final String topic;
        private final Time time;
        @Size(max = 200)
        private final String propslist;
        private final Set<SpeakerDto> speakers;

        public TalkDto(Integer id, String topic, Time time, String propslist, Set<SpeakerDto> speakers) {
            this.id = id;
            this.topic = topic;
            this.time = time;
            this.propslist = propslist;
            this.speakers = speakers;
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

        public Set<SpeakerDto> getSpeakers() {
            return speakers;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TalkDto entity = (TalkDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.topic, entity.topic) &&
                    Objects.equals(this.time, entity.time) &&
                    Objects.equals(this.propslist, entity.propslist) &&
                    Objects.equals(this.speakers, entity.speakers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, topic, time, propslist, speakers);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "topic = " + topic + ", " +
                    "time = " + time + ", " +
                    "propslist = " + propslist + ", " +
                    "speakers = " + speakers + ")";
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

            public SpeakerDto(Integer id, String name, String profession, String gender) {
                this.id = id;
                this.name = name;
                this.profession = profession;
                this.gender = gender;
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

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                SpeakerDto entity = (SpeakerDto) o;
                return Objects.equals(this.id, entity.id) &&
                        Objects.equals(this.name, entity.name) &&
                        Objects.equals(this.profession, entity.profession) &&
                        Objects.equals(this.gender, entity.gender);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, name, profession, gender);
            }

            @Override
            public String toString() {
                return getClass().getSimpleName() + "(" +
                        "id = " + id + ", " +
                        "name = " + name + ", " +
                        "profession = " + profession + ", " +
                        "gender = " + gender + ")";
            }
        }
    }
}