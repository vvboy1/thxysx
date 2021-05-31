package com.huicai.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

//日期类型转化器
public class ToDate implements Converter<String, Date> {
    //两个日期 字符串 模板
    private String datePattern;
    private String datePattern2;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    public String getDatePattern2() {
        return datePattern2;
    }

    public void setDatePattern2(String datePattern2) {
        this.datePattern2 = datePattern2;
    }

    @Override
    public Date convert(String date) {
        try{
            //先尝试 按照 yyyy-MM 模板 进行转换
            SimpleDateFormat format = new SimpleDateFormat(this.datePattern);
            return format.parse(date);
        }catch (Exception e){
            try {
                //如果转换不成功 则 换成 yyyy/MM
                SimpleDateFormat format = new SimpleDateFormat(this.datePattern2);
                return format.parse(date);
            }catch (Exception e1){
                new RuntimeException("类型转换失败");
            }
        }
        return null;
    }
}
