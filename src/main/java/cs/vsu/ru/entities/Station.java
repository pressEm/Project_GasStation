package cs.vsu.ru.entities;


import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stations", schema = "public")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_id")
    int stat_id;

    @Column(name = "address")
    @NotEmpty(message = "Station address can not be empty")
    @Size(max = 100, message = "Station address should be between 1 an 100 characters")
    String address;

    public Station() {}

    public int getStat_id() {
        return stat_id;
    }

    public String getAddress() {
        return address;
    }

    public void setStat_id(int stat_id) {
        this.stat_id = stat_id;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
