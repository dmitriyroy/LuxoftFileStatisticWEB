package dmroy.luxoft.been;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

/**
 *
 * @author dmitriyroy
 */
@Component
@JsonRootName(value = "lineList")
@XmlRootElement(name = "lineList")
@XmlAccessorType(value=XmlAccessType.FIELD)
public class LineList {
    @XmlElement(name="line")
    private List<Line> lineList = new ArrayList<>();

    public LineList() {
    }

    public LineList(List<Line> lineList) {
        this.lineList = lineList;
    }
    
    public List<Line> getLineList() {
        return lineList;
    }

    public void setLineList(List<Line> lineList) {
        this.lineList = lineList;
    }   
    
    
}
