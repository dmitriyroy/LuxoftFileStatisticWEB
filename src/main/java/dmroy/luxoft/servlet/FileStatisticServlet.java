package dmroy.luxoft.servlet;

import dmroy.luxoft.MainContext;
import static dmroy.luxoft.MainContext.fileStatisticDao;
import dmroy.luxoft.PageContent;
import dmroy.luxoft.been.Line;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Дима
 */
@WebServlet(name = "FileStatisticServlet", urlPatterns = {"/fileStatistics"})
public class FileStatisticServlet extends HttpServlet {

    public FileStatisticServlet(){
        new MainContext();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Line> lineList = fileStatisticDao.getFileStatictic(Long.parseLong(request.getParameter("fileId"))).getLineList();

        try (PrintWriter out = response.getWriter()) {
            PageContent pageContent = new PageContent();
            String title = "Информация о файле.";
            out.println(pageContent.getHeader(title));
            out.println("<table id=\"table_center\">"
                                +"<caption>"+title+"</caption>"
                                + "<tr>"
                                    + "<td class=\"tableHeader\">Название файла</td>"
//                                    + "<td class=\"tableHeader\">ID файла</td>"
                                    + "<td class=\"tableHeader\">Номер строки</td>"
                                    + "<td class=\"tableHeader\">Самое короткое слово</td>"
                                    + "<td class=\"tableHeader\">Самое длинное слово</td>"
                                    + "<td class=\"tableHeader\">Длина короткого слова</td>"
                                    + "<td class=\"tableHeader\">Длина длинного слова</td>"
                                    + "<td class=\"tableHeader\">Средняя длина слова</td>"
                                    + "<td class=\"tableHeader\">Длина всех уникальных слов</td>"
                                    + "<td class=\"tableHeader\">Кол-во уникальных слов</td>"
                                + "</tr>");
            for (Line line:lineList){
                printRow(out, line);
            }
            out.println("</table>");
            out.println(pageContent.getFooter());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        String fileName = request.getParameter("fileName");
//        try (PrintWriter out = response.getWriter()) {
//            PageContent pageContent = new PageContent();
//            String title = "Информация о файле.";
//            out.println(pageContent.getHeader(title));
//            out.println("<table id=\"table_center\">"
//                                +"<caption>"+title+"</caption>"
//                                + "<tr>"
//                                    + "<td class=\"tableHeader\">Название файла</td>"
////                                    + "<td class=\"tableHeader\">ID файла</td>"
//                                    + "<td class=\"tableHeader\">Номер строки</td>"
//                                    + "<td class=\"tableHeader\">Самое короткое слово</td>"
//                                    + "<td class=\"tableHeader\">Самое длинное слово</td>"
//                                    + "<td class=\"tableHeader\">Длина короткого слова</td>"
//                                    + "<td class=\"tableHeader\">Длина длинного слова</td>"
//                                    + "<td class=\"tableHeader\">Средняя длина слова</td>"
//                                    + "<td class=\"tableHeader\">Длина всех уникальных слов</td>"
//                                    + "<td class=\"tableHeader\">Кол-во уникальных слов</td>"
//                                + "</tr>");
//
//            List<Line> lineList = fileStatisticDao.getFileStatictic(fileName).getLineList();
//            for (Line line:lineList){
//                printRow(out, line);
//            }
//            out.println("</table>");
//            out.println(pageContent.getFooter());
//        }
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void printRow(PrintWriter out,Line line){
        out.println("<tr>"
                        + "<td>"
                            + line.getFileName()
                        + "</td>"
//                        + "<td  class=\"textCenter\">"
//                            + line.getFileId()
//                        + "</td>"
                        + "<td  class=\"textCenter\">"
                            + line.getLineNumber()
                        + "</td>"
                        + "<td>"
                            + line.getMinWord()
                        + "</td>"
                        + "<td>"
                            + line.getMaxWord()
                        + "</td>"
                        + "<td  class=\"textCenter\">"
                            + line.getMinWordLength()
                        + "</td>"
                        + "<td  class=\"textCenter\">"
                            + line.getMaxWordLength()
                        + "</td>"
                        + "<td  class=\"textCenter\">"
                            + line.getAverageWordLength()
                        + "</td>"
                        + "<td  class=\"textCenter\">"
                            + line.getAllWordsLength()
                        + "</td>"
                        + "<td  class=\"textCenter\">"
                            + line.getWordsCount()
                        + "</td>"
                    + "</tr>");
    }

}
