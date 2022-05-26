package dao;

import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Cart;
import dto.Category;
import dto.Order;
import dto.Orderdetail;
import dto.Product;
import dto.Stock;

public class ProductDao extends Dao{

	public ProductDao() {
		super();
	}
	private static ProductDao productDao = new ProductDao();
	public static ProductDao getProductDao() {
		return productDao;
	}
	
	/////////// 카테고리 //////////////
	// 1. 카테고리 등록
	public boolean csave(String cname) {
		try {
			String sql = "insert into category(cname) values('"+cname+"')";
			ps = con.prepareStatement(sql);
			ps.executeUpdate(); 
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}
	// 2. 카테고리 호출
	public ArrayList<Category> getcategorylist(){
		ArrayList<Category> list = new ArrayList<Category>();
		try {
			String sql = "select *from category ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category category = new Category(rs.getInt(1), rs.getString(2));
				list.add(category);
			}
			return list;
		} catch (Exception e) {
			
		}return null;
		
	}
	// 3. 카테고리 수정
	// 4. 카테고리 삭제
	/////////// 제품 //////////////
	// 1. 제품 등록 
	public boolean psave(Product product) { 
		try {
			String sql = "insert into product(pname, pprice, pdiscount, pimg, cno)"
					+ "values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getPname());
			ps.setInt(2, product.getPprice());
			ps.setFloat(3, product.getPdiscount());
			ps.setString(4, product.getPimg());
			ps.setInt(5, product.getCno());
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			
		}
		return false; 
		}
	// 2. 제품 모든 호출
	public ArrayList<Product> getproductlist() { 
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			String sql = "select * from product";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product(
						rs.getInt(1),rs.getString(2), 
						rs.getInt(3), rs.getFloat(4), 
						rs.getInt(5), rs.getString(6), rs.getInt(7) );
				products.add(product);
			}return products;
		} catch (Exception e) {
			
		}
		return null; 
		}
	// 3. 제품 개별 호출 
	public Product getproduct(int pno) { 
		try {
			String sql = "select *from product where pno="+pno;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				Product product = new Product(
						rs.getInt(1),rs.getString(2), 
						rs.getInt(3), rs.getFloat(4), 
						rs.getInt(5), rs.getString(6), rs.getInt(7) );
				return product;
			}
		} catch (Exception e) {
			
		}
		return null; 
		}
	// 4. 제품 수정 
	// 4-2. 제품 상태 변경
	public boolean activechange(int pno, int active) {
		try {
			String sql = "update product set pactive = "+active+" where pno="+pno;
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			
		}return false;
	}
	// 5. 제품 삭제 
	/////////// 재고 //////////////
	// 1. 제품의 재고 등록 
	public boolean ssave( Stock stock) { 
		try {
			String sql = "insert into stock( scolor , ssize , samount , pno )values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString( 1 , stock.getScolor() ); 	ps.setString( 2 , stock.getSsize() );
			ps.setInt( 3 , stock.getSamount() );	ps.setInt( 4 , stock.getPno() ); 
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println( e ); }return false; 
	}
	
		// 2. 제품의 재고 호출 
		public ArrayList< Stock >  getStock(int pno) { 
			ArrayList<Stock> list = new ArrayList<Stock>();
			try {
				String sql = "select * from stock where pno="+pno;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					Stock stock = new Stock( 
							rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getInt(4),
							rs.getString(5), rs.getString(6),
							rs.getInt(7));
					list.add(stock);
				}
				return list;
			}catch (Exception e) { 
				System.out.println( e ); 
			}
			return null; 
		}
		// 3. 제품의 재고 수정 
		public boolean stockupdate( int sno , int samount ) {
			String sql = "update stock set samount = "+samount+" where sno="+sno;
			try {
				ps = con.prepareStatement(sql);
				ps.executeUpdate(); return true;
			}catch (Exception e) { System.out.println( e ); } return false;
			
		}
		// 4. 제품의 재고 삭제
		////////////////// 찜하기 ///////////////////
		public int saveplike(int pno, int mno) {
			try {
				// 1. 검색  	제품번호와 회원번호가 동일하면 
				String sql = "select plikeno from plike where pno="+pno+" and mno="+mno;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if( rs.next() ) { // 2. 만약에 존재하면 삭제처리 
					sql = "delete from plike where plikeno = "+rs.getInt(1);
					ps = con.prepareStatement(sql); ps.executeUpdate();
					return 2; // 삭제 
				}else { 	// 3. 만약에 존재하지 않으면 등록처리 
					sql = "insert into plike( pno , mno )values( "+pno+","+mno+" ) ";
					ps = con.prepareStatement(sql); ps.executeUpdate();
					return 1; // 등록 
				}
			}catch (Exception e) { System.out.println(e); } return 3; // DB오류 
		}
		public boolean getplike(int pno, int mno) {
			try {
				String sql = "select * from plike where pno = "+pno+" and mno ="+mno;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					return true;
				}
			} catch (Exception e) {
				System.out.println("getplike 오류 " + e);
			}return false;
		}
		
		/////////////////////////////장바구니/////////////////////////
		public boolean savecart( Cart cart ) {
			try {
				String sql = "select cartno from cart where sno = "+cart.getSno()+" and mno = "+cart.getMno();
				ps = con.prepareStatement(sql); rs=ps.executeQuery();
				if( rs.next() ) { // 1. 장바구니내 동일한 제품이 존재하면 수량/가격 업데이트 처리
					sql = "update cart set samount = samount + "+cart.getSamount()+
									" , totalprice = totalprice + " + cart.getTotalprice() +
							" where cartno = " + rs.getInt(1);
					ps = con.prepareStatement(sql);	ps.executeUpdate(); return true;
					
				}else { // 2. 존재하지 않으면 등록
					sql ="insert into cart( samount , totalprice , sno , mno ) values( ?,?,?,? )";
					ps = con.prepareStatement(sql);
					ps.setInt( 1 ,  cart.getSamount() );
					ps.setInt( 2 ,  cart.getTotalprice() );
					ps.setInt( 3 ,  cart.getSno() );
					ps.setInt( 4 ,  cart.getMno() ); ps.executeUpdate(); return true;
				}
			}catch (Exception e) { System.out.println( e ); } return false; 
		}
		
		// 장바구니 출력 메소드 [  
		public JSONArray getcart( int mno ) {
			JSONArray jsonArray = new JSONArray(); // json배열 선언 
			String sql = "select "
					+ "	A.cartno as 장바구니번호 , "
					+ "    A.samount as 구매수량 , "
					+ "    A.totalprice as 총가격 , "
					+ "    B.scolor as 색상 ,  "
					+ "    B.ssize as 사이즈 , "
					+ "    B.pno as 제품번호 ,	 "
					+ "    C.pname as 제품명 , "
					+ "    C.pimg as 제품이미지 "
					+ "from cart A "
					+ "join stock B "
					+ "on A.sno = B.sno "
					+ "join product C "
					+ "on B.pno = C.pno "
					+ "where A.mno ="+mno;
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					// 결과내 하나씩 모든 레코드를 -> 하나씩 json객체 변환  
					JSONObject object = new JSONObject();
					object.put( "cartno" , rs.getInt(1) );
					object.put( "samount" , rs.getInt(2) );
					object.put( "totalprice" , rs.getInt(3) );
					object.put( "scolor" , rs.getString(4) );
					object.put( "ssize" , rs.getString(5) );
					object.put( "pno" , rs.getInt(6) );
					object.put( "pname" , rs.getString(7) );
					object.put( "pimg" , rs.getString(8) );
					// 하나씩 json객체를 json배열에 담기 
					jsonArray.put( object );
				}
				return jsonArray;
			}catch (Exception e) { System.out.println("getcart오류 "+ e );}  return null; 
			
		}
		
		// 장바구니 업데이트
		public boolean updatecart(int cartno, int samount, int totalprice) {
			try {
				String sql ="update cart set samount = "+samount+" , totalprice = "+totalprice+" where cartno ="+cartno;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				System.out.println("updatecart 오류 " +e);
			}return false;
		}
		
		// 장바구니 삭제
		public boolean deletecart(int cartno) {
			try {
				String sql = "delete from cart where cartno="+cartno;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return true;
			} catch (Exception e) {
				System.out.println("deletecart 오류 " + e);
			}return false;
		}
		
