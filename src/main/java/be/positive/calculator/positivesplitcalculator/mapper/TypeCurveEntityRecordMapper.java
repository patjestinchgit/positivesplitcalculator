package be.positive.calculator.positivesplitcalculator.mapper;

import be.positive.calculator.positivesplitcalculator.entity.adapt.TypeCurveEntityCreated;
import be.positive.calculator.positivesplitcalculator.record.TypeCurveRecord;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class TypeCurveEntityRecordMapper {

    private final EntityRecordMapper entityRecordMapper;
    private final EntityRecordMapperBasicFields entityRecordMapperBasicFields;

    public TypeCurveEntityRecordMapper() {
        this.entityRecordMapper = new EntityRecordMapper();
        this.entityRecordMapperBasicFields = new EntityRecordMapperBasicFields();
    }

    public void mapEntityRecord(TypeCurveEntityCreated typeCurveEntityCreated, TypeCurveRecord typeCurveRecord) {
        entityRecordMapper.map(typeCurveEntityCreated, typeCurveRecord);
    }

    public void mapRecordEntity( TypeCurveRecord typeCurveRecord, TypeCurveEntityCreated typeCurveEntityCreated) {
        entityRecordMapper.map(typeCurveRecord, typeCurveEntityCreated);
    }

    public void mapRecordEntityBasicFields(TypeCurveRecord typeCurveRecord, TypeCurveEntityCreated typeCurveEntityCreated) {
        entityRecordMapperBasicFields.map(typeCurveRecord, typeCurveEntityCreated);
    }


    public static class EntityRecordMapper extends ConfigurableMapper {
        protected void configure(MapperFactory factory) {
            factory.classMap(TypeCurveEntityCreated.class, TypeCurveRecord.class)
                    .byDefault().register();
        }
    }

    public static class EntityRecordMapperBasicFields extends ConfigurableMapper {
        protected void configure(MapperFactory factory) {
            factory.classMap(TypeCurveEntityCreated.class, TypeCurveRecord.class)
                    .exclude("runRecords")
                    .byDefault().register();
        }
    }

}
