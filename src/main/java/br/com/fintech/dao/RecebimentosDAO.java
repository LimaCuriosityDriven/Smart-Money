package br.com.fintech.dao;

import java.util.ArrayList;

import br.com.fiap.store.exception.DBException;
import br.com.fintech.beans.RecebimentosDTO;

public interface RecebimentosDAO {
	void cadastrarRecebimento(RecebimentosDTO recebimento) throws DBException;
	void atualizarRecebimento(RecebimentosDTO recebimento) throws DBException;
	void removerRecebimento(int id_recebimento) throws DBException;
	RecebimentosDTO buscarRecebimento(int id_recebimento);
	ArrayList<RecebimentosDTO> listarRecebimento();
}
