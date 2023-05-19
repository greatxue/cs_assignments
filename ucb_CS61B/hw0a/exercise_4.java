public class exercise_4 {
        public static void windowPosSum(int[] a, int n) {
        /** your code here */
          for (int i = 0; i < a.length; i++){
            if (a[i] < 0){
                continue;
            }
            for (int j = i + 1; j < Math.min(i + n + 1,a.length) ; j++){
              a[i] += a[j]; 
              }
            }
          }
      
        public static void main(String[] args) {
          int[] a = {1, 2, -3, 4, 5, 4};
          int n = 3;
          windowPosSum(a, n);
      
          // Should print 4, 8, -3, 13, 9, 4
          System.out.println(java.util.Arrays.toString(a));
        }
      
}
