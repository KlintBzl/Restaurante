
package views;

import DAO.ConexaoDAO;
import java.sql.*;
import javax.swing.*;


public class telaPrincipal extends javax.swing.JFrame {

        Connection conexao = null;

    
    public telaPrincipal() {
        initComponents();
        conexao = ConexaoDAO.conector();
        System.out.println(conexao);

        if (conexao != null) {
            ImageIcon iconeVerde = new ImageIcon("src/Imagens/conectado.png");
            lblConexao.setIcon(iconeVerde);
            lblAtencao.setText("Conectado ao Banco de dados!");
        }
            
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConexao = new javax.swing.JLabel();
        lblAtencao = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuGerenciar = new javax.swing.JMenu();
        MenuClientes = new javax.swing.JMenuItem();
        MenuPedidos = new javax.swing.JMenuItem();
        MenuAjuda = new javax.swing.JMenu();
        MenuSobre = new javax.swing.JMenuItem();
        MenuOpcoes = new javax.swing.JMenu();
        MenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setResizable(false);

        lblConexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/desconectado.png"))); // NOI18N

        lblAtencao.setText("Desconectado do banco de dados!!!");

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bem-Vindo!");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Esta é a tela principal do sistema");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Para usufruir de suas funções, acesse");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("a barra de menu acima");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/talher.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        MenuGerenciar.setText("Gerenciar");

        MenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pessoinha.png"))); // NOI18N
        MenuClientes.setText("Clientes");
        MenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientesActionPerformed(evt);
            }
        });
        MenuGerenciar.add(MenuClientes);

        MenuPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pedidinho.png"))); // NOI18N
        MenuPedidos.setText("Pedidos");
        MenuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPedidosActionPerformed(evt);
            }
        });
        MenuGerenciar.add(MenuPedidos);

        MenuBar.add(MenuGerenciar);

        MenuAjuda.setText("Ajuda");

        MenuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/infinho.png"))); // NOI18N
        MenuSobre.setText("Sobre");
        MenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSobreActionPerformed(evt);
            }
        });
        MenuAjuda.add(MenuSobre);

        MenuBar.add(MenuAjuda);

        MenuOpcoes.setText("Opções");

        MenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/saidinha.png"))); // NOI18N
        MenuSair.setText("Sair");
        MenuSair.setToolTipText("");
        MenuSair.setSelected(true);
        MenuSair.setVerifyInputWhenFocusTarget(false);
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        MenuOpcoes.add(MenuSair);

        MenuBar.add(MenuOpcoes);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblConexao))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAtencao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(lblConexao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtencao)
                .addGap(12, 12, 12))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        this.setVisible(false);
        telaCliente cliente = new telaCliente();
        cliente.setVisible(true);
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void MenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPedidosActionPerformed
        this.setVisible(false);
        telaPedido pedido = new telaPedido();
        pedido.setVisible(true);
    }//GEN-LAST:event_MenuPedidosActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair","Atenção",JOptionPane.YES_NO_OPTION);
        if(sair == JOptionPane.YES_OPTION){
            System.exit(sair);
        }
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSobreActionPerformed
        this.setVisible(false);
        Sobre sobre = new Sobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_MenuSobreActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAjuda;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenu MenuGerenciar;
    private javax.swing.JMenu MenuOpcoes;
    private javax.swing.JMenuItem MenuPedidos;
    private javax.swing.JMenuItem MenuSair;
    private javax.swing.JMenuItem MenuSobre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAtencao;
    private javax.swing.JLabel lblConexao;
    // End of variables declaration//GEN-END:variables
}
