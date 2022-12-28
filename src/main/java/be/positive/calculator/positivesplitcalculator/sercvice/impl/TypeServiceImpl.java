package be.positive.calculator.positivesplitcalculator.sercvice.impl;

import be.positive.calculator.positivesplitcalculator.entity.TypeCurveEntity;
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

    public TypeServiceImpl(TypeRepository typeRepository, TypeCurveEntityRecordMapper typeCurveEntityRecordMapper) {
        this.typeRepository = typeRepository;
        this.typeCurveEntityRecordMapper = typeCurveEntityRecordMapper;
    }


    @Override
    public List<TypeCurveEntity> getAllTypeCurves() {
        return mapToEntities(typeRepository.findAll());
    }

    private List<TypeCurveEntity> mapToEntities(List<TypeCurveRecord> typeCurveRecords) {
        TypeCurveEntity typeCurveEntity;
        List <TypeCurveEntity> typeCurveEntities = new ArrayList<>();
        for (TypeCurveRecord typeCurveRecord: typeCurveRecords
             ) {
            typeCurveEntity = new TypeCurveEntity();
            typeCurveEntityRecordMapper.mapRecordEntity(typeCurveRecord, typeCurveEntity);
            typeCurveEntities.add(typeCurveEntity);
        }
        return typeCurveEntities;
    }
}
