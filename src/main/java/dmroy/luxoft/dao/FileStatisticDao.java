package dmroy.luxoft.dao;

import dmroy.luxoft.been.FileStatistic;
import dmroy.luxoft.been.Line;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

/**
 *
 * @author dmitriyroy
 */
//@Repository("fileStatisticDao")
@Component
public class FileStatisticDao implements FileStatisticDaoInterface{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public FileStatisticDao() {
    }

    @Override
    public void addFileStatistics(List<Line> lineList) {
        // нужно делать проверку на наличие данных по такому файлу в базе
        // пока сделано такой заглушкой
        // просто удаляем данные по этому файлу
        // прим.: можно было обеспечить транзакционность, и пр....
        String fileName = null;
        if(lineList.size() > 0){
            fileName = lineList.get(0).getFileName();
            jdbcTemplate.update("DELETE file_statistic FROM file_statistic WHERE FILE_NAME = ? and LINE_NUMBER = ? ",
                                new Object[] { fileName},
                                new int[]{Types.VARCHAR});
        }

        String SQL_QUERY = "INSERT INTO file_statistic (               "
                                                   + "  FILE_ID,       "
                                                   + "  FILE_NAME,     "
                                                   + "  LINE_NUMBER,   "
                                                   + "  MIN_WORD,      "
                                                   + "  MAX_WORD,      "
                                                   + "  MIN_WORD_LEN,  "
                                                   + "  MAX_WORD_LEN,  "
                                                   + "  AVG_WORD_LEN,  "
                                                   + "  ALL_WORD_LEN,  "
                                                   + "  WORDS_CNT      "
                                                   + " )               "
                          + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        for(Line line:lineList){
            try{
                jdbcTemplate.update(SQL_QUERY,
                                   new Object[] {line.getFileId(), line.getFileName(), line.getLineNumber(), line.getMinWord(),
                                   line.getMaxWord(), line.getMinWordLength(), line.getMaxWordLength(),
                                   line.getAverageWordLength(), line.getAllWordsLength(), line.getWordsCount()},
                                   new int[]{Types.BIGINT, Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
                                             Types.VARCHAR, Types.INTEGER, Types.INTEGER,
                                             Types.INTEGER, Types.BIGINT, Types.INTEGER});
//                Logger.getLogger(FileStatisticDao.class.getName()).log(Level.INFO, "Файл {0}, трока № {1} добавлена в базу данных.", new Object[]{line.getFileName(), line.getLineNumber()});
//                System.out.println("Файл " + line.getFileName() + ", строка № " + line.getLineNumber() + " добавлена в базу данных.");
            }catch(DataAccessException e){
                Logger.getLogger(FileStatisticDao.class.getName()).log(Level.WARNING, "Ошибка добавления строки № {0} файла {1}.", new Object[]{line.getLineNumber(), line.getFileName()} );
                System.out.println("Ошибка добавления строки № " + line.getLineNumber() + " файла " + line.getFileName() + " в базу данных.");
            }
        }
        Logger.getLogger(FileStatisticDao.class.getName()).log(Level.INFO, "В базу данных добавлена информация по файлу {0}, вставлено {1} строк.", new Object[]{fileName, lineList.size()});
    }

    @Override
    public void addFileStatistic(Line line) {
        // нужно делать проверку на наличие данных по такому файлу в базе
        // пока сделано такой заглушкой
        // просто удаляем данные по этому файлу
        // прим.: можно было обеспечить транзакционность, и пр....
        jdbcTemplate.update("DELETE file_statistic FROM file_statistic WHERE FILE_NAME = ? and LINE_NUMBER = ? ",
                            new Object[] { line.getFileName(), line.getLineNumber()},
                            new int[]{Types.VARCHAR, Types.INTEGER});

        String SQL_QUERY = "INSERT INTO file_statistic (               "
                                                   + "  FILE_ID,       "
                                                   + "  FILE_NAME,     "
                                                   + "  LINE_NUMBER,   "
                                                   + "  MIN_WORD,      "
                                                   + "  MAX_WORD,      "
                                                   + "  MIN_WORD_LEN,  "
                                                   + "  MAX_WORD_LEN,  "
                                                   + "  AVG_WORD_LEN,  "
                                                   + "  ALL_WORD_LEN,  "
                                                   + "  WORDS_CNT      "
                                                   + " )               "
                          + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try{
            jdbcTemplate.update(SQL_QUERY,
                               new Object[] {line.getFileId(), line.getFileName(), line.getLineNumber(), line.getMinWord(),
                               line.getMaxWord(), line.getMinWordLength(), line.getMaxWordLength(),
                               line.getAverageWordLength(), line.getAllWordsLength(), line.getWordsCount()},
                               new int[]{Types.BIGINT, Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
                                         Types.VARCHAR, Types.INTEGER, Types.INTEGER,
                                         Types.INTEGER, Types.BIGINT, Types.INTEGER});
//                Logger.getLogger(FileStatisticDao.class.getName()).log(Level.INFO, "Файл {0}, трока № {1} добавлена в базу данных.", new Object[]{line.getFileName(), line.getLineNumber()});
//                System.out.println("Файл " + line.getFileName() + ", строка № " + line.getLineNumber() + " добавлена в базу данных.");
        }catch(DataAccessException e){
            Logger.getLogger(FileStatisticDao.class.getName()).log(Level.WARNING, "Ошибка добавления строки № {0} файла {1}.", new Object[]{line.getLineNumber(), line.getFileName()} );
            System.out.println("Ошибка добавления строки № " + line.getLineNumber() + " файла " + line.getFileName() + " в базу данных.");
        }
        Logger.getLogger(FileStatisticDao.class.getName()).log(Level.INFO, "В базу данных добавлена информация по файлу {0}, вставлена строка №{1}.", new Object[]{line.getFileName(), line.getLineNumber()});
    }

