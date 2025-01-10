
import java.util.Scanner;

/**
 *
 * @author jso
 */
public class Ex02e {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        int check = 1;

        double delta, x1, x2;

        Scanner sc = new Scanner(System.in);

        do {

            do {
                System.out.print("Enter a =/ 0: ");
                a = sc.nextDouble();
            } while (a == 0);

            System.out.print("Enter b: ");
            b = sc.nextDouble();
            System.out.print("Enter c: ");
            c = sc.nextDouble();

            // Tính delta
            delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Phuong trinh vo nghiem!");
            } else if (delta == 0) {
                x1 = x2 = -b / (2 * a);
                System.out.println("Phuong trinh co nghiem kep x1=x2=");
            } else {
                x1 = (-b + Math.sqrt(delta) / (2 * a));
                x2 = (-b + Math.sqrt(delta) / (2 * a));
                System.out.println("Phuong trinh co 2 nghiem");
                System.out.println("x1=" + x1);
                System.out.println("x2=" + x2);
            }

            System.out.println("Nhap 1 de tiep tuc, nhap 0 de thoat");
            check = sc.nextInt();
        } while (check == 1);
    }
}
