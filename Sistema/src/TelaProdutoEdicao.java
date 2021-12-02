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
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.ImageIcon;



public class TelaProdutoEdicao extends JFrame {

	private JPanel contentPane;
	private ProdutoRepositorio produtoRepo;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textQuantidade;
	private JTextField textValor;
	private JTextField textMarca;
	private int id;
	private Produto produto;
	private JTable tblProdutos;
	
	/**
	 * Create the frame.
	 */
	public TelaProdutoEdicao(ProdutoRepositorio produtoRepo, int id) {
		this.produtoRepo = produtoRepo;
		this.id =  id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblTitulo = new JLabel("Edi\u00E7\u00E3o De Produtos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 29, 379, 30);
		contentPane.add(lblTitulo);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setVisible(true);
		lblCodigo.setBackground(Color.WHITE);
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(33, 96, 60, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setVisible(true);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(33, 124, 60, 14);
		contentPane.add(lblNome);
		
		JLabel lblQuantidade = new JLabel("Qtd :");
		lblQuantidade.setVisible(true);
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setBounds(33, 152, 60, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblValor = new JLabel("Pre\u00E7o :");
		lblValor.setVisible(true);
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setBounds(10, 182, 83, 14);
		contentPane.add(lblValor);
		
		JLabel lblMarca = new JLabel("Marca :");
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
		

		TelaProdutoListagem lista = new  TelaProdutoListagem(produtoRepo);
	
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

		if ((textCodigo.getText().length()>0)
		                &&(textNome.getText().length()> 0)
		                &&(textQuantidade.getText().length()> 0)
		                &&(textValor.getText().length()> 0)
		                &&(textMarca.getText().length() > 0)
		                 ){
					
			produto.setCodigo(textCodigo.getText());
			produto.setNome(textNome.getText());
			produto.setQuantidade(textQuantidade.getText());
			produto.setValor(textValor.getText());
			produto.setMarca(textMarca.getText());
			
			
			Object[] options = {"   Sim   ", "   Não   "}; 
			int selecao = JOptionPane.showOptionDialog(null," Deseja realmente Editar? ","Editar Produto", 
			        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
			
			
			if(selecao == 0) {
				produtoRepo.editar(produto);
				
	            JOptionPane.showMessageDialog(btnEditar, "Produto editado com Sucesso !!");
	            dispose();
	            
			}if(selecao == 1) {
				
				dispose();
			}
			
		            
		        } else{
		            JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Para Continuar !!");
		}
/*
 * produtoRepo.editar(produto);
					
		            JOptionPane.showMessageDialog(btnEditar, "Produto editado com Sucesso !!");
		            dispose();
*/	
	}   	
});
		
		
		btnEditar.setBounds(97, 254, 102, 36);
		contentPane.add(btnEditar);
		
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
		
		this.produto = this.produtoRepo.obter(this.id);
		textCodigo.setText(this.produto.getCodigo());
		textNome.setText(this.produto.getNome());
		textQuantidade.setText(this.produto.getQuantidade());
		textValor.setText(this.produto.getValor());
		textMarca.setText(this.produto.getMarca());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaProdutoEdicao.class.getResource("/Imagem/logo.png")));
		lblNewLabel.setBounds(0, 0, 399, 375);
		contentPane.add(lblNewLabel);
		
		
	}
}
