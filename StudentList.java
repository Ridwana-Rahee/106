// File Name: StudentList.java

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        // STEP 2: Check for valid argument length
        if (args.length == 0) {
            System.out.println("No argument provided. Please provide a valid argument.");
            return;
        }

        String argument = args[0];

        if (argument.equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String studentDataLine = fileReader.readLine();
                String[] studentList = studentDataLine.split(",");

                for (String studentName : studentList) {
                    System.out.println(studentName.trim());
                }

                fileReader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (argument.equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );
                String studentDataLine = fileReader.readLine();
                String[] studentList = studentDataLine.split(",");

                Random randomGenerator = new Random();
                int randomIndex = randomGenerator.nextInt(studentList.length);

                System.out.println(studentList[randomIndex].trim());

                fileReader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (argument.contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter fileWriter = new BufferedWriter(
                    new FileWriter("students.txt", true)
                );

                String newStudentName = argument.substring(1);
                Date currentDate = new Date();
                String dateTimeFormat = "dd/MM/yyyy-hh:mm:ss a";
                DateFormat formatter = new SimpleDateFormat(dateTimeFormat);
                String formattedDateTime = formatter.format(currentDate);

                fileWriter.write(", " + newStudentName + "\nList last updated on " + formattedDateTime);
                fileWriter.close();

                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error writing to file.");
            }
        } else if (argument.contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );

                String studentDataLine = fileReader.readLine();
                String[] studentList = studentDataLine.split(",");

                String searchName = argument.substring(1);
                boolean found = false;

                for (String studentName : studentList) {
                    if (studentName.trim().equals(searchName)) {
                        System.out.println("We found it!");
                        found = true;
                        break;
                    }
                }

                fileReader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        } else if (argument.equals("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader fileReader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );

                String studentDataLine = fileReader.readLine();
                char[] characterArray = studentDataLine.toCharArray();

                boolean insideWord = false;
                int wordCount = 0;

                for (char currentChar : characterArray) {
                    if (currentChar == ' ') {
                        if (!insideWord) {
                            wordCount++;
                            insideWord = true;
                        }
                    } else {
                        insideWord = false;
                    }
                }

                System.out.println(wordCount + " word(s) found");
                fileReader.close();
                System.out.println("Data Loaded.");
            } catch (Exception e) {
                System.out.println("Error reading file.");
            }
        }
    }
}
