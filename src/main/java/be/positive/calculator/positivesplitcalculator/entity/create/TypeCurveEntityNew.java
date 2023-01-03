package be.positive.calculator.positivesplitcalculator.entity.create;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TypeCurveEntityNew {

    private String nameTypeCurve;
    private String formula;

    public TypeCurveEntityNew(String nameTypeCurve, String formula) {
        this.nameTypeCurve = nameTypeCurve;
        this.formula = formula;
    }
}
