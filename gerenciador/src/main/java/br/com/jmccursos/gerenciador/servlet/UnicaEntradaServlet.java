package br.com.jmccursos.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jmccursos.gerenciador.acao.AlteraEmpresa;
import br.com.jmccursos.gerenciador.acao.ListaEmpresas;
import br.com.jmccursos.gerenciador.acao.MostraEmpresa;
import br.com.jmccursos.gerenciador.acao.NovaEmpresa;
import br.com.jmccursos.gerenciador.acao.NovaEmpresaForm;
import br.com.jmccursos.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String nomeJsp = null;
		
		if(paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
		    nomeJsp = acao.executa(request,response);
		}else if(paramAcao.equals("MostraEmpresa")) {			
			MostraEmpresa acao = new MostraEmpresa();
			nomeJsp =acao.executa(request,response);
		}else if(paramAcao.equals("RemoveEmpresa")) {	
			RemoveEmpresa acao = new RemoveEmpresa();
			nomeJsp = acao.executa(request,response);			
		}else if(paramAcao.equals("AlteraEmpresa")) {	
			AlteraEmpresa acao = new AlteraEmpresa(); 
			nomeJsp = acao.executa(request,response);			
		}else if(paramAcao.equals("NovaEmpresa")) {	
			NovaEmpresa acao = new NovaEmpresa();
			nomeJsp =acao.executa(request,response);
			
		}else if(paramAcao.equals("NovaEmpresaForm")) {	
			NovaEmpresaForm acao = new NovaEmpresaForm();
			nomeJsp =acao.executa(request,response);
			
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
