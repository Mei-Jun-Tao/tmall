package com.tmall.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisGenerator {

    public static void main(String[] args) throws Exception {

        String today = "2020-9-18";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(today);
        Date d = new Date();

        if(d.getTime() > now.getTime() + 1000*60*60*24){
            System.out.println("请把时间改成今天的，并且只能运行一次");
            return;
        }

        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        //获取配置文件的内容
        InputStream is = MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").openStream();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        System.out.println("生成代码成功！");
    }
}
