import java.lang.*;
import java.util.Scanner;
class ConsOver
{
	private int l,b,h;
	public ConsOver()
	{
		Scanner in=new Scanner(System.in);		
		System.out.println("Enter length breadth and height");
		l=in.nextInt();
		b=in.nextInt();
		h=in.nextInt();		
	}
	public ConsOver(int a, int B, int c)
	{
		l=a;
		b=B;
		h=c;
	}
	public ConsOver(int a)
	{
		l=b=h=a;
	}
	public void disp()
	{
		System.out.println("Length = "+l+"\nBreadth = "+b+"\nHeight = "+h);
	}
}

class ConstructorOverloading
{
	public static void main(String []args)
	{
		ConsOver obj1=new ConsOver();
		ConsOver obj2=new ConsOver(100);
		ConsOver obj3=new ConsOver(10,20,30);
		obj1.disp();
		obj2.disp();
		obj3.disp();
	}	
}