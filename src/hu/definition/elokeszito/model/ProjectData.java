package hu.definition.elokeszito.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import hu.definition.elokeszito.util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProjectData {

	private final StringProperty projektCim;
	private final StringProperty projektRovidCim;

	private final StringProperty munkaSzam;
	private final StringProperty rajzSzam;
	private final StringProperty iktatoSzam;
	private final StringProperty seplandSzam;

//	private final StringProperty pmhNev;
//	private final StringProperty pmhVaros;
//	private final StringProperty pmhUtca;
	private final StringProperty pmhCim;

	private final StringProperty ugyintezoNev;
	private final StringProperty ugyintezoTelefon;

//	private final ObjectProperty<LocalDate> maiDatum;
	private final StringProperty maiDatum;

//	private final StringProperty hatosagNev;
//	private final StringProperty hatosagVaros;
//	private final StringProperty hatosagUtca;
//	private final StringProperty hatosagCim;
//
//	private final StringProperty tervezoNev;
//	private final StringProperty tervezoSzam;

//	private final StringProperty street;
//	private final IntegerProperty postalCode;
//	private final StringProperty city;
//	private final ObjectProperty<LocalDate> birthday;

	public ProjectData() {
		this(null, null);
	}

	public ProjectData(String projektCim, String projektRovidCim) {
		this.projektCim = new SimpleStringProperty(projektCim);
		this.projektRovidCim = new SimpleStringProperty(projektRovidCim);

		// Some initial dummy data, just for convenient testing.
//		this.street = new SimpleStringProperty("some street");
//		this.postalCode = new SimpleIntegerProperty(1234);
//		this.city = new SimpleStringProperty("some city");
//		this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
		this.munkaSzam = new SimpleStringProperty("MunkaSzám");
		this.rajzSzam = new SimpleStringProperty("RajzSzám");
		this.iktatoSzam = new SimpleStringProperty("Iktatószám");
		this.seplandSzam = new SimpleStringProperty("Sepland");
		this.pmhCim = new SimpleStringProperty("Polgármesteri Hivatal");
		this.ugyintezoNev = new SimpleStringProperty("Ugyintézõ Név");
		this.ugyintezoTelefon = new SimpleStringProperty("Ugyintézõ Telefon");
		this.maiDatum = new SimpleStringProperty("2019.06.24.");
	}

//-----------------------------------------
	public String getProjektCim() {
		return projektCim.get();
	}

	public void setProjektCim(String projektCim) {
		this.projektCim.set(projektCim);
	}

	public StringProperty projektCimProperty() {
		return projektCim;
	}

//------------------------------------------	
	public String getProjektRovidCim() {
		return projektRovidCim.get();
	}

	public void setProjektRovidCim(String projektRovidCim) {
		this.projektRovidCim.set(projektRovidCim);
	}

	public StringProperty projektRovidCimProperty() {
		return projektRovidCim;
	}

//------------------------------------------	
	public String getMunkaSzam() {
		return munkaSzam.get();
	}

	public void setMunkaSzam(String munkaSzam) {
		this.munkaSzam.set(munkaSzam);
	}

	public StringProperty munkaSzamProperty() {
		return munkaSzam;
	}

//-------------------------------------------
	public String getRajzSzam() {
		return rajzSzam.get();
	}

	public void setRajzSzam(String rajzSzam) {
		this.rajzSzam.set(rajzSzam);
	}

	public StringProperty rajzSzamProperty() {
		return rajzSzam;
	}

//-------------------------------------------
	public String getIktatoSzam() {
		return iktatoSzam.get();
	}

	public void setIktatoSzam(String iktatoSzam) {
		this.iktatoSzam.set(iktatoSzam);
	}

	public StringProperty iktatoSzamProperty() {
		return iktatoSzam;
	}

	// -------------------------------------------
	public String getSeplandSzam() {
		return seplandSzam.get();
	}

	public void setSeplandSzam(String seplandSzam) {
		this.seplandSzam.set(seplandSzam);
	}

	public StringProperty seplandSzamProperty() {
		return seplandSzam;
	}

	// -------------------------------------------
	public String getPmhCim() {
		return pmhCim.get();
	}

	public void setPmhCim(String pmhCim) {
		this.pmhCim.set(pmhCim);
	}

	public StringProperty pmhCimProperty() {
		return pmhCim;
	}

	// -------------------------------------------
	public String getUgyintezoNev() {
		return ugyintezoNev.get();
	}

	public void setUgyintezoNev(String ugyintezoNev) {
		this.ugyintezoNev.set(ugyintezoNev);
	}

	public StringProperty ugyintezoNevProperty() {
		return ugyintezoNev;
	}

	// -------------------------------------------
	public String getUgyintezoTelefon() {
		return ugyintezoTelefon.get();
	}

	public void setUgyintezoTelefon(String ugyintezoTelefon) {
		this.ugyintezoTelefon.set(ugyintezoTelefon);
	}

	public StringProperty ugyintezoTelefonProperty() {
		return ugyintezoTelefon;
	}

//--------------------------------------------	
	public String getMaiDatum() {
		return maiDatum.get();
	}

	public void setMaiDatum(String maiDatum) {
		this.maiDatum.set(maiDatum);
	}

	public StringProperty maiDatumProperty() {
		return maiDatum;
	}
//-----------------------------------------
//	public int getPostalCode() {
//		return postalCode.get();
//	}
//
//	public void setPostalCode(int postalCode) {
//		this.postalCode.set(postalCode);
//	}
//
//	public IntegerProperty postalCodeProperty() {
//		return postalCode;
//	}
//-----------------------------------------	
//	@XmlJavaTypeAdapter(LocalDateAdapter.class)
//	public LocalDate getBirthday() {
//		return birthday.get();
//	}
//
//	public void setBirthday(LocalDate birthday) {
//		this.birthday.set(birthday);
//	}
//
//	public ObjectProperty<LocalDate> birthdayProperty() {
//		return birthday;
//	}
}
