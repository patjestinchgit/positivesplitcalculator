package be.positive.calculator.positivesplitcalculator.entity;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.List;

@Data
@Table
@NoArgsConstructor
public class TypeCurveEntity {
    private Long pkTypeCurveId;
    private String nameTypeCurve;
    private String formula;
    private List<RunRecordDto> runRecordDtoList;

    public TypeCurveEntity(String nameTypeCurve, String formula) {
        this.nameTypeCurve = nameTypeCurve;
        this.formula = formula;
    }
}
