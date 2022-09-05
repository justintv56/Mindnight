
public class Hacker {
	private String role, name;
	public Hacker(String n)
	{
		name = n;
		role = "Agent";
	}
	public Hacker(String n, String g)
	{
		name = n;
		role = "Hacker";
	}
	public String getRole()
	{
		return role;
	}
	
	public String getName()
	{
		return name;
	}
}
