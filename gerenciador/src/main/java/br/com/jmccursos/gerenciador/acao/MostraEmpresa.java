package br.com.jmccursos.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jmccursos.gerenciador.modelo.Banco;
import br.com.jmccursos.gerenciador.modelo.Empresa;

public class MostraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Mostrando empresa");
		String paramId=request.getParameter("id");
		Integer id= Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		requestDispatcher.forward(request, response);
	}

}
