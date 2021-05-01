package br.com.jmccursos.gerenciador.acao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jmccursos.gerenciador.modelo.Banco;
import br.com.jmccursos.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("acao Cadatrando Nova empresa");

		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		
		Date dataAbertura=null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (java.text.ParseException e) {
			throw new ServletException(e);
		}
		
		
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		
		//response.sendRedirect("entrada?acao=ListaEmpresas");
		return "redirect:entrada?acao=ListaEmpresas";
		
//		//Chamar o JSP
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		requestDispatcher.forward(request, response);
		
		
	}

}
