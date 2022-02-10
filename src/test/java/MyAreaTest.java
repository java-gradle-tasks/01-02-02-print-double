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

         String expected="A szoba terulete 12,56 négyzetméter.\r\n";
         String actual=byteArrayOutputStream.toString();

         int result=expected.compareTo(actual);

         Assertions.assertEquals(result,0,"A program kimenete nem megfelelo!");
      }
   }
