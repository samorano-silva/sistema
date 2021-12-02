import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class TelaProdutoCadastro extends JFrame {

	private JPanel contentPane;
	private ProdutoRepositorio produtoRepo;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textQuantidade;
	private JTextField textValor;
	private JTextField textMarca;
	
	
	/**
	 * Create the frame.
	 */
	public TelaProdutoCadastro(ProdutoRepositorio produtoRepo) {
		this.produtoRepo = produtoRepo;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		
		JLabel lblTitulo = new JLabel("Cadastro De Produtos");
		lblTitulo.setBackground(SystemColor.desktop);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(SystemColor.desktop);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 35, 379, 30);
		contentPane.add(lblTitulo);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigo.setVisible(true);
		lblCodigo.setBackground(Color.WHITE);
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(33, 96, 60, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setVisible(true);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(33, 124, 60, 14);
		contentPane.add(lblNome);
		
		JLabel lblQuantidade = new JLabel("Qtd :");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQuantidade.setVisible(true);
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setBounds(33, 152, 60, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblValor = new JLabel("Pre\u00E7o :");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValor.setVisible(true);
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setBounds(10, 182, 83, 14);
		contentPane.add(lblValor);
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMarca.setVisible(true);
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarca.setBounds(10, 212, 83, 14);
		contentPane.add(lblMarca);
		
		textCodigo = new JTextField();
		textCodigo.setToolTipText("");
		textCodigo.setBounds(97, 93, 214, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(97, 121, 214, 20);
		contentPane.add(textNome);
		
		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(97, 149, 214, 20);
		contentPane.add(textQuantidade);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(97, 178, 214, 20);
		contentPane.add(textValor);
		
		textMarca = new JTextField();
		textMarca.setColumns(10);
		textMarca.setBounds(97, 209, 214, 20);
		contentPane.add(textMarca);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

		if ((textCodigo.getText().length()>0)
		                &&(textNome.getText().length()> 0)
		                &&(textQuantidade.getText().length()> 0)
		                &&(textValor.getText().length()> 0)
		                &&(textMarca.getText().length() > 0)) {
					
					Produto produto = new Produto();
					produto.setCodigo(textCodigo.getText());
					produto.setNome(textNome.getText());
					produto.setQuantidade(textQuantidade.getText());
					produto.setValor(textValor.getText());
					produto.setMarca(textMarca.getText());

					produtoRepo.cadastrar(produto);
					
		            JOptionPane.showMessageDialog(btnCadastrar, "Cadastro realizado com sucesso!!");
		            dispose();
		            
		        } else {
		            JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Para Contuniar!!");
		}


			}   
		
		});
		
		
		btnCadastrar.setBounds(97, 254, 102, 36);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodigo.setText("");
				textNome.setText("");
				textQuantidade.setText("");
				textValor.setText("");
				textMarca.setText("");
				
				
			}
		});
		btnLimpar.setBounds(209, 254, 102, 36);
		contentPane.add(btnLimpar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaProdutoCadastro.class.getResource("/Imagem/logo.png")));
		lblNewLabel.setBounds(0, 0, 399, 375);
		contentPane.add(lblNewLabel);
	}
}
