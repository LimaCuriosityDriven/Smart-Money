package br.com.fintech.beans;

import java.util.Date;

public class DespesasDTO{
    private int id_despesa, st_despesa;
    private String nm_despesa, ds_despesa;
    private Date dt_despesa, dt_vencimento;
    private double vl_despesa;

    public void setId_despesa(int id_despesa) {
        this.id_despesa = id_despesa;
    }

    public int getId_despesa() {
        return id_despesa;
    }

    public void setSt_despesa(int st_despesa) {
        this.st_despesa = st_despesa;
    }

    public int getSt_despesa() {
        return st_despesa;
    }

    public void setNm_despesa(String nm_despesa) {
        this.nm_despesa = nm_despesa;
    }

    public String getNm_despesa() {
        return nm_despesa;
    }

    public void setDs_despesa(String ds_despesa) {
        this.ds_despesa = ds_despesa;
    }

    public String getDs_despesa() {
        return ds_despesa;
    }

    public void setVl_despesa(double vl_despesa) {
        this.vl_despesa = vl_despesa;
    }

    public double getVl_despesa() {
        return vl_despesa;
    }

    public void setDt_despesa(Date dtDespesa) {
        this.dt_despesa = dtDespesa;
    }

    public Date getDt_despesa() {
        return dt_despesa;
    }

    public void setDt_vencimento(Date dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    public Date getDt_vencimento() {
        return dt_vencimento;
    }
}
