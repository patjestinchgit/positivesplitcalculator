package be.positive.calculator.positivesplitcalculator.entity;

import lombok.Data;

import java.time.LocalTime;

@Data
public class Run {

    private Long id;

    private Double distance;
    private int amountSplits;
    private LocalTime totalTimeRun;
    private TypeCurve typeCurve;

    public Run(Double distance, int amountSplits, LocalTime totalTimeRun) {
        this.distance = distance;
        this.amountSplits = amountSplits;
        this.totalTimeRun = totalTimeRun;
    }

}
