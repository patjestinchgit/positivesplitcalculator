package be.positive.calculator.positivesplitcalculator.controller;

import be.positive.calculator.positivesplitcalculator.entity.TypeCurveEntity;
import be.positive.calculator.positivesplitcalculator.exception.RunEntityException;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveAllReadyExists;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveDoesNotExistsException;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveUsedByRunException;
import be.positive.calculator.positivesplitcalculator.sercvice.impl.TypeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/types")
public class SplitCalculatorTypeController {
	private final TypeServiceImpl typeServiceImpl;

	public SplitCalculatorTypeController(TypeServiceImpl typeServiceImpl) {
		this.typeServiceImpl = typeServiceImpl;
	}

	@GetMapping("/typecurves/all")
	public List<TypeCurveEntity> getAllTypeCurves() {
		return typeServiceImpl.getAllTypeCurves();
	}

	@PostMapping("/save/{typecurveName}")
	public TypeCurveEntity saveTypeCurveEntity (@RequestBody TypeCurveEntity typeCurveEntity) {
		if(typeServiceImpl.checkTypeExists(typeCurveEntity)) {
			throw new TypeCurveAllReadyExists();
		}
		return typeServiceImpl.createCurveEntity(typeCurveEntity);
	}

	@RequestMapping(path = "/delete/{typeCurve}", method = RequestMethod.DELETE)
	void deleteTypeCurveEntity(@PathVariable TypeCurveEntity typeCurve) {
		if(typeServiceImpl.checkTypeExists(typeCurve)) {
			throw new TypeCurveDoesNotExistsException();
		}
		if(typeServiceImpl.checkTypeUsedByRunEntity(typeCurve)) {
			throw new TypeCurveUsedByRunException();
		}
		typeServiceImpl.deleteCurveEntity(typeCurve);
	}

}
