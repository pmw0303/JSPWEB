package dto;

public class Orderdetail {

	private int orderdetailno;
	private int orderdetailactive;
	private int samount;
	private int totalprice;
	private int orderno;
	private int sno;

	public Orderdetail() {
		
	}

	public Orderdetail(int orderdetailno, int orderdetailactive, int samount, int totalprice, int orderno, int sno) {
		super();
		this.orderdetailno = orderdetailno;
		this.orderdetailactive = orderdetailactive;
		this.samount = samount;
		this.totalprice = totalprice;
		this.orderno = orderno;
		this.sno = sno;
	}

	public int getOrderdetailno() {
		return orderdetailno;
	}

	public void setOrderdetailno(int orderdetailno) {
		this.orderdetailno = orderdetailno;
	}

	public int getOrderdetailactive() {
		return orderdetailactive;
	}

	public void setOrderdetailactive(int orderdetailactive) {
		this.orderdetailactive = orderdetailactive;
	}

	public int getSamount() {
		return samount;
	}

	public void setSamount(int samount) {
		this.samount = samount;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

}
