package cs.vsu.ru.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "requests", schema = "public")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id")
    int req_id;


    @Column(name = "V")
    @NotEmpty(message = "V can not be empty")
//    @Size(max = 100, message = "Name length should be between 1 an 100 characters")
    private int V;


    @Column(name = "mark")
    @NotEmpty(message = "Mark can not be empty")
//    @Size(max = 100, message = "Name length should be between 1 an 100 characters")
    private int mark;

    @Column(name = "t_proc")
//    @NotEmpty(message = "Mark can not be empty")
//    @Size(max = 100, message = "Name length should be between 1 an 100 characters")
    private String t_proc;

    @NotEmpty(message = "Date  can not be empty")
    @Column(name = "date_")
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "car_id")
    @NotNull(message = "Car_id can not be empty")
    private Car car_id;

    @ManyToOne()
    @JoinColumn(name = "gas_stat_id")
    @NotNull(message = "Gas_stat_id can not be empty")
    private GasStation gas_stat_id;

    public int getReq_id() {
        return req_id;
    }

    public int getV() {
        return V;
    }

    public int getMark() {
        return mark;
    }

    public String getT_proc() {
        return t_proc;
    }

    public Date getDate() {
        return date;
    }

    public Car getCar_id() {
        return car_id;
    }

    public GasStation getGas_stat_id() {
        return gas_stat_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public void setV(int v) {
        V = v;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setT_proc(String t_proc) {
        this.t_proc = t_proc;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCar_id(Car car_id) {
        this.car_id = car_id;
    }

    public void setGas_stat_id(GasStation gas_stat_id) {
        this.gas_stat_id = gas_stat_id;
    }
}
