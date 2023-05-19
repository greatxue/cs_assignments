public class exercise_3 {
    public static int forMax(int[] m) {
        /** Returns the maximum value from m using a for loop. */
        int max = 0;
        for (int i = 0; i < m.length; i += 1){
            if (m[i] > max){
                max = m[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
        System.out.println("The maximum is: " + forMax(numbers));
    }
}