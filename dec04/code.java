import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class code {
    public static void main(String[] args) throws IOException {
       // Prints "Hello, World" in the terminal window.
       char[][] ogopogo = inputProcessing();
       int partOneAns = wordSearch(ogopogo);
       int parttwoAns = configRead(ogopogo, 2, 2, 0, 0, 0, 0, false);
       System.out.println(partOneAns);
       System.out.println(parttwoAns);
   }
       
   private static int wordSearch(char[][] ogopogo) {
      int ans = 0;
      ans += configRead(ogopogo, 3, 0, 1, 0, 0, 0, true);
      ans += configRead(ogopogo, 3, 0, -1, 0, 3, 0, true);
      ans += configRead(ogopogo, 0, 3, 0, 1, 0, 0, true);
      ans += configRead(ogopogo, 0, 3, 0, -1, 0, 3, true);
      ans += configRead(ogopogo, 3, 3, 1, 1, 0, 0, true);
      ans += configRead(ogopogo, 3, 3, -1, -1, 3, 3, true);
      ans += configRead(ogopogo, 3, 3, 1, -1, 0, 3, true);
      ans += configRead(ogopogo, 3, 3, -1, 1, 3, 0, true);
      return ans;
   }

   public static int configRead(char[][] ogopogo, int vertOffset, int horOffset, int vertDir, int horDir, int vertStart, int horiStart, boolean xmas) {
      int matches = 0;
      for (int i = 0; i + vertOffset < ogopogo.length; i++) {
         for (int j = 0; j + horOffset < ogopogo[0].length; j++) {
            if (xmas) {
               boolean x = 'X' == ogopogo[i + vertStart + 0 * vertDir][j + horiStart + 0 * horDir];
               boolean m = 'M' == ogopogo[i + vertStart + 1 * vertDir][j + horiStart + 1 * horDir];
               boolean a = 'A' == ogopogo[i + vertStart + 2 * vertDir][j + horiStart + 2 * horDir];
               boolean s = 'S' == ogopogo[i + vertStart + 3 * vertDir][j + horiStart + 3 * horDir];
               if (x && m && a && s) {
                  matches++;
               }
            } else {
               boolean a = 'A' == ogopogo[i+1][j+1];
               boolean uldr = ogopogo[i][j] != ogopogo[i+2][j+2];
               boolean urdl = ogopogo[i+2][j] != ogopogo[i][j+2];
               boolean ulA = 'A' != ogopogo[i][j];
               boolean urA = 'A' != ogopogo[i+2][j];
               boolean dlA = 'A' != ogopogo[i][j+2];
               boolean drA = 'A' != ogopogo[i+2][j+2];
               boolean na = ulA && urA && dlA && drA;
               boolean ulX = 'X' != ogopogo[i][j];
               boolean urX = 'X' != ogopogo[i+2][j];
               boolean dlX = 'X' != ogopogo[i][j+2];
               boolean drX = 'X' != ogopogo[i+2][j+2];
               boolean nx = ulX && urX && dlX && drX;
               if (a && uldr && urdl && na && nx) {
                  matches++;
               }
            }
         }
      }
      return matches;
   }
       
   public static char[][] inputProcessing() throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("Advent Of Code 2024\\dec04\\input.txt"));
      try {
         StringBuilder sb = new StringBuilder();
         String line = br.readLine();

         while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
         }
         String everything = sb.toString();

         String[] neue = everything.split("\n");

         char[][] ret = new char[neue.length][neue.length];
         for (int i = 0; i < neue.length; i++) {
            for (int j = 0; j < neue.length; j++) {
               ret[i][j] = neue[i].charAt(j);
            }
         }
         return ret;
      } finally {
         br.close();
      }
    }
 }