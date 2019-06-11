private static int PORT = 8089;
public static void main(String[] args) {
		startJettyByHttps();
	}
public static void startJettyByHttps() {
		Server server = new Server();

		HttpConfiguration https_config = new HttpConfiguration();
		https_config.setSecureScheme("https");

		SslContextFactory sslContextFactory = new SslContextFactory();
		sslContextFactory.setKeyStorePath("./webapp/keystore");
		// 私钥
		sslContextFactory.setKeyStorePassword("password1");
		// 公钥
		sslContextFactory.setKeyManagerPassword("password2");

		ServerConnector httpsConnector = new ServerConnector(server,
		        new SslConnectionFactory(sslContextFactory,"http/1.1"),
		        new HttpConnectionFactory(https_config));
		        // 设置访问端口
		httpsConnector.setPort(PORT);
		httpsConnector.setIdleTimeout(IDLE_THREAD_NUM);
		server.addConnector(httpsConnector);

		WebAppContext webApp = new WebAppContext();
		webApp = new WebAppContext();
		webApp.setContextPath("/");
		webApp.setResourceBase("./webapp");
		server.setHandler(webApp);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			httpsConnector.close();
		}
}
