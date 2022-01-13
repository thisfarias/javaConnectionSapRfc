import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;


public class connectSap{
    public static void main(String[] args) throws JCoException{
        
        JCoDestination destination = JCoDestinationManager.getDestination("ABAP_AS");
        JCoFunction function = destination.getRepository().getFunction("ZEVT_RFC_REMOTE_PLATE");
		
        function.getImportParameterList().setValue("PLATE", "HCE-3316");
        function.getImportParameterList().setValue("STATE", "Minas Gerais");
        function.getImportParameterList().setValue("UF", "MG");
        try {
            function.execute(destination);
            System.out.println(function.getExportParameterList().getString("STATUS"));
            System.out.println(function.getExportParameterList().getString("ID"));
            System.out.println(function.getExportParameterList().getString("RESPONSE"));
        }
        catch (JCoException ex) {
            System.out.println("Erro");
        }
        System.out.println();

    }
}