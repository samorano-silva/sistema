import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordSenha;
	private static ProdutoRepositorio produtoRepo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView( ) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblUsuario.setForeground(SystemColor.text);
		lblUsuario.setBounds(49, 107, 74, 17);
		contentPane.add(lblUsuario);
		
		textLogin = new JTextField();
		textLogin.setBounds(133, 107, 162, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSenha.setForeground(SystemColor.window);
		lblSenha.setBounds(62, 156, 61, 17);
		contentPane.add(lblSenha);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProdutoListagem listagem = new TelaProdutoListagem(produtoRepo);
				listagem.setVisible(true);
				//JFrame.dispose();
			}
		});
		btnLogin.setBackground(SystemColor.menu);
		btnLogin.setBounds(65, 223, 86, 25);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(SystemColor.window);
		lblNewLabel_2.setBackground(SystemColor.activeCaption);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 52, 364, 25);
		contentPane.add(lblNewLabel_2);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(133, 156, 162, 20);
		contentPane.add(passwordSenha);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBackground(SystemColor.menu);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastro.setBounds(211, 223, 86, 25);
		contentPane.add(btnCadastro);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/Imagem/logo.png")));
		lblNewLabel.setBounds(0, 0, 384, 319);
		contentPane.add(lblNewLabel);
	}
}
