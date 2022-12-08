package javaBeans;
// Generated Nov 8, 2022, 4:21:38 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author generated by hbm2java
 */
@Entity
@Table(name = "author", catalog = "minishop")
public class Author implements java.io.Serializable {

	private Integer authorId;
	private String authorName;

	public Author() {
	}

	public Author(String authorName) {
		this.authorName = authorName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "AuthorId", unique = true, nullable = false)
	public Integer getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Column(name = "AuthorName", nullable = false, length = 128)
	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}