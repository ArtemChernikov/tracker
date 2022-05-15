package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает банковский сервис
 * Используются классы {@link Account} и {@link User}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.2
 */
public class BankService {
    /**
     * Поле - список пользователей(Ключ - пользватель,
     * значение - список банковских счетов пользователя) <b>users</b>
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляющий нового пользователя в список(если такого пользователя нет)
     *
     * @param user - пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляющий аккаунт пользователя (если такого аккаунта у пользователя еще нет)
     *
     * @param passport - паспорт
     * @param account  - аккаунт
     */
    public void addAccount(String passport, Account account) {
        Optional<User> newUser = findByPassport(passport);
        if (newUser.isPresent()) {
            if (!users.get(newUser.get()).contains(account)) {
                users.get(newUser.get()).add(account);
            }
        }
    }

    /**
     * Метод для поиска пользователя в списке {@link BankService#users} по паспорту
     *
     * @param passport - паспорт
     * @return возвращает найденного пользователя, если таковой не найден, возвращает null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод для поиска аккаунта по имени пользователя и реквизитам
     *
     * @param passport  - паспорт
     * @param requisite - реквизиты
     * @return возвращает найденный аккаунт пользователя, если такового нет, возвращает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value).stream()
                .filter(x -> x.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод для перевода средств другому лицу
     *
     * @param srcPassport   - паспорт делающего перевод
     * @param srcRequisite  - реквизиты делающего перевод
     * @param destPassport  - паспорт получателя перевода
     * @param destRequisite - реквизиты получателя перевода
     * @param amount        - сумма перевода
     * @return возвращает true, если перевод осуществлен, false в противному случае
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
