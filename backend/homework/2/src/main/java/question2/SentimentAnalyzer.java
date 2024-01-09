package question2;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SentimentAnalyzer {

    private static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzer.class);
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];

        for (int i = 0; i < featureSet.length; i++) {
            String[] features = featureSet[i];
            for (String feature : features) {
                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    break;
                }
            }
        }

        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return opinion;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        if (review.contains(pattern)) {
            for (String posWord : posOpinionWords) {
                if (review.contains(pattern + posWord)) {
                    opinion = 1;
                    break;
                }
            }
            for (String negWord : negOpinionWords) {
                if (review.contains(pattern + negWord)) {
                    opinion = -1;
                    break;
                }
            }
        }

        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        String[] sentences = review.split("\\.");
        int opinion = 0;

        for (String sentence : sentences) {
            for (String posWord : posOpinionWords) {
                if (sentence.contains(posWord + " " + feature)) {
                    opinion = 1; // Positive opinion
                    break;
                }
            }
            for (String negWord : negOpinionWords) {
                if (sentence.contains(negWord + " " + feature)) {
                    opinion = -1; // Negative opinion
                    break;
                }
            }
        }

        return opinion;
    }

    public static void main(String[] args) {
        String review = "Haven't been here in years! fantastic service and the food was delicious! Definitely will be a frequent flyer! Francisco was very attentive";
//        String review = "sorry OG, but you just lost some loyal customers. horrible waiter, no smile or greeting just attitude. The bread sticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" }
        };

        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };
        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        logger.info("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}
