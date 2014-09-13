package mk.ukim.finki.ki.pf.web.rest;

import java.util.List;

import mk.ukim.finki.ki.pf.model.Physician;
import mk.ukim.finki.ki.pf.model.Symptom;
import mk.ukim.finki.ki.pf.service.PhysicianFinderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest")
public class PhysicianResource {
	
	@Autowired
	PhysicianFinderService service;
	
	@RequestMapping(value="/search/{keywords}",method = RequestMethod.GET, produces = "application/json")
	public List<Physician> search(@PathVariable String keywords) {
		String[] parts = keywords.trim().replace(",", " ").split("\\s+");
		for(int i = 0; i < parts.length; ++i) {
			System.out.println(parts[i]);
		}
		return service.search(parts);
	}
	
	@RequestMapping(value="/symptom",method = RequestMethod.GET, produces = "application/json")
	public List<Symptom> get() {
		return service.getSymptoms();
	}

}