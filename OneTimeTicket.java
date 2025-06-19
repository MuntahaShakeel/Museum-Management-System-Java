
package my_package;
public class OneTimeTicket extends Ticket {
	public OneTimeTicket(String issueDate, int price) {
		super(issueDate, price);
	}
	public OneTimeTicket() {
		super();
	}
	@Override
	public String toString() {
		return super.toString() + "OneTimeTicket ";
	}
}
