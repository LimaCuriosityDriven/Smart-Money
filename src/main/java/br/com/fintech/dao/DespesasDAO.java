package br.com.fintech.dao;

import java.util.ArrayList;

import br.com.fiap.store.exception.DBException;
import br.com.fintech.beans.DespesasDTO;

public interface DespesasDAO {
	void cadastrarDespesa(DespesasDTO despesa) throws DBException;
	void atualizarDespesa(DespesasDTO despesa) throws DBException;
	void removerDespesa(int id_despesa) throws DBException;
	DespesasDTO buscarDespesa(int id_despesa);
	ArrayList<DespesasDTO> listarDespesa();
}
