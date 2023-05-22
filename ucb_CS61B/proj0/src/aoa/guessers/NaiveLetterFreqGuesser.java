package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NaiveLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public NaiveLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Makes a guess which ignores the given pattern. */
    public char getGuess(String pattern, List<Character> guesses) {
        return getGuess(guesses);
    }

    /** Returns a map from a given letter to its frequency across all words.
     *  This task is similar to something you did in hw0b! */
    public Map<Character, Integer> getFrequencyMap() {
        // TODO: Fill in this method.
        Map<Character, Integer> frequencyMap = new HashMap();
        for (char c = 'a'; c <= 'z'; c++) {
            int num = 0;
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    char letter = word.charAt(i);
                    if (letter == c) {
                        num++;
                        frequencyMap.put(c, num);
                    }
                }
            }
        }
        return frequencyMap;
    }

    /** Returns the most common letter in WORDS that has not yet been guessed
     *  (and therefore isn't present in GUESSES). */
    public char getGuess(List<Character> guesses) {
        // TODO: Fill in this method.
        Map<Character, Integer> frequencyMap = getFrequencyMap();
        if (frequencyMap.isEmpty()){
            return '?';
        }
        TreeMap<Character, Integer> sortedMap = new TreeMap<>(frequencyMap);
        for (Character ch: guesses){
            sortedMap.remove(ch);
        }
        int maxFrequency = 0;
        char getguess = '?';
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()){
            char c = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxFrequency){
                maxFrequency = frequency;
                getguess = c;
            }
        }
        return getguess;
    }

    public static void main(String[] args) {
        NaiveLetterFreqGuesser nlfg = new NaiveLetterFreqGuesser("data/example.txt");
        System.out.println("list of words: " + nlfg.words);
        System.out.println("frequency map: " + nlfg.getFrequencyMap());

        List<Character> guesses = List.of('e', 'l');
        System.out.println("guess: " + nlfg.getGuess(guesses));
    }
}
