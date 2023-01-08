package be.positive.calculator.positivesplitcalculator.sercvice.impl;

import be.positive.calculator.positivesplitcalculator.entity.adapt.TypeCurveEntityCreated;
import be.positive.calculator.positivesplitcalculator.entity.create.TypeCurveEntityNew;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveAllReadyExists;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveDoesNotExistsException;
import be.positive.calculator.positivesplitcalculator.mapper.RunRecordDTOMapper;
import be.positive.calculator.positivesplitcalculator.mapper.TypeCurveEntityRecordMapper;
import be.positive.calculator.positivesplitcalculator.record.TypeCurveRecord;
import be.positive.calculator.positivesplitcalculator.repository.TypeRepository;
import be.positive.calculator.positivesplitcalculator.sercvice.TypeService;
import be.positive.calculator.positivesplitcalculator.utils.Utility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

	private final TypeRepository typeRepository;
	private final TypeCurveEntityRecordMapper typeCurveEntityRecordMapper;
	private final RunRecordDTOMapper runRecordDTOMapper;

	public TypeServiceImpl(TypeRepository typeRepository, TypeCurveEntityRecordMapper typeCurveEntityRecordMapper, RunRecordDTOMapper runRecordDTOMapper) {
		this.typeRepository = typeRepository;
		this.typeCurveEntityRecordMapper = typeCurveEntityRecordMapper;
		this.runRecordDTOMapper = runRecordDTOMapper;
	}


	@Override
	public List<TypeCurveEntityCreated> getAllTypeCurves() {
		return mapToEntities(typeRepository.findAll());
	}

	@Override
	public TypeCurveEntityCreated createCurveEntity(TypeCurveEntityNew typeCurveEntityNew) throws TypeCurveAllReadyExists {
		TypeCurveEntityCreated typeCurveNewEntity = new TypeCurveEntityCreated();
		typeRepository.save(new TypeCurveRecord(typeCurveEntityNew.getNameTypeCurve(), typeCurveEntityNew.getFormula()));
		typeCurveEntityRecordMapper.mapRecordEntity(typeRepository.findByNameTypeCurveAndFormula(typeCurveEntityNew.getNameTypeCurve(), typeCurveEntityNew.getFormula()), typeCurveNewEntity);
		return typeCurveNewEntity;
	}

	@Override
	public void deleteCurveEntity(TypeCurveEntityCreated typeCurveEntityCreated) {
		TypeCurveRecord typeCurveRecord = typeRepository.findByNameTypeCurveAndFormula(typeCurveEntityCreated.getNameTypeCurve(), typeCurveEntityCreated.getFormula());
		if(typeCurveRecord != null) {
			typeRepository.delete(typeCurveRecord);
		}

	}

	@Override
	public TypeCurveEntityCreated getCurveEntityById(Long id) {
		TypeCurveEntityCreated typeCurveEntityCreated = new TypeCurveEntityCreated();
		if(id != null) {
			typeCurveEntityRecordMapper.mapRecordEntity(typeRepository.findById(id).orElseThrow(TypeCurveDoesNotExistsException::new), typeCurveEntityCreated);
		}

		return typeCurveEntityCreated;
	}

	@Override
	public void adaptCurveEntity(TypeCurveEntityCreated typeCurveEntityCreated) {
		TypeCurveRecord typeCurveRecord = new TypeCurveRecord();
		typeCurveEntityRecordMapper.mapEntityRecord(typeCurveEntityCreated, typeCurveRecord);
		if(typeCurveRecord.getPkTypeCurveId() == null || !typeRepository.runEntityRecordExists(typeCurveEntityCreated.getPkTypeCurveId())) {
			throw new TypeCurveDoesNotExistsException("You try to replace a not existing runentity");
		}
		else {
			typeRepository.save(typeCurveRecord);
		}

	}

	@Override
	public boolean checkTypeExists(TypeCurveEntityNew typeCurveEntityNew) {
		return typeRepository.existsByNameTypeCurveOrFormula(typeCurveEntityNew.getNameTypeCurve(), typeCurveEntityNew.getFormula());
	}

	@Override
	public boolean checkTypeUsedByRunEntity(TypeCurveEntityNew typeCurve) {
		return typeRepository.findByNameTypeCurveAndFormula(typeCurve.getNameTypeCurve(), typeCurve.getFormula()).getRunRecords().isEmpty();
	}

	@Override
	public List<TypeCurveEntityCreated> searchByTypeCurveNameOrFormula(String typeCurveName, String formula) {
		List<TypeCurveRecord> typeCurveRecordList;
		if(StringUtils.isEmpty(typeCurveName) && StringUtils.isNoneEmpty(formula)) {
			typeCurveRecordList = typeRepository.searchTypeCurveRecordsByFormulaLikeIgnoreCase(
					Utility.convertNullEmptyToSomethingOrLowerCaseAndTrim(formula));
		}
		else if(StringUtils.isEmpty(formula) && StringUtils.isNoneEmpty(typeCurveName)) {
			typeCurveRecordList = typeRepository.searchTypeCurveRecordsByNameTypeCurveLikeIgnoreCase(
					Utility.convertNullEmptyToSomethingOrLowerCaseAndTrim(typeCurveName));
		}
		else {
			typeCurveRecordList = typeRepository.searchTypeCurveRecordsByNameTypeCurveLikeIgnoreCaseOrFormulaLikeIgnoreCase(
					Utility.convertNullEmptyToSomethingOrLowerCaseAndTrim(typeCurveName),
					Utility.convertNullEmptyToSomethingOrLowerCaseAndTrim(formula));
		}
		return mapToEntities(typeCurveRecordList);
	}

	private List<TypeCurveEntityCreated> mapToEntities(List<TypeCurveRecord> typeCurveRecords) {
		TypeCurveEntityCreated typeCurveEntityCreated;

		List<TypeCurveEntityCreated> typeCurveEntities = new ArrayList<>();
		for (TypeCurveRecord typeCurveRecord : typeCurveRecords
		) {
			typeCurveEntityCreated = new TypeCurveEntityCreated();
			typeCurveEntityRecordMapper.mapRecordEntity(typeCurveRecord, typeCurveEntityCreated);
			typeCurveEntityCreated.setRunRecordDtoList(runRecordDTOMapper.mappingRunDtoList(typeCurveRecord.getRunRecords()));
			typeCurveEntities.add(typeCurveEntityCreated);
		}
		return typeCurveEntities;
	}




}
