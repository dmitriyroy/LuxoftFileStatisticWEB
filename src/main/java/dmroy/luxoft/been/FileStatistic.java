package dmroy.luxoft.been;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

/**
 *
 * @author dmitriyroy
 */
@Component
@JsonRootName(value = "fileStatistic")
@XmlRootElement(name = "fileStatistic")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class FileStatistic {

    private String fileName;
    private List<Line> lineList;

    public FileStatistic() {
    }

    public FileStatistic(List<Line> lineList) {
        if(lineList.size()>0){
            this.fileName = lineList.get(0).getFileName();
        }        
        this.lineList = lineList;
    }

    public FileStatistic(String fileName, List<Line> lineList) {
        this.fileName = fileName;
        this.lineList = lineList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public void setLineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.fileName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileStatistic other = (FileStatistic) obj;
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "File{" + "fileName=" + fileName + ", lineList=" + lineList + '}';
    }



}
