import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      try{
          File file =new File("abc.png");//current directory
          Scanner sc=new Scanner(System.in);
          String content=sc.next();
          String answer=UPIPaymentLinkGenerator.payment(content);
          ByteArrayOutputStream byteArrayOutputStream= QRCode.from(answer).to(ImageType.PNG).stream(); //static method
          FileOutputStream fileOutputStream=new FileOutputStream(file);
          fileOutputStream.write(byteArrayOutputStream.toByteArray());
          fileOutputStream.close();
          System.out.println("QR CODE GENERATED...");

          String filePath = "abc.png";

          // Create a File object
          File newFile = new File(filePath);

          // Check if Desktop is supported
          if (Desktop.isDesktopSupported()) {
              // Get the Desktop instance
              Desktop desktop = Desktop.getDesktop();

              try {
                  // Open the file with the default program
                  desktop.open(newFile);
              } catch (IOException e) {
                  System.out.println("Error opening the file: " + e.getMessage());
              }
          } else {
              System.out.println("Desktop is not supported. Cannot open the file.");
          }

      }
      catch (Exception e){
e.printStackTrace();
      }
    }
}