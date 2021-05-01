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

public class AlteraEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	


		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("acao altera empresa" + id);
		
		Date dataAbertura=null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (java.text.ParseException e) {
			throw new ServletException(e);
		}
		
		
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
		
	}

}
