package cs.vsu.ru.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "owners", schema = "public")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    int owner_id;

    @Column(name = "name")
    @NotEmpty(message = "Name can not be empty")
    @Size(max = 100, message = "Name length should be between 1 an 100 characters")
    private String name;

    @Column(name = "card")
    @NotEmpty(message = "Card can not be empty")
    @Size(max = 100, message = "Card length should be between 1 an 100 characters")
    private String card;

    public int getOwner_id() {
        return owner_id;
    }

    public String getName() {
        return name;
    }

    public String getCard() {
        return card;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
