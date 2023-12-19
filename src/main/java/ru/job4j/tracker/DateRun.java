package ru.job4j.tracker;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TimeZone;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 31.10.2023
 */
public class DateRun {
    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf
                    .withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("Europe/Moscow"))
                    .openSession();
            session.beginTransaction();
            var item = new Item();
            item.setName("check timezone");
            item.setCreated(LocalDateTime.now());
            session.persist(item);
            session.getTransaction().commit();
            session.close();
            var stored = session.createQuery(
                    "from Item", Item.class
            ).list();
            for (Item it : stored) {
                var time = it.getCreated().atZone(
                        ZoneId.of("UTC+3")
                ).withZoneSameInstant(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd"));
                ZonedDateTime zonedDateTime = it.getCreated().atZone(ZoneId.of("UTC+3")).withZoneSameInstant(ZoneId.of("UTC"));
                System.out.println(zonedDateTime);

                var zones = new ArrayList<TimeZone>();
                for (String timeId : TimeZone.getAvailableIDs()) {
                    zones.add(TimeZone.getTimeZone(timeId));
                }
                for (TimeZone zone : zones) {
                    System.out.println(zone.getID() + " : " + zone.getDisplayName());
                }
                System.out.println(time);
                System.out.println(TimeZone.getDefault().getID());
                System.out.println(LocalDateTime.now().atZone(ZoneId.of("UTC")));
                System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC")));
                System.out.println(it.getCreated().atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("UTC")));
                System.out.println(LocalDateTime.now(ZoneId.of("UTC")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
