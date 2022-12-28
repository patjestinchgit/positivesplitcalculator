package be.positive.calculator.positivesplitcalculator.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@Table
@NoArgsConstructor
public class TypeCurveEntity {

    private String name;
    private String curve;

    public TypeCurveEntity(String name, String curve) {
        this.name = name;
        this.curve = curve;
    }
}
