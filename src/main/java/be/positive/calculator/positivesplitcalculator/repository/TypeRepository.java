package be.positive.calculator.positivesplitcalculator.repository;

import be.positive.calculator.positivesplitcalculator.record.TypeCurveRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeCurveRecord, Long> {
	boolean existsByNameTypeCurveOrFormula(String nameTypeCurve, String formula);
	TypeCurveRecord findByNameTypeCurveAndFormula(String nameTypeCurve, String formula);
	void deleteByNameTypeCurveAndFormula(String nameTypeCurve, String formula);
}
