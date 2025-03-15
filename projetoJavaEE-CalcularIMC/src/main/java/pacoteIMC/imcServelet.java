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
		
		System.out.printf("Nome digitado: %s; Peso digitado: %f; Altura digitado: %f",nome,peso,altura);
		System.out.printf("Seu cálculo do IMC resoltou em: %f",imc);
	}
	
}
