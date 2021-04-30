package br.com.jmccursos.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jmccursos.gerenciador.modelo.Banco;
import br.com.jmccursos.gerenciador.modelo.Empresa;

public class ListaEmpresas  {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listando empresa");
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		request.setAttribute("empresas", lista);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
		requestDispatcher.forward(request, response);
	}

}
