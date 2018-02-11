import java.lang.*;
class Employee
{
	public String name;
	public double sal;
	public void setData(String name, double sal)
	{
		this.name=name;
		this.sal=sal;
	}
	public String getName()
	{
		return this.name;
	}
	public double getSal()
	{
		return this.sal;
	}	
}
class Manager extends Employee
{
	public double bonus;
	public void setBonus(double bonus)
	{
		this.bonus=bonus;
	}
	public double income()
	{
		double income=getSal()+bonus;
		return income;
	}
	public void disp()
	{
		System.out.println("name is "+super.name+"\nsal is "+super.sal);
	}
}

class Inheritance
{
	public static void main(String [] args)
	{
		Manager M=new Manager();
		M.setData("ABC",50000);
		M.disp();
		M.setBonus(3000);
		System.out.println("Bonus is "+M.bonus);
		System.out.println("income is "+M.income());
	}
}
