package dtos;

import entities.Conference;
import entities.Speaker;
import entities.SpeakerHasTalk;
import entities.Talk;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link SpeakerHasTalk} entity
 */
public class SpeakerHasTalkDTO implements Serializable {
    private final TalkDto talk;
    private final SpeakerDto speaker;

    public SpeakerHasTalkDTO(TalkDto talk, SpeakerDto speaker) {
        this.talk = talk;
        this.speaker = speaker;
    }

    public TalkDto getTalk() {
        return talk;
    }

    public SpeakerDto getSpeaker() {
        return speaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeakerHasTalkDTO entity = (SpeakerHasTalkDTO) o;
        return Objects.equals(this.talk, entity.talk) &&
                Objects.equals(this.speaker, entity.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(talk, speaker);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "talk = " + talk + ", " +
                "speaker = " + speaker + ")";
    }

    /**
     * A DTO for the {@link Talk} entity
     */
    public static class TalkDto implements Serializable {
        private final Integer id;
        private final ConferenceDto conference;
        @Size(max = 45)
        private final String topic;
        private final Time time;
        @Size(max = 200)
        private final String propslist;

        public TalkDto(Integer id, ConferenceDto conference, String topic, Time time, String propslist) {
            this.id = id;
            this.conference = conference;
            this.topic = topic;
            this.time = time;
            this.propslist = propslist;
        }

        public Integer getId() {
            return id;
        }

        public ConferenceDto getConference() {
            return conference;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TalkDto entity = (TalkDto) o;
            return Objects.equals(this.id, entity.id) &&
                    Objects.equals(this.conference, entity.conference) &&
                    Objects.equals(this.topic, entity.topic) &&
                    Objects.equals(this.time, entity.time) &&
                    Objects.equals(this.propslist, entity.propslist);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, conference, topic, time, propslist);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "conference = " + conference + ", " +
                    "topic = " + topic + ", " +
                    "time = " + time + ", " +
                    "propslist = " + propslist + ")";
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