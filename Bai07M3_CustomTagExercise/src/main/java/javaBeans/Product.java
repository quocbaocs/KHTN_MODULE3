package javaBeans;

public class Product {
	private int productId;
	private int categoryId;
	private int publishedId;
	private int authorId;
	private String isbn;
	private String title;
	private int pages;
	private int year;
	private String weight;
	private String size;
	private String description;
	private String content;
	private String urlImage;
	private int price;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getPublishedId() {
		return publishedId;
	}

	public void setPublishedId(int publishedId) {
		this.publishedId = publishedId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product() {
		super();
	}

	public Product(int productId, int categoryId, int publishedId, int authorId, String isbn, String title, int pages,
			int year, String weight, String size, String description, String content, String urlImage, int price) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.publishedId = publishedId;
		this.authorId = authorId;
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.year = year;
		this.weight = weight;
		this.size = size;
		this.description = description;
		this.content = content;
		this.urlImage = urlImage;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + "]";
	}

}
