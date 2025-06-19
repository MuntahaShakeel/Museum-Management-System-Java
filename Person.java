
package my_package;
public class Person {
	private String name = null;
	private int id = 0;
	private String dob = null;
	public Person(String name, int id, String dob)
        {
		this.name = name;
		this.id = id;
		this.dob = dob;
	}
	public Person() 
        {
		super();
	}
	public String getName()
        {
		return name;
	}
	public void setName(String name)
        {
		this.name = name;
	}
	public int getId() 
        {
		return id;
	}
	public void setId(int id) 
        {
		this.id = id;
	}
	public String getDob()
        {
		return dob;
	}
	public void setDob(String dob) 
        {
		this.dob = dob;
	}
	@Override
	public String toString() 
        {
		return "Person [name=" + name + ", id=" + id + ", dob=" + dob + "]\n";
	}
}
