

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No argument provided. Please provide a valid argument.");
            return;
        }

        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                for (String studentName : fileReader.readLine().split(",")) {
                    System.out.println(studentName.trim());
                }
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                String[] studentList = fileReader.readLine().split(",");
                System.out.println(studentList[new Random().nextInt(studentList.length)].trim());
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("students.txt", true))) {
                String newStudentName = args[0].substring(1);
                String formattedDateTime = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss a").format(new Date());
                fileWriter.write(", " + newStudentName + "\nList last updated on " + formattedDateTime);
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error writing to file.");
            }
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                String[] studentList = fileReader.readLine().split(",");
                String searchName = args[0].substring(1);
                for (String studentName : studentList) {
                    if (studentName.trim().equals(searchName)) {
                        System.out.println("We found it!");
                        break;
                    }
                }
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (args[0].equals("c")) {
            System.out.println("Loading data ...");
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                String fileContent = fileReader.readLine();
                String[] words = fileContent.trim().split("\\s+");  
                System.out.println(words.length + " word(s) found");
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        }
    }
}
