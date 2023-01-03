package be.positive.calculator.positivesplitcalculator.dto;

import be.positive.calculator.positivesplitcalculator.entity.adapt.TypeCurveEntityCreated;
import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * A DTO for the {@link be.positive.calculator.positivesplitcalculator.record.RunRecord} entity
 */
@Data
public class RunRecordDto implements Serializable {
    private Long pkRunRecordId;
    private String nameRunRecord;
    private Double distance;
    private int totalTimeSeconds;
    private Double splitDistance;
    private int [] splitTimes;
    @Transient
    private TypeCurveEntityCreated typeCurveEntityCreated;
}
