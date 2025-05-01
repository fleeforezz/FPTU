package services;

import java.util.List;
import java.util.Scanner;

import entity.Account;
import repository.AccountRepository;

public class AccountService {

    Scanner sc = new Scanner(System.in);

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        if (accountRepository.findById(account.getId()) != null) {
            System.out.println("Account with id " + account.getId() + "exist!");
            return;
        }

        System.out.print("Enter account Id: ");
        account.setId(sc.nextLine());

        System.out.print("Enter account Name: ");
        account.setName(sc.nextLine());
        
        System.out.print("Enter account Password: ");
        account.setPassword(sc.nextLine());

        System.out.print("Enter account Type: ");
        account.setAccountType(sc.nextLine());

        accountRepository.save(account);
        System.out.println("Account created successfully: " + account);

    }

    public List<Account> listAccounts() {
        return accountRepository.listAll();
    }
}
