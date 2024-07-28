package entity;
import java.util.Date;

/**
 *
 * @author angel
 */
public class usuario {
    
    private int Matricula;
    private String Nome;
    private String Sobrenome;
    private Date DtNascimento;
    private String senha;
    private String Formacao;
    private String CPF;
    private String numero;
    private String DDD;
    private String Logradouro;
    private String Cidade;
    private String Telefone_Emergencial;
    private int Cargo_idCargo;
    
    
    public int getMatricula(){
        return Matricula; 
    }
    
    public void setMatricula (int Matricula){
        this.Matricula = Matricula; 
    }
    
    public String getNome(){
        return Nome; 
    }
    
    public void setNome (String Nome){
        this.Nome = Nome; 
    }
    
    public String getSobrenome(){
        return Sobrenome; 
    }
    
    public void setSobrenome (String Sobrenome){
        this.Sobrenome = Sobrenome; 
    }
    
     public Date getDtNacimento(){
        return DtNascimento; 
    }
    
    public void setDtNascimento (Date DtNascimento){
        this.DtNascimento = DtNascimento; 
    }
    
     public String senha(){
        return senha; 
    }
    
    public void setsenha (String senha){
        this.senha = senha; 
    }
    
     public String Formacao(){
        return Formacao; 
    }
    
    public void setFormacao (String Formacao){
        this.Formacao = Formacao; 
    }
    
     public String getCPF(){
        return CPF; 
    }
    
    public void setCPF (String CPF){
        this.CPF = CPF; 
    }
    
     public String numero(){
        return numero; 
    }
    
    public void setnumero (String numero){
        this.numero = numero; 
    }
    
     public String DDD(){
        return DDD; 
    }
    
    public void setDDD (String DDD){
        this.DDD = DDD; 
    }
    
     public String getLogradouro(){
        return Logradouro; 
    }
    
    public void setLogradouro (String Logradouro){
        this.Logradouro = Logradouro; 
    }
    
     public String getCidade(){
        return Cidade; 
    }
    
    public void setCidade (String Cidade){
        this.Cidade = Cidade; 
    }
    
     public String getTelefone_Emergencial(){
        return Telefone_Emergencial; 
    }
    
    public void setTelefone_Emergencial (String Telefone_Emergencial){
        this.Telefone_Emergencial = Telefone_Emergencial; 
    }
    
    public int getCargo_idCargo(){
        return Cargo_idCargo; 
    }
    
    public void setCargo_idCargo (int Cargo_idCargo){
        this.Cargo_idCargo = Cargo_idCargo; 
    }

}
