/*
 * 
 * Author: Sithum Nanayakkara
 */
package ChessPanels;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class RulesPanel extends javax.swing.JPanel {

    private final MenuPanel menuPanel;
    
    /**
     * Creates new form RulesPanel
     */
    public RulesPanel(MenuPanel menu) {
        initComponents();
        this.menuPanel = menu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBackToMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jTextPane5 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jTextPane6 = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        jTextPane7 = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(0, 0, 102));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        btnBackToMenu.setBackground(new java.awt.Color(60, 63, 65));
        btnBackToMenu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnBackToMenu.setForeground(new java.awt.Color(51, 255, 255));
        btnBackToMenu.setText("Back to Menu");
        btnBackToMenu.setBorder(null);
        btnBackToMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackToMenu.setDefaultCapable(false);
        btnBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToMenuActionPerformed(evt);
            }
        });
        add(btnBackToMenu);
        btnBackToMenu.setBounds(30, 630, 118, 24);
        btnBackToMenu.setOpaque( false );

        jScrollPane1.setForeground(new java.awt.Color(255, 204, 102));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(16, 1));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));
        jPanel2.setFocusable(false);
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 1900));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Overview");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextPane3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextPane3.setForeground(new java.awt.Color(204, 255, 255));
        jTextPane3.setText("The game can end under the following circumstances:\n\nIf your opponent's king is under threat of capture, but your opponent has no legal move to prevent that capture, you have won. This is referred to as \"Checkmate\".\n\nIf a players king is not under threat of capture but that player has no legal moves anyway, the game is a draw.\n\nThe game is also a draw if any of the following situations come up:\n\n\tNeither player has enough pieces to be able to checkmate\n\n\tThe players agree to a draw");
        jTextPane3.setAutoscrolls(false);
        jTextPane3.setFocusable(false);
        jTextPane3.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Aim of the Game");
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextPane4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextPane4.setForeground(new java.awt.Color(204, 255, 255));
        jTextPane4.setText("The game of chess is played on an 8x8 checkered board, where the rows are marked from 1-8 and referred to as \"ranks\" and the columns marked from \"A\" to \"H\", referred to as \"files\". The square marked as \"A1\" should be black. The player controlling the white pieces places his pieces on ranks 1 and 2, and the player playing the black pieces places his pieces on ranks 7 and 8. The pawns are placed on ranks 2 and 7. The other pieces are placed on ranks 1 and 8 as followed, starting from the \"A\" file: A rook, a knight, a bishop, a queen, a king, a bishop, a knight, and a rook. The player who has white goes first, and players alternate moves after that.");
        jTextPane4.setAutoscrolls(false);
        jTextPane4.setFocusable(false);
        jTextPane4.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Making a move");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextPane5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextPane5.setForeground(new java.awt.Color(204, 255, 255));
        jTextPane5.setText("The six pieces move as follows:\n\nThe Bishop can move any number of squares along the diagonal.\n\nThe Rook can move any number of squares along the same rank or file.\n\nThe Queen can move any number of squares along the same rank, file, or diagonal.\n\nThe Knight moves to the closest square that is neither on the same rank, file, or diagonal. Essentially the knight moves in an \"L\" shape, two squares along a rank or file and then a single square perpendicular.The knight is the only piece that can \"jump over\" other pieces.\n\nThe Pawn moves one square along the file, always towards the opponent's side of the board. The first time a pawn moves it is allowed to move two spaces along the file instead of one granted it has the space. A pawn can only capture a piece imminently along the diagonals in the direction of travel, not along the file it is currently travelling.\n\nThe King can only move a single square in any direction, with the exception of castling (see below). The King can never place himself in a check.");
        jTextPane5.setAutoscrolls(false);
        jTextPane5.setFocusable(false);
        jTextPane5.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Placing a king in check");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextPane6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextPane6.setForeground(new java.awt.Color(204, 255, 255));
        jTextPane6.setText("When a player makes a move in which any of his pieces threatens to capture the opponents king the next turn the king is said to be in check. A player in check must make a move that results in the check being relieved; be that by moving the king out of the way, capturing the threatning piece, or placing a piece in between the king and threatning piece. A player that has no legal move out of the check has lost the game (referred to a Checkmate). A player can be placed in check by multiple pieces at once, and must get out of all checks at once. A player can not remain in check. A player may never make a move that results in his own king being in check.");
        jTextPane6.setAutoscrolls(false);
        jTextPane6.setFocusable(false);
        jTextPane6.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Special moves");
        jLabel7.setFocusable(false);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextPane7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jTextPane7.setForeground(new java.awt.Color(204, 255, 255));
        jTextPane7.setText("Castling refers to a special move open to the King and Rooks. If neither the King nor Rook has been moved during the game, the rank separating them is clear of pieces, and during the castling process no space the king will move over or end on is under attack by an opponent piece, the player can move his king two spaces towards the rook, and the rook on the opposite side of the king. For example, assume that the white king on E1 and the white rook on A1 have direct line of sight and have not moved. The white player can, in a single move, move the king two spaces left (to C1) and the rook three spaces right (to D1). The player could also castle kingside, moving the king to G1 and the H1 rook to F1.");
        jTextPane7.setAutoscrolls(false);
        jTextPane7.setFocusable(false);
        jTextPane7.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 185, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jTextPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addComponent(jTextPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(jTextPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(jTextPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(jTextPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
        );

        jScrollPane1.setViewportView(jPanel2);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 1292, 720);
        jScrollPane1.setOpaque( false );
        jScrollPane1.getViewport().setOpaque( false );
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToMenuActionPerformed
        this.menuPanel.setupCard();
    }//GEN-LAST:event_btnBackToMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToMenu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    // End of variables declaration//GEN-END:variables
}