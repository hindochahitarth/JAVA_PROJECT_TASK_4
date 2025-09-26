import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- File Operations Menu ---");
            System.out.println("1. Write a file");
            System.out.println("2. Read a file");
            System.out.println("3. Delete a file");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int ch = sc.nextInt();
            sc.nextLine();  
            String fname;

            switch (ch) {
                case 1:
                    System.out.print("Enter file name to create/write: ");
                    fname = sc.nextLine();
                    try (FileWriter myWriter = new FileWriter(fname)) {
                        System.out.print("Enter note you want to add: ");
                        String mssg = sc.nextLine();
                        myWriter.write(mssg);
                        System.out.println("Notes added successfully.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter file name to read: ");
                    fname = sc.nextLine();
                    try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
                        String line;
                        System.out.println("\n--- File Content ---");
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter file name to delete: ");
                    fname = sc.nextLine();
                    File fobj = new File(fname);
                    if (fobj.delete()) {
                        System.out.println("File " + fobj.getName() + " deleted successfully.");
                    } else {
                        System.out.println("Failed to delete file " + fobj.getName());
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
