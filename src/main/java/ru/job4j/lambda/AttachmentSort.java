package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Класс сортировки вложений {@link Attachment}
 * Демонстрируется использование анонимного класса на примере {@link Comparator}
 *
 * @author ARTEM CHERNIKOV
 * @version 1.0
 */
public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator comparatorBySize = new Comparator() {
            /**
             * Переопределение метода {@link Comparator#compare(Object, Object)}
             * для сортировки вложений по возрастанию, по размеру
             * @param o1 - первое вложение
             * @param o2 - второе вложение
             * @return - возвращает int - разницу двух сравниваемых объектов, для сортировки
             */
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        attachments.sort(comparatorBySize);
        System.out.println(attachments);

        Comparator<Attachment> comparatorByName = new Comparator() {
            /**
             * Переопределение метода {@link Comparator#compare(Object, Object)}
             * для сортировки вложений по возрастанию, по имени
             * @param o1 - первое вложение
             * @param o2 - второе вложение
             * @return - возвращает int - разницу двух сравниваемых объектов, для сортировки
             */
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getName().compareTo(right.getName());
            }
        };
    }
}
