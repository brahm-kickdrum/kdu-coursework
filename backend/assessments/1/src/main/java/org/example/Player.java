package org.example;

public class Player {

    private String name;
    private String team;
    private String role;
    private int matches;
    private int runs;
    private double average;
    private double sr;
    private int wickets;

    public Player(){}

    public Player(String name, String team, String role, int matches, double average, double sr, int wickets){
        this.name = name;
        this.team = team;
        this.role = role;
        this.matches = matches;
        this.average = average;
        this.sr = sr;
        this.wickets = wickets;

    }
    public String getName(){
        return this.name;
    }
    public String getRole(){
        return this.role;
    }
    public String getTeam(){
        return this.team;
    }
    public int getMatches(){
        return this.matches;
    }
    public int getRuns(){
        return this.runs;
    }
    public double getAverage(){
        return this.average;
    }
    public double getSr(){
        return this.sr;
    }
    public int getWickets(){
        return this.wickets;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setTeam(String team){
        this.team = team;
    }
    public void setRole(String role){
        this.role = role;
    }
    public void setMatches(int matches){
        this.matches = matches;
    }
    public void setRuns(int runs){
        this.runs = runs;
    }
    public void setAverage(double average){
        this.average = average;
    }
    public void setSr(double sr){
        this.sr = sr;
    }
    public void setWickets(int wickets){
        this.wickets = wickets;
    }
}
