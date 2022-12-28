package be.positive.calculator.positivesplitcalculator.record;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "run_records")
public class RunRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_run_record_id", nullable = false)
    private Long pkRunRecordId;

    @Column(name = "name_run_record")
    private String nameRunRecord;
    @Column(name = "distance")
    private Double distance;
    @Column(name = "total_time_seconds")
    private int totalTimeSeconds;

    @ManyToOne
    @JoinColumn(name = "fk_type_curve_id")
    private TypeCurveRecord typeCurveRecord;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RunRecord runRecord = (RunRecord) o;
        return pkRunRecordId != null && Objects.equals(pkRunRecordId, runRecord.pkRunRecordId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
