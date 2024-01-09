package org.example;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] studentGpa = new double[studentIdList.length];
        int counter = 0;
        for (char[] row : studentsGrades) {
            int totalScore = 0;
            for (char c : row) {
                if (c == 'A') {
                    totalScore = totalScore + 4;
                }
                else if (c == 'B') {
                    totalScore = totalScore + 3;
                }
                else if (c == 'C') {
                    totalScore = totalScore + 2;
                }
            }
            double gpa = (double)totalScore/row.length;
            studentGpa[counter] = gpa ;
            counter++;
        }
        return studentGpa;
    }
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        double[] studentGpa = calculateGPA(studentIdList,studentsGrades);
        int arrSize = 0;
        for(double j : studentGpa){
            if(j<higher && j>lower){
                arrSize++;
            }
        }
        int[] studentsInRange = new int[arrSize];
        int counter = 0;
        for(int i=0;i<studentGpa.length;i++){
            if(studentGpa[i]<higher && studentGpa[i]>lower){
                studentsInRange[counter] = studentIdList[i];
                counter++;
            }
        }
        return studentsInRange;
    }
}
