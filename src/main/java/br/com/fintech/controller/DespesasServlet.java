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
import br.com.fintech.beans.DespesasDTO;
import br.com.fintech.dao.DespesasDAO;
import br.com.fintech.factory.DAOFactory;

@WebServlet("/Despesas")


public class DespesasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DespesasDAO dao;
	private ArrayList<DespesasDTO> listadespesa;
	
	public void init() throws ServletException{
		super.init();
		dao = DAOFactory.getDespesasDAO();
		listadespesa = new ArrayList<>();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    System.out.println("DespesasServlet chamado com action: " + action);
	    listadespesa.clear();

	    if (action != null) {
	        switch (action) {
	            case "listardespesa":
	                listarDespesa(request, response);
	                break;

	            case "open-form-despesaedicao":	                
	                buscarDespesa(request, response);
	                break;

	            default:
	            	response.sendRedirect("index.jsp");
	                break;
	        }
	    } else {
	        response.sendRedirect("index.jsp");
	    }
	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	listadespesa.clear();
    	
    	switch (action) {
    		case "cadastrardespesas":
    			cadastrarDespesa(request, response);
    			break;
    			
    		case "editardespesas":
    			editarDespesa(request, response);
    			break;
    			
    		case "excluirdespesas":
    			excluirDespesa(request, response);
    			break;
    	}
    }
    
	protected void listarDespesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cheguei aqui");
		listadespesa.clear();
		listadespesa = dao.listarDespesa();
		System.out.println("Lista de despesas: " + listadespesa);
		request.setAttribute("despesas", listadespesa);
		request.getRequestDispatcher("listaDespesa.jsp").forward(request, response);		
	}
    
    protected void cadastrarDespesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DespesasDTO despesa = new DespesasDTO();
    	
    	try {
    		despesa.setNm_despesa(request.getParameter("nomedespesa"));
    		despesa.setVl_despesa(Double.parseDouble(request.getParameter("valordespesa")));
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		try {
    			Date dtDespesa = format.parse(request.getParameter("datadespesa"));
    			despesa.setDt_despesa(dtDespesa);

    			Date dtVencimento = format.parse(request.getParameter("datavencdespesa"));
    			despesa.setDt_vencimento(dtVencimento);
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
            if (request.getParameter("statusdespesa") != null) {
                despesa.setSt_despesa(Integer.parseInt(request.getParameter("statusdespesa")));
            } else {
                despesa.setSt_despesa(0);
            }
    		despesa.setDs_despesa(request.getParameter("descdespesa"));
    		
    		dao.cadastrarDespesa(despesa);
    		request.setAttribute("msg", "Despesa Cadastrada");
    	}
    	catch(DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao Cadastrar");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Valide os dados");
    	} 
    	// listarDespesa(request, response);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroDespesa.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void buscarDespesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int idDespesa = Integer.parseInt(request.getParameter("iddespesa"));
    	DespesasDTO despesa = dao.buscarDespesa(idDespesa);
    	request.setAttribute("despesa", despesa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edicaoDespesa.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void editarDespesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try {
    		DespesasDTO despesa = new DespesasDTO();
    		despesa.setId_despesa(Integer.parseInt(request.getParameter("iddespesa")));
    		despesa.setNm_despesa(request.getParameter("nomedespesa"));
    		despesa.setVl_despesa(Double.parseDouble(request.getParameter("valordespesa")));
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		try {
    			Date dtDespesa = format.parse(request.getParameter("datadespesa"));
    			despesa.setDt_despesa(dtDespesa);

    			Date dtVencimento = format.parse(request.getParameter("datavencdespesa"));
    			despesa.setDt_vencimento(dtVencimento);
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
            if (request.getParameter("statusdespesa") != null) {
                despesa.setSt_despesa(Integer.parseInt(request.getParameter("statusdespesa")));
            } else {
                despesa.setSt_despesa(0);
            }
    		despesa.setDs_despesa(request.getParameter("descdespesa"));
    		dao.atualizarDespesa(despesa);
    		request.setAttribute("msg", "Despesa Atualizada");
    		listarDespesa(request, response);
    	}
    	catch(DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao Atualizar");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		request.setAttribute("erro", "Valide os dados");
    	} 
    }
    
    private void excluirDespesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int idDespesa = Integer.parseInt(request.getParameter("iddespesa"));
    	try {
    		dao.removerDespesa(idDespesa);
    		request.setAttribute("msg", "Despesa removido");    		
    	} catch (DBException db) {
    		db.printStackTrace();
    		request.setAttribute("erro", "Erro ao remover a despesa");
    	}
    	listarDespesa(request, response);
    }    
} 