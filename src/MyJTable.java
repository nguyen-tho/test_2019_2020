import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.*;
import java.awt.event.*;
 
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class MyJTable extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = -6464587060272247354L;
    private Connection connect = null;
    private JTable jtable = new JTable();
    private DefaultTableModel tableModel = new DefaultTableModel();

    //private JLabel l1;
    private JTextField tf1;
    private JButton b1;
    private JPanel panel;
     
    public MyJTable(){
        String []colsName = {"Mã hàng", "Tên hàng"};
        tableModel.setColumnIdentifiers(colsName);  // đặt tiêu đề cột cho tableModel
        jtable.setModel(tableModel);    // kết nối jtable với tableModel

        tf1 = new JTextField();
        b1 = new JButton("Tìm kiếm");
        b1.addActionListener(this);

         
        initComponent();    // Khởi tạo các components trên JFrame
        connectSQL();       // kết nối cơ sở dữ liệu
        updateData(view()); // gọi hàm view để truy suất dữ liệu sau đó truyền cho hàm updateData để đưa dữ liệu vào tableModel và hiện lên Jtable trong Frame
    }
     
    public void updateData(ResultSet result){
        String []colsName = {"username", "password","hoten"};
        tableModel.setColumnIdentifiers(colsName); // Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
 
        try {
            while(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
                String rows[] = new String[3];
                rows[0] = result.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
                rows[1] = result.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
                rows[2] = result.getString(3); // lấy dữ liệu tai cột số 3
                tableModel.addRow(rows); // đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
                //mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự động update lại trên frame
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
     
    public void initComponent(){
        panel = new JPanel();
        panel.add(tf1);
        panel.add(b1);
        this.add(panel);
        this.setSize(400, 200);
        // Đưa jtable vào trong thanh cuộn (khi dữ liệu quá nhiều dòng sẽ có thanh cuộn ngang và doc để xem dữ liệu)
        JScrollPane scroll = JTable.createScrollPaneForTable(jtable);   
        this.add(scroll); // Đưa thanh cuộn vào Frame (hiện thanh cuộn trên frame)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
     
    public void connectSQL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = new String("jdbc:mysql://127.0.0.1:3306/dct119c1");
            try {
                connect = DriverManager.getConnection(url, "root", "");
                System.out.println("Kết nối thành công");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         
    }
     
    public ResultSet view(){
        ResultSet result = null;
        String sql = "SELECT * FROM user";
        try {
            Statement statement = (Statement) connect.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void actionPerformed(ActionEvent e) {

    }
     
    public static void main(String[] args) {
        new MyJTable();
    }
 
}