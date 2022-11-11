package javaBeans;
// Generated Nov 8, 2022, 4:21:38 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StatusId generated by hbm2java
 */
@Embeddable
public class StatusId implements java.io.Serializable {

	private byte statusId;
	private String statusName;

	public StatusId() {
	}

	public StatusId(byte statusId, String statusName) {
		this.statusId = statusId;
		this.statusName = statusName;
	}

	@Column(name = "StatusId", nullable = false)
	public byte getStatusId() {
		return this.statusId;
	}

	public void setStatusId(byte statusId) {
		this.statusId = statusId;
	}

	@Column(name = "StatusName", nullable = false, length = 32)
	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StatusId))
			return false;
		StatusId castOther = (StatusId) other;

		return (this.getStatusId() == castOther.getStatusId()) && ((this.getStatusName() == castOther.getStatusName())
				|| (this.getStatusName() != null && castOther.getStatusName() != null
						&& this.getStatusName().equals(castOther.getStatusName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getStatusId();
		result = 37 * result + (getStatusName() == null ? 0 : this.getStatusName().hashCode());
		return result;
	}

}
