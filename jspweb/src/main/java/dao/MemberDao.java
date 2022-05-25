package dao;

import dto.Member;

public class MemberDao extends Dao{
	
	public MemberDao() {
		super(); // 부모 클래스 생성자 호출
	}
	public static MemberDao memberDao = new MemberDao();
	public static MemberDao getmemberDao() { return memberDao;}
	
	// 아이도 중복체크 메소드
	public boolean idcheck(String mid) {
		String sql = "select * from member where mid=?"+mid;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("idcheck 오류 : " +e);
		}return false;
	}
	
	// 이메일 중복체크
	public boolean emailcheck(String email) {
		String sql = "select *from member where memail ="+email;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("emailcheck 오류 : " +e);
		}return false;
	}
	
	// 회원가입 메소드
	public boolean signup(Member member) {
		String sql = "insert into member(mid,mpassword,mname,mphone,memail,maddress) "
				+ "value(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMphone());
			ps.setString(5, member.getMemail());
			ps.setString(6, member.getMaddress());
			ps.executeUpdate(); return true;
		} catch (Exception e) {
			System.out.println("signup 오류 " +e);
		}return false;
	}
	
	public int login(String mid, String mpassword) {
		String sql = "select *from member where mid=? and mpassword=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpassword);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}return 2;
		} catch (Exception e) {
			System.out.println("login 오류 " +e);
		}return 3;
	}
	
	// 개별 회원 정보 출력 [인수 = 세션에 저장된 아이디]
	public Member getmember(String mid) {
		
		// String sql = "select *from member where mid=?";
		String sql = "select *from member where mid='" + mid + "'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				// 패스워드 제외** - 검색된 레코드 필드값 객체화
				Member member = new Member(
						rs.getInt(1), rs.getString(2), 
						null, rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getInt(8), 
						rs.getString(9));
				return member;		
			}
		} catch (Exception e) {
			System.out.println("getmember 오류 " +e);
		}return null;
	}
	
	// 패스워드 확인 메소드 
	public boolean passwordcheck( String mid , String mpassword ) {
		
		String sql = "select * from member where mid = '"+mid+"' and mpassword = '"+mpassword+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); if( rs.next() ) return true;
		}catch (Exception e) { System.out.println( e );} return false;
	}
	// 회원 삭제 메소드 
		public boolean delete( String mid ) {
			String sql ="delete from member where mid = '"+mid+"'";
			try { ps=con.prepareStatement(sql); ps.executeUpdate(); return true; }
			catch (Exception e) { System.out.println(e); } return false;
		}
		
	// 회원 수정 메소드 
		public boolean update( Member member ) {
			try {
			if( member.getMpassword() == null ) { // 패스워드 변경이 없을때 
				String sql ="update member set mname=? ,  mphone=? , memail=?,"
						+ "maddress = ? where mno=?";
					ps = con.prepareStatement(sql);
					ps.setString( 1 , member.getMname() );
					ps.setString( 2 , member.getMphone() );
					ps.setString( 3 , member.getMemail() );
					ps.setString( 4 , member.getMaddress() );
					ps.setInt( 5, member.getMno() );
			}else {	// 패스워드가 변경이 있을때 
				String sql ="update member set mname=? , mpassword = ? ,  mphone=? , memail=?,"
						+ "maddress = ? where mno=?";
					ps = con.prepareStatement(sql);
					ps.setString( 1 , member.getMname() );
					ps.setString( 2 , member.getMpassword() );
					ps.setString( 3 , member.getMphone() );
					ps.setString( 4 , member.getMemail() );
					ps.setString( 5 , member.getMaddress() );
					ps.setInt( 6 , member.getMno() );
			}
				ps.executeUpdate(); return true;
			}catch (Exception e) {} return false;
		}
		
		// 회원번호 출력
		public int getmno(String mid) {
			String sql = "select mno from member where mid='"+mid+"'";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
				
			}return 0;
		}
		
		// 회원아이디 검색 메소드 - boardlist
		public String getmemberid( int mno) {
			
			String sql ="select mid from member where mno=?";
			try {
				ps =con.prepareStatement(sql); ps.setInt(1, mno);
				rs = ps.executeQuery(); 
				if( rs.next() ) { return rs.getString(1); }
			}catch (Exception e) {} return null;
			
		}
		
		// 회원id 출력 메소드 
		public String getmid( int mno ) {
			String sql = "select mid from member where mno = "+mno;
			try { ps=con.prepareStatement(sql); rs=ps.executeQuery(); 
				if(rs.next() ) return rs.getString( 1 ); 
			}
			catch (Exception e) {} return null;
		}
		
	}
		

