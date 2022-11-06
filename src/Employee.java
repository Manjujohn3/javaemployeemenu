import java.sql.*;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {


        int choice;

        while (true) {
            System.out.println("select an option");
            System.out.println("1.insert");
            System.out.println("2.view");
            System.out.println("3.search");
            System.out.println("4.delete");
            System.out.println("5.update");
            System.out.println("6.Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("insert employee selected");
                    break;

                case 2:
                    System.out.println("view employee selected");
                    break;
                case 3:
                    System.out.println("search search selected");
                    break;

                case 4:
                    System.out.println("delete delete selected");
                    break;

                case 5:
                    System.out.println("update update selected");
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct value");
                    break;
            }
        }
    }
}



