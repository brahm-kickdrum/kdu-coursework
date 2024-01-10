package org.example;

public class Patient extends User {
    private long patientId;

    public Patient(){

    }
    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
}
