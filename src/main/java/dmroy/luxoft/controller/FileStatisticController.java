package dmroy.luxoft.controller;

import static dmroy.luxoft.MainContext.fileStatisticDao;
import dmroy.luxoft.been.FileStatistic;
import dmroy.luxoft.been.Line;
import dmroy.luxoft.dao.FileStatisticDao;
import dmroy.luxoft.service.FileParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dmitriyroy
 */
@Controller
@RequestMapping("/fileparser")
public class FileStatisticController {


    @RequestMapping(value = "/get/{fileName}", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody
    FileStatistic getFileStatistic(@PathVariable("fileName") String fileName) {
        System.out.println("\n\n\n\n\n--------\n GET \n --------------\n\n\n");
        FileStatistic fileStatistic = new FileStatisticDao().getFileStatictic(fileName);

        return fileStatistic;
    }

    @RequestMapping(value = "/add/{fileName}", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody
    void addFileStatistic(@PathVariable("fileName") String fileName) {
        System.out.println("\n\n\n\n\n--------\n ADD \n --------------\n\n\n");
        List<Line> lineList = new ArrayList<>();
        // парсим книгу
        FileParser fileParser = new FileParser();
        lineList = fileParser.parseFile();
        fileStatisticDao.addFileStatistic(lineList);
    }

    
    /**
     * @param args the command line arguments
     */
/*
    public static void main(String[] args) {
        String path = FileStatisticController.class.getResource("../../beans.xml").toString().substring(6);
        new FileSystemXmlApplicationContext(path);
//        String fileToWork = "D:/!!!_tmp/Books/Кирпичи.txt";
//        String fileToWork = "D:/!!!_tmp/Books/eroshort.txt";
//        String fileToWorkResult = "D:/!!!_tmp/Books/Кирпичи_result.txt";
        FileParser fileParser = null;
        if(args.length > 0){
            fileParser = new FileParser(new File(args[0]));
        }else{
            fileParser = new FileParser();
        }
        List<Line> lineList = fileParser.parseFile();
        Set<String> globalWordSet = fileParser.getGlobalWordSet();
        int globalMinWordLength = fileParser.getGlobalMinWordLength();
        int globalMaxWordLength = fileParser.getGlobalMaxWordLength();
        String globalMinWord = fileParser.getGlobalMinWord();
        String globalMaxWord = fileParser.getGlobalMaxWord();
        int lineNumber = fileParser.getLineNumber();

        FileStatisticDao statistic = new FileStatisticDao();
        if(args.length > 1){
            statistic.writeIntoFile(lineList, args[1]);
        }else{
            statistic.writeIntoFile(lineList);
        }
        statistic.writeIntoDB(lineList);

        System.out.println("rows = " + lineNumber
                        + "; globalWordsCount = " + globalWordSet.size()
                        + "; globalMinWord = " + globalMinWord
                        + "; globalMinWordLength = " + globalMinWordLength
                        + "; globalMaxWord = " + globalMaxWord
                        + "; globalMaxWordLength = " + globalMaxWordLength);
    }
*/
}
