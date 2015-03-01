/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdpuh.hbase.project;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import static org.apache.hadoop.hbase.util.Bytes.toBytes;

/**
 *
 * @author hdadmin
 */
public class AddUser {
     public static void main(String[] args) throws IOException {
    
        Configuration conf = HBaseConfiguration.create();
        HTable hTable = new HTable(conf, "User");
        
        String add = args[0];
        String rowid = args[1];     
        String email = args[2];
        String password = args[3];
        String status = args[4];
        String dob = args[5];
        String security_q = args[6];
        String security_ans = args[7];
        Put put1 = new Put(toBytes(rowid));
        put1.add(toBytes("Creds"), toBytes("email"), toBytes(email));
        put1.add(toBytes("Creds"), toBytes("password"), toBytes(password));
        put1.add(toBytes("Prefs"), toBytes("status"), toBytes(status));
        put1.add(toBytes("Prefs"), toBytes("date_of_birth"), toBytes(dob));
        put1.add(toBytes("Prefs"), toBytes("security_question"), toBytes(security_q));
        put1.add(toBytes("Prefs"), toBytes("security_answer"), toBytes(security_ans));
        
        hTable.put(put1);
        System.out.println("Record created successfully");
        hTable.close();
        
    }
}
