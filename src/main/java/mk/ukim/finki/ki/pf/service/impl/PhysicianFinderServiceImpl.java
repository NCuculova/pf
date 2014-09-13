package mk.ukim.finki.ki.pf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.ki.pf.model.Diagnose;
import mk.ukim.finki.ki.pf.model.DiagnoseSymptom;
import mk.ukim.finki.ki.pf.model.Physician;
import mk.ukim.finki.ki.pf.model.PhysicianSpecialty;
import mk.ukim.finki.ki.pf.model.PhysicianUniversity;
import mk.ukim.finki.ki.pf.model.Specialty;
import mk.ukim.finki.ki.pf.model.SpecialtyDiagnose;
import mk.ukim.finki.ki.pf.model.Symptom;
import mk.ukim.finki.ki.pf.model.University;
import mk.ukim.finki.ki.pf.repository.DiagnoseRepository;
import mk.ukim.finki.ki.pf.repository.DiagnoseSymptomRepository;
import mk.ukim.finki.ki.pf.repository.PhysicianRepository;
import mk.ukim.finki.ki.pf.repository.PhysicianSpecialtyRepository;
import mk.ukim.finki.ki.pf.repository.PhysicianUniversityRepository;
import mk.ukim.finki.ki.pf.repository.SpecialtyDiagnoseRepository;
import mk.ukim.finki.ki.pf.repository.SpecialtyRepository;
import mk.ukim.finki.ki.pf.repository.SymptomRepository;
import mk.ukim.finki.ki.pf.repository.UniversityRepository;
import mk.ukim.finki.ki.pf.service.PhysicianFinderService;

@Service
public class PhysicianFinderServiceImpl implements PhysicianFinderService {

	@Autowired
	private PhysicianRepository physicianRepository;

	@Autowired
	private DiagnoseRepository diagnoseRepository;

	@Autowired
	private SpecialtyRepository specialtyRepository;

	@Autowired
	private UniversityRepository universityRepository;

	@Autowired
	private PhysicianUniversityRepository puRepository;

	@Autowired
	private PhysicianSpecialtyRepository psRepository;

	@Autowired
	private SymptomRepository sRespository;

	@Autowired
	private DiagnoseSymptomRepository dsRepository;

	@Autowired
	private SpecialtyDiagnoseRepository sdRepository;

	@Override
	public void generateData() {
		// Create symptoms
		List<Symptom> entities = new ArrayList<Symptom>();
		for (int i = 0; i < 100; i++) {
			Symptom simptom = new Symptom();
			simptom.setName(String.format("simptom %d", i + 1));
			entities.add(simptom);
		}
		sRespository.save(entities);
		// Create diagnosis
		List<Diagnose> diagnosis = new ArrayList<Diagnose>();
		for (int i = 0; i < 50; i++) {
			Diagnose entity = new Diagnose();
			entity.setName(String.format("diagnose %d", i + 1));
			diagnosis.add(entity);
		}
		diagnoseRepository.save(diagnosis);

		// Create ds
		Random r = new Random();
		List<DiagnoseSymptom> dss = new ArrayList<DiagnoseSymptom>();
		for (int i = 0; i < 50; ++i) {
			Diagnose d = diagnosis.get(i);
			int count = r.nextInt(4) + 2;
			for (int j = 0; j < count; ++j) {
				Symptom s = entities.get(r.nextInt(entities.size()));
				DiagnoseSymptom ds = new DiagnoseSymptom();
				ds.setDiagnose(d);
				ds.setSymptom(s);
				dss.add(ds);
			}
		}
		dsRepository.save(dss);

		// create specialities
		List<Specialty> specialties = new ArrayList<Specialty>();
		for (int i = 0; i < 50; i++) {
			Specialty entity = new Specialty();
			entity.setName(String.format("specialty %d", i + 1));
			specialties.add(entity);
		}
		specialtyRepository.save(specialties);

		// create specialty diagnosis
		List<SpecialtyDiagnose> sds = new ArrayList<SpecialtyDiagnose>();
		for (int i = 0; i < 50; ++i) {
			Specialty s = specialties.get(i);
			int count = r.nextInt(5) + 3;
			for (int j = 0; j < count; ++j) {
				Diagnose d = diagnosis.get(r.nextInt(diagnosis.size()));
				SpecialtyDiagnose sd = new SpecialtyDiagnose();
				sd.setDiagnose(d);
				sd.setSpecialty(s);
				sds.add(sd);
			}
		}
		sdRepository.save(sds);

		// create universities
		List<University> universities = new ArrayList<University>();
		for (int i = 0; i < 10; i++) {
			University entity = new University();
			entity.setName(String.format("university %d", i + 1));
			universities.add(entity);
		}
		universityRepository.save(universities);

		// create physicians
		List<Physician> physicians = new ArrayList<Physician>();
		for (int i = 0; i < 500; i++) {
			Physician entity = new Physician();
			entity.setFirstName(String.format("phys%d", i + 1));
			entity.setLastName(String.format("owski%d", i + 1));
			entity.setLocation(String.format("location %d", r.nextInt(30) + 1));
			entity.setGender(r.nextBoolean());
			entity.setDate(new Date(70 + r.nextInt(35), r.nextInt(12), r
					.nextInt(28)));
			physicians.add(entity);
		}
		physicianRepository.save(physicians);

		// create physician specialties
		List<PhysicianSpecialty> pss = new ArrayList<PhysicianSpecialty>();
		for (int i = 0; i < 500; ++i) {
			Physician p = physicians.get(i);
			int count = r.nextInt(5) + 1;
			for (int j = 0; j < count; ++j) {
				Specialty s = specialties.get(r.nextInt(specialties.size()));
				PhysicianSpecialty ps = new PhysicianSpecialty();
				ps.setPhysician(p);
				ps.setSpecialty(s);
				pss.add(ps);
			}
		}
		psRepository.save(pss);

		// create physician university
		List<PhysicianUniversity> pus = new ArrayList<PhysicianUniversity>();
		for (int i = 0; i < 500; ++i) {
			Physician p = physicians.get(i);
			University u = universities.get(r.nextInt(universities.size()));
			PhysicianUniversity pu = new PhysicianUniversity();
			pu.setPhysician(p);
			pu.setUniversity(u);
			pus.add(pu);
		}
		puRepository.save(pus);

	}

	@Override
	public List<Physician> search(String... symptoms) {
		if (symptoms.length == 1) {
			return physicianRepository.search1(symptoms[0]);
		} else if (symptoms.length == 2) {
			return physicianRepository.search2(symptoms[0], symptoms[1]);
		} else if (symptoms.length == 3) {
			return physicianRepository.search3(symptoms[0], symptoms[1],
					symptoms[2]);
		} else if (symptoms.length == 4) {
			return physicianRepository.search4(symptoms[0], symptoms[1],
					symptoms[2], symptoms[3]);
		} else {
			return physicianRepository.search5(symptoms[0], symptoms[1],
					symptoms[2], symptoms[3], symptoms[4]);
		}
	}

	@Override
	public List<Symptom> getSymptoms() {
		return sRespository.findAll();
	}
}
