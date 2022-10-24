package businessLogics;

import java.util.HashMap;
import java.util.Map;

import javaBeans.SanPham;

public class ShoppingCart {
	private Map<SanPham, Integer> cart = new HashMap<SanPham, Integer>();

	public ShoppingCart() {
	}

	public void addCart(SanPham sp, int quantity) {
		if (cart.containsKey(sp)) {
			cart.put(sp, cart.get(sp) + quantity);

		} else {

			cart.put(sp, quantity);
		}
	}

	public double getTongTien() {
		double tien = 0;
		for (Map.Entry<SanPham, Integer> item : cart.entrySet()) {
			tien += item.getValue() * item.getKey().getDonGia();

		}
		return tien;
	}

	public void updateQuantity(SanPham sp, int qtNew) {
		if (cart.containsKey(sp)) {
			cart.put(sp, qtNew);
		}
	}
	public void getQuantity(SanPham sp) {
		if (cart.containsKey(sp)) {
			System.out.println("value :"+ cart.get(sp));
		}
	}
	public Map<SanPham, Integer> getGioHang() {
		return this.cart;
	}

	public void deleteItemCart(SanPham sp) {
		cart.remove(sp);
	}

	public static void main(String[] args) {
		SanPham sp = SanPhamBL.docTheoID(12);
		ShoppingCart cart = new ShoppingCart();
		cart.addCart(sp, 3);
		Map<SanPham, Integer> c = cart.getGioHang();
		c.forEach((k, v) -> {
			System.out.println(v);
		});
	}

	public int getSize() {
		return this.cart.size();
	}

}
