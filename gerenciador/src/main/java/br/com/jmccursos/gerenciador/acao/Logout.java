package br.com.jmccursos.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession htReq = request.getSession();
		
		//htReq.removeAttribute("usuarioLogado");
		htReq.invalidate();
		
		
		
		return "redirec t:entrada?acao=LoginForm";
	}

}
