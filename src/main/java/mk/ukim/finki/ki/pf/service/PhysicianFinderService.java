package mk.ukim.finki.ki.pf.service;

import java.util.List;

import mk.ukim.finki.ki.pf.model.Physician;
import mk.ukim.finki.ki.pf.model.Symptom;


public interface PhysicianFinderService {

	public void generateData();
	
	public List<Physician> search(String... symptoms);

	public List<Symptom> getSymptoms();
}
