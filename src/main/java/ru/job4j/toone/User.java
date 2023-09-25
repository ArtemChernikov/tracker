package ru.job4j.toone;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 25.09.2023
 */
@Data
@EqualsAndHashCode
@Entity
@Table(name = "j_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
