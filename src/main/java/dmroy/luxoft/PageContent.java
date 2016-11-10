package dmroy.luxoft;

/**
 *
 * @author dmitriyroy
 */
public class PageContent {

    public PageContent(){

    }

    public String getHeader(String title){
        return"<!DOCTYPE html>"
                +"<html>"
                    +"<head>"
                        +"<title>"+title+"</title>"
                        +"<link href=\"resources/css/style.css\" rel=\"stylesheet\" type=\"text/css\">"
                        +"<script type=\"text/javascript\" src=\"resources/js/script.js\"></script>"
                        +"</head>"
                    +"<body>"
                        +"<div id=\"mainMenu\">\n"
                            +"<ul>\n"
                                +"<li id=\"mainMenuIndex\"><a href=\"index.htm\">Главная</a></li>\n"
//                                +"<li><a href=\"fileparser/add/\">Обработать файл</a></li>\n"
                                +"<li id=\"mainMenuFileList\"><a href=\"allFiles\">Список обработанных файлов</a></li>\n"
                            +"</ul>\n"
                        +"</div>"
                        +"<div class=\"button_back_area\"><input class=\"button_back\" type=\"button\" value=\"Назад\""
                        +" onclick=\"window.history.back()\" /></div>";
    }

    public String getFooter(){
        return "</body></html>";
    }

}
