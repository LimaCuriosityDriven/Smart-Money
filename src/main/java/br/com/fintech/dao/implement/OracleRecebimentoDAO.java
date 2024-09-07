package br.com.fintech.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fiap.store.exception.DBException;
import br.com.fintech.beans.RecebimentosDTO;
import br.com.fintech.dao.RecebimentosDAO;
import br.com.fintech.singleton.ConexaoDAO;


public class OracleRecebimentoDAO implements RecebimentosDAO{
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    ArrayList<RecebimentosDTO> listaRecebimento = new ArrayList<>();
    

	@Override
	public void cadastrarRecebimento(RecebimentosDTO recebimento) throws DBException {
        conn = new ConexaoDAO().conectaBD();

        try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return;
            }
            String sql = "INSERT INTO T_FIN_RECEBIMENTOS (nm_recebimento, vl_recebimento, dt_recebimento, st_recebimento, ds_recebimento) VALUES(?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, recebimento.getNm_recebimento());
            pstm.setDouble(2, recebimento.getVl_recebimento());
            java.sql.Date datarecebimento = new java.sql.Date(recebimento.getDt_recebimento().getTime());
            pstm.setDate(3, datarecebimento);
            pstm.setInt(4,recebimento.getSt_recebimento());
            pstm.setString(5, recebimento.getDs_recebimento());

            pstm.executeUpdate();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar um Recebimento! Erro na classe OracleRecebimentosDAO Cadastrar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	@Override
	public void atualizarRecebimento(RecebimentosDTO recebimento) throws DBException {
		conn = new ConexaoDAO().conectaBD();
		
		try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return;
            }
            String sql = "UPDATE T_FIN_RECEBIMENTOS SET nm_recebimento = ?, vl_recebimento = ?, dt_recebimento = ?, st_recebimento = ?, ds_recebimento = ? WHERE id_recebimento = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, recebimento.getNm_recebimento());
            pstm.setDouble(2, recebimento.getVl_recebimento());
            java.sql.Date datarecebimento = new java.sql.Date(recebimento.getDt_recebimento().getTime());
            pstm.setDate(3, datarecebimento);
            pstm.setInt(4,recebimento.getSt_recebimento());
            pstm.setString(5, recebimento.getDs_recebimento());
            pstm.setInt(6, recebimento.getId_recebimento());

            pstm.executeUpdate();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar um Recebimento! Erro na classe OracleRecebimentosDAO Cadastrar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
	}

	@Override
	public void removerRecebimento(int id_recebimento) throws DBException {
		conn = new ConexaoDAO().conectaBD();
    	
    	try {
    	String sql = "DELETE FROM T_FIN_RECEBIMENTOS WHERE id_recebimento = ?";
    	pstm = conn.prepareStatement(sql);
    	pstm.setInt(1, id_recebimento);
    	pstm.executeUpdate();    	
    	
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Não foi possível remover o recebimento! Erro na clase OraceRecebimentosDAO" + e.getMessage());
    	} finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    	}
	}

	@Override
	public RecebimentosDTO buscarRecebimento(int id_recebimento) {
		conn = new ConexaoDAO().conectaBD();
		RecebimentosDTO recebimento = null;
		
		try {
	    	String sql = "SELECT * FROM T_FIN_RECEBIMENTOS WHERE id_recebimento = ?";
	    	pstm = conn.prepareStatement(sql);
	    	pstm.setInt(1, id_recebimento);
	    	rs = pstm.executeQuery();
	    	
	    	if(rs.next()) {
	    		recebimento = new RecebimentosDTO();
	    		recebimento.setId_recebimento(rs.getInt("id_recebimento"));
	    		recebimento.setNm_recebimento(rs.getString("nm_recebimento"));
	    		recebimento.setVl_recebimento(rs.getDouble("vl_recebimento"));
	    		java.sql.Date datarecebimento = rs.getDate("dt_recebimento");
	    		recebimento.setDt_recebimento(datarecebimento);
	    		recebimento.setDs_recebimento(rs.getString("ds_recebimento"));
	    		recebimento.setSt_recebimento(rs.getInt("st_recebimento"));
	    	}
		} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Não foi possível buscar o recebimento! Erro na clase OracleRecebimentoDAO buscarRecebimento" + e.getMessage());
    	} finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    	}
		return recebimento;
	}

	@Override
	public ArrayList<RecebimentosDTO> listarRecebimento() {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM T_FIN_RECEBIMENTOS";

        try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return null;
            }
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            System.out.println(rs);

            while (rs.next()){
            RecebimentosDTO recebimento = new RecebimentosDTO();

            recebimento.setId_recebimento(rs.getInt("id_recebimento"));
            recebimento.setNm_recebimento(rs.getString("nm_recebimento"));
            recebimento.setVl_recebimento(rs.getFloat("vl_recebimento"));
            java.sql.Date datarecebimento = rs.getDate("dt_recebimento");
            recebimento.setDt_recebimento(datarecebimento);
            recebimento.setSt_recebimento(rs.getInt("st_recebimento"));
            recebimento.setDs_recebimento(rs.getString("ds_recebimento"));

            listaRecebimento.add(recebimento);
            
            System.out.println(listaRecebimento);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar um recebimento! Erro na classe RecebimentoDAO Listar: " + e.getMessage());
        } finally {
            if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaRecebimento;
	}
	
}
