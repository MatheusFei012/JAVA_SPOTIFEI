package controller;

import DAO.Conexao;
import DAO.OuvirDAO;
import DAO.PlaylistDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Ouvir;
import view.OuvirFrame;


public class ControllerOuvir {
    private OuvirFrame view;

    public ControllerOuvir(OuvirFrame view) {
        this.view = view;
    }

    public void carregarArtistasOuvir() {
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.getConnection()) {
            OuvirDAO dao = new OuvirDAO(conn);
            List<Ouvir> ouvirartista = dao.listarArtistasouvir();

            StringBuilder resultado = new StringBuilder("<html>");
            for (Ouvir h : ouvirartista) {
                resultado.append(h.getNome()).append("<br>");
            }
            resultado.append("</html>");

            view.getOuvir_artista().setText(resultado.toString());

        } catch (SQLException e) {
            view.getOuvir_artista().setText("Erro ao carregar histórico.");
        }
    }
    
    public void remover_artista() {
        String ouvirartistatext = view.getTxt_excluir_artista().getText();

        Ouvir ouvir = new Ouvir(ouvirartistatext);
        Conexao conexao = new Conexao();

        try (Connection conn = conexao.getConnection()) {
            OuvirDAO dao = new OuvirDAO(conn);
            dao.remover_artistas(ouvir); // Usando o nome correto do método

            JOptionPane.showMessageDialog(view, "Artista removido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão: " + e.getMessage());
        }
    }
    
    public void carregarPlaylistOuvir() {
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.getConnection()) {
            OuvirDAO dao = new OuvirDAO(conn);
            List<Ouvir> ouvirartista = dao.listarPlaylistouvir();

            StringBuilder resultado = new StringBuilder("<html>");
            for (Ouvir h : ouvirartista) {
                resultado.append(h.getNome()).append("<br>");
            }
            resultado.append("</html>");

            view.getOuvir_playlist().setText(resultado.toString());

        } catch (SQLException e) {
            view.getOuvir_playlist().setText("Erro ao carregar histórico.");
        }
    }
    
    
}
