package ua.goit.model.dao;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RoleDAO {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @Column(name = "role", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String role;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<UserDAO> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RoleDAO roleDao = (RoleDAO) o;
        return id != null && Objects.equals(id, roleDao.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
