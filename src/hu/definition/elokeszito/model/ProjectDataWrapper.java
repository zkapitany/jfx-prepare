package hu.definition.elokeszito.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Projekt_Adatok")
public class ProjectDataWrapper {

    private List<ProjectData> data;

    @XmlElement(name = "Projekt")
    public List<ProjectData> getData() {
        return data;
    }

    public void setData(List<ProjectData> data) {
        this.data = data;
    }
}
