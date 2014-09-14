package mk.ukim.finki.ki.pf.model;

import java.util.List;

public class SearchResults {
	private List<Physician> physicians;

	private List<Diagnose> diagnosis;

	public List<Physician> getPhysicians() {
		return physicians;
	}

	public void setPhysicians(List<Physician> physicians) {
		this.physicians = physicians;
	}

	public List<Diagnose> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(List<Diagnose> diagnosis) {
		this.diagnosis = diagnosis;
	}

}
