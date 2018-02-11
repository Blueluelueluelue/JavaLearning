class JaggedArray
{
  public static void main(String[]args)
  {
    int jagg[][] = {
                        {1,2,3,4},
                        {2,4,6},
                        {0,3,6,9,2}
                   };
    for(int i = 0; i < jagg.length; i++) {
      for(int j = 0; j < jagg[i].length; j++) {
        System.out.print(" "+jagg[i][j]);
      }
      System.out.println();
    }
  }
}
