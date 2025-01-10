
import java.util.Arrays;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int temp;
        for (int i = 0; i<a.length; i++) {
            for (int j = i + 1; j<a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    return;
                }
            }
        }
        
        for (int k=3; k<a.length; k++) {
            System.out.println(a[k]);
        }

    }
}
