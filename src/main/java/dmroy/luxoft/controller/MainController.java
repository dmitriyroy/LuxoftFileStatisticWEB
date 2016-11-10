package dmroy.luxoft.controller;

import static dmroy.luxoft.MainContext.fileStatisticDao;
import dmroy.luxoft.been.Line;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author dmitriyroy
 */
@Controller
@RequestMapping("/fileparser")
public class MainController {


    @RequestMapping(value = "/test/{requestData}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addTest(@PathVariable("requestData") Line requestData) {
        System.out.println("\n\n\n  --------->>>>>>>>> Обработали запрос: addTest(). На вход прилетело: "+requestData);
    }

    @RequestMapping(value = "/addFile/{fileId}/{fileName}/{lineNumber}/{minWord}/{maxWord}/{minWordLength}/{maxWordLength}/{averageWordLength}/{allWordsLength}/{wordsCount}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addFileStatistic(@PathVariable("fileId") long fileId, @PathVariable("fileName") String fileName, @PathVariable("lineNumber") int lineNumber, @PathVariable("minWord") String minWord,
                        @PathVariable("maxWord") String maxWord, @PathVariable("minWordLength") int minWordLength, @PathVariable("maxWordLength") int maxWordLength,
                        @PathVariable("averageWordLength") int averageWordLength, @PathVariable("allWordsLength") long allWordsLength,@PathVariable("wordsCount") int wordsCount) {

        System.out.println("\n\n\n  --------->>>>>>>>> Обработали запрос: addFileStatistic(). На вход прилетело: fileId="+fileId+"; fileName="+fileName+"; lineNumber="+lineNumber);
        Line line = new Line();
        line.setFileId(fileId);
        line.setFileName(fileName);
        line.setLineNumber(lineNumber);
        line.setMinWord(minWord);
        line.setMaxWord(maxWord);
        line.setMinWordLength(minWordLength);
        line.setMaxWordLength(maxWordLength);
        line.setAverageWordLength(averageWordLength);
        line.setAllWordsLength(allWordsLength);
        line.setWordsCount(wordsCount);
        fileStatisticDao.addFileStatistic(line);

    }

}
