package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@WebServlet("/lotto")
public class LottoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Set<Integer> lottoNumbers = generateLottoNumbers();

        out.println("<html>");
        out.println("<head><title>Lotto Numbers</title><link rel='stylesheet' type='text/css' href='styles.css'></head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Your Lotto Numbers</h1>");
        out.println("<div class='numbers'>");
        for (Integer number : lottoNumbers) {
            out.println("<div class='number'>" + number + "</div>");
        }
        out.println("</div>");
        out.println("<button onclick='window.location.reload();'>Generate New Numbers</button>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private Set<Integer> generateLottoNumbers() {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(45) + 1);
        }
        return numbers;
    }
}
