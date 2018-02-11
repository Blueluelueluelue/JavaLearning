import java.lang.*;
class FactorialCmdArgs
{
public static void main(String args[])
{
int n,i,fac=1;
n=Integer.parseInt(args[0]);
for(i=2;i<=n;i++)
fac*=i;
System.out.println("Factorial :"+fac);
}
}