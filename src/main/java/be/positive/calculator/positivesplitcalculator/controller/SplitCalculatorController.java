package be.positive.calculator.positivesplitcalculator.controller;

import be.positive.calculator.positivesplitcalculator.dto.RunRecordDto;
import be.positive.calculator.positivesplitcalculator.entity.adapt.RunEntityCreated;
import be.positive.calculator.positivesplitcalculator.entity.create.RunEntityNew;
import be.positive.calculator.positivesplitcalculator.sercvice.impl.RunServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/runs")
public class SplitCalculatorController {
	private final RunServiceImpl runServiceImpl;

	@Autowired
	public SplitCalculatorController(RunServiceImpl runServiceImpl) {
		this.runServiceImpl = runServiceImpl;

	}

	@GetMapping("run/greeting")
	public String greeting() {
		return "greeting";
	}

	@GetMapping("/run/{id}")
	public RunRecordDto getRunRecord(@PathVariable Long id) {
		return runServiceImpl.getRunRecord(id);
	}

	@PostMapping("/save/{run}")
	public RunEntityCreated calculateNewRun(@RequestBody RunEntityNew runEntityNew) {
		return runServiceImpl.createNewRunRecord(runEntityNew);
	}



}
