package be.positive.calculator.positivesplitcalculator.mapper;

import be.positive.calculator.positivesplitcalculator.entity.TypeCurveEntity;
import be.positive.calculator.positivesplitcalculator.record.TypeCurveRecord;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class TypeCurveEntityRecordMapper {

    private final EntityRecordMapper entityRecordMapper;

    public TypeCurveEntityRecordMapper() {
        this.entityRecordMapper = new EntityRecordMapper();
    }

    public void mapEntityRecord(TypeCurveEntity typeCurveEntity, TypeCurveRecord typeCurveRecord) {
        entityRecordMapper.map(typeCurveEntity, typeCurveRecord);
    }

    public void mapRecordEntity( TypeCurveRecord typeCurveRecord, TypeCurveEntity typeCurveEntity) {
        entityRecordMapper.map(typeCurveRecord, typeCurveEntity);
    }


    static class EntityRecordMapper extends ConfigurableMapper {
        protected void configure(MapperFactory factory) {
            factory.classMap(TypeCurveEntity.class, TypeCurveRecord.class)
                    .byDefault().register();
        }
    }

}
