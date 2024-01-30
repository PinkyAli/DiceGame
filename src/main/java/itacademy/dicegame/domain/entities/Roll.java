package itacademy.dicegame.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roll")
public class Roll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dice1")
    private byte dice1;
    @Column(name = "dice2")
    private byte dice2;
    @Column(name = "win")
    private boolean win;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;
    private final byte winValue = 7;

    public Roll(User user, byte dice1, byte dice2) {
        this.user = user;
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.win = (this.dice1 + this.dice2) == winValue;
        user.getRolls().add(this);
    }


}
