/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.*;
import java.sql.SQLException;
import DAO.FerramentaDAO;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author gustav
 */
public class Ferramenta {

    private int id;
    private String nome;
    private String marca;
    private double custo;
    private final FerramentaDAO dao;

    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }
    

    public Ferramenta(String nome, String marca, double custo, int id) {
    this.nome = nome;
    this.marca = marca;
    this.custo = custo;
    this.id = id;
    this.dao = new FerramentaDAO();
    }
    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public double getCusto() {
        
        return custo;

    }
    public String getCustoFormatado(){
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String custoFormatado = format.format(custo);
        return custoFormatado;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCusto(double custo) {
        this.custo = custo;
                        
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Marca:" + this.getMarca()
                + "\n Custo: " + this.getCusto()
                + "\n -----------";
    }

   public ArrayList<Ferramenta> getMinhaLista() {
    return dao.getMinhaLista();
}


    public boolean InsertFerramentaBD(String nome, String marca, double custo) throws SQLException {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(nome, marca, custo,id);
        dao.InsertFerramentaBD(objeto);
        return true;
    }

    public boolean DeleteFerramentaBD(int id) {
        dao.DeleteFerramentaBD(id);
        return true;
    }

    public boolean UpdateFerramentaBD(String nome, String marca, double custo,int id) {
        Ferramenta objeto = new Ferramenta(nome, marca, custo,id);
        dao.UpdateFerramentaBD(objeto);
        return true;
    }

    public Ferramenta carregaFerramenta(int id) {
        dao.carregaFerramenta(id);
        return null;
    }

      public int maiorID() throws SQLException {
//    public int maiorID(){
//        return AlunoDAO.maiorID();
        return dao.maiorID();
    }   
}
