package org.example;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import question2.SentimentAnalyzer;

import java.util.Arrays;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzer.class);
    public static void main(String[] args) {
        int[] studentIdList = {1001, 1002};
        char[][] studentsGrades = {
                {'A', 'A', 'A', 'B'},
                {'A', 'B', 'B'}
        };

        double[] gpas = StudentUtil.calculateGPA(studentIdList, studentsGrades);
        logger.info("GPAs: " + Arrays.toString(gpas));

        double lower = 3.2;
        double higher = 3.5;
        int[] selectedStudents = StudentUtil.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);
        logger.info("Selected Students: " + Arrays.toString(selectedStudents));
    }
}
