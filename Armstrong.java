import java.lang.*;
class Armstrong
{
public static int power(int a,int n)
{
int i,r=1;
for(i=1;i<=n;i++)
r=r*a;
return r;
}
/*My name is Taha (just writing this so you know this is not just an image from the internet)*/
public static void main(String args[])
{
int n,d=0,m,sum=0,temp;
n=Integer.parseInt(args[0]);
m=n;
while(m!=0)
{
m=m/10;
d++;
}
m=n;
while(m!=0)
{
temp=m%10;
sum+=power(temp,d);
m=m/10;
}
if(sum==n)
System.out.print("It is an armstrong number");
else
System.out.print("Not an armstrong number");
}
}