package br.com.fintech.dao;

import java.util.ArrayList;

import br.com.fiap.store.exception.DBException;
import br.com.fintech.beans.InvestimentosDTO;

public interface InvestimentosDAO {
	void cadastrarInvestimento(InvestimentosDTO investimento) throws DBException;
	void atualizarInvestimento(InvestimentosDTO investimento) throws DBException;
	void removerInvestimento(int id_investimento) throws DBException;
	InvestimentosDTO buscarInvestimento(int id_investimento);
	ArrayList<InvestimentosDTO> listarInvestimento();
}
