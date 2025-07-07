// File Name: StudentList.java

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        // Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String line = reader.readLine();
                String[] students = line.split(",");
                for (String student : students) {
                    System.out.println(student.trim());
                }
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String line = reader.readLine();
                String[] students = line.split(",");
                Random random = new Random();
                int index = random.nextInt(students.length);
                System.out.println(students[index].trim());
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter("students.txt", true)
                );
                String newStudent = args[0].substring(1);
                Date currentDate = new Date();
                String dateFormatPattern = "dd/MM/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
                String formattedDate = dateFormat.format(currentDate);
                writer.write(", " + newStudent + "\nList last updated on " + formattedDate);
                writer.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error writing to file.");
            }
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String line = reader.readLine();
                String[] students = line.split(",");
                String target = args[0].substring(1);
                boolean found = false;

                for (String student : students) {
                    if (student.trim().equals(target)) {
                        System.out.println("We found it!");
                        found = true;
                        break;
                    }
                }

                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (args[0].equals("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String data = reader.readLine();
                char[] characters = data.toCharArray();

                boolean inWord = false;
                int wordCount = 0;

                for (char ch : characters) {
                    if (ch == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        }
                    } else {
                        inWord = false;
                    }
                }

                System.out.println(wordCount + " word(s) found");
                reader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        }
    }
}
