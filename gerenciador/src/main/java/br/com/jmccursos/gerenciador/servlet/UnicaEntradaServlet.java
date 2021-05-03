package br.com.jmccursos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jmccursos.gerenciador.acao.Acao;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
//		HttpSession htses= request.getSession();
//		boolean usuarioNaoEstaLogado= (htses.getAttribute("usuarioLogado")==null);
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
		
		
		
		
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
		
		
		
		
//				
//		String nomeJsp = null;
//		
//		if(paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//		    nomeJsp = acao.executa(request,response);
//		}else if(paramAcao.equals("MostraEmpresa")) {			
//			MostraEmpresa acao = new MostraEmpresa();
//			nomeJsp =acao.executa(request,response);
//		}else if(paramAcao.equals("RemoveEmpresa")) {	
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nomeJsp = acao.executa(request,response);			
//		}else if(paramAcao.equals("AlteraEmpresa")) {	
//			AlteraEmpresa acao = new AlteraEmpresa(); 
//			nomeJsp = acao.executa(request,response);			
//		}else if(paramAcao.equals("NovaEmpresa")) {	
//			NovaEmpresa acao = new NovaEmpresa();
//			nomeJsp =acao.executa(request,response);
//			
//		}else if(paramAcao.equals("NovaEmpresaForm")) {	
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nomeJsp =acao.executa(request,response);
//			
//		}
	
	
	}

}
