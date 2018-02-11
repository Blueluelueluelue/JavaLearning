class Calc
{
  public int add(int ... arr) {
    int res = 0;
    for(int i = 0; i < arr.length; i++) {
      res += arr[i];
    }
    return res;
  }

  public double add(double ... arr) {
    double res = 0;
    for(double i : arr) {
      res += i;
    }
    return res;
  }
}


class VarLengthArgs
{
  public static void main(String[]args)
  {
    Calc obj = new Calc();
    System.out.println("10 + 1 = "+obj.add(10,1));
    System.out.println("503.123 + 54.13 + 4234.123 + 443.333 = "+obj.add(503.123, 54.13, 4234.123, 443.333));
  }
}
