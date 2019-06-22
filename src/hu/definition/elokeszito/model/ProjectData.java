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
	private final StringProperty street;
	private final IntegerProperty postalCode;
	private final StringProperty city;
	private final ObjectProperty<LocalDate> birthday;

	public ProjectData() {
		this(null, null);
	}

	public ProjectData(String projektCim, String projektRovidCim) {
		this.projektCim = new SimpleStringProperty(projektCim);
		this.projektRovidCim = new SimpleStringProperty(projektRovidCim);

		// Some initial dummy data, just for convenient testing.
		this.street = new SimpleStringProperty("some street");
		this.postalCode = new SimpleIntegerProperty(1234);
		this.city = new SimpleStringProperty("some city");
		this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
	}

	public String getProjektCim() {
		return projektCim.get();
	}

	public void setProjektCim(String projektCim) {
		this.projektCim.set(projektCim);
	}

	public StringProperty projektCimProperty() {
		return projektCim;
	}

	public String getProjektRovidCim() {
		return projektRovidCim.get();
	}

	public void setProjektRovidCim(String projektRovidCim) {
		this.projektRovidCim.set(projektRovidCim);
	}

	public StringProperty projektRovidCimProperty() {
		return projektRovidCim;
	}

	public String getStreet() {
		return street.get();
	}

	public void setStreet(String street) {
		this.street.set(street);
	}

	public StringProperty streetProperty() {
		return street;
	}

	public int getPostalCode() {
		return postalCode.get();
	}

	public void setPostalCode(int postalCode) {
		this.postalCode.set(postalCode);
	}

	public IntegerProperty postalCodeProperty() {
		return postalCode;
	}

	public String getCity() {
		return city.get();
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public StringProperty cityProperty() {
		return city;
	}

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getBirthday() {
		return birthday.get();
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday.set(birthday);
	}

	public ObjectProperty<LocalDate> birthdayProperty() {
		return birthday;
	}
}
