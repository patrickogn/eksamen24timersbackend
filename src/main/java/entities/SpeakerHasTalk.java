package entities;

import javax.persistence.*;

@Entity
@Table(name = "speaker_has_talk")
public class SpeakerHasTalk {
    @EmbeddedId
    private SpeakerHasTalkId id;

    @MapsId("talkId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "talk_id", nullable = false)
    private Talk talk;

    @MapsId("speakerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "speaker_id", nullable = false)
    private Speaker speaker;

    public SpeakerHasTalkId getId() {
        return id;
    }

    public void setId(SpeakerHasTalkId id) {
        this.id = id;
    }

    public Talk getTalk() {
        return talk;
    }

    public void setTalk(Talk talk) {
        this.talk = talk;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

}