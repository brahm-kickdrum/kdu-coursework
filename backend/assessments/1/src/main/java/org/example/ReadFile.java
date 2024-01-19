package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.compare;

public class ReadFile {
    public static ArrayList<Player> playerArray = new ArrayList<>();
    public ArrayList<Player> readPlayerCsv(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Player player = createPlayerFromData(data);
                playerArray.add(player);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return playerArray;
    }

    private static Player createPlayerFromData(String[] data) {
        Player player = new Player();

        player.setName(data[0]);
        player.setTeam(data[1]);
        player.setRole(data[2]);
        try {
            player.setMatches(Integer.parseInt(data[3]));
        } catch (NumberFormatException e) {
            player.setMatches(0);
        }
        try {
            player.setRuns(Integer.parseInt(data[4]));
        } catch (NumberFormatException e) {
            player.setRuns(0);
        }
        try {
            player.setAverage(Double.parseDouble(data[5]));
        } catch (NumberFormatException e) {
            player.setAverage(0.0);
        }
        try {
            player.setSr(Double.parseDouble(data[6]));
        } catch (NumberFormatException e) {
            player.setSr(0.0);
        }
        try {
            player.setWickets(Integer.parseInt(data[7]));
        } catch (NumberFormatException e) {
            player.setWickets(0);
        }

        return player;
    }

    public void playersWithAtleast40Wickets(List<Player> playerArray, String team){
        playerArray.stream().filter(player -> player.getTeam().equals(team)).filter(player -> player.getWickets()>=40)
                .forEach(p-> LoggerFile.logInfo("Player Name : " + p.getName()));
    }
    public void highestWicketTaker(List<Player> playerArray, String team){
        playerArray.stream().filter(player -> player.getTeam().equals(team))
                .sorted((p1,p2)->{
                    if(p2.getWickets()> p1.getWickets()){
                        return 1;
                    }
                    else if(p2.getWickets()<p1.getWickets()){
                        return -1;
                    }
                    else return 0;
                })
                .limit(1).forEach(p-> LoggerFile.logInfo("Highest wicket taker is " + p.getName() + " with " + p.getWickets() + " wickets"));

    }
    public void highestRunScorer(List<Player> playerArray, String team){
        playerArray.stream().filter(player -> player.getTeam().equals(team))
                .sorted((p1,p2)->{
                    if(p2.getRuns()> p1.getRuns()){
                        return 1;
                    }
                    else if(p2.getRuns()<p1.getRuns()){
                        return -1;
                    }
                    else return 0;
                })
                .limit(1).forEach(p-> LoggerFile.logInfo("Highest run scorer is " + p.getName() + " with " + p.getRuns() + " runs"));

    }
    public void topThreeRunScorer(List<Player> playerArray){
        playerArray.stream()
                .sorted((p1,p2)->{
                    if(p2.getRuns()> p1.getRuns()){
                        return 1;
                    }
                    else if(p2.getRuns()<p1.getRuns()){
                        return -1;
                    }
                    else return 0;
                })
                .limit(3).forEach(p-> LoggerFile.logInfo(p.getName() + "has "+ p.getRuns() + " runs"));
    }
    public void topThreeWicketTakers(List<Player> playerArray){
        playerArray.stream()
                .sorted((p1,p2)->{
                    if(p2.getWickets()> p1.getWickets()){
                        return 1;
                    }
                    else if(p2.getWickets()<p1.getWickets()){
                        return -1;
                    }
                    else return 0;
                })
                .limit(3).forEach(p-> LoggerFile.logInfo(p.getName() + "has " + p.getWickets() + " wickets"));

    }
}
