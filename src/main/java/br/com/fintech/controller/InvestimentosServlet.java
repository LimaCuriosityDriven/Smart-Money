package br.com.fintech.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.store.exception.DBException;
import br.com.fintech.beans.InvestimentosDTO;
import br.com.fintech.dao.InvestimentosDAO;
import br.com.fintech.factory.DAOFactory;

@WebServlet("/Investimentos")
public class InvestimentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvestimentosDAO dao;
	private ArrayList<InvestimentosDTO> listainvestimento;
	
    public InvestimentosServlet() {
    	super();
    	dao = DAOFactory.getInvestimentosDAO();
    	listainvestimento = new ArrayList<>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		listainvestimento.clear();
		
		switch (action) {
			case "listarinvestimento":
			listarInvestimento(request, response);
			break;
			
			case "open-form-investimentoedicao":
			buscarInvestimento(request, response);
			break;
				
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		listainvestimento.clear();
		
		switch (action) {
			case "cadastrarinvestimento":
			cadastrarInvestimento(request, response);
			break;
			
			case "excluirinvestimento":
			excluirInvestimento(request, response);
			break;
			
			case "editarinvestimento":
			editarInvestimento(request, response);
			break;	
		}
	}
	
	protected void cadastrarInvestimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvestimentosDTO investimento = new InvestimentosDTO();
		
		try {	
			investimento.setNm_investimento(request.getParameter("nomeinvestimento"));
			investimento.setVl_investimento(Double.parseDouble(request.getParameter("valorinvestimento")));
			investimento.setVl_retorno_mes(Double.parseDouble(request.getParameter("valorretornoinvestimento")));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
    			Date dtInvestimento = format.parse(request.getParameter("datainvestimento"));
    			investimento.setDt_investimento(dtInvestimento);

    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
			
			dao.cadastrarInvestimento(investimento);
			request.setAttribute("msg", "Investimento Cadastrado");			
		} catch(DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao Cadastrar");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Valide os dados");
    	} 
    	RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroInvestimento.jsp");
        dispatcher.forward(request, response);
	}
	
	protected void excluirInvestimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int idInvestimento = Integer.parseInt(request.getParameter("idinvestimento"));
	    try {
	        dao.removerInvestimento(idInvestimento);
	        request.setAttribute("msg", "Investimento removido");
	    } catch (DBException db) {
	        db.printStackTrace();
	        request.setAttribute("erro", "Erro ao remover o investimento");
	    }
	    listarInvestimento(request, response);
	}
	
	protected void editarInvestimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void buscarInvestimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idInvestimento = Integer.parseInt(request.getParameter("idinvestimento"));
		InvestimentosDTO investimento = dao.buscarInvestimento(idInvestimento);
		request.setAttribute("investimento", investimento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edicaoInvestimento.jsp");
        dispatcher.forward(request, response);		
	}
	
	protected void listarInvestimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listainvestimento.clear();
		listainvestimento = dao.listarInvestimento();
		request.setAttribute("investimentos", listainvestimento);
		request.getRequestDispatcher("listaInvestimentos.jsp").forward(request, response);
	}
}
