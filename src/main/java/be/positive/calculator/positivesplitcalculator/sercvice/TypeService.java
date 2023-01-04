package be.positive.calculator.positivesplitcalculator.sercvice;

import be.positive.calculator.positivesplitcalculator.entity.adapt.TypeCurveEntityCreated;
import be.positive.calculator.positivesplitcalculator.entity.create.TypeCurveEntityNew;
import be.positive.calculator.positivesplitcalculator.exception.RunEntityException;

import java.util.List;

public interface TypeService {
    List<TypeCurveEntityCreated> getAllTypeCurves();
    TypeCurveEntityCreated createCurveEntity(TypeCurveEntityNew typeCurveEntityNew) throws RunEntityException;
    void deleteCurveEntity(TypeCurveEntityCreated typeCurveEntityCreated);
    TypeCurveEntityCreated getCurveEntityById(Long id);
    void adaptCurveEntity(Long id);

    boolean checkTypeExists(TypeCurveEntityNew typeCurveEntityNew);
    boolean checkTypeUsedByRunEntity(TypeCurveEntityNew typeCurve);

    List<TypeCurveEntityCreated> searchByTypeCurveNameOrFormula(String typeCurveName, String formula);
}
