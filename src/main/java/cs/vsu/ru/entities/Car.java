package cs.vsu.ru.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cars", schema = "public")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    int car_id;

    @Column(name = "model")
    @NotEmpty(message = "Model can not be empty")
    @Size(max = 100, message = "Model should be between 1 an 100 characters")
    String model;

    @Column(name = "num")
    @NotEmpty(message = "Car num can not be empty")
    @Size(max = 100, message = "Car num should be between 1 an 20 characters")
    String num;

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    @NotNull(message = "Owner_id can not be empty")
    private Owner owner_id;

    public Car() {}

    public int getCar_id() {
        return car_id;
    }

    public String getModel() {
        return model;
    }

    public String getNum() {
        return num;
    }

    public Owner getOwner_id() {
        return owner_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setOwner_id(Owner owner_id) {
        this.owner_id = owner_id;
    }
}
