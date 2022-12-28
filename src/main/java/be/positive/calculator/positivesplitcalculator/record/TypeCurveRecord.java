package be.positive.calculator.positivesplitcalculator.record;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "type_curves")
public class TypeCurveRecord {

    @Id
    @Column(name = "pk_type_curve_id")
    private Long pkTypeCurveId;

    @Column(name = "name_type_curve")
    private String nameTypeCurve;
    @Column(name = "formula")
    private String formula;

    @OneToMany
    private List<RunRecord> runRecords;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TypeCurveRecord that = (TypeCurveRecord) o;
        return pkTypeCurveId != null && Objects.equals(pkTypeCurveId, that.pkTypeCurveId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
