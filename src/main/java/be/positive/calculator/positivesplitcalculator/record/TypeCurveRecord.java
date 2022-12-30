package be.positive.calculator.positivesplitcalculator.record;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "type_curves")
public class TypeCurveRecord {

    @Id
    @Column(name = "pk_type_curve_id")
    //TO FOLLOW: https://stackoverflow.com/questions/2595124/how-does-the-jpa-sequencegenerator-annotation-work
    //https://vladmihalcea.com/jpa-entity-identifier-sequence/
    @GeneratedValue(generator="pk_type_curve_id_seq")
    @SequenceGenerator(name="pk_type_curve_id_seq",sequenceName="pk_type_curve_id_seq", allocationSize=1)
    private Long pkTypeCurveId;

    @Column(name = "name_type_curve")
    private String nameTypeCurve;
    @Column(name = "formula")
    private String formula;

    @OneToMany
    @JoinColumn(name = "fk_type_curve_id")
    private List<RunRecord> runRecords;

    public TypeCurveRecord() {
    }

    public TypeCurveRecord(String nameTypeCurve, String formula) {
        this.nameTypeCurve = nameTypeCurve;
        this.formula = formula;
    }

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
