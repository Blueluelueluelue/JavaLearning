import java.lang.*;
import java.util.Scanner;
class MatrixMultiply
{
public static void main(String args[])
{
int i,j,k,r1,c1,r2,c2;
Scanner sc=new Scanner(System.in);
do
{
System.out.println("no. of columns of 1st matrix and no. of rows of 2nd matrix should be equal for multiplication");
System.out.println("\n enter the rows and columns for 1st matrix");
r1=sc.nextInt();
c1=sc.nextInt();
System.out.println("enter rows and columns for 2nd matrix");
r2=sc.nextInt();
c2=sc.nextInt();
}
while(c1!=r2);
int [][]a=new int[r1][c1];
int [][]b=new int[r2][c2];
System.out.println("enter the elements of 1st matrix");
for(i=0;i<r1;i++)
for(j=0;j<c1;j++)
a[i][j]=sc.nextInt();
System.out.println("enter the elements of 2nd matrix");
for(i=0;i<r2;i++)
for(j=0;j<c2;j++)
b[i][j]=sc.nextInt();
System.out.println("The 1st matrix is");
for(i=0;i<r1;i++)
{
for(j=0;j<c1;j++)
System.out.print(a[i][j]+" ");
System.out.println();
}
System.out.println("The 2nd matrix is");
for(i=0;i<r2;i++)
{
for(j=0;j<c2;j++)
System.out.print(b[i][j]+" ");
System.out.println();
}

int [][]c=new int[r1][c2];
for(i=0;i<r1;i++)
{
for(j=0;j<c2;j++)
{
for(k=0;k<c1;k++)
c[i][j]+=a[i][k]*b[k][j];
}
}

System.out.println("The product is");
for(i=0;i<r1;i++)
{
for(j=0;j<c2;j++)
System.out.print(c[i][j]+" ");
System.out.println();
}
}
}
