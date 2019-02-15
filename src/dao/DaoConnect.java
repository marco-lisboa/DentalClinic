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
	Paciente paciente = new Paciente();
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

		//---------------------------------------------------------------------
		//Checagem de id para vincular Privilegios a o Usuario
		//----------------------------------------------------------------------
		String sqlprive = "SELECT MAX(idlogin) FROM login";

		try {
			stmt =  con.prepareStatement(sqlprive);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				usuario.setUsuarioId(res.getInt("MAX(idlogin)"));
			}

		} catch (SQLException e2) {
			erro(e2.getMessage());
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
	 * Excluir de Usuarios - Comentario Maynore Soft
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
	 * 							Funções Paciente                               *
	 *                                                                         *
	 ***************************************************************************/
	/*--------------------------------------------------
	 * Inserir Paciente - Comentario Maynore Soft
	 * ------------------------------------------------ */
	//Inicio

	public void inserirPaciente(Paciente paciente) {
		String sql = "INSERT INTO paciente("
				+ "nome,"
				+ "cpf,"
				+ "datanascimento,"
				+ "nacionalidade,"
				+ "estado,"
				+ "cidade,"
				+ "provincia,"
				+ "contato1,"
				+ "contato2,"
				+ "op1,"
				+ "op2,"
				+ "whats1,"
				+ "whats2,"
				+ "email1,"
				+ "ameil2,"
				+ "convenioid,"
				+ "alergia,"
				+ "obsalegia"
				+ ")VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

		try {

			stmt =  con.prepareStatement(sql);
			stmt.setString(1, paciente.getNomepaciente());
			stmt.setString(2,paciente.getCpf());
			//stmt.setDate(3, paciente.getData());
			stmt.setString(4,paciente.getNascionalidade());
			stmt.setString(5,paciente.getEstado());
			stmt.setString(6, paciente.getCidade());
			stmt.setString(7, paciente.getProvicia());
			stmt.setString(8, paciente.getContato1());
			stmt.setString(9, paciente.getContato2());
			stmt.setString(10, paciente.getOp1());
			stmt.setString(11,paciente.getOp2());
			stmt.setInt(12,paciente.getWhats1());
			stmt.setInt(13, paciente.getWhats2());
			stmt.setString(14, paciente.getEmail1());
			stmt.setString(15, paciente.getEmail2());
			stmt.setInt(16, paciente.getConvenio());
			stmt.setInt(27,paciente.getAlegia());
			stmt.setString(28,paciente.getObsmedicamento());
			stmt.execute();
		} catch (SQLException e) {
			erro(e.getMessage());
		}

		String sqlprive = "SELECT MAX(idpacientes) FROM pacientes";

		try {
			stmt =  con.prepareStatement(sqlprive);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				usuario.setUsuarioId(res.getInt("MAX(idpacientes)"));
			}
		} catch (SQLException e2) {
			erro(e2.getMessage());
		}

		if(usuario.getUsuarioId()>0) {
			sqlprive = "INSERT INTO avaliacao("
					+ "idpaciente,"
					+ "dt11,"
					+ "avdt11,"
					+ "dt12,"
					+ "avdt12,"
					+ "dt13,"
					+ "avdt13,"
					+ "dt14,"
					+ "avdt14,"
					+ "dt15,"
					+ "avdt15,"
					+ "dt16,"
					+ "avdt16,"
					+ "dt17,"
					+ "avdt17,"
					+ "dt18,"
					+ "avdt18,"
					+ "dt21,"
					+ "avdt21,"
					+ "dt22,"
					+ "dt23,"
					+ "avdt23,"
					+ "dt24,"
					+ "avdt24,"
					+ "dt25,"
					+ "avdt25,"
					+ "dt26,"
					+ "avdt26,"
					+ "dt27,"
					+ "avdt27,"
					+ "dt28,"
					+ "avdt28,"
					+ "dt31,"
					+ "avdt31,"
					+ "dt32,"
					+ "avdt32,"
					+ "dt33,"
					+ "avdt33,"
					+ "dt34,"
					+ "avdt34,"
					+ "dt35,"
					+ "avdt35,"
					+ "dt36,"
					+ "avdt36,"
					+ "dt37,"
					+ "dt38,"
					+ "avdt38,"
					+ "dt41,"
					+ "avdt41,"
					+ "dt42,"
					+ "avdt42,"
					+ "dt43,"
					+ "avdt43,"
					+ "dt44,"
					+ "avdt44,"
					+ "dt45,"
					+ "avdt45,"
					+ "dt46,"
					+ "avdt46,"
					+ "dt47,"
					+ "avdt47,"
					+ "dt48,"
					+ "avdt48"
					+ ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


			try {
				stmt =  con.prepareStatement(sqlprive);
				stmt.setInt(1, paciente.getIdpaciente());
				stmt.setInt(2, paciente.getDt11());
				stmt.setString(3,paciente.getAv11());
				stmt.setInt(4,paciente.getDt12());
				stmt.setString(5, paciente.getAv12());
				stmt.setInt(6, paciente.getDt13());
				stmt.setString(7, paciente.getAv13());
				stmt.setInt(8, paciente.getDt14());
				stmt.setString(9, paciente.getAv14());
				stmt.setInt(10, paciente.getDt15());
				stmt.setString(11, paciente.getAv15());
				stmt.setInt(12, paciente.getDt16());
				stmt.setString(13, paciente.getAv16());
				stmt.setInt(14, paciente.getDt17());
				stmt.setString(15, paciente.getAv17());
				stmt.setInt(16, paciente.getDt18());
				stmt.setString(17, paciente.getAv18());
				stmt.setInt(18, paciente.getDt21());
				stmt.setString(19, paciente.getAv21());
				stmt.setInt(20, paciente.getDt22());
				stmt.setString(21, paciente.getAv22());
				stmt.setInt(22, paciente.getDt23());
				stmt.setString(23, paciente.getAv23());
				stmt.setInt(24, paciente.getDt24());
				stmt.setString(25, paciente.getAv24());
				stmt.setInt(26, paciente.getDt25());
				stmt.setString(27, paciente.getAv25());
				stmt.setInt(28, paciente.getDt26());
				stmt.setString(29, paciente.getAv26());
				stmt.setInt(30, paciente.getDt27());
				stmt.setString(31, paciente.getAv27());
				stmt.setInt(32, paciente.getDt28());
				stmt.setString(33, paciente.getAv28());
				stmt.setInt(34, paciente.getDt31());
				stmt.setString(35, paciente.getAv31());
				stmt.setInt(36, paciente.getDt32());
				stmt.setString(37, paciente.getAv32());
				stmt.setInt(38, paciente.getDt33());
				stmt.setString(39, paciente.getAv33());
				stmt.setInt(40, paciente.getDt34());
				stmt.setString(41, paciente.getAv34());
				stmt.setInt(42, paciente.getDt35());
				stmt.setString(43, paciente.getAv35());
				stmt.setInt(44, paciente.getDt36());
				stmt.setString(45, paciente.getAv36());
				stmt.setInt(46, paciente.getDt37());
				stmt.setString(47, paciente.getAv37());
				stmt.setInt(48, paciente.getDt38());
				stmt.setString(49, paciente.getAv38());
				stmt.setInt(50, paciente.getDt41());
				stmt.setString(51, paciente.getAv41());
				stmt.setInt(52, paciente.getDt42());
				stmt.setString(53, paciente.getAv42());
				stmt.setInt(54, paciente.getDt43());
				stmt.setString(55, paciente.getAv43());
				stmt.setInt(56, paciente.getDt44());
				stmt.setString(57, paciente.getAv44());
				stmt.setInt(58, paciente.getDt45());
				stmt.setString(59, paciente.getAv45());
				stmt.setInt(60, paciente.getDt46());
				stmt.setString(61, paciente.getAv46());
				stmt.setInt(62, paciente.getDt47());
				stmt.setString(63, paciente.getAv47());
				stmt.setInt(64, paciente.getDt48());
				stmt.setString(65, paciente.getAv48());
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
	public void listaPaciente(Paciente paciente) {}
	public void alteraPaciente(Paciente paciente) {
		String sql = "UPDATE paciente SET "
				+ "nome=?,"
				+ "cpf=?,"
				+ "datanascimento=?,"
				+ "nacionalidade=?,"
				+ "estado=?,"
				+ "cidade=?,"
				+ "provincia=?,"
				+ "contato1=?,"
				+ "contato2=?,"
				+ "op1=?,"
				+ "op2=?,"
				+ "whats1=?,"
				+ "whats2=?,"
				+ "email1=?,"
				+ "ameil2=?,"
				+ "convenioid=?,"
				+ "alergia=?,"
				+ "obsalegia=?"
				+ "WHERE idpaciente=?;";

		try {

			stmt =  con.prepareStatement(sql);
			stmt.setString(1, paciente.getNomepaciente());
			stmt.setString(2,paciente.getCpf());
			//stmt.setDate(3, paciente.getData());
			stmt.setString(4,paciente.getNascionalidade());
			stmt.setString(5,paciente.getEstado());
			stmt.setString(6, paciente.getCidade());
			stmt.setString(7, paciente.getProvicia());
			stmt.setString(8, paciente.getContato1());
			stmt.setString(9, paciente.getContato2());
			stmt.setString(10, paciente.getOp1());
			stmt.setString(11,paciente.getOp2());
			stmt.setInt(12,paciente.getWhats1());
			stmt.setInt(13, paciente.getWhats2());
			stmt.setString(14, paciente.getEmail1());
			stmt.setString(15, paciente.getEmail2());
			stmt.setInt(16, paciente.getConvenio());
			stmt.setInt(27,paciente.getAlegia());
			stmt.setString(28,paciente.getObsmedicamento());
			stmt.setInt(29, paciente.getIdpaciente());
			stmt.execute();
		} catch (SQLException e) {
			erro(e.getMessage());
		}


		String sqlprive = "UPDATE avaliacao SET"
				+ "dt11=?,"
				+ "avdt11=?,"
				+ "dt12=?,"
				+ "avdt12=?,"
				+ "dt13=?,"
				+ "avdt13=?,"
				+ "dt14=?,"
				+ "avdt14=?,"
				+ "dt15=?,"
				+ "avdt15=?,"
				+ "dt16=?,"
				+ "avdt16=?,"
				+ "dt17=?,"
				+ "avdt17=?,"
				+ "dt18=?,"
				+ "avdt18=?,"
				+ "dt21=?,"
				+ "avdt21=?,"
				+ "dt22=?,"
				+ "dt23=?,"
				+ "avdt23=?,"
				+ "dt24=?,"
				+ "avdt24=?,"
				+ "dt25=?,"
				+ "avdt25=?,"
				+ "dt26=?,"
				+ "avdt26=?,"
				+ "dt27=?,"
				+ "avdt27=?,"
				+ "dt28=?,"
				+ "avdt28=?,"
				+ "dt31=?,"
				+ "avdt31=?,"
				+ "dt32=?,"
				+ "avdt32=?,"
				+ "dt33=?,"
				+ "avdt33=?,"
				+ "dt34=?,"
				+ "avdt34=?,"
				+ "dt35=?,"
				+ "avdt35=?,"
				+ "dt36=?,"
				+ "avdt36=?,"
				+ "dt37=?,"
				+ "dt38=?,"
				+ "avdt38=?,"
				+ "dt41=?,"
				+ "avdt41=?,"
				+ "dt42=?,"
				+ "avdt42=?,"
				+ "dt43=?,"
				+ "avdt43=?,"
				+ "dt44=?,"
				+ "avdt44=?,"
				+ "dt45=?,"
				+ "avdt45=?,"
				+ "dt46=?,"
				+ "avdt46=?,"
				+ "dt47=?,"
				+ "avdt47=?,"
				+ "dt48=?,"
				+ "avdt48=?"
				+ "WHERE idpaciente=?;";


		try {
			stmt =  con.prepareStatement(sqlprive);
			stmt.setInt(1, paciente.getDt11());
			stmt.setString(2,paciente.getAv11());
			stmt.setInt(3,paciente.getDt12());
			stmt.setString(4, paciente.getAv12());
			stmt.setInt(5, paciente.getDt13());
			stmt.setString(6, paciente.getAv13());
			stmt.setInt(7, paciente.getDt14());
			stmt.setString(8, paciente.getAv14());
			stmt.setInt(9, paciente.getDt15());
			stmt.setString(10, paciente.getAv15());
			stmt.setInt(11, paciente.getDt16());
			stmt.setString(12, paciente.getAv16());
			stmt.setInt(13, paciente.getDt17());
			stmt.setString(14, paciente.getAv17());
			stmt.setInt(15, paciente.getDt18());
			stmt.setString(16, paciente.getAv18());
			stmt.setInt(17, paciente.getDt21());
			stmt.setString(18, paciente.getAv21());
			stmt.setInt(19, paciente.getDt22());
			stmt.setString(20, paciente.getAv22());
			stmt.setInt(21, paciente.getDt23());
			stmt.setString(22, paciente.getAv23());
			stmt.setInt(23, paciente.getDt24());
			stmt.setString(24, paciente.getAv24());
			stmt.setInt(25, paciente.getDt25());
			stmt.setString(26, paciente.getAv25());
			stmt.setInt(27, paciente.getDt26());
			stmt.setString(28, paciente.getAv26());
			stmt.setInt(29, paciente.getDt27());
			stmt.setString(30, paciente.getAv27());
			stmt.setInt(31, paciente.getDt28());
			stmt.setString(32, paciente.getAv28());
			stmt.setInt(33, paciente.getDt31());
			stmt.setString(34, paciente.getAv31());
			stmt.setInt(35, paciente.getDt32());
			stmt.setString(36, paciente.getAv32());
			stmt.setInt(37, paciente.getDt33());
			stmt.setString(38, paciente.getAv33());
			stmt.setInt(39, paciente.getDt34());
			stmt.setString(40, paciente.getAv34());
			stmt.setInt(41, paciente.getDt35());
			stmt.setString(42, paciente.getAv35());
			stmt.setInt(43, paciente.getDt36());
			stmt.setString(44, paciente.getAv36());
			stmt.setInt(45, paciente.getDt37());
			stmt.setString(46, paciente.getAv37());
			stmt.setInt(47, paciente.getDt38());
			stmt.setString(48, paciente.getAv38());
			stmt.setInt(49, paciente.getDt41());
			stmt.setString(50, paciente.getAv41());
			stmt.setInt(51, paciente.getDt42());
			stmt.setString(52, paciente.getAv42());
			stmt.setInt(53, paciente.getDt43());
			stmt.setString(54, paciente.getAv43());
			stmt.setInt(55, paciente.getDt44());
			stmt.setString(56, paciente.getAv44());
			stmt.setInt(57, paciente.getDt45());
			stmt.setString(58, paciente.getAv45());
			stmt.setInt(59, paciente.getDt46());
			stmt.setString(60, paciente.getAv46());
			stmt.setInt(61, paciente.getDt47());
			stmt.setString(62, paciente.getAv47());
			stmt.setInt(63, paciente.getDt48());
			stmt.setString(64, paciente.getAv48());
			stmt.setInt(65, paciente.getIdpaciente());
			stmt.execute();
		} catch (SQLException e3) {
			erro(e3.getMessage());
		}
	}
	public void excluiPaciente(Paciente paciente) {}
	public void dadosPaciente(Paciente paciente) {}


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
