package controller;

import DAO.ArtistaAdicionadoDAO;
import DAO.Conexao;
import DAO.HistoricoDAO;
import DAO.PesquisaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Historico;
import model.Pesquisa;
import view.PesquisaFrame;

public class ControllerPesquisa {
    private PesquisaFrame view;

    public ControllerPesquisa(PesquisaFrame view) {
        this.view = view;
    }

    public void buscarPesquisa() {
        String pesquisatext = view.getTxt_buscar_pesquisa().getText();

        Conexao conexao = new Conexao();
        try (Connection conn = conexao.getConnection()) {
            PesquisaDAO daoPesquisa = new PesquisaDAO(conn);
            Pesquisa pesquisa = daoPesquisa.buscarPorNome(pesquisatext);

            if (pesquisa != null) {
                view.getLbl_resultado_pesquisa().setText("Artista encontrado: " + pesquisa.getNome());
            } else {
                view.getLbl_resultado_pesquisa().setText("Artista não encontrado.");
            }

            // ➕ Adiciona ao histórico SEM mostrar nada
            HistoricoDAO daoHistorico = new HistoricoDAO(conn);
            daoHistorico.inserir(new Historico(pesquisatext));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar artista.");
        }
    }
    
    public void adicionarPesquisa() {
        String pesquisatext = view.getTxt_buscar_pesquisa().getText();
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.getConnection()) {
            ArtistaAdicionadoDAO daoAdicionado = new ArtistaAdicionadoDAO(conn);
            Pesquisa artista = new Pesquisa(pesquisatext);
            daoAdicionado.inserir(artista); // 👉 Insere só em artistas_adicionados
            JOptionPane.showMessageDialog(view, "Artista adicionado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao adicionar artista.");
            e.printStackTrace();
        }
    }
    
    public void adicionarCurtir() {
    String pesquisatext = view.getTxt_buscar_pesquisa().getText();
    Conexao conexao = new Conexao();

    try (Connection conn = conexao.getConnection()) {
        PesquisaDAO daoPesquisa = new PesquisaDAO(conn); // ✅ Usa a DAO correta
        Pesquisa curtir = new Pesquisa(pesquisatext);
        daoPesquisa.curtir(curtir); // ✅ Usa o método que insere na tabela "curtir"
        JOptionPane.showMessageDialog(view, "Curtida adicionada com sucesso!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(view, "Erro ao curtir artista.");
        e.printStackTrace();
    }
}

}
