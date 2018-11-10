/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Tipo;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface ITipoDao {
    
    public void cadastrarTipo(Tipo tipo);
    
    public Tipo consultarTipo(Tipo tipo);
    
    public ArrayList<Tipo> consultarTodosTipo(Tipo tipo);
    
    public  boolean alterarTipo(Tipo tipo);
    
    public boolean excluirTipo(Tipo tipo);
    
}
