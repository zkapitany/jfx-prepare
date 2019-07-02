package hu.definition.elokeszito.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hrsz {

	private final StringProperty hrszSzam;
	private final StringProperty hrszHanyad;
	private final StringProperty hrszVaros;
	private final StringProperty hrszUtca;
	private final StringProperty hrszBesorolas;
	private final StringProperty tulajdonosNev;
	private final StringProperty tulajdonosHrsz;
	private final StringProperty tulajdonosVaros;
	private final StringProperty tulajdonosUtca;
	private final StringProperty tulajdonosCim;

	public Hrsz() {
		this(null, null, null, null, null, null, null, null, null);
	}

	public Hrsz(String hrszSzam, String hrszHanyad, String hrszVaros, String hrszUtca, String hrszBesorolas,
			String tulajdonosNev, String tulajdonosHrsz, String tulajdonosVaros, String tulajdonosUtca) {
		this.hrszSzam = new SimpleStringProperty(hrszSzam);
		this.hrszHanyad = new SimpleStringProperty(hrszHanyad);
		this.hrszVaros = new SimpleStringProperty(hrszVaros);
		this.hrszUtca = new SimpleStringProperty(hrszUtca);
		this.hrszBesorolas = new SimpleStringProperty(hrszBesorolas);
		this.tulajdonosNev = new SimpleStringProperty(tulajdonosNev);
		this.tulajdonosHrsz = new SimpleStringProperty(tulajdonosHrsz);
		this.tulajdonosVaros = new SimpleStringProperty(tulajdonosVaros);
		this.tulajdonosUtca = new SimpleStringProperty(tulajdonosUtca);
		this.tulajdonosCim = new SimpleStringProperty(tulajdonosHrsz + " " + tulajdonosVaros + ", " + tulajdonosUtca);
	}

	// -----------------------------------------
	public String getHrszSzam() {
		return hrszSzam.get();
	}

	public void setHrszSzam(String hrszSzam) {
		this.hrszSzam.set(hrszSzam);
	}

	public StringProperty hrszSzamProperty() {
		return hrszSzam;
	}

	// -----------------------------------------

	public String getHrszHanyad() {
		return hrszHanyad.get();
	}

	public void setHrszHanyad(String hrszHanyad) {
		this.hrszHanyad.set(hrszHanyad);
	}

	public StringProperty hrszHanyadProperty() {
		return hrszHanyad;
	}

	// -----------------------------------------
	public String getHrszVaros() {
		return hrszVaros.get();
	}

	public void setHrszVaros(String hrszVaros) {
		this.hrszVaros.set(hrszVaros);
	}

	public StringProperty hrszVarosProperty() {
		return hrszVaros;
	}

	// -----------------------------------------
	public String getHrszUtca() {
		return hrszUtca.get();
	}

	public void setHrszUtca(String hrszUtca) {
		this.hrszUtca.set(hrszUtca);
	}

	public StringProperty hrszUtcaProperty() {
		return hrszUtca;
	}

	// -----------------------------------------
	public String getHrszBesorolas() {
		return hrszBesorolas.get();
	}

	public void setHrszBesorolas(String hrszBesorolas) {
		this.hrszBesorolas.set(hrszBesorolas);
	}

	public StringProperty hrszBesorolasProperty() {
		return hrszBesorolas;
	}

	// -----------------------------------------
	public String getTulajdonosNev() {
		return tulajdonosNev.get();
	}

	public void setTulajdonosNev(String tulajdonosNev) {
		this.tulajdonosNev.set(tulajdonosNev);
	}

	public StringProperty tulajdonosNevProperty() {
		return tulajdonosNev;
	}

	// -----------------------------------------
	public String getTulajdonosHrsz() {
		return tulajdonosHrsz.get();
	}

	public void setTulajdonosHrsz(String tulajdonosHrsz) {
		this.tulajdonosHrsz.set(tulajdonosHrsz);
	}

	public StringProperty tulajdonosHrszProperty() {
		return tulajdonosHrsz;
	}

	// -----------------------------------------
	public String getTulajdonosVaros() {
		return tulajdonosVaros.get();
	}

	public void setTulajdonosVaros(String tulajdonosVaros) {
		this.tulajdonosVaros.set(tulajdonosVaros);
	}

	public StringProperty tulajdonosVarosProperty() {
		return tulajdonosVaros;
	}

	// -----------------------------------------
	public String getTulajdonosUtca() {
		return tulajdonosUtca.get();
	}

	public void setTulajdonosUtca(String tulajdonosUtca) {
		this.tulajdonosUtca.set(tulajdonosUtca);
	}

	public StringProperty tulajdonosUtcaProperty() {
		return tulajdonosUtca;
	}
	// -----------------------------------------

	public String getTulajdonosCim() {
		return tulajdonosCim.get();
	}

	public void setTulajdonosCim(String tulajdonosCim) {
		this.tulajdonosCim.set(tulajdonosCim);
	}

	public StringProperty tulajdonosCimProperty() {
		return tulajdonosCim;
	}

}
