import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        if (L.size() > 0) {
            int sum = 0;
            for (int i : L){
                sum = sum + i;
            }
            return sum;
          }
        return 0;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> L_even = new ArrayList<>();
        for (int num: L){
            if (num % 2  == 0){
                L_even.add(num);
            }
        }
        return L_even;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> L_common = new ArrayList<>();
        for (int num1: L1){
            for (int num2: L2){
                if (num1 == num2){
                    L_common.add(num2);
                }
            }
        }
        return L_common;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int num = 0;
        for(String word: words){
            for (int i = 0; i < word.length(); i++){
                char letter = word.charAt(i);
                if (letter == c){
                    num ++;
                }
            }

        }
        return num;
    }
}
