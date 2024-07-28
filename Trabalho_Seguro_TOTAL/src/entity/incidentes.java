
package entity;

import java.util.Date;

public class incidentes {
    
    private String Nome;
    private String Tipo;
    private Date Data;
    private String Descricao;
    
    public String getNome(){
        return Nome; 
    }
    
    public void setNome (String Nome){
        this.Nome = Nome; 
    }
    
    public String getTipo(){
        return Tipo; 
    }
    
    public void setTipo (String Tipo){
        this.Tipo = Tipo; 
    }
   
    public Date getData(){
        return Data; 
    }
    
    public void setData (Date Data){
        this.Data = Data; 
    }
    
    public String getDescricao(){
        return Descricao; 
    }
    
    public void setDescricao (String Descricao){
        this.Descricao = Descricao; 
    }

}