import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Jettyサーバー起動
 *
 */
public class SimpleWebStarter {

	/**
	 * 起動<br>
	 * <br>
	 * @param pArgs 起動引数
	 * @throws Exception 例外
	 */
    public static void main(final String[] pArgs) throws Exception {

    	//webContents
        final String webappDirLocation = "src/main/webapp/";
        //ポート
        final int port = 8080;
        //コンテキスト
        final String contextName = "project-support";

        final Server server = new Server(port);
        final WebAppContext context = new WebAppContext();
        context.setConfigurations(new Configuration[]{ //
                new AnnotationConfiguration() //
                , new WebXmlConfiguration() //
                , new WebInfConfiguration() //
                , new PlusConfiguration() //
                , new MetaInfConfiguration() //
                , new FragmentConfiguration() //
                , new EnvConfiguration() //
        });
        context.setContextPath("/" + contextName);
        context.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        context.setResourceBase(webappDirLocation);
        context.setParentLoaderPriority(true);
        server.setHandler(context);

        // ユーザ名はsa（System Administrator）
        //Class.forName("org.h2.Driver");
        //Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        //DriverManager.getConnection("jdbc:h2:mem:test");

        server.start();
        server.join();
    }

}