package be.positive.calculator.positivesplitcalculator.sercvice.impl;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.entity.RunEntity;
import be.positive.calculator.positivesplitcalculator.entity.TypeCurveEntity;
import be.positive.calculator.positivesplitcalculator.mapper.RunEntityRecordMapper;
import be.positive.calculator.positivesplitcalculator.mapper.RunRecordDTOMapper;
import be.positive.calculator.positivesplitcalculator.mapper.TypeCurveEntityRecordMapper;
import be.positive.calculator.positivesplitcalculator.record.RunRecord;
import be.positive.calculator.positivesplitcalculator.repository.RunRepository;
import be.positive.calculator.positivesplitcalculator.sercvice.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RunServiceImpl implements RunService {
    private final RunRepository runRepository;
    private final RunEntityRecordMapper runEntityRecordMapper;
    private final RunRecordDTOMapper runRecordDTOMapper;
    private final TypeCurveEntityRecordMapper typeCurveEntityRecordMapper;

    @Autowired
    public RunServiceImpl(RunRepository runRepository, RunEntityRecordMapper runEntityRecordMapper, RunRecordDTOMapper runRecordDTOMapper, TypeCurveEntityRecordMapper typeCurveEntityRecordMapper) {
        this.runRepository = runRepository;
        this.runEntityRecordMapper = runEntityRecordMapper;
        this.runRecordDTOMapper = runRecordDTOMapper;
        this.typeCurveEntityRecordMapper = typeCurveEntityRecordMapper;
    }

    public RunRecordDto getRunRecord(Long id) {
        RunRecord runRecord = new RunRecord();
        RunRecordDto runRecordDto = new RunRecordDto();
        TypeCurveEntity typeCurveEntity = new TypeCurveEntity();
        if(Optional.of(runRepository.findById(id)).orElseThrow().isPresent()) {
            runRecord = runRepository.findById(id).get();
        }
        runRecordDTOMapper.mapRecordDto(runRecord, runRecordDto);
        typeCurveEntityRecordMapper.mapRecordEntity(runRecord.getTypeCurveRecord(), typeCurveEntity);
        runRecordDto.setTypeCurveEntity(typeCurveEntity);
        return runRecordDto;
    }

    @Override
    public RunEntity createNewRunRecord(RunEntity runEntity) {
        /* TODO: check if is existing
        *        if not create a new one and save if  database is existing possible*/
        if(!checkExisting(runEntity)) {

        }
        else {

        }
        return null;
    }

    private boolean checkExisting(RunEntity runEntity) {
        for(RunRecord runRecord : runRepository.findAll()) {
            runEntityRecordMapper.mapEntityRecord(runEntity, runRecord);
        }
        return false;
    }

}
