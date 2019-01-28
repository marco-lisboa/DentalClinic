package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import control.Usuario;
import view.Taviso;

public class DaoConnect {

	//Conexão com banco de dados - MAYNORECOMENTS
	
		private Connection con;
		private PreparedStatement stmt;
		Usuario usuario = new Usuario();
		private final String USER = "root";
		private final String PASS = "maynore";
		public String URL = null;
		private ResultSet resultado = null;
		Taviso aviso = new Taviso();
		
		
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
					aviso.texto.setText("USUARIO E SENHA INCORRETOS.");
					aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/fechar.png")));
					aviso.setLocationRelativeTo(null);
					aviso.show();
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
						+ "ativo_site"
						+ ")VALUES(?,?,?,?,?,?,?,?,?,?)";
				
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
					stmt.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//----------------------------------------------------------------------
				String sqlprive = "SELECT MAX(idlogin) FROM login";

				try {
					stmt =  con.prepareStatement(sqlprive);
					ResultSet res = stmt.executeQuery();
					while(res.next()) {
						usuario.setUsuarioId(res.getInt("MAX(idlogin)"));
					}
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				System.out.println( usuario.getUsuarioId());
				if(usuario.getUsuarioId()>0) {
					sqlprive = "INSERT INTO privilegios("
							/*1*/					+ "idusuario,"
							/*2*/					+ "cad_alt_clientes,"
							/*3*/					+ "cad_alt_agenda,"
							/*4*/					+ "acesso_recebe_pag,"
							/*5*/					+ "realiza_simu_orcameto,"
							/*6*/					+ "cad_alt_servico,"
							/*7*/					+ "livro_caixa,"
							/*8*/					+ "chamada,"
							/*9*/					+ "sincroniza,"
							/*10*/					+ "atualizar,"
							/*11*/					+ "acesso_configuracao,"
							/*12*/					+ "cad_alt_empresa,"
							/*13*/					+ "realiza_recebimento,"
							/*14*/					+ "realiza_recebimento_avul,"
							/*15*/					+ "excluir_financeiro,"
							/*16*/					+ "estornar,"
							/*17*/					+ "acesso_geren_finac,"
							/*18*/					+ "cad_alt_banco_conta,"
							/*19*/					+ "cad_alt_despesas,"
							/*20*/					+ "acesso_folha,"
							/*21*/					+ "cad_alt_fornecedores,"
							/*22*/					+ "acesso_relatorios,"
							/*23*/					+ "cad_alt_funcionarios"
											+ ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
									
									
									try {
										stmt =  con.prepareStatement(sqlprive);
										stmt.setInt(1,usuario.getUsuarioId());
										stmt.setInt(2, usuario.getpCadCliente());
										stmt.setInt(3, usuario.getpCadAgenda());
										stmt.setInt(4, usuario.getpAcessReceber());
										stmt.setInt(5, usuario.getpRealizaOrcamento());
										stmt.setInt(6, usuario.getpCadServico());
										stmt.setInt(7, usuario.getpLivroCaixa());
										stmt.setInt(8, usuario.getpChamada());
										stmt.setInt(9, usuario.getpSincroniza());
										stmt.setInt(10, usuario.getpAtualizar());
										stmt.setInt(11, usuario.getpAcessConfig());
										stmt.setInt(12, usuario.getpCadEmpresas());
										stmt.setInt(13, usuario.getpRealizaRecebimento());
										stmt.setInt(14, usuario.getpRealizaRecebimentoAvulso());
										stmt.setInt(15, usuario.getpExcluirFinanceiro());
										stmt.setInt(16, usuario.getpEstorna());
										stmt.setInt(17, usuario.getpAcessGenFin());
										stmt.setInt(18, usuario.getpCadContasBancos());
										stmt.setInt(19, usuario.getpCadDespesas());
										stmt.setInt(20, usuario.getpAcessFolha());
										stmt.setInt(21,usuario.getpCadFornecedor());
										stmt.setInt(22, usuario.getpAcessRelatorios());
										stmt.setInt(23, usuario.getpCadFuncionarios());
										stmt.execute();
									} catch (SQLException e3) {
										// TODO Auto-generated catch block
										e3.printStackTrace();
									}
									aviso.texto.setText("CADASTRO REALIZADO COM SUCESSO.");
									aviso.setLocationRelativeTo(null);
									aviso.show();
				}else {
					aviso.texto.setText("NÃO FOI POSSIVEL CONCLUIR O CADASTRO TENTE NOVAMENTE.");
					aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/fechar.png")));
					aviso.setLocationRelativeTo(null);
					aviso.show();
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
