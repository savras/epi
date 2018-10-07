// Get parity
// Use x&(x-1) which gives x with lowest bit erased
// e.g. x = 10010010, x-1 = 10010001
// 10010010 & 10010001 == 10010000
class solution 
{
  public static void main(String args[])
  {
    long x = 8138;  // 1111 1110 01010 - odd parity
    System.out.println(getParity(x) == 1 ? "Odd" : "Even");
  }

  public static short getParity(long x)
  {
    short result = 0;
    while(x > 0)
    {
      x &= x-1;
      result ^= 1;
    }

    return result;
  }
}