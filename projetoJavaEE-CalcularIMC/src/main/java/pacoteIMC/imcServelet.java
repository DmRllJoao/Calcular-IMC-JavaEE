package pacoteIMC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/imc")
public class imcServelet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nomeP");
		
		double altura = Double.parseDouble(req.getParameter("alturaP"));
		double peso = Double.parseDouble(req.getParameter("pesoP"));
		
		double imc = peso / (altura*altura);
		
		System.out.printf("Nome digitado: %s; Peso digitado: %.2f; Altura digitado: %.2f",nome,peso,altura);
		System.out.printf("Seu cálculo do IMC resoltou em: %.2f",imc);
	
	
	
		 // Configura a resposta como HTML
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        // Escreve a resposta na página
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head><title>Resultado do IMC</title></head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h2>Olá, " + nome + "!</h2>");
        resp.getWriter().println("<p>Seu IMC é: <strong>" + String.format("%.2f", imc) + "</strong></p>");
	
     // Exibir a classificação do IMC
        if (imc < 18.5) {
            resp.getWriter().println("<p>Classificação: Abaixo do peso.</p>");
        } else if (imc < 24.9) {
            resp.getWriter().println("<p>Classificação: Peso normal.</p>");
        } else if (imc < 29.9) {
            resp.getWriter().println("<p>Classificação: Sobrepeso.</p>");
        } else {
            resp.getWriter().println("<p>Classificação: Obesidade.</p>");
        }

        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
	}
	
}
