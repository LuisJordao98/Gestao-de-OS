package model;

import db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoDAO {
    public void create(OrdemDeServico os) throws SQLException {
        String sql = "INSERT INTO os (cliente, telefone, modelo, problema, data_recebimento, data_entrega, valor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, os.getCliente());
            stmt.setString(2, os.getTelefone());
            stmt.setString(3, os.getModelo());
            stmt.setString(4, os.getProblema());
            stmt.setDate(5, new java.sql.Date(os.getDataRecebimento().getTime()));
            stmt.setDate(6, new java.sql.Date(os.getDataEntrega().getTime()));
            stmt.setDouble(7, os.getValor());
            stmt.executeUpdate();
        }
    }

    public List<OrdemDeServico> read() throws SQLException {
        List<OrdemDeServico> oss = new ArrayList<>();
        String sql = "SELECT * FROM os";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                OrdemDeServico os = new OrdemDeServico();
                os.setId(rs.getInt("id"));
                os.setCliente(rs.getString("cliente"));
                os.setTelefone(rs.getString("telefone"));
                os.setModelo(rs.getString("modelo"));
                os.setProblema(rs.getString("problema"));
                os.setDataRecebimento(rs.getDate("data_recebimento"));
                os.setDataEntrega(rs.getDate("data_entrega"));
                os.setValor(rs.getDouble("valor"));
                oss.add(os);
            }
        }
        return oss;
    }

    public void update(OrdemDeServico os) throws SQLException {
        String sql = "UPDATE os SET cliente = ?, telefone = ?, modelo = ?, problema = ?, data_recebimento = ?, data_entrega = ?, valor = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, os.getCliente());
            stmt.setString(2, os.getTelefone());
            stmt.setString(3, os.getModelo());
            stmt.setString(4, os.getProblema());
            stmt.setDate(5, new java.sql.Date(os.getDataRecebimento().getTime()));
            stmt.setDate(6, new java.sql.Date(os.getDataEntrega().getTime()));
            stmt.setDouble(7, os.getValor());
            stmt.setInt(8, os.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM os WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
