/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comissaoemp.telas;

import java.sql.*;
import br.com.comissaoemp.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author adels
 */
public class TelaComissao extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaComissao
     */
    public TelaComissao() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void pesquisar_funcionario() {
        String sql = "select iduser as Id, usuario as Nome, funcao as Função from tbusuarios where usuario like ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtComPesquisar.getText() + "%");
            rs = pst.executeQuery();
            tblFuncionarios.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar_campos() {
        int setar = tblFuncionarios.getSelectedRow();
        txtComId.setText(tblFuncionarios.getModel().getValueAt(setar, 0).toString());
    }

    private void cadastrar_comissao() {
                     
        String sql = "insert into tbcomissao (loja, mes, ano, valor, iduser) values (?,?,?,?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboComLoja.getSelectedItem().toString());
            pst.setString(2, cboComMes.getSelectedItem().toString());
            pst.setString(3, cboComAno.getSelectedItem().toString());
            pst.setString(4, txtComValor.getText().replace(",", "."));
            pst.setString(5, txtComId.getText());

            if ((txtComId.getText().isEmpty() || cboComLoja.getSelectedItem().equals("Selecione uma loja") || cboComMes.getSelectedItem().equals("Selecione o mês") || txtComValor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Comissão cadastrada com sucesso!");

                    txtComPesquisar.setText(null);
                    txtComId.setText(null);
                    txtComValor.setText(null);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pesquisar_comissao() {
        String sql = "select * from tbcomissao where loja=? and mes=? and ano=? and iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboComLoja.getSelectedItem().toString());
            pst.setString(2, cboComMes.getSelectedItem().toString());
            pst.setString(3, cboComAno.getSelectedItem().toString());
            pst.setString(4, txtComId.getText());

            rs = pst.executeQuery();
            if (rs.next()) {
                txtComValor.setText(rs.getString(5));

            } else {
                JOptionPane.showMessageDialog(null, "Comissão não cadastrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar_comissao() {
        String sql = "update tbcomissao set loja=?, mes=?, ano=?, valor=? where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cboComLoja.getSelectedItem().toString());
            pst.setString(2, cboComMes.getSelectedItem().toString());
            pst.setString(3, cboComAno.getSelectedItem().toString());
            pst.setString(4, txtComValor.getText().replace(",", "."));
            pst.setString(5, txtComId.getText());

            if ((txtComId.getText().isEmpty() || cboComLoja.getSelectedItem().equals("Selecione uma loja") || cboComMes.getSelectedItem().equals("Selecione o mês") || txtComValor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Comissão alterada com sucesso!");

                    txtComPesquisar.setText(null);
                    txtComId.setText(null);
                    txtComValor.setText(null);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void excluir_comissao() {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir essa comissão?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbcomissao where loja=? and mes=? and ano=? and iduser=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, cboComLoja.getSelectedItem().toString());
                pst.setString(2, cboComMes.getSelectedItem().toString());
                pst.setString(3, cboComAno.getSelectedItem().toString());
                pst.setString(4, txtComId.getText());
                /*    
                int apagado = pst.executeUpdate();

                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Comissão removida com sucesso!");
                    txtComPesquisar.setText(null);
                    txtComId.setText(null);
                    cboComLoja.setSelectedItem(null);
                    txtComValor.setText(null);
                }*/
                if ((txtComId.getText().isEmpty() || cboComLoja.getSelectedItem().equals("Selecione uma loja") || cboComMes.getSelectedItem().equals("Selecione o mês") || txtComValor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

            } else {
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Comissão removida com sucesso!");

                    txtComPesquisar.setText(null);
                    txtComId.setText(null);
                    txtComValor.setText(null);
                }
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtComPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtComId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboComLoja = new javax.swing.JComboBox<>();
        cboComMes = new javax.swing.JComboBox<>();
        txtComValor = new javax.swing.JTextField();
        btnComRead = new javax.swing.JButton();
        btnComUpdate = new javax.swing.JButton();
        btnComDelete = new javax.swing.JButton();
        btnComCreate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboComAno = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Comissão");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionário"));

        txtComPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComPesquisarActionPerformed(evt);
            }
        });
        txtComPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/comissaoemp/icones/pesquisar.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("*id");

        txtComId.setEditable(false);

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Função"
            }
        ));
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtComPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtComId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtComId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtComPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("*Loja");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("*Mês");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("*Comissão R$");

        cboComLoja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma loja", "1 - Candelária", "2 - Bairro Nordeste", "3 - Satélite", "4 - Neópolis", "5 - Nova Parnamirim" }));

        cboComMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        btnComRead.setText("Consultar");
        btnComRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComReadActionPerformed(evt);
            }
        });

        btnComUpdate.setText("Alterar");
        btnComUpdate.setMaximumSize(new java.awt.Dimension(79, 23));
        btnComUpdate.setMinimumSize(new java.awt.Dimension(79, 23));
        btnComUpdate.setPreferredSize(new java.awt.Dimension(79, 23));
        btnComUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComUpdateActionPerformed(evt);
            }
        });

        btnComDelete.setText("Remover");
        btnComDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComDeleteActionPerformed(evt);
            }
        });

        btnComCreate.setText("Adicionar");
        btnComCreate.setMaximumSize(new java.awt.Dimension(79, 23));
        btnComCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComCreateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("*Ano");

        cboComAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnComCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnComRead, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnComUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnComDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboComMes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboComAno, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtComValor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboComLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(209, 209, 209))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboComLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboComMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboComAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtComValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnComCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComRead)
                    .addComponent(btnComUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComDelete))
                .addGap(44, 44, 44))
        );

        setBounds(0, 0, 640, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void txtComPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComPesquisarActionPerformed

    private void btnComReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComReadActionPerformed
        pesquisar_comissao();
    }//GEN-LAST:event_btnComReadActionPerformed

    private void btnComUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComUpdateActionPerformed
        alterar_comissao();
    }//GEN-LAST:event_btnComUpdateActionPerformed

    private void btnComDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComDeleteActionPerformed
        excluir_comissao();
    }//GEN-LAST:event_btnComDeleteActionPerformed

    private void btnComCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComCreateActionPerformed
        cadastrar_comissao();
    }//GEN-LAST:event_btnComCreateActionPerformed

    private void txtComPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComPesquisarKeyReleased
        pesquisar_funcionario();
    }//GEN-LAST:event_txtComPesquisarKeyReleased

    private void tblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseClicked
        setar_campos();
    }//GEN-LAST:event_tblFuncionariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComCreate;
    private javax.swing.JButton btnComDelete;
    private javax.swing.JButton btnComRead;
    private javax.swing.JButton btnComUpdate;
    private javax.swing.JComboBox<String> cboComAno;
    private javax.swing.JComboBox<String> cboComLoja;
    private javax.swing.JComboBox<String> cboComMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtComId;
    private javax.swing.JTextField txtComPesquisar;
    private javax.swing.JTextField txtComValor;
    // End of variables declaration//GEN-END:variables
}
