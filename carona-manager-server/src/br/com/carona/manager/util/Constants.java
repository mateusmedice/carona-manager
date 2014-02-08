package br.com.carona.manager.util;

public class Constants {

	/**
	 * Host do banco de dados MongoDB.
	 */
	public static final String MONGO_DB_HOST = "localhost";

	/**
	 * Porta do banco de dados MongoDB.
	 */
	public static final Integer MONGO_DB_PORT = 27017;

	/**
	 * Nome do banco de dados MongoDB.
	 */
	public static final String MONGO_DB_CARONA = "carona";

	/**
	 * Nome do usuario do banco de dados MongoDB.
	 */
	public static final String MONGO_DB_USER_NAME = "pws_us";

	/**
	 * Senha do usuario do banco de dados MongoDB.
	 */
	public static final String MONGO_DB_PASSWORD = "pws_pw";
	
	/**
	 * Regex para LIKE nas queries do MongoDB.
	 */
	public static final String REGEX_LIKE_QUERY_FORMAT = ".*((?i)%s).*";

	
	/**
	 * Regex para LIKE nas queries do MongoDB.
	 */
	public static final String REGEX_LIKE_LEFT_QUERY_FORMAT = ".*((?i)^%s).*";
	
	/**
	 * Mensagem para a falha na conxao com o Servidor.
	 */
	public static final String MENSAGEM_FALHA_CONEXAO_SERVER = "Sistema temporariamente indisponível.";

}
