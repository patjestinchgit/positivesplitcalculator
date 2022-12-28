package be.positive.calculator.positivesplitcalculator.entity;

import lombok.*;

@Data
public class RunEntity {

    private String name;
    private Double totalDistance;
    private int amountSplits;
    private int totalTimeRun;
    private TypeCurveEntity typeCurveEntity;
    private int secondsX;

    public RunEntity() {
    }

    public RunEntity(String name, Double totalDistance, int amountSplits, int totalTimeRun, TypeCurveEntity typeCurveEntity, int secondsX) {
        this.name = name;
        this.totalDistance = totalDistance;
        this.amountSplits = amountSplits;
        this.totalTimeRun = totalTimeRun;
        this.typeCurveEntity = typeCurveEntity;
        this.secondsX = secondsX;
    }

}
