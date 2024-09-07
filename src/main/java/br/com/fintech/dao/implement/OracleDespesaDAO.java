package br.com.fintech.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fintech.beans.DespesasDTO;
import br.com.fintech.dao.DespesasDAO;
import br.com.fintech.singleton.ConexaoDAO;

public class OracleDespesaDAO implements DespesasDAO {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    ArrayList<DespesasDTO> listaDespesa = new ArrayList<>();

    @Override
    public void cadastrarDespesa(DespesasDTO despesa) {
        conn = new ConexaoDAO().conectaBD();

        try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return;
            }
            String sql = "INSERT INTO T_FIN_DESPESAS (nm_despesa, vl_despesa, dt_despesa, dt_vencimento, st_despesa, ds_despesa) VALUES(?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, despesa.getNm_despesa());
            pstm.setDouble(2, despesa.getVl_despesa());
            java.sql.Date dataDespesa = new java.sql.Date(despesa.getDt_despesa().getTime());
            pstm.setDate(3, dataDespesa);
            java.sql.Date dataVencimento = new java.sql.Date(despesa.getDt_vencimento().getTime());
            pstm.setDate(4, dataVencimento);
            pstm.setInt(5,despesa.getSt_despesa());
            pstm.setString(6, despesa.getDs_despesa());

            pstm.executeUpdate();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar uma despesa! Erro na classe DespesaDAO Cadastrar: " + e.getMessage());
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
    public ArrayList<DespesasDTO> listarDespesa() { // Comando getAll;
        ArrayList<DespesasDTO> listaDespesa = new ArrayList<>(); // Cria uma nova instância da lista aqui
        System.out.println("Cheguei aqui no OracleDAO");
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM t_fin_despesas";
        System.out.println("Fiz a conexão");

        try {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return listaDespesa;
            }
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            System.out.println("Executei a Query");
            System.out.println(rs);

            while (rs.next()) {
                DespesasDTO despesa = new DespesasDTO();

                despesa.setId_despesa(rs.getInt("id_despesa"));
                despesa.setNm_despesa(rs.getString("nm_despesa"));
                despesa.setVl_despesa(rs.getFloat("vl_despesa"));
                java.sql.Date dataDespesa = rs.getDate("dt_despesa");
                despesa.setDt_despesa(dataDespesa);
                java.sql.Date dataVencimento = rs.getDate("dt_vencimento");
                despesa.setDt_vencimento(dataVencimento); 
                despesa.setSt_despesa(rs.getInt("st_despesa"));
                despesa.setDs_despesa(rs.getString("ds_despesa"));
                
                System.out.println("despesa:" + despesa);

                listaDespesa.add(despesa);
            }

            // Depuração
            System.out.println("Despesas obtidas do banco: " + listaDespesa);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar uma despesa! Erro na classe DespesaDAO Listar: " + e.getMessage());
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaDespesa;
    }
    	
    public void removerDespesa(int idDespesaRemove) {
    	conn = new ConexaoDAO().conectaBD();
    	
    	try {
    	String sql = "DELETE FROM T_FIN_DESPESAS WHERE id_despesa = ?";
    	pstm = conn.prepareStatement(sql);
    	pstm.setInt(1, idDespesaRemove);
    	pstm.executeUpdate();    	
    	
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Não foi possível remover a despesa! Erro na clase OraceDespesaDAO" + e.getMessage());
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
    
    public void atualizarDespesa(DespesasDTO despesa) {
    	conn = new ConexaoDAO().conectaBD();
    	
    	try {
    		if (conn == null) {
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados não disponível");
                return;
    		}
    		String sql = "UPDATE T_FIN_DESPESAS SET nm_despesa = ?, vl_despesa = ?, dt_despesa = ?, dt_vencimento = ?, st_despesa = ?, ds_despesa = ? WHERE id_despesa = ?";
    		pstm = conn.prepareStatement(sql);
    		pstm.setString(1, despesa.getNm_despesa());
    		pstm.setDouble(2, despesa.getVl_despesa());
    		java.sql.Date dataDespesa = new java.sql.Date(despesa.getDt_despesa().getTime());
    		pstm.setDate(3, dataDespesa);
    		java.sql.Date dataVencimento = new java.sql.Date(despesa.getDt_vencimento().getTime());
    		pstm.setDate(4, dataVencimento);
    		pstm.setInt(5, despesa.getSt_despesa());
    		pstm.setString(6, despesa.getDs_despesa());
    		pstm.setInt(7, despesa.getId_despesa());
    		pstm.executeUpdate();
    		
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Não foi possível atualizar a despesa! Erro na classe OracleDespesaDAO atualizarDespesa");
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
    
    public DespesasDTO buscarDespesa(int idDespesaSearch) {
    	conn = new ConexaoDAO().conectaBD();
    	DespesasDTO despesa = null;
    	
    	try {    	
    	String sql = "SELECT * FROM T_FIN_DESPESAS WHERE ID_DESPESA = ?";
    	pstm = conn.prepareStatement(sql);
    	pstm.setInt(1, idDespesaSearch);
    	rs = pstm.executeQuery();
    	
    	if (rs.next()) {
    		despesa = new DespesasDTO();
    		despesa.setId_despesa(rs.getInt("id_despesa"));
            despesa.setNm_despesa(rs.getString("nm_despesa"));
            despesa.setVl_despesa(rs.getFloat("vl_despesa"));
            java.sql.Date dataDespesa = rs.getDate("dt_despesa");
            despesa.setDt_despesa(dataDespesa);
            java.sql.Date dataVencimento = rs.getDate("dt_vencimento");
            despesa.setDt_vencimento(dataVencimento); 
            despesa.setSt_despesa(rs.getInt("st_despesa"));
            despesa.setDs_despesa(rs.getString("ds_despesa"));
    	}
    	
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "Não foi possível buscar a despesa! Erro na clase OracleDespesaDAO buscarDespesa" + e.getMessage());
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
    	return despesa;
    }
}
