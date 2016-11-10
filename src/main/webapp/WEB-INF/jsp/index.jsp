<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> ООО "IT-эксперт" - справочник </title>
        <link href="resources/css/style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="resources/js/script.js"></script>
    </head>

    <body>
        <div id="mainMenu">
            <ul>
                <li id="mainMenuIndex"><a href="index.htm">Главная</a></li>
                <!--<li><a href="fileparser/add/">Обработать файл</a></li>-->
                <li id="mainMenuFileList"> 
                <form id="fileChoose" action="allFiles">
                    <input id="btnSumit" type="submit" value="Список обработанных файлов" >
                <select id="selectForm" name="fileCount" onchange="" size="1" >
                    <option value="all" style="">Все файлы</option>
                    <option value="10">Файлы до 10 строк</option>
                    <option value="50">Файлы до 50 строк</option>
                    <option value="100">Файлы до 100 строк</option>
                    <option value="500">Файлы до 500 строк</option>
                </select>
                </form>
                </li>
            </ul>
        </div>

        <div id="indexCenter">
            <h4>
              WEB-интерфейс обработчика файлов для получения статистики его строк.
            </h4>

            <p class="enterpriseInfo">Тестовое задание<br>
                на вакансию <a href="http://career.luxoft.com/careers/110764/sq-senior-java/" target="blank">SQ_SENIOR JAVA</a><br>
            </p>

            <p class="developers">
                Разработал:<br>
                Дмитрий Рой<br>
                тел: (050) 45-22-411 / (068) 974-81-30<br>
                dmitriy.roy@ita.biz.ua
            </p>
        </div>

    </body>
</html>
