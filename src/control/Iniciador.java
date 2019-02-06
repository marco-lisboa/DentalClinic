package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class Iniciador extends Usuario {
String ip_server;

public String getIp_server() {
	return ip_server;
}

public void setIp_server(String ip_server) {
	this.ip_server = ip_server;
}

public static Properties getProp() throws IOException {
	Properties props = new Properties();
	FileInputStream file = new FileInputStream(
			"./properties/dentalclinic.properties");
	props.load(file);
	return props;

}

public void LeituraIp() throws IOException{
	String host;
	String ip;
	Properties prop = getProp();
	host = prop.getProperty("prop.server.host");
	ip= host;
	setIp_server(ip);
}

public void leituraUsuarioLogado() throws IOException{
	String id;
	Properties prop = getProp();
	id = prop.getProperty("prop.iduser.login");
	setUsuarioLogado(Integer.parseInt(id));
}

public void EscritaIp(String ip) throws IOException{
	Properties prop = getProp();
	prop.setProperty("prop.server.host", ip); 
	prop.store(new FileOutputStream("./properties/dentalclinic.properties"), null);
	
}
	
public void EscritaUsuarioLogado(String usuario)throws IOException{
	Properties prop = getProp();
	prop.setProperty("prop.iduser.login", usuario); 
	prop.store(new FileOutputStream("./properties/dentalclinic.properties"), null);
	
}


}
