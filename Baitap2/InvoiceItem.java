package Baitap2;

public class InvoiceItem {
	
	private String id;
	private String desc;
	private int qty;
	private double unitPrice;
	public InvoiceItem(String id, String desc, int qty, double unitPrice) {
		super();
		this.id = id;
		this.desc = desc;
		this.qty = qty;
		this.unitPrice = unitPrice;
	} 
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDesc() {
		return desc;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotal () {
		return this.unitPrice * this.qty; 
	}
	
	public String toString () {
		return "InvoiceItem[id=" + this.id + ",desc=" + this.desc + ",qty=" + this.qty + ",unitPrice=" + this.unitPrice + "]";
	} 
	

}