package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SpeakerHasTalkId implements Serializable {
    private static final long serialVersionUID = -4647456823131913086L;
    @NotNull
    @Column(name = "talk_id", nullable = false)
    private Integer talkId;

    @NotNull
    @Column(name = "speaker_id", nullable = false)
    private Integer speakerId;

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public Integer getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Integer speakerId) {
        this.speakerId = speakerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeakerHasTalkId entity = (SpeakerHasTalkId) o;
        return Objects.equals(this.speakerId, entity.speakerId) &&
                Objects.equals(this.talkId, entity.talkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speakerId, talkId);
    }

}