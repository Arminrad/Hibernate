package hibernate;

import lombok.*;

import javax.persistence.*;

@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "findAll",
                query = "FROM hibernate.Contact"  // hql string
        ),
        @org.hibernate.annotations.NamedQuery(
                name = "findById",
                query = "FROM hibernate.Contact c WHERE c.id = :id"
        ),
        @org.hibernate.annotations.NamedQuery(
                name = "findByFirstName",
                query = "FROM hibernate.Contact c WHERE c.firstName = :firstName"
        )
})
@org.hibernate.annotations.NamedNativeQueries({
        @org.hibernate.annotations.NamedNativeQuery(
                name = "nativeFindAll",
                query = "SELECT * FROM contact" // sql
        )
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremented id in postgre
    private Long id;

    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(length = 500)
    private String address;
}