    @Override
    public FileStatistic getFileStatictic(Long fileId) {
        String SQL_QUERY =   " SELECT FILE_ID,       "
                           + "        FILE_NAME,     "
                           + "        LINE_NUMBER,   "
                           + "        MIN_WORD,      "
                           + "        MAX_WORD,      "
                           + "        MIN_WORD_LEN,  "
                           + "        MAX_WORD_LEN,  "
                           + "        AVG_WORD_LEN,  "
                           + "        ALL_WORD_LEN,  "
                           + "        WORDS_CNT      "
                           + "   FROM file_statistic "
                           + "  WHERE FILE_ID = ?  ";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_QUERY,
                new Object[]{fileId},
                new int[]{Types.BIGINT});
        List<Line> lineList = getLineList(rows);
        return new FileStatistic(lineList);
    }

    @Override
    public List<Map<String,Object>> getAllFileStaticticName() {
        String SQL_QUERY =  "SELECT FILE_NAME,                         "
                           +"       FILE_ID,                           "
                           +"       max(LINE_NUMBER) as \"LINE_COUNT\" "
                           +"  FROM file_statistic                     "
                           +"GROUP BY FILE_NAME, FILE_ID               ";
//        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_QUERY);
//        Map<String,Long> outCollection = new HashMap<>();
//        for(Map row:rows){
//            outCollection.put((String)row.get("FILE_NAME"),(Long)row.get("FILE_ID"));
//        }
//        return outCollection;
        return jdbcTemplate.queryForList(SQL_QUERY);
    }

    @Override
    public List<Map<String,Object>> getAllFileStaticticName(int lineCount) {
        String SQL_QUERY =   "select t1.FILE_NAME,                               "
                            +"       t1.FILE_ID,                                 "
                            +"       t1.LINE_COUNT                               "
                            +"  from (                                           "
                            +"        select FILE_NAME,                          "
                            +"               FILE_ID,                            "
                            +"               max(LINE_NUMBER) as \"LINE_COUNT\"  "
                            +"          from file_statistic                      "
                            +"        group by FILE_NAME, FILE_ID                "
                            +"       ) as t1                                     "
                            +" where t1.LINE_COUNT < ?                           ";
//        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_QUERY,new Object[]{lineCount});
//        Map<String,Long> outCollection = new HashMap<>();
//        for(Map<String, Object> m:rows){
//            
//        }
//        for(Map row:rows){
//            if(lineCount > (Integer)row.get("LINE_COUNT")){
//                outCollection.put((String)row.get("FILE_NAME"),(Long)row.get("FILE_ID"));
//            }
//        }
//        return outCollection;
        return jdbcTemplate.queryForList(SQL_QUERY,new Object[]{lineCount});
    }

    public List<Line> getLineList(List<Map<String, Object>> rows){
        List<Line> lineList = new ArrayList<>();
        for (Map row : rows) {
            Line line = new Line();
            line.setFileName((String)row.get("FILE_NAME"));
            line.setLineNumber(Integer.parseInt(String.valueOf(row.get("LINE_NUMBER"))));
            line.setMinWord((String) row.get("MIN_WORD"));
            line.setMaxWord((String) row.get("MAX_WORD"));
            line.setMinWordLength(Integer.parseInt(String.valueOf(row.get("MIN_WORD_LEN"))));
            line.setMaxWordLength(Integer.parseInt(String.valueOf(row.get("MAX_WORD_LEN"))));
            line.setAverageWordLength(Integer.parseInt(String.valueOf(row.get("AVG_WORD_LEN"))));
            line.setAllWordsLength(Long.parseLong(String.valueOf(row.get("ALL_WORD_LEN"))));
            line.setWordsCount(Integer.parseInt(String.valueOf(row.get("WORDS_CNT"))));
            lineList.add(line);
        }
        return lineList;
    }
}
