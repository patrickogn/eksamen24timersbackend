package entities;

import javax.persistence.*;

@Entity
@Table(name = "conference_has_talks")
public class ConferenceHasTalk {
    @EmbeddedId
    private ConferenceHasTalkId id;

    @MapsId("conferenceId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conference_id", nullable = false)
    private Conference conference;

    @MapsId("talkId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "talk_id", nullable = false)
    private Talk talk;

    public ConferenceHasTalkId getId() {
        return id;
    }

    public void setId(ConferenceHasTalkId id) {
        this.id = id;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

}