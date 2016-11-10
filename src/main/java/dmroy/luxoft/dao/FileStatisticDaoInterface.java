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
    public void addFileStatistics(List<Line> lineList);
    public void addFileStatistic(Line line);
    public FileStatistic getFileStatictic(Long fileId);
    public List<Map<String,Object>> getAllFileStaticticName();
    public List<Map<String,Object>> getAllFileStaticticName(int lineCount);
}
