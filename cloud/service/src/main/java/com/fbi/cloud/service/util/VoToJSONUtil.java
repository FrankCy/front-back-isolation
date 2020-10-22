package com.fbi.cloud.service.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

/**
 * 将普通java类对象的成员和成员变量转换为JSON格式的数据
 * @author cy
 * @version VoToJSONUtil.java, v 0.1 2020年10月12日 17:24 cy Exp $
 */
public class VoToJSONUtil {

    /**
     * 将一个对象中的成员变量数据,自动拼接位为JSON格式数据,但只会读取第一层的数据<br/>
     * 如果该对象中还含有其他对象的引用,则不会继续读取<br/>
     *
     *      {"变量名称1":变量内容1,"变量名称2":变量内容2,...}   <br/>
     *
     * 该方法使用StringBuffer类完成拼接操作,<br>
     * 1.    先通过反射取出该对象的每一个成员<br/>
     * 2.    再调用本类中isBasicData()判断每一个成员变量是否为常用的数据类型<br/>
     * 3.    再使用本类中的handle()方法,将变量和变量内容转换为 "变量名称1":变量内容1 的格式
     * * @param obj
     * @return
     * @throws Exception
     */
    public static String createJSONdate(Object obj)throws Exception{
        //拼接vo类中的成员变量,和变量内容
        //JSON中每一组数据都是以"{"开始
        StringBuffer buf = new StringBuffer("{");
        //首先的到vo类中所有的成员
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int x = 0; x < fields.length; x++){
            //得到每一个成员变量的类型
            String fieldTypeName = fields[x].getType().getSimpleName();
            //判断如果该成员变量为基本数据类型,则进行拼接操作
            if(isBasicData(fieldTypeName) != -1){
                //如果是基本数据类型的话,那就将变量名和变量内容以"变量名:变量值"的格式返回
                String key_value = handle(obj,fields[x]);
                //拼接到buf字符串中
                buf.append(key_value).append(",");
            }
        }
        //去除掉最后一个","号,再最后添加上"}"号
        buf.delete(buf.length()-1,buf.length()).append("}");
        return buf.toString();
    }

    /**
     * 将指定对象中的成员变量以"变量名:变量内容"的格式返回
     * @param obj 要操作的对象
     * @param field 类中的一个成员
     * @return
     *          "变量名:变量内容",如果变量内容为字符串型或是日期类型则要使用双引号包裹字符串<br/>
     * 例如:<br/>
     *      "变量名:"变量内容""
     */
    private static String handle(Object obj,Field field) throws Exception {
        //保存变量类型名称
        String fieldTypeName = field.getType().getSimpleName();
        //得到变量名称
        String fieldName = field.getName();
        //得到成员变量的get()方法
        Method method = obj.getClass().getMethod("get"+StringUtil.initCap(fieldName));
        //保存方法执行的结果
        Object value = method.invoke(obj);

        //判断变量类型为那种数据类型,int返回1,double返回2,String返回4,Date返回8
        int typeNumber = isBasicData(fieldTypeName);
        //如果为int或者double类型,则变量内容不用添加双引号
        if(typeNumber == 1 | typeNumber == 2){
            return "\""+fieldName+"\""+":"+value;
        }else if (typeNumber == 4){
            return "\""+fieldName+"\""+":"+"\""+value+"\"";
        }else if (typeNumber == 8){
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sf.format(value);
            return "\""+fieldName+"\""+":"+"\""+date+"\"";
        }
        //如果是其他类型,则不进行处理
        return "";
    }

    /**
     * 判断为那种基本数据类型的方法,该方法有以下几种返回值<br/>
     * 如果是double类型返回 1 <br/>
     * 如果是int类型返回 2;<br/>
     * 如果是String类型返回 4<br/>
     * 如果是Date类型返回 8 <br/>
     * @param dataTypeName :
     *                     变量的类型简写名称
     * @return
     */
    private static Integer isBasicData(String dataTypeName){
        if(dataTypeName .equalsIgnoreCase("double")){
            return 1;
        }else if(dataTypeName.equals("int")||dataTypeName.equals("Integer")){
            return 2;
        }else if(dataTypeName.equals("String")){
            return 4;
        }else if(dataTypeName.equals("Date")){
            return 8;
        }
        return -1;
    }
}

