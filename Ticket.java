
package my_package;
class Ticket {
	private Visitor visitor ;
	private String issueDate;
	private int price;
	
	public Ticket(String issueDate, int price) {
		
		this.issueDate = issueDate;
		this.price = price;
		
	}
        public Ticket() {
		this.issueDate = null;
		this.price = 0;
		this.visitor = null;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	public Visitor getVisitor () {
		return this.visitor;
	}
	public void setVisitor (Visitor v) {
		this.visitor = v; 
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	Visitor vr = new  RegularVisitor();
	Visitor vs = new SeniorVisitor();
	public Ticket(Visitor visitor, String issueDate, int price, RegularVisitor vr, SeniorVisitor vs) {
		super();
		this.visitor = visitor;
		this.issueDate = issueDate;
		this.price = price;
		this.vr = vr;
		this.vs = vs;
	}
	public Visitor getVr() {
		return vr;
	}
	public void setVr(RegularVisitor vr) {
		this.vr = vr;
	}
	public Visitor getVs() {
		return vs;
	}
	public void setVs(SeniorVisitor vs) {
		this.vs = vs;
	}
	@Override
	public String toString() {
		vs.bookTour();
		return "Ticket [" + " issueDate=" + issueDate + ", price=" + price + "]";
	}
	
}
