package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Account;

public class InMemoryAccountRepository implements AccountRepository {

    private List<Account> accountStore = new ArrayList<>();
    private String FILE_LOCATION = "D:\\Cabinet\\Github\\FPTU\\LAB\\Self_Practice\\Airport-Management\\src\\data\\Account.txt";

    public InMemoryAccountRepository() {
        accountStore = listAll();
    }

    @Override
    public Account findById(String id) {
        for (Account account : accountStore) {
            if (account.getId().equals(id)) {
                return account;
            }
        }

        return null;
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_LOCATION))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                String id = fields[0];
                String name = fields[1];
                String password = fields[2];
                String accountType = fields[3];

                list.add(new Account(id, name, password, accountType));
            }
        } catch (IOException e) {
            System.out.println("Error load account from file: " + e.getMessage());
        }

        return list;
    }

    @Override
    public void save(Account account) {
        accountStore.add(account);

        try (FileWriter fw = new FileWriter(FILE_LOCATION, true)) {
            String line = account.getId() + "," + account.getName() + "," +
                            account.getPassword() + "," + account.getAccountType() + "\n";

            fw.write(line);

        } catch (IOException e) {
            System.out.println("Error saving account to file: " + e.getMessage());
        }
    }

    @Override
    public void update(Account account) {
        for (int i = 0; i < accountStore.size(); i++) {
            if (accountStore.get(i).getId().equals(account.getId())) {
                accountStore.set(i, account);
            }
        }
    }

    @Override
    public void delete(String id) {
        accountStore.remove(id);
    }
}
