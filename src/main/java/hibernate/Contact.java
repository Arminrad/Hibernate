package hibernate;

import lombok.*;

import javax.persistence.*;

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
