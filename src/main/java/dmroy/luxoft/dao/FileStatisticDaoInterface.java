package dmroy.luxoft.dao;

import dmroy.luxoft.been.FileStatistic;
import dmroy.luxoft.been.Line;
import java.io.File;
import java.util.List;

/**
 *
 * @author dmitriyroy
 */
public interface FileStatisticDaoInterface {
    public void addFileStatistic(List<Line> lineList);
    public FileStatistic getFileStatictic(String fileName);
    public List<String> getAllFileStaticticName();
}
