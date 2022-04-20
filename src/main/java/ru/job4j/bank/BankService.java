package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс банковского сервиса с полем, поле - список пользователей(Ключ - пользватель,
 * значение - список банковских счетов пользователя) <b>users</b>.
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляющий нового пользователя в список(если такого пользователя нет).
     * @param user - пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляющий аккаунт пользователя (если такого аккаунта у пользователя еще нет).
     * @param passport - паспорт
     * @param account - аккаунт
     */
    public void addAccount(String passport, Account account) {
        User newUser = findByPassport(passport);
        if (newUser != null) {
            if (!users.get(newUser).contains(account)) {
                users.get(newUser).add(account);
            }
        }
    }

    /**
     * Метод для поиска пользователя в списке {@link BankService#users} по паспорту
     * @param passport - паспорт
     * @return возвращает найденного пользователя, если таковой не найден, возвращает null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод для поиска аккаунта по имени пользователя и реквизитам
     * @param passport - паспорт
     * @param requisite - реквизиты
     * @return возвращает найденный аккаунт пользователя, если такового нет, возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account account : list) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод для перевода средств другому лицу
     * @param srcPassport - паспорт делающего перевод
     * @param srcRequisite - реквизиты делающего перевод
     * @param destPassport - паспорт получателя перевода
     * @param destRequisite - реквизиты получателя перевода
     * @param amount - сумма перевода
     * @return возвращает true, если перевод осуществлен, false в противному случае
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
