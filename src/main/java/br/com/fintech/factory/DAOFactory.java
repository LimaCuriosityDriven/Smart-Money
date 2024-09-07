package br.com.fintech.factory;

import br.com.fintech.dao.DespesasDAO;
import br.com.fintech.dao.InvestimentosDAO;
import br.com.fintech.dao.RecebimentosDAO;
import br.com.fintech.dao.implement.OracleDespesaDAO;
import br.com.fintech.dao.implement.OracleInvestimentosDAO;
import br.com.fintech.dao.implement.OracleRecebimentoDAO;

public class DAOFactory {
	
	public static DespesasDAO getDespesasDAO() {
		System.out.println("Cheguei aqui no DaoFactory");
		return new OracleDespesaDAO();
	}
	
	public static RecebimentosDAO getRecebimentosDAO() {
		return new OracleRecebimentoDAO();
	}
	
	public static InvestimentosDAO getInvestimentosDAO() {
		return new OracleInvestimentosDAO();
	}
}
