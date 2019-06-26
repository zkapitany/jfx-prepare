package hu.definition.elokeszito.model;

import java.util.HashMap;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tulajdonos {
	
	private StringProperty nev;
	private StringProperty iranyitoSzam;
	private StringProperty varos;
	private StringProperty utca;
	private StringProperty cim;
	
//	private ObservableList<Hrsz> hrszList = FXCollections.observableArrayList();
	private HashMap<String, String> hrszMap = new HashMap<>();

	public Tulajdonos(String nev, String cim, String hrsz, String hanyad) {
		this.nev = new SimpleStringProperty(nev);		
		this.cim = new SimpleStringProperty(cim);
		this.hrszMap.put(hrsz, hanyad);
	}
	
	// -----------------------------------------
		public String getNev() {
			return nev.get();
		}

		public void setNev(String nev) {
			this.nev.set(nev);
		}

		public StringProperty nevProperty() {
			return nev;
		}

		// -----------------------------------------
		public String getCim() {
			return cim.get();
		}

		public void setCim(String cim) {
			this.cim.set(cim);
		}

		public StringProperty cimProperty() {
			return cim;
		}
		// -----------------------------------------

		public HashMap<String, String> getHrszMap() {
			return hrszMap;
		}

		public void setHrszMap(HashMap<String, String> hrszMap) {
			this.hrszMap = hrszMap;
		}
		
	

}
