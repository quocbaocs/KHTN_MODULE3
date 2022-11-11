package javaBeans;
// Generated Nov 8, 2022, 4:21:38 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Status generated by hbm2java
 */
@Entity
@Table(name = "status", catalog = "minishop")
public class Status implements java.io.Serializable {

	private StatusId id;

	public Status() {
	}

	public Status(StatusId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "statusId", column = @Column(name = "StatusId", nullable = false)),
			@AttributeOverride(name = "statusName", column = @Column(name = "StatusName", nullable = false, length = 32)) })
	public StatusId getId() {
		return this.id;
	}

	public void setId(StatusId id) {
		this.id = id;
	}

}
