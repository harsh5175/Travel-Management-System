import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewCustomers extends JFrame {
    Connection conn = null;
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewCustomers frame = new ViewCustomers();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewCustomers() throws SQLException {
        // Initialize DB connection
		conn = new Conn().c;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(580, 220, 900, 680);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Image 1
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i3 = i1.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(new ImageIcon(i3));
        l1.setBounds(0, 450, 626, 201);
        contentPane.add(l1);

        // Image 2
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(626, 201, Image.SCALE_DEFAULT);
        JLabel l2 = new JLabel(new ImageIcon(i5));
        l2.setBounds(615, 450, 626, 201);
        contentPane.add(l2);

        // JTable with scroll pane
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 40, 880, 350);
        contentPane.add(scrollPane);

        // Load data from database
        try {
            String displayCustomerSql = "SELECT * FROM customer";
            PreparedStatement pst = conn.prepareStatement(displayCustomerSql);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading customer data.");
        }

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(390, 400, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(e -> setVisible(false));
        contentPane.add(btnBack);

        getContentPane().setBackground(Color.WHITE);
    }
}
