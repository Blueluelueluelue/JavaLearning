
import java.lang.*;
import java.util.*;
class AscDesc
{
	public static void main(String[] args)
	{
		int i,size,temp;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no. of elements\n");
		size=sc.nextInt();
		if(size<=0)
		{
			System.out.println("size cannot be "+size);
			return;
		}			
		int a[]=new int [size];
		System.out.println("enter the elements\n");
		for(i=0;i<size;i++)
			a[i]=sc.nextInt();
		System.out.println("the array you entered :\n");
		for(i=0;i<size;i++)
			System.out.print(a[i]+"  ");
		System.out.println("\n");
		for(i=0;i<size;i++)
			for(int j=0;j<size-i-1;j++)
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
		System.out.println("largest value is "+a[size-1]+"\nsmallest value is "+a[0]);
		System.out.println("ascending order");
		for(i=0;i<size;i++)
			System.out.print(a[i]+" ");
		System.out.println("\n");
		System.out.println("descending order");
		for(i=size-1;i>=0;i--)
			System.out.print(a[i]+" ");		
	}
}