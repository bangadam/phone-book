package phonebook.application;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
//import com.jtattoo.plaf.mint.MintLookAndFeel;
/**
 *
 * @author bangadam
 */
public class App {
     private static DokterServices dokterService;
    
    public static DokterServices getDokterService(){
        return dokterService;
    }
    
    public static void main( String[] args ) throws SQLException{
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDatabaseName("contact_app");
        dataSource.setServerName("localhost");
        
        dokterService =new DokterServices();
        dokterService.setDataSource(dataSource);
        
        try{
            new MainForm().setVisible(true);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}