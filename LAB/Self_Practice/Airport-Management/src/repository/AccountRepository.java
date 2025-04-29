package repository;

import java.util.List;

import entity.Account;

public interface AccountRepository {
    Account findById(String id);
    List<Account> listAll();
    void save(Account account);
    void update(Account account);
    void delete(String name);
}
