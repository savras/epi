// >> is arithmatic shift. This preserves signedness of number
// >>> is logical shift. This fills everything on the msb with 0s
class SwapBitsSolution
{
  public static void main(String args[]) 
  {
    int x = 71; // 0100 0111
    int i = 1;  // index 1 from lsb
    int j = 5;  // index 5 from lsb
    int result = swapBits(x, i, j);
    System.out.println(result);
  }

  public static int swapBits(int x, int i, int j)
  {
    if(((x >>> i) & 1) != ((x >>> j) & 1))
    {
      int mask = (1 << i) | (1 << j);   // Make both indices contain '1', e.g. 0010 0010
      x ^= mask;  // 0100 0111
                  // 0101 0000
                  // 0001 0111
    }

    return x;
  }
}