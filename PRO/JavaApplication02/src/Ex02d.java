
/**
 *
 * @author jso
 */
public class Ex02d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a = 4;
        double b = 12;
        double c = 6;

        double delta, x1, x2;

        // Tính delta
        delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("Phuong trinh vo nghiem!");
        } else if (delta == 0) {
            x1=x2=-b/(2*a);
            System.out.println("Phuong trinh co nghiem kep x1=x2=");
        } else {
            x1 = (-b+Math.sqrt(delta)/(2*a));
            x2 = (-b+Math.sqrt(delta)/(2*a));
            System.out.println("Phuong trinh co 2 nghiem");
            System.out.println("x1=" + x1);
            System.out.println("x2=" + x2);
        }
    }
}
