package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/hrms/city")
public class CityControllers {

	private CityService cityService;

	@Autowired
	public CityControllers(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/GetAll")
	public DataResult<List<City>> cityGetAll(){
		return this.cityService.getAll();
	}
	
	@PostMapping("/Add")
	public Result cityAdd(@RequestBody City city) {
		return this.cityService.add(city);
	}
	
}
