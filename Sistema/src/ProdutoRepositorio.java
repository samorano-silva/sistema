import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoRepositorio {
	private BD bd;
	
	public ProdutoRepositorio(BD bd) {
		this.bd = bd;
	}
	
	public void cadastrar (Produto produto) {
		String query = "INSERT INTO "
					+ "produto "
					+ "(codigo, nome, quantidade, valor, marca) "
					+ "VALUES "
					+ "('" + produto.getCodigo() + "', "
					+"'"+ produto.getNome() + "', "
					+"'"+ produto.getQuantidade() + "', "
					+"'"+ produto.getValor() + "', "
					+"'"+ produto.getMarca() + "');";
		this.bd.executeUpdate(query);
	}
	
	public Produto obter(int id) {
		String query = "SELECT * FROM produto WHERE id =  " + id + ";";
		ResultSet dados = this.bd.executeQuery(query);
		Produto produto = new Produto();
		try {
			dados.next();
			produto.setId(dados.getInt("id"));
			produto.setCodigo(dados.getString("codigo"));
			produto.setNome(dados.getString("nome"));
			produto.setQuantidade(dados.getString("quantidade"));
			produto.setValor(dados.getString("valor"));
			produto.setMarca(dados.getString("marca"));
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
	
	public ArrayList<Produto> listar() {
		String query = "SELECT * FROM produto;";
		ResultSet dados = this.bd.executeQuery(query);
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
		while(dados.next()) {
			Produto produto = new Produto();
			produto.setId(dados.getInt("id"));
			produto.setCodigo(dados.getString("codigo"));
			produto.setNome(dados.getString("nome"));
			produto.setQuantidade(dados.getString("quantidade"));
			produto.setValor(dados.getString("valor"));
			produto.setMarca(dados.getString("marca"));
			produtos.add(produto);
			
		 }	
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
		
	}
	public void excluir (int id) {
		String query = "DELETE FROM produto WHERE id = "+ id +";";
		this.bd.executeUpdate(query);
		
		
	}

	public void editar(Produto produto) {
		String query = "UPDATE produto SET "
				+ "codigo = '" + produto.getCodigo() + "', "
				+ "nome = '" + produto.getNome() + "', "
				+ "quantidade = '" + produto.getQuantidade() + "', "
				+ "valor = '" + produto.getValor() + "', "
				+ "marca = '" + produto.getMarca() + "' "
				+ "WHERE id = " + produto.getId() + ";";
		this.bd.executeUpdate(query);
		
	}
	
	
	
	
	
}
