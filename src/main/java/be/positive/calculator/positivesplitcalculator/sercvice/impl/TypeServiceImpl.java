package be.positive.calculator.positivesplitcalculator.sercvice.impl;

import be.positive.calculator.positivesplitcalculator.entity.TypeCurveEntity;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveAllReadyExists;
import be.positive.calculator.positivesplitcalculator.mapper.RunRecordDTOMapper;
import be.positive.calculator.positivesplitcalculator.mapper.TypeCurveEntityRecordMapper;
import be.positive.calculator.positivesplitcalculator.record.TypeCurveRecord;
import be.positive.calculator.positivesplitcalculator.repository.TypeRepository;
import be.positive.calculator.positivesplitcalculator.sercvice.TypeService;
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
	public List<TypeCurveEntity> getAllTypeCurves() {
		return mapToEntities(typeRepository.findAll());
	}

	@Override
	public TypeCurveEntity createCurveEntity(TypeCurveEntity typeCurveEntity) throws TypeCurveAllReadyExists {
		TypeCurveEntity typeCurveNewEntity = new TypeCurveEntity();
		typeRepository.save(new TypeCurveRecord(typeCurveEntity.getNameTypeCurve(), typeCurveEntity.getFormula()));
		typeCurveEntityRecordMapper.mapRecordEntity(typeRepository.findByNameTypeCurveAndFormula(typeCurveEntity.getNameTypeCurve(), typeCurveEntity.getFormula()), typeCurveNewEntity);
		return typeCurveNewEntity;
	}

	@Override
	public void deleteCurveEntity(TypeCurveEntity typeCurveEntity) {
		typeRepository.deleteByNameTypeCurveAndFormula(typeCurveEntity.getNameTypeCurve(), typeCurveEntity.getFormula());
	}

	@Override
	public void getCurveEntity(Long id) {

	}

	@Override
	public void adaptCurveEntity(Long id, String nameTypeCurve, String formula) {

	}

	@Override
	public boolean checkTypeExists(TypeCurveEntity typeCurveEntity) {
		return typeRepository.existsByNameTypeCurveOrFormula(typeCurveEntity.getNameTypeCurve(), typeCurveEntity.getFormula());
	}

	@Override
	public boolean checkTypeUsedByRunEntity(TypeCurveEntity typeCurve) {
		return typeRepository.findByNameTypeCurveAndFormula(typeCurve.getNameTypeCurve(), typeCurve.getFormula()).getRunRecords().isEmpty();
	}

	private List<TypeCurveEntity> mapToEntities(List<TypeCurveRecord> typeCurveRecords) {
		TypeCurveEntity typeCurveEntity;

		List<TypeCurveEntity> typeCurveEntities = new ArrayList<>();
		for (TypeCurveRecord typeCurveRecord : typeCurveRecords
		) {
			typeCurveEntity = new TypeCurveEntity();
			typeCurveEntityRecordMapper.mapRecordEntity(typeCurveRecord, typeCurveEntity);
			typeCurveEntity.setRunRecordDtoList(runRecordDTOMapper.mappingRunDtoList(typeCurveRecord.getRunRecords()));
			typeCurveEntities.add(typeCurveEntity);
		}
		return typeCurveEntities;
	}




}
