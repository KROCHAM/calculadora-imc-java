/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kyron_rocha
 */
@WebServlet(name = "IMCServlet", urlPatterns = {"/IMCServlet"})
public class IMCServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String pesoS = request.getParameter("peso");
            String alturaS = request.getParameter("altura");
            String sexo = request.getParameter("sexo");
            String status = "";
            String color = "";
            //IMC = peso / (altura x altura )
            float  peso = Float.parseFloat(pesoS);
            float  altura = Float.parseFloat(alturaS);
            float  imc = peso / (altura*altura);
            float minPeso = 20.8f * (altura*altura);
            float maxPeso = 26.4f * (altura*altura);
            
            if(sexo.equals("homem")){
                
                if(imc <= 20.7){
                    status = "Abaixo do peso";
                    color = "#9bdaeb";
                }
                
                if(imc > 20.7 && imc <= 26.4){
                    status = "pesando normal";
                    color = "#44d085";
                }
                
                if(imc > 26.4 && imc <= 27.8){
                    status = "marginalmente acima do peso";
                    color = "#f9d98f";
                }
                
                if(imc > 27.8 && imc <= 31.1){
                    status = "acima do peso";
                    color = "#f2a745";
                }
                
                if(imc > 31.1){
                    status = "com obesidade";
                    color = "#f36666";
                }
                
            }else{
                 if(imc <= 19.1){
                    status = "abaixo do peso";
                    color = "#9bdaeb";
                }
                
                if(imc > 19.1 && imc <= 25.8){
                    status = "pesando normal";
                    color = "#44d085";
                }
                
                if(imc > 25.8 && imc <= 27.3){
                    status = "marginalmente acima do peso";
                    color = "#f9d98f";
                }
                
                if(imc > 27.3 && imc <= 32.3){
                    status = "acima do peso";
                    color = "#f2a745";
                }
                
                if(imc > 32.3){
                    status = "com obesidade";
                    color = "#f36666";
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IMCServlet</title>"); 
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\" justify-content-center align-items-baseline\" style=\"padding-top: 200px;text-align: center\">");
            out.println("<div><h1>RESULTADO</h1></div>");
             out.println("<div><h3 style=\"background-color: "+color+";width: auto;color:white; padding-top:20px;padding-bottom:20px\">Você está " + status + " </h3></div>");
            out.println("<div><h3 style=\"color:gray \">Seu IMC é : " + imc + "</h3></div>");
           
            out.println("<div><h3 style=\"color:gray \">Peso ideal entre "+minPeso+" Kg e "+maxPeso+" Kg</h3></div>");
            out.print("<button type=\"button\" class=\"btn btn-success\"><a style=\"color:white;text-decoration:none \" href='https://www.unimedfortaleza.com.br/blog/alimentacao/dicas-praticas-para-manter-o-peso-ideal'>Confira dicas para o peso ideal</a</button>");
            out.println("</div>");                       
            out.println("</body>");
            out.println("<footer class=\"bg-light text-center text-lg-start\" style=\"position: fixed; bottom: 0;width: 100%; color:white\">");
            out.println("<div class=\"text-center p-3\" style=\"background-color: #151b26\">");
            out.println("Feito com ❤ por");
            out.println("<a   href=\"https://www.linkedin.com/in/kyron-rocha-madeira-melo-391218197/\" style=\"text-decoration: none\"> ");
            out.println("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-linkedin\" viewBox=\"0 0 16 16\">");
            out.println("<path d=\"M0 1.146C0 .513.526 0 1.175 0h13.65C15.474 0 16 .513 16 1.146v13.708c0 .633-.526 1.146-1.175 1.146H1.175C.526 16 0 15.487 0 14.854V1.146zm4.943 12.248V6.169H2.542v7.225h2.401zm-1.2-8.212c.837 0 1.358-.554 1.358-1.248-.015-.709-.52-1.248-1.342-1.248-.822 0-1.359.54-1.359 1.248 0 .694.521 1.248 1.327 1.248h.016zm4.908 8.212V9.359c0-.216.016-.432.08-.586.173-.431.568-.878 1.232-.878.869 0 1.216.662 1.216 1.634v3.865h2.401V9.25c0-2.22-1.184-3.252-2.764-3.252-1.274 0-1.845.7-2.165 1.193v.025h-.016a5.54 5.54 0 0 1 .016-.025V6.169h-2.4c.03.678 0 7.225 0 7.225h2.4z\"/>");
            out.println("</svg>");
            out.println("Kyron Rocha");
            out.println("</a>");
            out.println("</div>");
            out.println(" </footer>");
            out.println("</html>");
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void swtch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
