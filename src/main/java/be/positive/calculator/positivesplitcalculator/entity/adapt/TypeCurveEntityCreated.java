package be.positive.calculator.positivesplitcalculator.entity.adapt;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.entity.create.TypeCurveEntityNew;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TypeCurveEntityCreated extends TypeCurveEntityNew implements Serializable {
    private Long pkTypeCurveId;
    private List<RunRecordDto> runRecordDtoList;

    public TypeCurveEntityCreated(String nameTypeCurve, String formula) {
        super(nameTypeCurve, formula);
    }
}
