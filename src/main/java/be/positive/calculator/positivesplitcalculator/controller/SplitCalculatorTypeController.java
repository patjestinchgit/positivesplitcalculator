package be.positive.calculator.positivesplitcalculator.controller;

import be.positive.calculator.positivesplitcalculator.entity.adapt.TypeCurveEntityCreated;
import be.positive.calculator.positivesplitcalculator.entity.create.TypeCurveEntityNew;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveAllReadyExists;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveDoesNotExistsException;
import be.positive.calculator.positivesplitcalculator.exception.TypeCurveUsedByRunException;
import be.positive.calculator.positivesplitcalculator.sercvice.impl.TypeServiceImpl;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
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
	public List<TypeCurveEntityCreated> getAllTypeCurves() {
		return typeServiceImpl.getAllTypeCurves();
	}

	@GetMapping(value = "/typecurves/{id}", params = {"id"})
	public TypeCurveEntityCreated getTypeCurveEntity (@RequestParam Long id) {
		return typeServiceImpl.getCurveEntityById(id);
	}

	@GetMapping(value = "/typecurves/searchtypecurve")
	@ResponseBody
	public List<TypeCurveEntityCreated> searchByTypeCurveNameOrFormula(
			@RequestParam(value = "nameTypeCurve", required = false) String nameTypeCurve,
			@RequestParam(value = "formula", required = false) String formula) {
		return typeServiceImpl.searchByTypeCurveNameOrFormula(nameTypeCurve, formula);
	}

	@PostMapping("/save/{typecurveName}")
	public TypeCurveEntityCreated saveTypeCurveEntity (@RequestBody TypeCurveEntityNew typeCurveEntityNew, @PathVariable String typecurveName) {
		if(typeServiceImpl.checkTypeExists(typeCurveEntityNew)) {
			throw new TypeCurveAllReadyExists();
		}
		return typeServiceImpl.createCurveEntity(typeCurveEntityNew);
	}



	@DeleteMapping(path = "/delete/{typeCurveName}")
	void deleteTypeCurveEntity(@RequestBody TypeCurveEntityNew typeCurveEntityNew, @PathVariable String typeCurveName) {
		if(!typeServiceImpl.checkTypeExists(typeCurveEntityNew)) {
			throw new TypeCurveDoesNotExistsException();
		}
		if(!typeServiceImpl.checkTypeUsedByRunEntity(typeCurveEntityNew)) {
			throw new TypeCurveUsedByRunException();
		}
		typeServiceImpl.deleteCurveEntity(new TypeCurveEntityCreated(typeCurveEntityNew.getNameTypeCurve(), typeCurveEntityNew.getFormula()));
	}

}
