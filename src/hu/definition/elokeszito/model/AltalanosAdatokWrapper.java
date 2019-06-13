package hu.definition.elokeszito.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Általános Adatok")
public class AltalanosAdatokWrapper {

    private List<AltalanosAdatok> data;

    @XmlElement(name = "Projekt")
    public List<AltalanosAdatok> getData() {
        return data;
    }

    public void setData(List<AltalanosAdatok> data) {
        this.data = data;
    }
}
