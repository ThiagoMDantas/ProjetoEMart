/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Thiago
 */
public class Promocao {
    
    private String nomePromo;
    private double percentPromo;

    public String getNomePromo() {
        return nomePromo;
    }

    public void setNomePromo(String nomePromo) {
        this.nomePromo = nomePromo;
    }

    public double getPercentPromo() {
        return percentPromo;
    }

    public void setPercentPromo(double percentPromo) {
        this.percentPromo = percentPromo;
    }
    
    public Promocao(String nomePromo, double percentPromo) {
        this.nomePromo = nomePromo;
        this.percentPromo = percentPromo;
    }

    public Promocao() {
    }
    
    
    
}
