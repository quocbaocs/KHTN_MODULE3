package entities;
// Generated Oct 31, 2022, 8:22:59 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Statusinvoice generated by hbm2java
 */
@Entity
@Table(name = "statusinvoice", catalog = "minishop")
public class Statusinvoice implements java.io.Serializable {

	private StatusinvoiceId id;

	public Statusinvoice() {
	}

	public Statusinvoice(StatusinvoiceId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "statusId", column = @Column(name = "StatusId", nullable = false)),
			@AttributeOverride(name = "statusName", column = @Column(name = "StatusName", nullable = false, length = 32)) })
	public StatusinvoiceId getId() {
		return this.id;
	}

	public void setId(StatusinvoiceId id) {
		this.id = id;
	}

}
