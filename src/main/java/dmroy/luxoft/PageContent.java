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
                            +"<ul>"
                                +"<li id=\"mainMenuIndex\"><a href=\"index.htm\">Главная</a></li>"
//                                +"<li><a href=\"fileparser/add/\">Обработать файл</a></li>"
                                +"<li id=\"mainMenuFileList\"> "
                                +"    <form id=\"fileChoose\" action=\"allFiles\">"
                                +"        <input id=\"btnSumit\" type=\"submit\" value=\"Список обработанных файлов\" >"
                                +"        <select id=\"selectForm\" name=\"fileCount\" size=\"1\" >"
                                +"            <option value=\"all\" style=\"\">Все файлы</option>"
                                +"            <option value=\"10\">Файлы до 10 строк</option>"
                                +"            <option value=\"50\">Файлы до 50 строк</option>"
                                +"            <option value=\"100\">Файлы до 100 строк</option>"
                                +"            <option value=\"500\">Файлы до 500 строк</option>"
                                +"        </select>"
                                +"    </form>"
                                +"</li>"
                            +"</ul>"
                        +"</div>"
                        +"<div class=\"button_back_area\"><input class=\"button_back\" type=\"button\" value=\"Назад\""
                        +" onclick=\"window.history.back()\" /></div>";
    }

    public String getFooter(){
        return "</body></html>";
    }

}
