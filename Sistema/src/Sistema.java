/*
* <Unime Lauro De Freitas>
* <Sistema De Informção>
* <POO 2>
* <Pablo Roxo>
* <Samorano Silva, Gustavo Mariano>
*/


public class Sistema {

	public static void main(String[] args) {
		
			BD bd = new BD();
			bd.conectar();
			
			ProdutoRepositorio produtoRepo = new ProdutoRepositorio(bd);
			
			TelaProdutoListagem telaProdutoListagem = new TelaProdutoListagem(produtoRepo);
			telaProdutoListagem.setVisible(true);
	
	}

}
