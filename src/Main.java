import javax.swing.*;
import java.util.Scanner;

class Main{
    public static void main(String[] argc) {



        Scanner sc = new Scanner(System.in);





        while(true) {
            System.out.println("******************************************");
            System.out.println("WELCOME TO FILE MANAGEMENT SYSTEM");
            System.out.println("******************************************");
            System.out.println("1. Upload File");
            System.out.println("2. Retrieve File");
            System.out.println("3. Read File");
            System.out.println("4. Delete File");




            System.out.println("Enter your Choice: ");
            int choice = sc.nextInt();

//        sc.close();







            switch (choice) {



                case 1:

                    UploadFile.upload();
                    break;

                case 2:
                    RetrieveFile.retrieve();
                    break;

                case 3:
                    ReadFile.read();
                    break;

                case 4:
                    DeleteFile.delete();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }

//
//    UploadFile.retrieve();
//    RetrieveFile.retrieve();
//    ReadFile.read();
//    DeleteFile.delete();


        }
    }

}