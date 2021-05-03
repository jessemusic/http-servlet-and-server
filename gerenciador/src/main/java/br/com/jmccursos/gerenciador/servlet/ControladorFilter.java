package br.com.jmccursos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jmccursos.gerenciador.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControladorFilter");		
		HttpServletRequest request =(HttpServletRequest)servletRequest;
		HttpServletResponse response =(HttpServletResponse)servletResponse;
		
		String paramAcao = request.getParameter("acao");		
		String nomeDaClasse = "br.com.jmccursos.gerenciador.acao."+ paramAcao;		
		
		String nomeJsp;
		try {
			Class classe = Class.forName(nomeDaClasse);//Carrega a classe com o nome da String
			Acao acao = (Acao) classe.newInstance();		
			nomeJsp = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[]  tipoEEnderoco = nomeJsp.split(":");
		if(tipoEEnderoco[0].equals("forward")) {	
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEEnderoco[1]);
			requestDispatcher.forward(request, response);
		}else{

			response.sendRedirect(tipoEEnderoco[1]);
		}		
	}	
}
