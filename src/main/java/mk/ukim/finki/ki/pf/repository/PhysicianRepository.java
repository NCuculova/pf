package mk.ukim.finki.ki.pf.repository;

import java.util.List;

import mk.ukim.finki.ki.pf.model.Physician;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhysicianRepository extends JpaRepository<Physician, Long> {

	@Query(nativeQuery = true, value = "SELECT distinct(p.id), p.date, p.firstName, p.lastName, p.gender, p.location FROM physicians as p"
			+ " JOIN physician_specialties as ps ON p.id = ps.physician_id"
			+ " JOIN specialities as s ON ps.specialty_id = s.id"
			+ " JOIN specialty_diagnoses as sd ON sd.specialty_id = s.id"
			+ " JOIN diagnoses as d ON d.id = sd.diagnose_id"
			+ " JOIN diagnose_symptoms as ds ON d.id = ds.diagnose_id"
			+ " JOIN symptoms as ss ON ds.symptom_id = ss.id"
			+ " WHERE ss.name = ?1")
	public List<Physician> search1(String symptom1);
	
	@Query(nativeQuery = true, value = "SELECT distinct(p.id), p.date, p.firstName, p.lastName, p.gender, p.location FROM physicians as p"
			+ " JOIN physician_specialties as ps ON p.id = ps.physician_id"
			+ " JOIN specialities as s ON ps.specialty_id = s.id"
			+ " JOIN specialty_diagnoses as sd ON sd.specialty_id = s.id"
			+ " JOIN diagnoses as d ON d.id = sd.diagnose_id"
			+ " JOIN diagnose_symptoms as ds ON d.id = ds.diagnose_id"
			+ " JOIN symptoms as ss ON ds.symptom_id = ss.id"
			+ " WHERE ss.name = ?1 OR ss.name = ?2")
	public List<Physician> search2(String symptom1, String symptom2);
	
	@Query(nativeQuery = true, value = "SELECT distinct(p.id), p.date, p.firstName, p.lastName, p.gender, p.location FROM physicians as p"
			+ " JOIN physician_specialties as ps ON p.id = ps.physician_id"
			+ " JOIN specialities as s ON ps.specialty_id = s.id"
			+ " JOIN specialty_diagnoses as sd ON sd.specialty_id = s.id"
			+ " JOIN diagnoses as d ON d.id = sd.diagnose_id"
			+ " JOIN diagnose_symptoms as ds ON d.id = ds.diagnose_id"
			+ " JOIN symptoms as ss ON ds.symptom_id = ss.id"
			+ " WHERE ss.name = ?1 OR ss.name = ?2 OR ss.name = ?3")
	public List<Physician> search3(String symptom1, String symptom2, String symptom3);
	
	@Query(nativeQuery = true, value = "SELECT distinct(p.id), p.date, p.firstName, p.lastName, p.gender, p.location FROM physicians as p"
			+ " JOIN physician_specialties as ps ON p.id = ps.physician_id"
			+ " JOIN specialities as s ON ps.specialty_id = s.id"
			+ " JOIN specialty_diagnoses as sd ON sd.specialty_id = s.id"
			+ " JOIN diagnoses as d ON d.id = sd.diagnose_id"
			+ " JOIN diagnose_symptoms as ds ON d.id = ds.diagnose_id"
			+ " JOIN symptoms as ss ON ds.symptom_id = ss.id"
			+ " WHERE ss.name = ?1 OR ss.name = ?2 OR ss.name = ?3 OR ss.name = ?4")
	public List<Physician> search4(String symptom1, String symptom2, String symptom3, String symptom4);
	
	@Query(nativeQuery = true, value = "SELECT distinct(p.id), p.date, p.firstName, p.lastName, p.gender, p.location FROM physicians as p"
			+ " JOIN physician_specialties as ps ON p.id = ps.physician_id"
			+ " JOIN specialities as s ON ps.specialty_id = s.id"
			+ " JOIN specialty_diagnoses as sd ON sd.specialty_id = s.id"
			+ " JOIN diagnoses as d ON d.id = sd.diagnose_id"
			+ " JOIN diagnose_symptoms as ds ON d.id = ds.diagnose_id"
			+ " JOIN symptoms as ss ON ds.symptom_id = ss.id"
			+ " WHERE ss.name = ?1 OR ss.name = ?2 OR ss.name = ?3 OR ss.name = ?4 OR ss.name = ?5")
	public List<Physician> search5(String symptom1, String symptom2, String symptom3, String symptom4, String symptom5);
	
}
