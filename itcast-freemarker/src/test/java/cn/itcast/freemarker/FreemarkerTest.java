package cn.itcast.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerTest {

    @Test
    public void test() throws Exception {

        //1、创建配置对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //1.1、设置模版路径
        configuration.setClassForTemplateLoading(FreemarkerTest.class, "/ftl");
        //1.2、文件编码
        configuration.setDefaultEncoding("utf-8");

        //2、获取模版
        Template template = configuration.getTemplate("test.ftl");

        //3、数据
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", "传智播客");
        dataModel.put("msg", "can we chat");

        //数据集合
        List<Map<String, Object>> goodsList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "橘子");
        map1.put("price", 3.0);
        goodsList.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "柚子");
        map2.put("price", 6);
        goodsList.add(map2);

        dataModel.put("goodsList", goodsList);

        //4、输出；参数1：在模版中使用到的数据map；参数2：输出的媒介
        FileWriter fileWriter = new FileWriter("D:\\itcast\\test\\test.html");
        template.process(dataModel, fileWriter);

        fileWriter.close();
    }
}
