package br.com.fintech.beans;

import java.util.Date;

public class InvestimentosDTO {
    private int id_investimento;
    private String nm_investimento;
    private double vl_investimento, vl_retorno_mes;
    private Date dt_investimento;

    public void setId_investimento(int id_investimento){
        this.id_investimento = id_investimento;
    }

    public int getId_investimento(){
        return id_investimento;
    }

    public void setNm_investimento(String nm_investimento){
        this.nm_investimento = nm_investimento;
    }

    public String getNm_investimento(){
        return nm_investimento;
    }

    public void setVl_investimento(double vl_investimento){
        this.vl_investimento = vl_investimento;
    }

    public double getVl_investimento(){
        return vl_investimento;
    }

    public void setDt_investimento(Date dt_investimento){
        this.dt_investimento = dt_investimento;
    }

    public Date getDt_investimento(){
        return dt_investimento;
    }

    public void setVl_retorno_mes(double vl_retorno_mes){
        this.vl_retorno_mes = vl_retorno_mes;
    }

    public double getVl_retorno_mes(){
        return vl_retorno_mes;
    }
}