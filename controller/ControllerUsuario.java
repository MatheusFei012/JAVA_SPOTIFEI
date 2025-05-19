package controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Cliente;
import view.PesquisaFrame;


public class ControllerUsuario {
    private PesquisaFrame view;
    private Cliente aluno;

    public ControllerUsuario(PesquisaFrame view, Cliente aluno) {
        this.view = view;
        this.aluno = aluno;
    }
    
    public void atualizar(){
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.atualizar(aluno);
            JOptionPane.showMessageDialog(view, "Atualizado com sucesso");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexâo");
        }
    }
    
    
}
    
