package be.positive.calculator.positivesplitcalculator.dto;

import be.positive.calculator.positivesplitcalculator.entity.TypeCurveEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

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
    private TypeCurveEntity typeCurveEntity;
}