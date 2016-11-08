package dmroy.luxoft.servlet;

import dmroy.luxoft.MainContext;
import static dmroy.luxoft.MainContext.fileStatisticDao;
import dmroy.luxoft.PageContent;
import dmroy.luxoft.been.FileStatistic;
import dmroy.luxoft.been.Line;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "FileNameListServlet", urlPatterns = {"/allFiles"})
public class FileNameListServlet extends HttpServlet {

//    private FileStatistic fileStatistic;

    public FileNameListServlet(){
//        System.out.println("-------- FileNameListServlet() 123 ---------------------");
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

//        System.out.println("\n FileNameListServlet processRequest 0 \n");
        List<String> fileList = fileStatisticDao.getAllFileStaticticName();
//        System.out.println("\n FileNameListServlet processRequest 1 \n");

        try (PrintWriter out = response.getWriter()) {
            PageContent pageContent = new PageContent();
            String title = "Список обработанных файлов.";
            out.println(pageContent.getHeader(title));
            out.println("<table id=\"table_center\">"
                                +"<caption>"+title+"</caption>"
                                + "<tr>"
                                    + "<td class=\"tableHeader\">Название файла</td>"
                                + "</tr>");
            for (String fileName : fileList){
                printRow(out,fileName);
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
//        System.out.println("\n FileNameListServlet doPost 1 \n");
////        String fileName = request.getParameter("fileName");
//        try (PrintWriter out = response.getWriter()) {
//            PageContent pageContent = new PageContent();
//            String title = "Список обработанных файлов.";
//            out.println(pageContent.getHeader(title));
//            out.println("<table id=\"table_center\">"
//                                +"<caption>"+title+"</caption>"
//                                + "<tr>"
//                                    + "<td class=\"tableHeader\">Название файла</td>"
//                                + "</tr>");
//
//            List<String> fileList = fileStatisticDao.getAllFileStaticticName();
//            for (String fileName : fileList){
//                printRow(out, fileName);
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

    private void printRow(PrintWriter out,String fileName){
        out.println("<tr>"
                        + "<td>"
                            + "<a href=\"fileStatistics?fileName="+fileName+"\" title=\"Информация о файле\">" + fileName  + "</a>"
                        + "</td>"
                    + "</tr>");
    }

}
