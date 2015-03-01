/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdpuh.hbase.project;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import static org.apache.hadoop.hbase.util.Bytes.toBytes;

/**
 *
 * @author hdadmin
 */
public class DeleteUser {
     public static void main(String[] args) throws IOException {
         
        Configuration conf = HBaseConfiguration.create();
        HTable hTable = new HTable(conf, "User");

        String delete = args[0];
        String rowid = args[1];
        Delete delete1 = new Delete(toBytes(rowid));
        hTable.delete(delete1);
        System.out.println("Delete completed successfully");
        hTable.close();
     }
}
