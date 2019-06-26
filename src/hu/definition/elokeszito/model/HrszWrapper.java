package hu.definition.elokeszito.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Hrsz_Adatok")
public class HrszWrapper {
	
	private List<Hrsz> data;

	@XmlElement(name = "Hrsz")
	public List<Hrsz> getData() {
		return data;
	}

	public void setData(List<Hrsz> data) {
		this.data = data;
	}
	
	

}
