package be.positive.calculator.positivesplitcalculator.repository;

import be.positive.calculator.positivesplitcalculator.record.TypeCurveRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<TypeCurveRecord, Long> {
	boolean existsByNameTypeCurveOrFormula(String nameTypeCurve, String formula);
	TypeCurveRecord findByNameTypeCurveAndFormula(String nameTypeCurve, String formula);

	@Query("SELECT T from TypeCurveRecord T where lower(T.nameTypeCurve) like concat('%',:nameTypeCurve,'%') or lower(T.formula) like concat('%',:formula,'%')")
	List<TypeCurveRecord> searchTypeCurveRecordsByNameTypeCurveLikeIgnoreCaseOrFormulaLikeIgnoreCase(@Param("nameTypeCurve") String nameTypeCurve, @Param("formula") String formula);

	@Query("SELECT T from TypeCurveRecord T where lower(T.formula) like concat('%',:formula,'%')")
	List<TypeCurveRecord> searchTypeCurveRecordsByFormulaLikeIgnoreCase(@Param("formula") String formula);

	@Query("SELECT T from TypeCurveRecord T where lower(T.nameTypeCurve) like concat('%',:nameTypeCurve,'%')")
	List<TypeCurveRecord> searchTypeCurveRecordsByNameTypeCurveLikeIgnoreCase(@Param("nameTypeCurve") String nameTypeCurve);
}
