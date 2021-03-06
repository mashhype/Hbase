/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdpuh.hbase.project;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import static org.apache.hadoop.hbase.util.Bytes.toBytes;

/**
 *
 * @author hdadmin
 */
public class ShowUser {
    public static void main(String[] args) throws IOException {
    
        Configuration conf = HBaseConfiguration.create();
        HTable hTable = new HTable(conf, "User");
        
        String show = args[0];
        String rowid = args[1]; 
        Get get1 = new Get(toBytes(rowid));
        Result result1 = hTable.get(get1);
        System.out.println("-------------------------------------");
        System.out.println("RowId: " + Bytes.toString(result1.getRow()));
        byte[] val1 = result1.getValue(toBytes("Creds"), toBytes("email"));
        System.out.println("Creds:email: " + Bytes.toString(val1));
        byte[] val2 = result1.getValue(toBytes("Creds"), toBytes("password"));
        System.out.println("Creds:password: " + Bytes.toString(val2));
        byte[] val3 = result1.getValue(toBytes("Prefs"), toBytes("status"));
        System.out.println("Prefs:status: " + Bytes.toString(val3));
        byte[] val4 = result1.getValue(toBytes("Prefs"), toBytes("date_of_birth"));
        System.out.println("Prefs:date_of_birth: " + Bytes.toString(val4));
        byte[] val5 = result1.getValue(toBytes("Prefs"), toBytes("security_question"));
        System.out.println("Prefs:security_question: " + Bytes.toString(val5));
        byte[] val6 = result1.getValue(toBytes("Prefs"), toBytes("security_answer"));
        System.out.println("Prefs:security_answer: " + Bytes.toString(val6));
        byte[] val7 = result1.getValue(toBytes("Lastlogin"), toBytes("ip"));
        System.out.println("Lastlogin:ip: " + Bytes.toString(val7));
        byte[] val8 = result1.getValue(toBytes("Lastlogin"), toBytes("date"));
        System.out.println("Lastlogin:date: " + Bytes.toString(val8));
        byte[] val9 = result1.getValue(toBytes("Lastlogin"), toBytes("time"));
        System.out.println("Lastlogin:time " + Bytes.toString(val9));
        byte[] val10 = result1.getValue(toBytes("Lastlogin"), toBytes("success"));
        System.out.println("Lastlogin:success " + Bytes.toString(val10));
        System.out.println("-------------------------------------");
        hTable.close();
    }
}
