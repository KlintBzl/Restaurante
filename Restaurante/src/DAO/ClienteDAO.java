package DAO;

import DAO.ConexaoDAO;
import DTO.ClienteDTO;
import views.telaPrincipal;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import views.telaCliente;


public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    public void inserirUsuario(ClienteDTO objClienteDTO) {
        String sql = "insert into tb_clientes (id_cliente, nome, telefone, email)"
                + " values (?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();
        
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getId());
            pst.setString(2, objClienteDTO.getNome());
            pst.setString(3, objClienteDTO.getTelefone());
            pst.setString(4, objClienteDTO.getEmail());
            int add  = pst.executeUpdate();
            if (add > 0) {
                pesquisaAuto();
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso! ");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Método Inserir " + e);
        }
    }

    public void pesquisar(ClienteDTO objClienteDTO) {
        String sql = "select * from tb_clientes where id_clientes = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getId());
            rs = pst.executeQuery();
            if (rs.next()) {
                telaCliente.txtNome.setText(rs.getString(2));
                telaCliente.txtTelefone.setText(rs.getString(3));
                telaCliente.txtEmail.setText(rs.getString(4));
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar" + e);
        }
    }

    public void pesquisaAuto() {
        String sql = "select * from tb_clientes";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) telaCliente.tbClientes.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                model.addRow(new Object[]{id, nome, telefone, email});
            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar Automático " + e);
        }
    }

    //Método editar
    public void editar(ClienteDTO objClienteDTO) {
        String sql = "update tb_clientes set nome = ?, telefone = ?, email = ? where id_cliente = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(4, objClienteDTO.getId());
            pst.setString(3, objClienteDTO.getNome());
            pst.setString(2, objClienteDTO.getTelefone());
            pst.setString(1, objClienteDTO.getEmail());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método editar " + e);
        }
    }

    //Método deletar
    public void deletar(ClienteDTO objClienteDTO) {
        String sql = "delete from tb_chaves where id_chaves = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getId());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Cliente deletado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }

    public void limparCampos() {
        telaCliente.txtId.setText(null);
        telaCliente.txtNome.setText(null);
        telaCliente.txtTelefone.setText(null);
        telaCliente.txtEmail.setText(null);
    }
    
}