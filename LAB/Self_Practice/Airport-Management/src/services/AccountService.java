package services;

import java.util.List;

import entity.Account;
import repository.AccountRepository;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        if (accountRepository.findById(account.getId()) != null) {
            System.out.println("Account with id " + account.getId() + "exist!");
            return;
        }

        System.out.print("Enter id: ");
        account.setId();

        accountRepository.save(account);
        System.out.println("Account created successfully: " + account);

    }

    public List<Account> listAccounts() {
        return accountRepository.listAll();
    }
}
