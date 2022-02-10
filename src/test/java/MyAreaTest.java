   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;

   import java.io.*;

   public class MyAreaTest {

      @Test
      public void test() {
         String newLine="";
         if (System.getProperty("os.name").startsWith("Windows")) {
            newLine="\r\n";
         } else {
            newLine="\n";
         }

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(byteArrayOutputStream);
         PrintStream stdout = System.out;
         System.setOut(ps);

         MyArea.main(new String[0]);

         System.setOut(stdout);

         String actual=byteArrayOutputStream.toString();

         String expected="";
         if (System.getProperty("os.name").startsWith("Windows")) {
            expected = "A szoba kerulete 12,56 negyzetmeter." + newLine;
         } else {
            expected = "A szoba kerulete 12.56 negyzetmeter." + newLine;
         }

         System.out.println(expected);
         System.out.println(actual);

         int result=expected.compareTo(actual);

         Assertions.assertEquals(result,0,"A program kimenete nem a megfelelo karakterkebol epul fel!");
         Assertions.assertEquals(expected,actual,"A program kimenete nem megfelelo!");
      }
   }
