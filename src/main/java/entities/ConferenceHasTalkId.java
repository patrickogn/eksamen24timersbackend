package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConferenceHasTalkId implements Serializable {
    private static final long serialVersionUID = -6945226562535178905L;
    @NotNull
    @Column(name = "conference_id", nullable = false)
    private Integer conferenceId;

    @NotNull
    @Column(name = "talk_id", nullable = false)
    private Integer talkId;

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceHasTalkId entity = (ConferenceHasTalkId) o;
        return Objects.equals(this.conferenceId, entity.conferenceId) &&
                Objects.equals(this.talkId, entity.talkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, talkId);
    }

}