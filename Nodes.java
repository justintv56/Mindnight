
public class Nodes {
	private String mem1, mem2, mem3, mem4;
	public Nodes(String one, String two)
	{
		mem1 = one;
		mem2 = two;
		mem3 = "";
		mem4 = "";
	}
	public Nodes(String one, String two, String three)
	{
		mem1 = one;
		mem2 = two;
		mem3 = three;
		mem4 = "";
	}
	public Nodes(String one, String two, String three, String four)
	{
		mem1 = one;
		mem2 = two;
		mem3 = three;
		mem4 = four;
	}
	public String getMem1()
	{
		return mem1;
	}
	public String getMem2()
	{
		return mem2;
	}
	public String getMem3()
	{
		return mem3;
	}
	public String getMem4()
	{
		return mem4;
	}
	public String toString()
	{
		System.out.print(mem1);
		System.out.print(", " + mem2);
		if(!mem3.equals(""))
			System.out.print(", " + mem3);
		if(!mem4.equals(""))
			System.out.print(", " + mem4);
		return "";
	}
	
}
