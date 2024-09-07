package br.com.fintech.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fiap.store.exception.DBException;
import br.com.fintech.beans.InvestimentosDTO;
import br.com.fintech.dao.InvestimentosDAO;
import br.com.fintech.singleton.ConexaoDAO;

public class OracleInvestimentosDAO implements InvestimentosDAO {
	 Connection conn;
	 PreparedStatement pstm;
	 ResultSet rs;
	 ArrayList<InvestimentosDTO> listaInvestimento = new ArrayList<>();
	    

	public void cadastrarInvestimento(InvestimentosDTO investimento) throws DBException {
		conn = new ConexaoDAO().conectaBD();

        try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return;
            }
            String sql = "INSERT INTO T_FIN_INVESTIMENTOS (nm_investimento, vl_investimento, dt_investimento, vl_retorno_mes) VALUES(?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, investimento.getNm_investimento());
            pstm.setDouble(2, investimento.getVl_investimento());
            java.sql.Date datainvestimento = new java.sql.Date(investimento.getDt_investimento().getTime());
            pstm.setDate(3, datainvestimento);
            pstm.setDouble(4,investimento.getVl_retorno_mes());

            pstm.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar um Investimento! Erro na classe InvestimentosDAO Cadastrar: " + e.getMessage());
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

	public void atualizarInvestimento(InvestimentosDTO investimento) throws DBException {
		conn = new ConexaoDAO().conectaBD();
    	
    	try {
    		if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return;
    		}
    		String sql = "UPDATE T_FIN_INVESTIMENTOS SET nm_investimento = ?, vl_investimento = ?, dt_investimento = ?, vl_retorno_mes = ? WHERE id_investimento = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, investimento.getNm_investimento());
            pstm.setDouble(2, investimento.getVl_investimento());
            java.sql.Date datainvestimento = new java.sql.Date(investimento.getDt_investimento().getTime());
            pstm.setDate(3, datainvestimento);
            pstm.setDouble(4,investimento.getVl_retorno_mes());
            pstm.setInt(5,investimento.getId_investimento());

            pstm.executeUpdate();
    	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar um Investimento! Erro na classe InvestimentosDAO Cadastrar: " + e.getMessage());
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
	
	public void removerInvestimento(int id_investimento) throws DBException {
		conn = new ConexaoDAO().conectaBD();
    	
    	try {
    	String sql = "DELETE FROM T_FIN_INVESTIMENTOS WHERE id_investimento = ?";
    	pstm = conn.prepareStatement(sql);
    	pstm.setInt(1, id_investimento);
    	pstm.executeUpdate();    	
    	
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Não foi possível remover o Investimento!" + e.getMessage());
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

	public InvestimentosDTO buscarInvestimento(int id_investimento) {
		conn = new ConexaoDAO().conectaBD();
    	InvestimentosDTO investimento = null;
    	
    	try {    	
    	String sql = "SELECT * FROM T_FIN_INVESTIMENTOS WHERE id_investimento = ?";
    	pstm = conn.prepareStatement(sql);
    	pstm.setInt(1, id_investimento);
    	rs = pstm.executeQuery();
    	
    	if (rs.next()) {
    		
    		investimento = new InvestimentosDTO();
    		investimento.setId_investimento(rs.getInt("id_investimento"));
    		investimento.setNm_investimento(rs.getString("nm_investimento"));
    		investimento.setVl_investimento(rs.getDouble("vl_investimento"));
            java.sql.Date datainvestimento = rs.getDate("dt_investimento");
            investimento.setDt_investimento(datainvestimento);
            investimento.setVl_retorno_mes(rs.getDouble("vl_retorno_mes"));
      		}
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Não foi possível buscar um investimento!" + e.getMessage());
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
    	return investimento;
	}

	public ArrayList<InvestimentosDTO> listarInvestimento() {
		conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM T_FIN_INVESTIMENTOS";

        try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return null;
            }
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
            InvestimentosDTO investimento = new InvestimentosDTO();

            investimento.setId_investimento(rs.getInt("id_investimento"));
            investimento.setNm_investimento(rs.getString("nm_investimento"));
            investimento.setVl_investimento(rs.getDouble("vl_investimento"));
            java.sql.Date datainvestimento = rs.getDate("dt_investimento");
            investimento.setDt_investimento(datainvestimento);
            investimento.setVl_retorno_mes(rs.getDouble("vl_retorno_mes"));

            listaInvestimento.add(investimento);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar um Investimento! Erro na classe InvestimentosDAO Listar: " + e.getMessage());
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
        return listaInvestimento;
    }	
}
