package br.com.fintech.beans;

import java.util.Date;

public class RecebimentosDTO{
    private int id_recebimento, st_recebimento;
    private String nm_recebimento, ds_recebimento;
    private Date dt_recebimento;
    private double vl_recebimento;

    public void setId_recebimento(int id_recebimento) {
        this.id_recebimento = id_recebimento;
    }

    public int getId_recebimento() {
        return id_recebimento;
    }

    public void setSt_recebimento(int st_recebimento) {
        this.st_recebimento = st_recebimento;
    }

    public int getSt_recebimento() {
        return st_recebimento;
    }

    public void setNm_recebimento(String nm_recebimento) {
        this.nm_recebimento = nm_recebimento;
    }

    public String getNm_recebimento() {
        return nm_recebimento;
    }

    public void setDs_recebimento(String ds_recebimento) {
        this.ds_recebimento = ds_recebimento;
    }

    public String getDs_recebimento() {
        return ds_recebimento;
    }

    public void setVl_recebimento(double vl_recebimento) {
        this.vl_recebimento = vl_recebimento;
    }

    public double getVl_recebimento() {
        return vl_recebimento;
    }

    public void setDt_recebimento(Date dtRecebimento) {
        this.dt_recebimento = dtRecebimento;
    }

    public Date getDt_recebimento() {
        return dt_recebimento;
    }
}