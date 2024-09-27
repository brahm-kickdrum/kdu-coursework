package org.example;

import org.example.ReadFile;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]){

        ArrayList<Player> playerArray = new ArrayList<>();
        String iplDataPath = "src/main/resources/IPLdata.csv";
        ReadFile reader = new ReadFile();
        playerArray = reader.readPlayerCsv(iplDataPath);


        reader.playersWithAtleast40Wickets(playerArray,"RCB");

        reader.highestWicketTaker(playerArray,"RCB");
        reader.highestRunScorer(playerArray,"RCB");
        reader.topThreeRunScorer(playerArray);
        reader.topThreeWicketTakers(playerArray);
    }


}

