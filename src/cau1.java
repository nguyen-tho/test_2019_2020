import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
câu 1a chỉ vẽ giao diện 
giao diện gồm
- 1 dòng nhập số x
- 1 dòng nhập số n
- 1 dòng xuất kết quả
mỗi dòng là 1 text field

- 1 button tính giá trị biểu thức

câu 1b viết hàm actionPerformed cho việc tính toán biểu thức 
1+2x+3x^2....(n+1)x^n
*/
public class cau1 extends JFrame implements ActionListener{
    /*
    3 dòng (2 dòng nhập 1 dòng xuất) tương ứng 3 label, 3 text field,
    1 button để xử lý
    */ 
    private JLabel label, label2, label3;
    private JTextField tf1, tf2, tf3;
    private JButton button;
// 4 panel để đưa từng thành phần của giao diện tương ứng thành 4 phần
    private JPanel panel, panel2, panel3, panel4;
    // code câu 1a 
    cau1() {
        //tạo 1 frame để đưa từng thành phần thuộc 4 panel trên vào giao diện chính
        JFrame frame = new JFrame("Câu 1");
//khởi tạo từng thành phần
        label = new JLabel("Nhập x");
        tf1 = new JTextField();
        tf1.setColumns(30);

        label2 = new JLabel("Nhập n");
        tf2 = new JTextField();
        tf2.setColumns(30);

        label3 = new JLabel("Kết quả");
        tf3 = new JTextField();
        tf3.setColumns(30);
        tf3.setEditable(false);//dòng này chỉ hiển thị kết quả không được nhập thêm bất cứ giá trị gì từ bên ngoài

        button = new JButton("Tính giá trị biểu thức");
        button.addActionListener(this);//khi nhấn vào nút "tính giá trị biểu thức" thì sẽ thực thi việc tính toán
//đưa các thành phần vào panel
        panel = new JPanel();
        panel.setSize(200,40);
        panel.add(label);
        panel.add(tf1);

        panel2 = new JPanel();
        panel2.setSize(200,40);
        panel2.add(label2);
        panel2.add(tf2);

        panel3 = new JPanel();
        panel3.setSize(200,40);
        panel3.add(label3);
        panel3.add(tf3);

        panel4 = new JPanel();
        panel4.setSize(200,40);
        panel4.add(button,BorderLayout.CENTER);
//đưa từng panel vào frame
        frame.setLayout(new GridLayout(4,1));
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        frame.setSize(400,300);
//setVisible(true) giúp hiển thị giao diện
        frame.setVisible(true);
    }
    // câu 1b
    //actionPerformed(ActionEvent e) giúp thực thi khi nhấn nút "tính giá trị biểu thức" 
    public void actionPerformed(ActionEvent e) {
        double result = 0;
        int x = Integer.parseInt(tf1.getText());
        int n = Integer.parseInt(tf2.getText());

        for(int i = 0; i <= n; i++) {
            result += (i+1)*Math.pow(x,i);
        }

        tf3.setText(String.valueOf(result));
    }
    public static void main(String[] args) {
        new cau1();
    }
}