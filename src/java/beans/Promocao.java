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
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
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

    public Promocao(String nomePromo, double percentPromo, int id) {
        this.nomePromo = nomePromo;
        this.percentPromo = percentPromo;
        this.id = id;
    }
    
    public Promocao() {
    }
    
    
    
}
