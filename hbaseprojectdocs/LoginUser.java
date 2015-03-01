/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdpuh.hbase.project;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import static org.apache.hadoop.hbase.util.Bytes.toBytes;

/**
 *
 * @author hdadmin
 */
public class LoginUser {
    public static void main(String[] args) throws IOException {
        
        Configuration conf = HBaseConfiguration.create();
        HTable hTable = new HTable(conf, "User");
        
        String rowid = args[1];
        String password = args[2];
        String ip = args[3];
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        long time = now.getTime();

        Put put1 = new Put(toBytes(rowid));

        if (password.equals("mypasswd")) {

            put1.add(toBytes("Lastlogin"), toBytes("ip"), toBytes(ip));
            put1.add(toBytes("Lastlogin"), toBytes("date"), toBytes(dateFormat.format(now)));
            put1.add(toBytes("Lastlogin"), toBytes("time"), toBytes(time));
            put1.add(toBytes("Lastlogin"), toBytes("success"), toBytes("success"));
            hTable.put(put1);
            hTable.close();

        } else {

            System.out.println("Incorrect password. The record was not updated.");
            System.exit(0);
        }
    }
}
