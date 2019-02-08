package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.*;
import viewTavisos.*;

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
		TavisoErro erro = new TavisoErro();
		private List<Usuario>dados = new ArrayList<>();
		
		public void conectar(String ip){
			 URL = "jdbc:mysql://"+ip+":3306/dentalclinic";
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(URL,USER,PASS);
				
			} catch (ClassNotFoundException | SQLException e) {
				erro.textPaneErro.setText("FOI INDENTIFICADO QUE COM CONEX\u00C3O COM SERVIDOR N\u00C3O FOI COMPLETADA "
						+ "SIGA OS PASSO A SEGUIR:\r\n1- VERIFIQUE O NOME OU IP SERVIDOR BANCO DE DADOS\r\n2-CERTIFIQUESE QUE"
						+ " A PORTA 3366 DO SERVIDOR SE ENCONTRA LIBERADA NO SERVIDOR\r\n3- RELIZER UM TESTE DE CONEX\u00C3O COM "
						+ "SERVIDOR E VERIFIQUE SE ELE SE ENCONTRA EM REDE.\r\n\r\nCASO O PROBLEMA PERSISTA OU TENHA ALGUMA DUVIDA "
						+ "ENTRE EM CONTATO COM SUPORTE E INFORME O ERRO ABAIXO.\r\n---------------------------------------------------------------"
						+ "---------------------------------------\r\n"+e.getMessage());
				erro.setLocationRelativeTo(null);
				erro.show();
			}
		}
		/*---------------------------------------------------------------------*/
		//Execulção banco de dados - MAYNORECOMENTS

		//Validação login - MAYNORECOMENTS
		public boolean logado;

	
		public void Acesso(String log_usuario,String senha_usuario,String ip,Usuario usuario){

			Connection conectado = null;
			PreparedStatement consulta = null;
			ResultSet retorno= null;
			String url ;

			try{
				url = "jdbc:mysql://"+ip+":3306/dentalclinic";
				conectado = DriverManager.getConnection(url,"root","maynore");
				consulta =  conectado.prepareStatement("select idlogin,login, senha,nome,situacao from login where login='"+log_usuario+"'and senha='"+senha_usuario+"'");
				retorno =consulta.executeQuery();
				if(retorno.next()){
					
					usuario.setUsuarioLogado(retorno.getInt("idlogin"));
					usuario.setNomeUsuarioLogado((retorno.getString("nome")));
					usuario.setSituacao(retorno.getInt("situacao"));
					
					if(usuario.getSituacao()==1) {
						logado=true;
					}else {
						aviso.texto.setText("USUARIO NÃO ATIVO AO SISTEMA");
						aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/fechar.png")));
						aviso.setLocationRelativeTo(null);
						aviso.show();
						logado=false;
					}
					
				}else{
					aviso.texto.setText("USUARIO E SENHA INCORRETOS.");
					aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/fechar.png")));
					aviso.setLocationRelativeTo(null);
					aviso.show();
					logado=false;
				}	
			}catch (Exception e){
				erro.textPaneErro.setText("FOI INDENTIFICADO QUE COM CONEX\u00C3O COM SERVIDOR N\u00C3O FOI COMPLETADA "
						+ "SIGA OS PASSO A SEGUIR:\r\n1- VERIFIQUE O NOME OU IP SERVIDOR BANCO DE DADOS\r\n2-CERTIFIQUESE QUE"
						+ " A PORTA 3366 DO SERVIDOR SE ENCONTRA LIBERADA NO SERVIDOR\r\n3- RELIZER UM TESTE DE CONEX\u00C3O COM "
						+ "SERVIDOR E VERIFIQUE SE ELE SE ENCONTRA EM REDE.\r\n\r\nCASO O PROBLEMA PERSISTA OU TENHA ALGUMA DUVIDA "
						+ "ENTRE EM CONTATO COM SUPORTE E INFORME O ERRO ABAIXO.\r\n---------------------------------------------------------------"
						+ "---------------------------------------\r\n"+e.getMessage());
				erro.setLocationRelativeTo(null);
				erro.show();

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
			public void listUsuarios (JTable tabela, Usuario usuario) throws SQLException{
				try {
					String sql;
					if(usuario.getSituacao()<3) {
						sql = "SELECT * FROM login WHERE nome like'"+usuario.getNomeUsuario()+"%' AND situacao like '"+usuario.getSituacao()+"%' ORDER BY idlogin";
					}else {
						sql = "SELECT * FROM login WHERE nome like'"+usuario.getNomeUsuario()+"%' ORDER BY idlogin";
					}
					
					stmt = con.prepareStatement(sql);
					ResultSet res = stmt.executeQuery();
					DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
					modelo.setNumRows(0);
					while(res.next()) {
						modelo.addRow(new Object[]{
								res.getInt("idlogin"),
								res.getString("nome"),
								res.getString("funcao")
						});
						
					}
					
					
				}catch(Exception e){
					erro(e.getMessage());
				}
				//--------------------------------------------------------------------------------------------------------------------------------------------
				try {
				String sqlconta;
				if(usuario.getSituacao()<3) {
					sqlconta = "SELECT COUNT(idlogin) AS nresgistro FROM login WHERE nome like'"+usuario.getNomeUsuario()+"%' AND situacao like '"+usuario.getSituacao()+"%'";
				}else {
					sqlconta = "SELECT COUNT(idlogin) AS nresgistro FROM login WHERE nome like'"+usuario.getNomeUsuario()+"%'";
				}
				stmt = con.prepareStatement(sqlconta);
				ResultSet res = stmt.executeQuery();
				while (res.next()) {
					usuario.setNumeroRegistro(res.getInt("nresgistro"));
				}
				}catch(Exception e){
					erro(e.getMessage());
				}
				
				
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
					erro(e1.getMessage());
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
										erro(e3.getMessage());
									}
									aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/confimado.png")));
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
						+ "ativo_site =? "
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
					stmt.setInt(11,usuario.getUsuarioId());
					stmt.execute();
					
					
				} catch (SQLException e) {
					erro(e.getMessage());
				}
				
				String sqlprive="UPDATE privilegios SET "
						/*1*/					+ "cad_alt_clientes=? ,"
						/*2*/					+ "cad_alt_agenda=? ,"
						/*3*/					+ "acesso_recebe_pag=? ,"
						/*4*/					+ "realiza_simu_orcameto=? ,"
						/*5*/					+ "cad_alt_servico=? ,"
						/*6*/					+ "livro_caixa=? ,"
						/*7*/					+ "chamada=? ,"
						/*8*/					+ "sincroniza=? ,"
						/*9*/					+ "atualizar=? ,"
						/*10*/					+ "acesso_configuracao=? ,"
						/*11*/					+ "cad_alt_empresa=? ,"
						/*12*/					+ "realiza_recebimento=? ,"
						/*13*/					+ "realiza_recebimento_avul=? ,"
						/*14*/					+ "excluir_financeiro=? ,"
						/*15*/					+ "estornar=? ,"
						/*16*/					+ "acesso_geren_finac=? ,"
						/*17*/					+ "cad_alt_banco_conta=? ,"
						/*18*/					+ "cad_alt_despesas=? ,"
						/*19*/					+ "acesso_folha=? ,"
						/*20*/					+ "cad_alt_fornecedores=? ,"
						/*21*/					+ "acesso_relatorios=? ,"
						/*22*/					+ "cad_alt_funcionarios=? "
						/*23*/					+ "WHERE idusuario = ? ";
				
				try {
					stmt =  con.prepareStatement(sqlprive);
					stmt.setInt(1, usuario.getpCadCliente());
					stmt.setInt(2, usuario.getpCadAgenda());
					stmt.setInt(3, usuario.getpAcessReceber());
					stmt.setInt(4, usuario.getpRealizaOrcamento());
					stmt.setInt(5, usuario.getpCadServico());
					stmt.setInt(6, usuario.getpLivroCaixa());
					stmt.setInt(7, usuario.getpChamada());
					stmt.setInt(8, usuario.getpSincroniza());
					stmt.setInt(9, usuario.getpAtualizar());
					stmt.setInt(10, usuario.getpAcessConfig());
					stmt.setInt(11, usuario.getpCadEmpresas());
					stmt.setInt(12, usuario.getpRealizaRecebimento());
					stmt.setInt(13, usuario.getpRealizaRecebimentoAvulso());
					stmt.setInt(14, usuario.getpExcluirFinanceiro());
					stmt.setInt(15, usuario.getpEstorna());
					stmt.setInt(16, usuario.getpAcessGenFin());
					stmt.setInt(17, usuario.getpCadContasBancos());
					stmt.setInt(18, usuario.getpCadDespesas());
					stmt.setInt(19, usuario.getpAcessFolha());
					stmt.setInt(20,usuario.getpCadFornecedor());
					stmt.setInt(21, usuario.getpAcessRelatorios());
					stmt.setInt(22, usuario.getpCadFuncionarios());
					stmt.setInt(23,usuario.getUsuarioId());
					stmt.execute();
					aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/confimado.png")));
					aviso.texto.setText("ATUALIZAÇÃO REALIZADO COM SUCESSO.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
				} catch (SQLException e) {
					erro(e.getMessage());
				}
				
			}
			
			//Fim
			/*--------------------------------------------------
			 * Exclui de Usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			public void desativarUsuario(Usuario usuario) {
				String sql = "UPDATE login SET situacao = 0 WHERE idlogin = ?";
				
				try {
					stmt =  con.prepareStatement(sql);
					stmt.setInt(1,usuario.getUsuarioId());
					stmt.execute();
					aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/confimado.png")));
					aviso.texto.setText("USUARIO DESATIVADO COM SUCESSO.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
				} catch (SQLException e) {
					erro(e.getMessage());
				}
				
			}
			
			
			/*--------------------------------------------------
			 * Exclui de Usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			
			public void excluiUsuario(Usuario usuario) {
				String sql = "DELETE FROM login WHERE idlogin =?;";
				
				try {
					stmt =  con.prepareStatement(sql);
					stmt.setInt(1,usuario.getUsuarioId());
					stmt.execute();
				} catch (SQLException e) {
					erro(e.getMessage());
				}
				
				String sqlprive = "DELETE FROM privilegios WHERE idusuario=?";
				try {
					stmt =  con.prepareStatement(sqlprive);
					stmt.setInt(1,usuario.getUsuarioId());
					stmt.execute();
					aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/confimado.png")));
					aviso.texto.setText("CADASTRO DELETADO COM SUCESSO.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
				} catch (SQLException e) {
					erro(e.getMessage());
				}
			}
			//Fim
			
			/*--------------------------------------------------
			 * Dados  usuarios - Comentario Maynore Soft
			 * ------------------------------------------------ */
			//Inicio
			
			public void dadosUsuario(Usuario usuario) {
				
				try {
					String sql = "SELECT * FROM login l,privilegios p WHERE l.idlogin = "+usuario.getUsuarioId()+"  and l.idlogin= p.idusuario;";
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
						usuario.setAltera_privi(res.getInt("altera_privilegio"));
						usuario.setSituacao(res.getInt("situacao"));
						usuario.setAtivo_site(res.getInt("ativo_site"));
						//--------------------------------------------------
						usuario.setpCadCliente(res.getInt("cad_alt_clientes"));
						usuario.setpCadAgenda(res.getInt("cad_alt_agenda"));
						usuario.setpAcessReceber(res.getInt("acesso_recebe_pag"));
						usuario.setpRealizaOrcamento(res.getInt("realiza_simu_orcameto"));
						usuario.setpCadServico(res.getInt("cad_alt_servico"));
						usuario.setpLivroCaixa(res.getInt("livro_caixa"));
						usuario.setpChamada(res.getInt("chamada"));
						usuario.setpSincroniza(res.getInt("sincroniza"));
						usuario.setpAtualizar(res.getInt("atualizar"));
						usuario.setpAcessConfig(res.getInt("acesso_configuracao"));
						usuario.setpCadEmpresas(res.getInt("cad_alt_empresa"));
						usuario.setpRealizaRecebimento(res.getInt("realiza_recebimento"));
						usuario.setpRealizaRecebimentoAvulso(res.getInt("realiza_recebimento_avul"));
						usuario.setpExcluirFinanceiro(res.getInt("excluir_financeiro"));
						usuario.setpEstorna(res.getInt("estornar"));
						usuario.setpAcessGenFin(res.getInt("acesso_geren_finac"));
						usuario.setpCadContasBancos(res.getInt("cad_alt_banco_conta"));
						usuario.setpCadDespesas(res.getInt("cad_alt_despesas"));
						usuario.setpAcessFolha(res.getInt("acesso_folha"));
						usuario.setpCadFornecedor(res.getInt("cad_alt_fornecedores"));
						usuario.setpAcessRelatorios(res.getInt("acesso_relatorios"));
						usuario.setpCadFuncionarios(res.getInt("cad_alt_funcionarios"));
					}
					
				} catch (SQLException e) {
					erro(e.getMessage());
				}
			}
			//Fim

			public void privilegio(Usuario usuario) {
				String sql = "SELECT * FROM login l,privilegios p WHERE l.idlogin = "+usuario.getUsuarioLogado()+"  and l.idlogin= p.idusuario;";
				try {
					stmt =  con.prepareStatement(sql);
					ResultSet res = stmt.executeQuery();
					while(res.next()) {
						usuario.setCadastro(res.getInt("cadastro"));
						usuario.setAltera_privi(res.getInt("altera_privilegio"));
						usuario.setSituacao(res.getInt("situacao"));
						usuario.setAtivo_site(res.getInt("ativo_site"));
						//--------------------------------------------------
						usuario.setpCadCliente(res.getInt("cad_alt_clientes"));
						usuario.setpCadAgenda(res.getInt("cad_alt_agenda"));
						usuario.setpAcessReceber(res.getInt("acesso_recebe_pag"));
						usuario.setpRealizaOrcamento(res.getInt("realiza_simu_orcameto"));
						usuario.setpCadServico(res.getInt("cad_alt_servico"));
						usuario.setpLivroCaixa(res.getInt("livro_caixa"));
						usuario.setpChamada(res.getInt("chamada"));
						usuario.setpSincroniza(res.getInt("sincroniza"));
						usuario.setpAtualizar(res.getInt("atualizar"));
						usuario.setpAcessConfig(res.getInt("acesso_configuracao"));
						usuario.setpCadEmpresas(res.getInt("cad_alt_empresa"));
						usuario.setpRealizaRecebimento(res.getInt("realiza_recebimento"));
						usuario.setpRealizaRecebimentoAvulso(res.getInt("realiza_recebimento_avul"));
						usuario.setpExcluirFinanceiro(res.getInt("excluir_financeiro"));
						usuario.setpEstorna(res.getInt("estornar"));
						usuario.setpAcessGenFin(res.getInt("acesso_geren_finac"));
						usuario.setpCadContasBancos(res.getInt("cad_alt_banco_conta"));
						usuario.setpCadDespesas(res.getInt("cad_alt_despesas"));
						usuario.setpAcessFolha(res.getInt("acesso_folha"));
						usuario.setpCadFornecedor(res.getInt("cad_alt_fornecedores"));
						usuario.setpAcessRelatorios(res.getInt("acesso_relatorios"));
						usuario.setpCadFuncionarios(res.getInt("cad_alt_funcionarios"));
					};
				} catch (SQLException e) {
					erro(e.getMessage());
				}
				
			}
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
		
		public void erro(String erros) {
			erro.textPaneErro.setText("OCORREU ALGO INESPERADO, POR FAVOR INFORMAR OCORRIDO AO ADMINISTRADOR DO SISTEMA. \r\n---"
					+ "-------------------------------------------------------------------------------------------------"
					+ "------\r\n"+erros);
			erro.setLocationRelativeTo(null);
			erro.show();
		}
}
