package dmroy.luxoft.dao;

import dmroy.luxoft.been.FileStatistic;
import dmroy.luxoft.been.Line;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dmitriyroy
 */
public interface FileStatisticDaoInterface {
    public void addFileStatistic(List<Line> lineList);
    public FileStatistic getFileStatictic(Long fileId);
    public Map<String,Long> getAllFileStaticticName();
}
