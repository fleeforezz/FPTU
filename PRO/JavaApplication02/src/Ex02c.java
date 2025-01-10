
/**
 *
 * @author jso
 */
public class Ex02c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean check = 5 >= 4;
        System.out.println(check);

        check = ((5 >= 4) && (15 % 2 == 0));
        System.out.println(check);

        int x = 100;
        System.out.println((x % 2 == 0) ? "Chan" : "le");

//        String ketQua = "";
//        if (x%2==0) {
//            ketQua = "chan";
//        } else {
//            ketQua = "le";
//        }
//        
//        ketQua = (x%2==0)?"chan":"le";
    }
}
