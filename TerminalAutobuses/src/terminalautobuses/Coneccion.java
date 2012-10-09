/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package terminalautobuses;

/**
 *
 * @author Jorge
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class Coneccion 
{
    private String bd;
    private String url;
    private String driver;
    private Connection con=null;
    private String user;
    private String password;
    private Statement estancia;
    private PreparedStatement sta;
    private String tabla;
    private ResultSet rs;
    public Coneccion(String bd,String url,String driver,String user,String pass)
    {
        this.bd = bd;
        this.url = url;
        this.driver = driver;
        this.user = user;
        this.password = pass;
    }
    public Coneccion()
    {
        bd="terminal";
        url="jdbc:postgresql://localhost/"+bd;
        driver="org.postgresql.Driver";
        user = "postgres";
        password = "DARCNESS147369";
    }
    public String getBd()
    {
        return bd;
    }
    public String getUrl()
    {
        return url;
    }
    public String getDriver()
    {
        return driver;
    }
    public String getUser()
    {
        return user;
    }
    public String getPassword()
    {
        return password;
    }
    public String getTabla()
    {
        return this.tabla;
    }
    public void setBd(String bd)
    {
        
        this.bd = bd;
    }
    public void setUrl(String url)
    {
        
        this.url = url;
    }
    public void setDriver(String driver)
    {
        
        this.driver = driver;
    }
    public void setUser(String user)
    {
        
        this.user = user;
    }
    public void setPassword(String pass)
    {
        
        this.password = pass;
    }
    public void setTabla(String tabla)
    {
        this.tabla = tabla;
    }
    public boolean conecta() throws SQLException
    {
        boolean c;
        try
        {
            Class.forName(getDriver());
            con=DriverManager.getConnection(getUrl(),getUser(),getPassword());
            System.out.println("Conexion Exitosa!!!");
            c = true;
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error de Conexion!!!",JOptionPane.ERROR_MESSAGE);
            c = false;
        }
        return c;
    }
    public void desconecta() throws SQLException
    {
            try
            {
                this.con.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
    }
    public Connection getCon()
    {
        return con;
    }
    public void inserta(String numBus,int numAsientos, String clase, Date fechaAd,int cond) throws SQLException
    {
        sta = con.prepareStatement("insert into "+getTabla()+" values(?,?,?,?,?)");
        sta.clearParameters();
        sta.setString(1,numBus);
        sta.setInt(2,numAsientos);
        sta.setString(3,clase);
        sta.setDate(4,fechaAd);
        sta.setInt(5, cond);
        sta.execute();
        sta.close();
    }
    public ResultSet consulta()
    {
        try
        {
            sta.clearParameters();
            sta = con.prepareStatement("Select *from "+getTabla()+"");
            rs = sta.executeQuery();
            sta.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error en consulta",JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    public ResultSet consulta(Object columG,Object value)
    {
        try
        {
            sta.clearParameters();
            sta = con.prepareStatement("Select *from "+getTabla()+"where ?=?");
            sta.setObject(1, columG);
            sta.setObject(2, value);
            rs = sta.executeQuery();
            sta.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error en consulta",JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    public void actualiza(Object columnaG,Object idBus,Object columnaM,Object clase)
    {
        try
        {
            //sta.clearParameters();
            //sta = con.prepareStatement("Update "+getTabla()+"set ?=? where ?=?");
            
            sta.clearParameters();
            sta = con.prepareStatement("Update "+getTabla()+"set ? = ? "+"where ? = ?");
            sta.setObject(1, columnaG);
            sta.setObject(2,idBus);
            sta.setObject(3, columnaM);
            sta.setObject(4, clase);
            sta.executeUpdate();
            sta.close();
        }
        catch (SQLException e)
        {}
    }
    public void elimina()
    {
        
    }
}
