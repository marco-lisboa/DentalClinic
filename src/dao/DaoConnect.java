package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Usuario;

public class DaoConnect {

	//Conexão com banco de dados - MAYNORECOMENTS
	
		private Connection con;
		private PreparedStatement stmt;
		Usuario usuario = new Usuario();
		private final String USER = "root";
		private final String PASS = "maynore";
		public String URL = null;
		private ResultSet resultado = null;
		
		
		public void conectar(String ip){
			 URL = "jdbc:mysql://"+ip+":3306/dentalclinic";
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL,USER,PASS);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.getMessage();
			}
		}
		/*---------------------------------------------------------------------*/
		//Execulção banco de dados - MAYNORECOMENTS

		//Validação login - MAYNORECOMENTS
		public boolean logado;

		int id_usuario;
		public int getId_usuario() {
			return id_usuario;
		}

		public void setId_usuario(int id_usuario) {
			this.id_usuario = id_usuario;
		}

		String nome_usuario;

		public String getNome_usuario() {
			return nome_usuario;
		}

		public void setNome_usuario(String nome_usuario) {
			this.nome_usuario = nome_usuario;
		}

		public void Acesso(String log_usuario,String senha_usuario,String ip){

			Connection conectado = null;
			PreparedStatement consulta = null;
			ResultSet retorno= null;
			String url ;

			try{
				url = "jdbc:mysql://"+ip+":3306/dentalclinic";
				conectado = DriverManager.getConnection(url,"root","maynore");
				consulta =  conectado.prepareStatement("select login, senha from login where login='"+log_usuario+"'and senha='"+senha_usuario+"'");
				retorno =consulta.executeQuery();
				if(retorno.next()){
					logado=true;
				}else{
					System.out.println("USUARIO OU SENHA INCORRETOS");
					logado=false;
				}	
			}catch (Exception e){

				e.getMessage();

			}


		}

		public void DadosUsuario(String nome){
			String sql= "SELECT * FROM login where login='"+nome+"';";
			try {
				stmt =  con.prepareStatement(sql);
				resultado = stmt.executeQuery();
				while (resultado.next()) {
					setId_usuario(Integer.parseInt(resultado.getString("id")));
					setNome_usuario(resultado.getString("login"));

				}

			} catch (SQLException e) {
				e.getMessage();
			}

		}
		
		
		/***************************************************************************
		 * 																		   *
		 * 				public void inserir() {}                                   *
		 *				public void altera() {}                                    *
		 *				public void exclui() {}                                    *
         *				public void dados() {}                               	   *
		 *                                                                         *
		 ***************************************************************************/
		
		
		
		/***************************************************************************
		 * 																		   *
		 * 							Funções Empresa                                *
		 *                                                                         *
		 ***************************************************************************/
			public void inserirEmpresa() {}
			public void alteraEmpresa() {}
			public void excluiEmpresa() {}
			public void dadosEmpresa() {}
		

		/***************************************************************************
		 * 																		   *
		 * 							Funções Usuario                                *
		 *                                                                         *
		 ***************************************************************************/
			/*--------------------------------------------------
			 * Consulta de usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			public void listUsuarios (Usuario usuario) {
				
			}
			//Fim
			/*--------------------------------------------------
			 * Cadastro de usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			
			public void inserirUsuario(Usuario usuario ) {
				String sql = "INSERT INTO login ("
						+ "nome,"
						+ "login,"
						+ "senha,"
						+ "funcao,"
						+ "nivel,"
						+ "padrao,"
						+ "cadastro,"
						+ "altera_privilegio,"
						+ "situacao,"
						+ "ativo_site,"
						+ "privilegioid"
						+ ")VALUES(?,?,?,?,?,?,?,?,?,?,?)";
				
				try {
					stmt =  con.prepareStatement(sql);
					stmt.setString(1,usuario.getNomeUsuario());
					stmt.setString(2,usuario.getLoginUsuario());
					stmt.setString(3,usuario.getSenhaUsuario());
					stmt.setString(4,usuario.getFuncao());
					stmt.setInt(5,usuario.getNivelUsuario());
					stmt.setInt(6,usuario.getPadrao());
					stmt.setInt(7,usuario.getCadastro());
					stmt.setInt(8,usuario.getAltera_privi());
					stmt.setInt(9, usuario.getSituacao());
					stmt.setInt(10, usuario.getAtivo_site());
					stmt.setInt(11,usuario.getPrivilegioId());
					stmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Fim
			
			/*--------------------------------------------------
			 * Altera de Usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			
			public void alteraUsuario(Usuario usuario) {
				String sql = "UPDATE login SET "
						+ "nome =?, "
						+ "login =?, "
						+ "senha =?, "
						+ "funcao =?, "
						+ "nivel =?, "
						+ "padrao =?, "
						+ "cadastro =?, "
						+ "altera_privilegio =?, "
						+ "situacao =? ,"
						+ "ativo_site =? ,"
						+ "privilegioid =? "
						+ "where idlogin =? ";
				
				try {
					stmt =  con.prepareStatement(sql);
					stmt.setString(1,usuario.getNomeUsuario());
					stmt.setString(2,usuario.getLoginUsuario());
					stmt.setString(3,usuario.getSenhaUsuario());
					stmt.setString(4,usuario.getFuncao());
					stmt.setInt(5,usuario.getNivelUsuario());
					stmt.setInt(6,usuario.getPadrao());
					stmt.setInt(7,usuario.getCadastro());
					stmt.setInt(8,usuario.getAltera_privi());
					stmt.setInt(9, usuario.getSituacao());
					stmt.setInt(10, usuario.getAtivo_site());
					stmt.setInt(11,usuario.getPrivilegioId());
					stmt.setInt(12,usuario.getUsuarioId());
					stmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Fim
			
			/*--------------------------------------------------
			 * Exclui de Usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			
			public void excluiUsuario(Usuario usuario) {
				//String sql = "DELETE FROM login WHERE idlogin =?;";
				
			}
			//Fim
			
			/*--------------------------------------------------
			 * Dados  usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			
			public void dadosUsuario(Usuario usuario) {
				String sql = "SELECT * FROM login WHERE loginid ='"+usuario.getUsuarioId()+"';";
				
				try {
					stmt =  con.prepareStatement(sql);
					ResultSet res = stmt.executeQuery();
					while(res.next()) {
						usuario.setNomeUsuario(res.getString("nome"));
						usuario.setLoginUsuario(res.getString("login"));
						usuario.setSenhaUsuario(res.getString("senha"));
						usuario.setFuncao(res.getString("funcao"));
						usuario.setNivelUsuario(res.getInt("nivel"));
						usuario.setPadrao(res.getInt("padrao"));
						usuario.setCadastro(res.getInt("cadastro"));
						usuario.setAltera_privi(res.getInt("aletera_privilegio"));
						usuario.setSituacao(res.getInt("situacao"));
						usuario.setAtivo_site(res.getInt("ativo_site"));
						usuario.setPrivilegioId(res.getInt("privilegioid"));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//Fim

		/***************************************************************************
		 * 																		   *
		 * 							Função Fecha Conexão                           *
		 *                                                                         *
		 ***************************************************************************/
		public void fecharCon(){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
}
