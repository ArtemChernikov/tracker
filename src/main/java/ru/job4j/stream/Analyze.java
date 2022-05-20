package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс который описывает сбор статистики по аттестатам
 * В этом классе используются {@link Subject}, {@link Tuple} и {@link Pupil}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class Analyze {
    /**
     * Метод описывает вычисление общего среднего балла всех учеников
     *
     * @param stream - поток учеников
     * @return - возвращает общий средний балл
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод описывает вычисление среднего балла ученика по его предметам
     *
     * @param stream - поток учеников
     * @return - возвращает список средних баллов каждого ученика в виде {@link Tuple}
     * где {@link Tuple#name} - имя ученика, а {@link Tuple#score} - средний балл по предмету
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод описывает вычисление среднего балла по всем предметам для каждого ученика
     *
     * @param stream - поток учеников
     * @return - возвращает список средних баллов по всем предметам в виде {@link Tuple}
     * где {@link Tuple#name} - название предмета, а {@link Tuple#score} - средний балл по предмету
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод описывает поиск лучшего ученика
     * (лучшим считается ученик с наибольшим баллом по всем предметам)
     *
     * @param stream - поток учеников
     * @return - возвращает объект аттестата лучшего ученика в виде {@link Tuple}
     * где {@link Tuple#name} - имя ученика, а {@link Tuple#score} - сумма баллов по всем предметам ученика
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);

    }

    /**
     * Метод описывает поиск предмета с наибольшим баллом для всех студентов
     *
     * @param stream - поток учеников
     * @return - возвращает предмет с наибольшим баллом для всех студентов в виде {@link Tuple}
     * где {@link Tuple#name} - название предмета, а {@link Tuple#score} - сумма баллов каждого ученика по предмету
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
