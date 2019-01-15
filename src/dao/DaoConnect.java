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
			 * Cadastro de usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			
			public void inserirUsuario(Usuario usuario ) {
				String sql = "";
				
				try {
					stmt =  con.prepareStatement(sql);
					
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
			
			public void alteraUsuario() {
				String sql = "";
				
				try {
					stmt =  con.prepareStatement(sql);
					
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
			
			public void excluiUsuario() {}
			//Fim
			
			/*--------------------------------------------------
			 * Dados  usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			
			public void dadosUsuario(Usuario usuario) {
				String sql = "";
				
				try {
					stmt =  con.prepareStatement(sql);
					ResultSet res = stmt.executeQuery();
					while(res.next()) {
						
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
