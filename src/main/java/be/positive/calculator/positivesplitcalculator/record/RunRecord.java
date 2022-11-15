package be.positive.calculator.positivesplitcalculator.record;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class RunRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double distance;
    private LocalTime totalTime;
    private Double splitDistance;
    private ArrayList<LocalTime> splitTimes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RunRecord(Double distance, LocalTime totalTime, Double splitDistance, ArrayList<LocalTime> splitTimes) {
        this.distance = distance;
        this.totalTime = totalTime;
        this.splitDistance = splitDistance;
        this.splitTimes = splitTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        RunRecord runRecord = (RunRecord) o;
        return id != null && Objects.equals(id, runRecord.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
