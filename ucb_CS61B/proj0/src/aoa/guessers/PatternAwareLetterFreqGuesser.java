package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.*;

public class PatternAwareLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PatternAwareLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    private List<String> keepOnlyWordsThatMatchPatten(String pattern, List<String> words){
        List<String> matchWords = new ArrayList<>();
        for (String word: words) {
            if (pattern.length() != word.length()) {
                continue;
            }
            boolean matchFlag = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c != '-' && c != pattern.charAt(i)) {
                    matchFlag = false;
                }
            }
            if (matchFlag == true) {
                matchWords.add(word);
            }
        }
        return matchWords;
    }



    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN. */
    public char getGuess(String pattern, List<Character> guesses) {
        // TODO: Fill in this method.
        List<String> matchWords = new ArrayList<>();
        matchWords = keepOnlyWordsThatMatchPatten(pattern, this.words);

    }
    public static void main(String[] args) {
        PatternAwareLetterFreqGuesser palfg = new PatternAwareLetterFreqGuesser("data/example.txt");
        System.out.println(palfg.getGuess("-e--", List.of('e')));
    }
}