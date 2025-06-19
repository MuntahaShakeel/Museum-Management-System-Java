
package my_package;
public class MultiTimeTicket extends Ticket {
	private TicketType tickectType;
	
	public MultiTimeTicket(String issueDate, int price, TicketType tickectType) {
		super(issueDate, price);
                
		this.tickectType = tickectType;
	}
	public MultiTimeTicket() {
		super();
	}
	public MultiTimeTicket(TicketType tickectType) {
		super();
		this.tickectType = tickectType;
	}
	public TicketType getTickectType() {
		return tickectType;
	}
	public void setTickectType(TicketType tickectType) {
		this.tickectType = tickectType;
	}

	@Override
	public String toString() {
		return super.toString() + "MultiTimeTicket [tickectType=" + tickectType + "]";
	}
	
}
