package ua.goit.goitjavadevhw8.model.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "producers")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProducerDao {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO, generator = "uuid")
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @NotBlank(message = "Name may not be blank")
    @Column(name = "name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @OneToMany(mappedBy = "producer")
    @ToString.Exclude
    private Set<ProductDao> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProducerDao producer = (ProducerDao) o;
        return id != null && Objects.equals(id, producer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
