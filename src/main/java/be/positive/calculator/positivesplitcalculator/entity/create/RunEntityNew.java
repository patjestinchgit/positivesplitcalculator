package be.positive.calculator.positivesplitcalculator.entity.create;

import be.positive.calculator.positivesplitcalculator.entity.adapt.TypeCurveEntityCreated;
import lombok.*;

@Data
@NoArgsConstructor
public class RunEntityNew {
    private String name;
    private Double totalDistance;
    private int amountSplits;
    private int totalTimeRunSeconds;
    private String formula;
    private TypeCurveEntityCreated typeCurveEntityCreated;
}
