package br.com.desafiopicpay.domain.user;

import br.com.desafiopicpay.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserTyper userType;

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.secondName = data.secondName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.document = data.document();
        this.password = data.password();
        this.email = data.email();
    }
}
