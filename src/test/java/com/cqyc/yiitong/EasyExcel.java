package com.cqyc.yiitong;

import com.alibaba.excel.metadata.Sheet;
import com.cqyc.yiitong.domain.TableHeaderExcelProperty;
import com.cqyc.yiitong.util.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author:
 * @Date:
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class EasyExcel {
    private static final String filePath="C:\\Users\\dell\\Desktop\\嘿嘿嘿\\shiroProject\\学生表.xlsx";

    @Test
    public void readLessThan1000Row(){
        //读取excel的内容
        List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
        objects.forEach(o -> System.out.println(o));
    }

    /**
     * 读取少于1000行的excle，可以指定sheet和从几行读起
     * sheetNo: sheet页码，默认为1
     * headLineMun: 从第几行开始读取数据，默认为0, 表示从第一行开始读取
     */
    @Test
    public void readLessThan1000RowBySheet(){
        String filePath = "C:\\Users\\dell\\Desktop\\嘿嘿嘿\\shiroProject\\测试.xls";
        Sheet sheet = new Sheet(2, 1);
        List<Object> objects = ExcelUtil.readLessThan1000RowBySheet(filePath, sheet);
        objects.forEach(o -> System.out.println("o = " + o));
    }

    /**
     * 读取大于1000行的excle
     * 带sheet参数的方法可参照测试方法readLessThan1000RowBySheet()
     */
    @Test
    public void readMoreThan1000Row(){
        String filePath="C:\\Users\\dell\\Desktop\\嘿嘿嘿\\shiroProject\\生成模板表.xlsx";
        List<Object> objects = ExcelUtil.readMoreThan1000Row(filePath);
        objects.forEach(System.out::println);
    }

    /**
     * 生成excle
     * 带sheet参数的方法可参照测试方法readLessThan1000RowBySheet()
     */
    @Test
    public void writeBySimple(){
        String filePath="C:\\Users\\dell\\Desktop\\嘿嘿嘿\\shiroProject\\生成学生表.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("yc","11","22"));
        data.add(Arrays.asList("yc","11","22"));
        data.add(Arrays.asList("yc","11","22"));
        data.add(Arrays.asList("yc","11","22"));
        List<String> head = Arrays.asList("姓名","随便1","随便2");
        ExcelUtil.writeBySimple(filePath,data,head);
    }

    /**
     * 生成excle
     * 带sheet参数
     */
    @Test
    public void writeBySheetSimple(){
        String filePath="C:\\Users\\dell\\Desktop\\嘿嘿嘿\\shiroProject\\生成学生表2.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("yc","11","22"));
        data.add(Arrays.asList("yc","11","22"));
        data.add(Arrays.asList("yc","11","22S"));
        data.add(Arrays.asList("yc","11","22"));
        Sheet sheet = new Sheet(2, 1);
        List<String> head = Arrays.asList("姓名","随便1","随便2");
        ExcelUtil.writeSimpleBySheet(filePath,data,head,sheet);
    }

    /**
     * 生成excle, 带用模型
     * 带sheet参数的方法可参照测试方法readLessThan1000RowBySheet()
     */
    @Test
    public void writeWithTemplate(){
        String filePath="C:\\Users\\dell\\Desktop\\嘿嘿嘿\\shiroProject\\生成模板表.xlsx";
        List<TableHeaderExcelProperty> data = new ArrayList<>();
        for (int i = 0; i < 1100; i++) {
            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
            tableHeaderExcelProperty.setName("cqyc"+i);
            tableHeaderExcelProperty.setAge(0+i);
            tableHeaderExcelProperty.setSchool("重庆灰尘学院"+i);
            data.add(tableHeaderExcelProperty);
        }
        ExcelUtil.writeWithTemplate(filePath,data);
    }

    /**
     * 生成excle, 带用模型,带多个sheet
     */
    @Test
    public void writeWithMultipleSheel(){
        String filePath="C:\\Users\\dell\\Desktop\\嘿嘿嘿\\shiroProject\\生成模板多表2.xlsx";
        List<ExcelUtil.MultipleSheelPropety> list1 = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            List<TableHeaderExcelProperty> list = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
                tableHeaderExcelProperty.setName("cqyc" + j);
                tableHeaderExcelProperty.setAge(1 + j);
                tableHeaderExcelProperty.setSchool("清华大学" + j);
                list.add(tableHeaderExcelProperty);
            }

            //这里i不能为0，如果为0的话，只有两张表
            Sheet sheet = new Sheet(i, 0);
            //设置excel表名
            sheet.setSheetName("学生表" + i);

            ExcelUtil.MultipleSheelPropety multipleSheelPropety = new ExcelUtil.MultipleSheelPropety();
            multipleSheelPropety.setData(list);
            multipleSheelPropety.setSheet(sheet);

            list1.add(multipleSheelPropety);
        }
        ExcelUtil.writeWithMultipleSheel(filePath,list1);

    }

    @Test
    public void fileNamtHouZhui(){
//        String fileName = "hell";
//        String s = StringUtils.substringAfterLast(fileName, ".");
//        System.out.println(s);
        String filePath="group1/M00/00/00/wKgrDV2b7liAdNk2AA6-Ihmij-I692.gush.tar.gz";
        String s1 = StringUtils.substringAfterLast(filePath, ".");
        System.out.println(s1);
    }


}
