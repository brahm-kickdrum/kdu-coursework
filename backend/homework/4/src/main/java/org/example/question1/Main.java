package org.example.question1;

import org.example.LoggerFile;

import java.util.Arrays;

public class Main {

    private static final LoggerFile log = new LoggerFile();

    public static void main(String[] args) {
        try {
            int[] studentIdList = {1001, 1002};
            char[][] studentsGrades = {
                    {'A', 'A', 'B'}
            };

            if (studentIdList.length != studentsGrades.length || studentsGrades.length == 0) {
                throw new IllegalArgumentException("Invalid input: Sizes of studentIdList and studentsGrades do not match.");
            }

            double[] gpa = StudentUtil.calculateGPA(studentIdList, studentsGrades);

            log.logInfo("GPAs: " + Arrays.toString(gpa));

            double lower = 3.2;
            double higher = 3.5;
            int[] selectedStudents = StudentUtil.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);
            log.logInfo("Selected Students: " + Arrays.toString(selectedStudents));
        }
        catch (IllegalArgumentException e) {
            log.logError("IllegalArgumentException: " + e.getMessage());
        }
        catch (MissingGradeException e) {
            log.logError("MissingGradeException: " + e.getMessage());
        }
        catch (InvalidDataException e) {
            log.logError("InvalidDataException: " + e.getMessage());
            log.logError("Underlying cause: " + e.getCause().getMessage());
        }
    }
}
