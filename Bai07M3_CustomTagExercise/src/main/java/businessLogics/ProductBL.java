package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javaBeans.Product;

public class ProductBL {
	public static List<Product> getAllProduct() {
		List<Product> dspd = null;
		Connection conn = CSDL.getKetNoi();
		String sql = "select * from product";
		Statement stm;
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			dspd = new ArrayList<Product>();
			while (rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt("productid"));
				p.setCategoryId(rs.getInt("categoryid"));
				p.setPublishedId(rs.getInt("publisherid"));
				p.setAuthorId(rs.getInt("authorid"));
				p.setIsbn(rs.getString("isbn"));
				p.setTitle(rs.getString("title"));
				p.setPages(rs.getInt("pages"));
				p.setYear(rs.getInt("year"));
				p.setSize(rs.getString("size"));

				dspd.add(p);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dspd;

	}

	public static void main(String[] args) {
		getAllProduct().forEach(new Consumer<Product>() {
			@Override
			public void accept(Product s) {
				System.out.println(s.toString());
			}
		});
	}
}
