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
import br.com.fintech.beans.RecebimentosDTO;
import br.com.fintech.dao.RecebimentosDAO;
import br.com.fintech.factory.DAOFactory;

@WebServlet("/Recebimentos")
public class RecebimentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecebimentosDAO dao;
	private ArrayList<RecebimentosDTO> listarecebimento;
	
    public RecebimentosServlet() {
        super();
        dao = DAOFactory.getRecebimentosDAO();
        listarecebimento = new ArrayList<>();
        }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		listarecebimento.clear();
		
		switch (action) {
		case "listarrecebimentos":
			listarRecebimento(request, response);	
			break;
		
		case "open-form-recebimentoedicao":
			buscarRecebimento(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		listarecebimento.clear();
		
		switch (action) {
			case "cadastrarrecebimento":
				cadastrarRecebimento(request, response);
				break;
			
			case "editarrecebimento":
				editarRecebimento(request, response);
				break;
			
			case "excluirrecebimento":
				excluirRecebimento(request, response);
		}
	}
	
	private void editarRecebimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecebimentosDTO recebimento = new RecebimentosDTO();
		try {
			recebimento.setId_recebimento(Integer.parseInt(request.getParameter("idrecebimento")));
			recebimento.setNm_recebimento(request.getParameter("nomerecebimento"));
			recebimento.setVl_recebimento(Double.parseDouble(request.getParameter("valorrecebimento")));
			if (request.getParameter("statusdespesa") != null) {
                recebimento.setSt_recebimento(Integer.parseInt(request.getParameter("statusrecebimento")));
            } else {
                recebimento.setSt_recebimento(0);
            }
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
    			Date dtRecebimento = format.parse(request.getParameter("datarecebimento"));
    			recebimento.setDt_recebimento(dtRecebimento);

    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
			recebimento.setDs_recebimento(request.getParameter("descrecebimento"));
			
			dao.atualizarRecebimento(recebimento);
			request.setAttribute("msg", "Recebimento Atualizado");
			listarRecebimento(request, response);
			
		} catch(DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao Atualizar");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Valide os dados");
    	} 
		
	}

	protected void cadastrarRecebimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecebimentosDTO recebimento = new RecebimentosDTO();
		
		try {	
			recebimento.setNm_recebimento(request.getParameter("nomerecebimento"));
			recebimento.setVl_recebimento(Double.parseDouble(request.getParameter("valorrecebimento")));
			if (request.getParameter("statusdespesa") != null) {
                recebimento.setSt_recebimento(Integer.parseInt(request.getParameter("statusrecebimento")));
            } else {
                recebimento.setSt_recebimento(0);
            }
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
    			Date dtRecebimento = format.parse(request.getParameter("datarecebimento"));
    			recebimento.setDt_recebimento(dtRecebimento);

    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
			recebimento.setDs_recebimento(request.getParameter("descrecebimento"));
			
			dao.cadastrarRecebimento(recebimento);
			request.setAttribute("msg", "Recebimento Cadastrado");
			
		} catch(DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao Cadastrar");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Valide os dados");
    	} 
    	RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroRecebimento.jsp");
        dispatcher.forward(request, response);
	}
	
	protected void listarRecebimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarecebimento.clear();
		listarecebimento = dao.listarRecebimento();
		request.setAttribute("recebimentos", listarecebimento);
		request.getRequestDispatcher("listaRecebimento.jsp").forward(request, response);
	}
	
	private void buscarRecebimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idRecebimento = Integer.parseInt(request.getParameter("idrecebimento"));
		RecebimentosDTO recebimento = dao.buscarRecebimento(idRecebimento);
		request.setAttribute("recebimento", recebimento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edicaoRecebimento.jsp");
        dispatcher.forward(request, response);		
	}
	
	private void excluirRecebimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idRecebimento = Integer.parseInt(request.getParameter("idrecebimento"));
    	try {
    		dao.removerRecebimento(idRecebimento);
    		request.setAttribute("msg", "Recebimento removido");    		
    	} catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao remover o recebimento");
    	}
    	listarRecebimento(request, response);
	}

}
	