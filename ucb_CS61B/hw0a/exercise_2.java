public class exercise_2 {
        public static int max(int[] m) {
            /** Returns the maximum value from m. */
            int maxValue = 0;
            for (int i = 0; i<m.length; i++){
                if (m[i] > maxValue){
                    maxValue = m[i];
                } 
            }
            return maxValue;
        }
        public static void main(String[] args) {
           int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};  
           int maxNumber = max(numbers);
           System.out.println("The maxinmum is " + maxNumber + ".");
        }
    } 