//////////////////////////주문//////////////////////////////
		public boolean saveorder(Order order) {

			String sql = "insert into porder(ordername,orderphone,orderaddress,ordertotalpay,orderrequest,mno) "
					+ " values(?,?,?,?,?,?)";
			try { // !! -> insert 후에 자동 생성된 pk값 가져오기
				ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, order.getOrdername());
				ps.setString(2, order.getOrderphone());
				ps.setString(3, order.getOrderaddress());
				ps.setInt(4, order.getOrdertotalpay());
				ps.setString(5, order.getOrderrequest());
				ps.setInt(6, order.getMno());
				ps.executeUpdate();
				rs = ps.getGeneratedKeys(); // pk 값 호출
				if (rs.next()) {
					int pk = rs.getInt(1);
					sql = "insert into porderdetail(samount, totalprice, orderno, sno)"
							+ "select samount, totalprice, " + pk +", sno from cart where mno = "+order.getMno();
					ps = con.prepareStatement(sql);
					ps.executeUpdate();
					
					sql = "delete from cart where mno= " +order.getMno();
					ps = con.prepareStatement(sql);
					ps.executeUpdate();
					return true;
				}
			} catch (Exception e) {
				System.out.println("saveorder오류 " +e);
			}

			return false;
		}
		
		////////////////////////////////주문내역
		// 주문내역 메소드 
		public JSONArray getorder( int mno) {
			String sql ="SELECT "
					+ "	A.orderno as 주문번호 , "
					+ "    A.orderdate as 주문일 , "
					+ "    B.orderdetailno as 주문상세번호 , "
					+ "    B.orderdetailactive as 주문상세상태 , "
					+ "    B.samount as 주문상세수량 , "
					+ "    C.sno as 재고번호 , "
					+ "    C.scolor as 색상 , "
					+ "    C.ssize as 사이즈 , "
					+ "    D.pno as 제품번호 , "
					+ "    D.pname as 제품명 ,"
					+ "    D.pimg as 제품사진 "
					+ "FROM "
					+ "porder A JOIN porderdetail B on A.orderno = B.orderno "
					+ "JOIN STOCK C on B.sno = C.sno "
					+ "JOIN product D ON C.pno = D.pno where A.mno = "+mno+" order by A.orderno desc;";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery(); 
				// 1. json 사용하는 이유 -> js로 전송하기위해 
				// 2. Arraylist 사용하는 이유 -> jsp로 사용할려면 
				JSONArray parentlist = new JSONArray();
				JSONArray childlist = new JSONArray(); // 하위 리스트
			
				int oldorderno = -1; // 이전 데이터의 주문번호 임시 저장
				while( rs.next() ) {
					// 데이터 json 객체
					JSONObject jsonObject = new JSONObject();
					jsonObject.put( "orderno" , rs.getInt( 1 ) ) ;
					jsonObject.put( "orderdate" , rs.getString( 2 ) ) ;
					jsonObject.put( "orderdetailno" , rs.getInt( 3 ) ) ;
					jsonObject.put( "orderdetailactive" , rs.getInt( 4 ) ) ;
					jsonObject.put( "samount" , rs.getInt( 5 ) ) ;
					jsonObject.put( "sno" , rs.getInt( 6 ) ) ;
					jsonObject.put( "scolor" , rs.getString( 7 ) ) ;
					jsonObject.put( "ssize" , rs.getString( 8 ) ) ;
					jsonObject.put( "pno" , rs.getInt( 9 ) ) ;
					jsonObject.put( "pname" , rs.getString( 10 ) ) ;
					jsonObject.put( "pimg" , rs.getString( 11 ) ) ;
					
					// 동일한 주문번호 이면 동일한 리스트에 담기 
					//   {  키 : 값  }		
					//   { 키 : [  ]  ,  키 : [  ]  , 키  , [ ] }
					if( oldorderno == rs.getInt( 1 ) ){ // 이전 주문번호와 현재 주문번호 동일하면
						childlist.put( jsonObject ); // 하위 리스트에 데이터 담기 
					}else { // 동일하지 않으면
						childlist = new JSONArray(); // 하위 리스트 초기화 
						childlist.put( jsonObject ); // 하위 리스트에 데이터 담기 
						parentlist.put( childlist ); // 상위 리스트에 하위 리스트 추가 
					}
					oldorderno = rs.getInt( 1 ); // 이전 주문번호 변수에 현재 주문번호 넣기 
				}
				return parentlist;
			}catch (Exception e) { System.out.println( e );} return null;
		}
		
		public boolean cancelorder( int orderdetailno , int active ) {
			try {
				String sql = " update porderdetail set orderdetailactive = "+active
						+ " where orderdetailno = "+orderdetailno;
				ps = con.prepareStatement(sql); ps.executeUpdate(); return true;
			}catch (Exception e) { System.out.println( e ); } return false;
		}
		
		public JSONArray getchart( int type  ) {
			String sql ="";
			JSONArray ja = new JSONArray();
			
			if( type == 1 ) { // 일별 매출 
				sql ="SELECT "
					+ "	substring_index( orderdate , ' ' , 1 ) AS 날짜 , "
					+ "	sum( ordertotalpay ) "
					+ "FROM porder "
					+ "GROUP BY 날짜 ORDER BY 날짜 DESC";
			}else if( type == 2 ) { // 카테고리별 전체 판매량 
				sql = "select  "
						+ "	sum( A.samount )  ,  "
						+ "    D.cname "
						+ "from porderdetail A, stock B , product C , category D  "
						+ "where A.sno = B.sno and B.pno = C.pno and C.cno = D.cno  "
						+ "group by D.cname "
						+ "order by orderdetailno desc";
			}
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					JSONObject jo = new JSONObject();
					if( type == 1 ) {
						jo.put("date", rs.getString( 1 ) );
						jo.put("value", rs.getString(2) );
						ja.put(jo);
					}else if( type == 2 ) {
						jo.put("value", rs.getInt( 1 ) );
						jo.put("category", rs.getString(2) );
						ja.put(jo);
					}
				}
				return ja;
			}catch (Exception e) { System.out.println( e );} return null;
		}
		
		
		// 1. 오늘 주문상세 호출 
		public ArrayList<Orderdetail> getordertail(){
			
			String sql = "select "
					+ "	A.* , substring_index( B.orderdate , ' ' , 1 ) as 날짜 "
					+ "from  porderdetail A , porder B "
					+ "where A.orderno = B.orderno "
					+ "and substring_index( B.orderdate , ' ' , 1 ) = substring_index( now() , ' ' , 1 ) "
					+ "and  A.orderdetailactive = 3";
			try {
				ps = con.prepareStatement(sql);
				rs  = ps.executeQuery();
				ArrayList<Orderdetail> list = new ArrayList<Orderdetail>();
				while( rs.next() ) {
					Orderdetail orderdetail = new Orderdetail();
					orderdetail.setOrderdetailno(  rs.getInt(1) );
					orderdetail.setOrderdetailactive( rs.getInt(2) );
					orderdetail.setSamount(rs.getInt(3) );
					orderdetail.setTotalprice(rs.getInt(4));
					orderdetail.setOrderno(rs.getInt(5));
					orderdetail.setSno(rs.getInt(6));
					
					list.add(orderdetail);
				}
				return list;
			}catch (Exception e) {} return null;
			
		}
	}
		

