package cs.vsu.ru.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "gas_stations", schema = "public")
public class GasStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id")
    int col_id;


    @Column(name = "mark")
    @NotEmpty(message = "Name can not be empty")
//    @Size(max = 100, message = "Name length should be between 1 an 100 characters")
    private int mark;

    @ManyToOne()
    @JoinColumn(name = "stat_id")
    @NotNull(message = "Stat_id can not be empty")
    private Station stat_id;

    public int getCol_id() {
        return col_id;
    }

    public int getMark() {
        return mark;
    }

    public Station getStat_id() {
        return stat_id;
    }

    public void setCol_id(int col_id) {
        this.col_id = col_id;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setStat_id(Station stat_id) {
        this.stat_id = stat_id;
    }
}
