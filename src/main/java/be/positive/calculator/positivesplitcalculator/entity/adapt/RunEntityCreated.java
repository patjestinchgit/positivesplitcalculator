package be.positive.calculator.positivesplitcalculator.entity.adapt;

import be.positive.calculator.positivesplitcalculator.entity.create.RunEntityNew;
import lombok.Data;

@Data
public class RunEntityCreated extends RunEntityNew {
    private TypeCurveEntityCreated typeCurveEntityCreated;

}
