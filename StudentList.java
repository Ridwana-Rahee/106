

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

        // Check if any command-line argument is provided
        if (args.length == 0) {
            System.out.println("No argument provided. Please provide a valid argument.");
            return;
        }

        String userInput = args[0];

        // Option: Display all students
        if (userInput.equals("a")) {
            System.out.println("Loading data ...");
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                // Read and print each student name
                for (String studentName : fileReader.readLine().split(",")) {
                    System.out.println(studentName.trim());
                }
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }

        // Option: Display a random student
        } else if (userInput.equals("r")) {
            System.out.println("Loading data ...");
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                String[] studentList = fileReader.readLine().split(",");
                // Pick and display a random student
                System.out.println(studentList[new Random().nextInt(studentList.length)].trim());
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }

        // Option: Add a new student to the file
        } else if (userInput.startsWith("+")) {
            System.out.println("Loading data ...");
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("students.txt", true))) {
                String newStudentName = userInput.substring(1);  // extract name
                // Create timestamp
                String formattedDateTime = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss a").format(new Date());
                // Append new student and update time
                fileWriter.write(", " + newStudentName + "\nList last updated on " + formattedDateTime);
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error writing to file.");
            }

        // Option: Search for a student name
        } else if (userInput.startsWith("?")) {
            System.out.println("Loading data ...");
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                String[] studentList = fileReader.readLine().split(",");
                String searchName = userInput.substring(1);  // extract name to search
                // Search and report if found
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

        // Option: Count number of words in the file
        } else if (userInput.equals("c")) {
            System.out.println("Loading data ...");
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")))) {
                String fileContent = fileReader.readLine();
                // Split content by whitespace and count the words
                String[] words = fileContent.trim().split("\\s+");
                System.out.println(words.length + " word(s) found");
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }

        // Handle invalid command-line input
        } else {
            System.out.println("Invalid argument. Please use one of the following:");
            System.out.println("  a           - Display all students");
            System.out.println("  r           - Display a random student");
            System.out.println("  +<name>     - Add a new student");
            System.out.println("  ?<name>     - Search for a student");
            System.out.println("  c           - Count words in the file");
        }
    }
}
