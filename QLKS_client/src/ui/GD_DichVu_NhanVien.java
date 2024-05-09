package ui;

import dao.BookRoomDAO;
import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ServiceDAO;
import dao.ServiceDetailDAO;
import entity.Order;
import entity.OrderDetail;
import entity.Room;
import entity.Service;
import entity.ServiceDetail;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.ui.tabbedui.DetailEditor;

public class GD_DichVu_NhanVien extends javax.swing.JInternalFrame {
    private DefaultTableModel dtmPhong,dtmDichVu,dtmChiTietDichVu;
    private final OrderDAO oDAO=new OrderDAO();
    private ArrayList<Order> listOrders;
    private ArrayList<Service> listServices;
    private ArrayList<ServiceDetail> listServiceDetails;
    private final BookRoomDAO  brDAO=new BookRoomDAO();
    private final CustomerDAO cDAO=new CustomerDAO();
    private final ServiceDAO sDAO=new ServiceDAO();
    private final ServiceDetailDAO sdDAO=new ServiceDetailDAO();
    
    /**
     * Creates new form GD_DichVu_NhanVien
     */
    public GD_DichVu_NhanVien() throws ClassNotFoundException, SQLException {
        this.setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ui
                = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ui).setNorthPane(null);
        
        
        initComponents();
        dtmDichVu=(DefaultTableModel) tblDichVu.getModel();
        dtmPhong=(DefaultTableModel) tblPhong.getModel();
        dtmChiTietDichVu=(DefaultTableModel) tblChiTietDichVu.getModel();
        loadPhongToTable(dtmPhong,listOrders);
        loadServiceToTable(dtmDichVu,listServices);
        
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlPhong = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtTim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        pnlOption = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnXemChiTiet = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JSpinner();
        jPanel11 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPhong = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblChiTietDichVu = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();

        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        Main.setLayout(new javax.swing.BoxLayout(Main, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Dá»‹ch Vá»¥");
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

        Main.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        pnlPhong.setBackground(new java.awt.Color(255, 255, 255));
        pnlPhong.setLayout(new javax.swing.BoxLayout(pnlPhong, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(1000, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(138, 70));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setMaximumSize(new java.awt.Dimension(500, 300));
        jPanel5.setMinimumSize(new java.awt.Dimension(80, 50));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 65));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKeyReleased(evt);
            }
        });
        jPanel5.add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 340, 30));

        jLabel2.setText("Tìm phòng:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        pnlPhong.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách các phòng đang sử dụng"));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã phòng", "Tên phòng", "CCCD", "Tên khách hàng"
            }
        ));
        jScrollPane2.setViewportView(tblPhong);

        jPanel4.add(jScrollPane2);

        pnlPhong.add(jPanel4);

        jPanel2.add(pnlPhong);

        pnlOption.setBackground(new java.awt.Color(255, 255, 255));
        pnlOption.setLayout(new javax.swing.BoxLayout(pnlOption, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 304));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.add(jPanel14);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        btnXemChiTiet.setBackground(new java.awt.Color(36, 89, 83));
        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXemChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiTiet.setText("Xem chi tiết dịch vụ");
        btnXemChiTiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });
        jPanel12.add(btnXemChiTiet);

        jPanel13.add(jPanel12);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Số lượng: ");
        jPanel10.add(jLabel3);

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSoLuong.setMaximumSize(new java.awt.Dimension(300, 100));
        txtSoLuong.setPreferredSize(new java.awt.Dimension(85, 31));
        jPanel10.add(txtSoLuong);
        SpinnerNumberModel modelGio = new SpinnerNumberModel(0, 0, 999, 1);
        txtSoLuong.setModel(modelGio);

        jPanel13.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(36, 89, 83));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm dịch vụ vào phòng");
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel11.add(btnThem);

        jPanel13.add(jPanel11);

        jPanel7.add(jPanel13);

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách dịch vụ"));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Đơn giá", "Số lượng tồn"
            }
        ));
        jScrollPane1.setViewportView(tblDichVu);

        jPanel8.add(jScrollPane1);

        jPanel6.add(jPanel8);

        pnlOption.add(jPanel6);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết dịch vụ trong phòng"));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Danh sách dịch vụ");
        jPanel16.add(jLabel4);

        lblPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel16.add(lblPhong);

        jPanel9.add(jPanel16);

        tblChiTietDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Giá"
            }
        ));
        jScrollPane3.setViewportView(tblChiTietDichVu);

        jPanel9.add(jScrollPane3);

        jPanel15.add(jPanel9);

        pnlOption.add(jPanel15);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.Y_AXIS));

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.Y_AXIS));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(231, 162, 58)));
        jPanel19.setLayout(new java.awt.GridLayout(1, 2));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Thành tiền: ");
        jPanel19.add(jLabel5);

        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel19.add(lblThanhTien);

        jPanel18.add(jPanel19);

        jPanel17.add(jPanel18);

        pnlOption.add(jPanel17);

        jPanel2.add(pnlOption);

        Main.add(jPanel2);

        getContentPane().add(Main);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        int index= tblPhong.getSelectedRow();
        if(index==-1){
            JOptionPane.showMessageDialog(null, "Hãy chọn phòng cần xem chi tiết!");
        }else{
            try {
                loadChiTietToTable(dtmChiTietDichVu,listServiceDetails);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GD_DichVu_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(GD_DichVu_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int indexDichVu=tblDichVu.getSelectedRow();
        int indexPhong=tblPhong.getSelectedRow();
        int soLuong=Integer.parseInt(txtSoLuong.getValue().toString());
        if(indexPhong==-1){
            JOptionPane.showMessageDialog(null, "Hãy chọn phòng cần mua!");
        }else if(indexDichVu==-1){
            JOptionPane.showMessageDialog(null, "Hãy chọn sản phẩm muốn mua!");
        }else {
            Service s=sDAO.getServiceByID(tblDichVu.getValueAt(indexDichVu, 0).toString());
            if(soLuong <=0 ){
            JOptionPane.showMessageDialog(null, "Sản lượng phải lớn hơn 0!");
        }else if(soLuong>s.getInventory()) {JOptionPane.showMessageDialog(null, "Số lượng hàng không đủ để bán cho khách hàng!");}
        else{
            Order o=oDAO.getOrderByID(tblPhong.getValueAt(indexPhong, 0).toString());
            boolean flag=false;
            for(ServiceDetail sd:sdDAO.getListServiceDetailByOrderID(o.getOrderID())){
                if(sd.getService().getServiceID().equals(dtmChiTietDichVu.getValueAt(indexDichVu, 0))){
                    int sl=sd.getQuantity()+soLuong;
                    sd.setQuantity(sl);
                    double gia=sl*sd.getService().getPrice();
                    if(sdDAO.update(sd)){
                        flag=true;
                    }
                    try {
                        s.setInventory(s.getInventory()-soLuong);
                        if(sDAO.update(s)){
                        loadServiceToTable(dtmDichVu, listServices);
                        loadChiTietToTable(dtmChiTietDichVu, listServiceDetails);
                        txtSoLuong.setValue(0);
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(GD_DichVu_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(GD_DichVu_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                        JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    }
            }
            if(flag==false){
                ServiceDetail sd=new ServiceDetail(maTuSinhChiTietDV(), s, o, soLuong);
                if(sdDAO.add(sd)){
                    try {
                        s.setInventory(s.getInventory()-soLuong);
                        if(sDAO.update(s)){
                        loadServiceToTable(dtmDichVu, listServices);
                        }

                        loadChiTietToTable(dtmChiTietDichVu, listServiceDetails);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(GD_DichVu_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(GD_DichVu_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    txtSoLuong.setValue(0);
                    JOptionPane.showMessageDialog(null,"Thêm thành công!" );
                } 
            }
        }
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyReleased
        String s=txtTim.getText();
        filter(s);
    }//GEN-LAST:event_txtTimKeyReleased
    private void filter(String s){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(dtmPhong);
        tblPhong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+s));

        
    }
    private String maTuSinhChiTietDV() {
        String ma = "CTDV";
        int tachMa;
        int i = 0, j = 1;
        int[] dem = new int[999];
        String id;
        if(sdDAO.getAlLServiceDetail() != null){
        for (ServiceDetail sd : sdDAO.getAlLServiceDetail()) {
            id = sd.getServiceDetailID();
            tachMa = Integer.parseInt(id.substring(4, 7));
            dem[i] = tachMa;
            i++;
        }
        i = 0;
        while (j < 999) {
            if (dem[i] < j) {
                if (j <= 9) {
                    ma += "00" + (j);
                } else {
                    ma += "0" + (j);
                }
                break;
            } else if (dem[i] > j) {
                j = dem[i];
            } else {

                i++;
                j++;
            }
        }
        }else{
            ma="CTDV001";
        }
        return ma;
    }

    private javax.swing.JPanel Main;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JPanel pnlOption;
    private javax.swing.JPanel pnlPhong;
    private javax.swing.JTable tblChiTietDichVu;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblPhong;
    private javax.swing.JSpinner txtSoLuong;
    private javax.swing.JTextField txtTim;

    private void loadPhongToTable(DefaultTableModel dtm, ArrayList<Order> list) {
        list=oDAO.getAlLOrderWithStatus();
        
        dtm.setRowCount(0);
        
        for(Order o:list){
            Room r=o.getBookRooms().get(0).getRoom();
            String cccd =o.getBookRooms().get(0).getCustomer().getCCCD();
            String name=o.getBookRooms().get(0).getCustomer().getCustomerName();
            dtm.addRow(new String []{o.getOrderID(),r.getRoomID(),r.getRoomName(),cccd,name});
        }
    }

    private void loadServiceToTable(DefaultTableModel dtm, List<Service> list) throws ClassNotFoundException, SQLException {
        list=sDAO.getAllService();
        
        dtm.setRowCount(0);
        
        for(Service s:list){
            dtm.addRow(new String []{s.getServiceID(),s.getServiceName(),s.getPrice()+"",s.getInventory()+""});
        }
    }

    private void loadChiTietToTable(DefaultTableModel dtm, ArrayList<ServiceDetail> list) throws ClassNotFoundException, SQLException {
        dtm.setRowCount(0);
        int index= tblPhong.getSelectedRow();
        String maHoaDon=tblPhong.getValueAt(index, 0).toString();
        lblPhong.setText(tblPhong.getValueAt(index, 2).toString());
        list=(ArrayList<ServiceDetail>) sdDAO.getListServiceDetailByOrderID(maHoaDon);
        if(list!=null){
            for(ServiceDetail sd:list){
                    double gia=sd.getQuantity()*sd.getService().getPrice();
                    dtm.addRow(new String [] {sd.getService().getServiceID(), sd.getService().getServiceName(),sd.getQuantity()+"",gia+""});
                }
        }

        double thanhTien=0;
        for(int i=0;i<dtmChiTietDichVu.getRowCount();i++){
            thanhTien+= Double.parseDouble( dtmChiTietDichVu.getValueAt(i, 3).toString());
        }
        lblThanhTien.setText(""+thanhTien);
        
    }
}
