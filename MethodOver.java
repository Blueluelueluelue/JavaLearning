import java.lang.*;
import java.util.Scanner;
class MethodOver
{
	double pi=3.1415;	
	public double area(double rad)
	{
		double area=rad*rad*pi;
		return area;
	}	
	public double area(double len,double br)
	{
		double area=len*br;
		return area;
	}
	public double area(double s1, double s2, double s3)
	{
		double s=(s1+s2+s3)/2;
		double q=s*(s-s1)*(s-s2)*(s-s3);
		double area=Math.sqrt(q);
		return area;
	}
	public static void disp(String str)
	{
		System.out.println(str);
	}
	public static void disp(double f)
	{
		System.out.println(f);
	}
	public static void main(String [] args)
	{	
		double a,b,c;
		Scanner sc=new Scanner(System.in);
		disp("Enter the radius");
		a=sc.nextDouble();
		MethodOver obj=new MethodOver();
		disp("area is");
		disp(obj.area(a));
		disp("enter the length and breadth");
		a=sc.nextDouble();
		b=sc.nextDouble();
		disp("area is");
		disp(obj.area(a,b));
		disp("enter the 3 sides");
		a=sc.nextDouble();
		b=sc.nextDouble();
		c=sc.nextDouble();
		disp("area is");
		disp(obj.area(a,b,c));
	}
}