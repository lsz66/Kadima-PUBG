package com.kadima.pubg.sql;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class InitDatabase {
    public static void init(HttpServletRequest request) {
        try {
            String user = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(user);
            System.out.println(password);
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", user, password);
            ScriptRunner runner = new ScriptRunner(connection);
            String path = InitDatabase.class.getClassLoader().getResource("com/kadima/pubg/sql/kadima.sql").getPath();
            runner.runScript(new InputStreamReader(new FileInputStream(new File(path)), "UTF-8"));
            SAXReader reader = new SAXReader();
            path = InitDatabase.class.getClassLoader().getResource("c3p0-config.xml").getPath();
            Document document = reader.read(new File(path));
            Element root = document.getRootElement();
            Element element = root.elementIterator().next();
            element.content().get(5).setText(user);
            element.content().get(7).setText(password);
            FileWriter out = new FileWriter(path);
            document.write(out);
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
