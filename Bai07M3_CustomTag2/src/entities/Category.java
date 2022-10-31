package entities;
// Generated Oct 31, 2022, 8:22:59 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "minishop")
public class Category implements java.io.Serializable {

	private Integer categoryId;
	private String categoryName;
	private Integer parentId;

	public Category() {
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category(String categoryName, Integer parentId) {
		this.categoryName = categoryName;
		this.parentId = parentId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CategoryId", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "CategoryName", nullable = false, length = 128)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "ParentId")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
