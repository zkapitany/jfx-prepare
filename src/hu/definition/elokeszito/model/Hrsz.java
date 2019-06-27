package hu.definition.elokeszito.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hrsz {

	private final StringProperty szam;
	private final StringProperty varos;
	private final StringProperty utca;
	private final StringProperty besorolas;
	private final ObjectProperty<Tulajdonos> tulajdonos;
	
	public Hrsz() {
		this(null, null, null, null, null);
	}

	public Hrsz(String szam, String varos, String utca, String besorolas, Tulajdonos tulajdonos) {
		this.szam = new SimpleStringProperty(szam);
		this.varos = new SimpleStringProperty(varos);
		this.utca = new SimpleStringProperty(utca);
		this.besorolas = new SimpleStringProperty(besorolas);
		this.tulajdonos = new SimpleObjectProperty<Tulajdonos>(tulajdonos);
	}

	// -----------------------------------------
	public String getSzam() {
		return szam.get();
	}

	public void setSzam(String szam) {
		this.szam.set(szam);
	}

	public StringProperty szamProperty() {
		return szam;
	}

	// -----------------------------------------
	public String getVaros() {
		return varos.get();
	}

	public void setVaros(String varos) {
		this.varos.set(varos);
	}

	public StringProperty varosProperty() {
		return varos;
	}

	// -----------------------------------------
	public String getUtca() {
		return utca.get();
	}

	public void setUtca(String utca) {
		this.utca.set(utca);
	}

	public StringProperty utcaProperty() {
		return utca;
	}

	// -----------------------------------------
	public String getBesorolas() {
		return besorolas.get();
	}

	public void setBesorolas(String besorolas) {
		this.besorolas.set(besorolas);
	}

	public StringProperty besorolasProperty() {
		return besorolas;
	}
	//-----------------------------------------	
	//@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public Tulajdonos getTulajdonos() {
		return tulajdonos.get();
	}

	public void setTulajdonos(Tulajdonos tulajdonos) {
		this.tulajdonos.set(tulajdonos);
	}

	public ObjectProperty<Tulajdonos> tulajdonosProperty() {
		return tulajdonos;
	}

}
