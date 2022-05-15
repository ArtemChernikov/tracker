package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Класс описывает медель колледжа со свойством <b>students</b>
 * Используются классы {@link Student} и {@link Subject}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class College {
    /**
     * Поле списка студентов и предметов каждого студента
     */
    private final Map<Student, Set<Subject>> students;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param students - список студентов и предметов
     */
    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    /**
     * Метод описывает поиск аккаунта в списке студентов
     *
     * @param account - искомый аккаунт
     * @return - возвращает студента с искомым аккаунтом
     */
    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод описывает поиск по аккаунту и названию предмета
     *
     * @param account - аккаунт
     * @param name    - название предмета
     * @return - возвращает список предметов
     */
    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = students.get(s.get());
            for (Subject subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}
