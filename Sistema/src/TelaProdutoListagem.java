
import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.List;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JEditorPane;



public class TelaProdutoListagem extends JFrame {

	private JPanel contentPane;
	
	private ProdutoRepositorio produtoRepo;
	public JTable tblProdutos;
	
	public TelaProdutoListagem(ProdutoRepositorio produtoRepo) {
		this.produtoRepo = produtoRepo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTelaCadasttro = new JButton("Cadastrar Produto");
		btnTelaCadasttro.setBackground(SystemColor.window);
		btnTelaCadasttro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProdutoCadastro telaProdutoCadastro = new TelaProdutoCadastro (produtoRepo);
				telaProdutoCadastro.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						listarProdutos();
					}
				});
				telaProdutoCadastro.setVisible(true);
				
				
			}
		});
		btnTelaCadasttro.setBounds(10, 25, 163, 55);
		contentPane.add(btnTelaCadasttro);
		
		 JScrollPane scrProdutos = new JScrollPane();
		scrProdutos.setBounds(249, 25, 474, 292);
		contentPane.add(scrProdutos);
		
		tblProdutos = new JTable();
		tblProdutos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID Origem", "Codigo", "Nome", "Quantidade", "Pre\u00E7o", "Marca"
			}
		));
		
		scrProdutos.setViewportView(tblProdutos);
		
		JEditorPane editorPane = new JEditorPane();
		scrProdutos.setColumnHeaderView(editorPane);
		
		JButton btnExcluir = new JButton("Excluir Produto");
		btnExcluir.setBackground(SystemColor.window);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tblProdutos.getSelectedRow() >= 0  ){
					int id = (int) tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 0);
					Object[] options = {"   Sim   ", "   Não   "}; 
					int selecao = JOptionPane.showOptionDialog(null," Deseja realmente Exluir? ","Excluir Produto", 
					        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
					
					
					if(selecao == 0) {
						produtoRepo.excluir(id);
			            JOptionPane.showMessageDialog(null, "Produto Excluido com sucesso!!");
			            listarProdutos();
					}if(selecao == 1) {
						
						listarProdutos();
					}
					
					//0 sim
					//1 não
					//2 cancelar

		        } else {
		            JOptionPane.showMessageDialog(null, "Selecione Um ou Mais Produtos!!");
		}
				
				
			}
		});
		btnExcluir.setBounds(10, 90, 163, 55);
		contentPane.add(btnExcluir);
		
		JButton btnTelaEdicao = new JButton("Editar Produto");
		btnTelaEdicao.setBackground(SystemColor.window);
		btnTelaEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (tblProdutos.getSelectedRow() >=0  ){
					int id = (int) tblProdutos.getModel().getValueAt(tblProdutos.getSelectedRow(), 0);
					Object[] options = {"   Sim   ", "   Não   "}; 
					int selecao = JOptionPane.showOptionDialog(null," Deseja realmente Editar? ","Editar Produto", 
					        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
					
					
					if(selecao == 0) {
						
						TelaProdutoEdicao telaProdutoEdicao = new TelaProdutoEdicao (produtoRepo, id);
						telaProdutoEdicao.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosed(WindowEvent e) {
								listarProdutos();
							}
						});
						telaProdutoEdicao.setVisible(true);
			            listarProdutos();
			            
					}if(selecao == 1) {
						
						listarProdutos();
					}
					
					//0 sim
					//1 não
					//2 cancelar

		        } else {
		            JOptionPane.showMessageDialog(null, "Selecione Um ou Mais Produtos!!");
		}
				

				/*
				TelaProdutoEdicao telaProdutoEdicao = new TelaProdutoEdicao (produtoRepo, id);
				telaProdutoEdicao.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						listarProdutos();
					}
				});
				telaProdutoEdicao.setVisible(true);
				
				
			*/}
		});
		btnTelaEdicao.setBounds(10, 156, 163, 55);
		contentPane.add(btnTelaEdicao);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaProdutoListagem.class.getResource("/Imagem/logo.png")));
		lblNewLabel.setBounds(20, 0, 758, 341);
		contentPane.add(lblNewLabel);
		
		this.listarProdutos();
		
	}
	
	public void listarProdutos() {
		
		ArrayList<Produto> produtos = this.produtoRepo.listar();
		DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
		model.setRowCount(0);
		for(Produto produto: produtos) {
			model.addRow(new Object[] {
				produto.getId(),
				produto.getCodigo(),
				produto.getNome(),
				produto.getQuantidade(),
				produto.getValor(),
				produto.getMarca()
					
					
					
			});
		}
		
	}
}
