package org.example.question1;

public class StudentUtil {
    /**
     * calculateGPA function calculates the GPA of a student based on their grades
     *
     * @param studentIdList
     * @param studentsGrades
     * @return an array of double with the calculated GPAs
     * @throws MissingGradeException
     */
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException{
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }
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
                else if (c == ' ') {
                    throw new MissingGradeException(studentIdList[counter]);
                }
            }
            double gpa = (double)totalScore/row.length;
            studentGpa[counter] = gpa ;
            counter++;
        }
        return studentGpa;
    }

    /**
     * getStudentsByGPA function finds the students whose GPA is between the lower and the higher limit
     *
     * @param lower
     * @param higher
     * @param studentIdList
     * @param studentsGrades
     * @return an array of integer
     * @throws MissingGradeException
     */
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
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
