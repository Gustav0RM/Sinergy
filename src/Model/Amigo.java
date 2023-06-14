/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AmigoDAO;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Duarte
 */
public class Amigo {
    
    private int id;
    private String nome;
    private String telefone;
    private final AmigoDAO dao;
   
    //Metodo Construtor de Objeto, inserindo dados
    
    public Amigo(){
        this.dao = new AmigoDAO();
    }
    
      public Amigo(String nome,String telefone,int id) {
        this.nome=nome;
        this.telefone=telefone;
        this.id= id;
        this.dao = new AmigoDAO(); // inicializado nao importa em qual construtor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    // Override necess�rio para poder retornar os dados de Pessoa no toString para Amigo.
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Telefone: " + this.getTelefone()
                + "\n -----------";
    }

    /*
    
        ABAIXO OS M�TODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    
     */
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
    }

    // Cadastra novo Amigo
    public boolean InsertAmigoBD(String nome, String telefone) throws SQLException {
        
        int id = this.maiorID() + 1;
        Amigo objeto = new Amigo(nome, telefone, id);
//        AlunoDAO.MinhaLista.add(objeto);
        dao.InsertAmigoBD(objeto);
        return true;

    }

    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteAmigoBD(int id) {
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.remove(indice);
        dao.DeleteAmigoBD(id);
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateAmigoBD(String nome, String telefone, int id) {
        Amigo objeto = new Amigo(nome, telefone, id);
        dao.UpdateAmigoBD(objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
//    private int procuraIndice(int id) {
//        int indice = -1;
//        for (int i = 0; i < AlunoDAO.MinhaLista.size(); i++) {
//            if (AlunoDAO.MinhaLista.get(i).getId() == id) {
//                indice = i;
//            }
//        }
//        return indice;
//    }

    // carrega dados de um aluno espec�fico pelo seu ID
    public Amigo carregaAmigo(int id) {
//        int indice = this.procuraIndice(id);
//        return AlunoDAO.MinhaLista.get(indice);
        dao.carregaAmigo(id);
        return null;
    }
    
    // retorna o maior ID da nossa base de dados
        public int maiorID() throws SQLException {
//    public int maiorID(){
//        return AlunoDAO.maiorID();
        return dao.maiorID();
    }   
    
}
