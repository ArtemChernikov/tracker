package ru.job4j.tracker;

import lombok.*;
import ru.job4j.toone.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();
    @ManyToMany
    @JoinTable(name = "participates",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> participates = new ArrayList<>();

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, created: %s", id, name, FORMATTER.format(created));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name) && Objects.equals(created.withNano(0), item.created.withNano(0));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }
}