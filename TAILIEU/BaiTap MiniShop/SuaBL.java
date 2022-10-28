package businessLogics;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entities.Sua;

public class SuaBL {
	public static List<Sua> docTatCa(){
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua";
		try (Session session = CSDL.getFactory().openSession()){
			return session.createQuery(sql, Sua.class).list();
		} catch (Exception e) {
			return null;
		}
	}
	public static List<Sua> docTheoMaHang(String maHang){
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua where s.hangSua.maHangSua = :maHang";
		try (Session session = CSDL.getFactory().openSession()){
			return session.createQuery(sql, Sua.class)
					.setParameter("maHang", maHang)
					.list();
		} catch (Exception e) {
			return null;
		}
	}
	public static List<Sua> docTheoLoaiHangTen(String maLoai, String maHang, String tenSua){
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua "
				+"where s.hangSua.maHangSua = :maHang "
				+"and s.loaiSua.maLoaiSua = :maLoai "
				+"and s.tenSua like :tenSua";
		try (Session session = CSDL.getFactory().openSession()){
			return session.createQuery(sql, Sua.class)
					.setParameter("maHang", maHang)
					.setParameter("maLoai", maLoai)
					.setParameter("tenSua", "%"+ tenSua + "%")
					.list();
		} catch (Exception e) {
			return null;
		}
	}
	public static List<Sua> suaGiaCao(int top){
		String sql = "select s from Sua s left join fetch s.hangSua left join fetch s.loaiSua order by s.donGia desc";
		try (Session session = CSDL.getFactory().openSession()) {
			return session.createQuery(sql, Sua.class)
				  .setFirstResult(0)
				  .setMaxResults(top)
				  .list();
		} catch (Exception e) {
			return null;
		}
	}
	public static List<Sua> suaBanChay(int top){
		String sql = "select s,sum(ct.soLuong) as tsl from Sua s join s.ctHoadons ct left join fetch s.hangSua left join fetch s.loaiSua "
				+ "group by s order by tsl desc";
		List<Sua> dsSua = new ArrayList<>();
		try (Session session = CSDL.getFactory().openSession()){
			List<Object> dsObj = session.createQuery(sql)
					.setFirstResult(0)
					.setMaxResults(top)
					.list();
			for(Object obj:dsObj) {
				Object[] mc = (Object[]) obj;
				Sua s = (Sua)mc[0];
				dsSua.add(s);
			}
		} catch (Exception e) {
			return null;
		}
		return dsSua;
	}
	public static void main(String[] args) {
		//List<Sua> ds = docTatCa();
		//List<Sua> ds = docTheoMaHang("DL");
		//List<Sua> ds = docTheoLoaiHangTen("SB","DL","Cô gái");
		//List<Sua> ds = suaGiaCao(5);
		List<Sua> ds = suaBanChay(3);
		for(Sua s:ds)
			System.out.println(s.getTenSua()+ " - " + s.getHangSua().getTenHangSua() + " - " + s.getLoaiSua().getTenLoai());
		
	}
}
