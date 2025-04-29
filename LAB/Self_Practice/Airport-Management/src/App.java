import java.util.Scanner;

import entity.Account;
import repository.InMemoryAccountRepository;
import services.AccountService;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int loginChoice = 0;

        Account account = new Account();

        do {
            System.out.println("1. Login");
            System.out.println("2. SignUp");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            loginChoice = sc.nextInt();

            switch (loginChoice) {
                case 1:
                    System.out.println("Login");

                    AccountService accountService = new AccountService(new InMemoryAccountRepository());

                    accountService.listAccounts();

                    for (Account accountList : accountService.listAccounts()) {
                        System.out.println(accountList);
                    }

                    break;
                case 2:
                    System.out.println("SignUp");

                    AccountService accountService2 = new AccountService(new InMemoryAccountRepository());

                    System.out.print("Enter id: ");
                    account.setId(sc.nextLine());

                    System.out.print("Enter name: ");
                    account.setName(sc.nextLine());

                    System.out.print("Enter password: ");
                    account.setPassword(sc.nextLine());

                    

                    break;
                default:
                    break;
            }

        } while (loginChoice > 0 && loginChoice <= 2);
    }
}
