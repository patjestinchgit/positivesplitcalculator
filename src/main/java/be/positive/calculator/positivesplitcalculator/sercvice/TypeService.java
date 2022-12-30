package be.positive.calculator.positivesplitcalculator.sercvice;

import be.positive.calculator.positivesplitcalculator.entity.TypeCurveEntity;
import be.positive.calculator.positivesplitcalculator.exception.RunEntityException;

import java.util.List;

public interface TypeService {
    List<TypeCurveEntity> getAllTypeCurves();
    TypeCurveEntity createCurveEntity(TypeCurveEntity typeCurveEntity) throws RunEntityException;
    void deleteCurveEntity(TypeCurveEntity typeCurveEntity);
    void getCurveEntity(Long id);
    void adaptCurveEntity(Long id, String nameTypeCurve, String formula);

    boolean checkTypeExists(TypeCurveEntity typeCurveEntity);
    boolean checkTypeUsedByRunEntity(TypeCurveEntity typeCurve);
}
