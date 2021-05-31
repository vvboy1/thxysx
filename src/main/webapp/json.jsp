<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
        <meta charset="UTF-8">
        <base href="<%=basePath%>">
        <script src="js/jquery-2.1.0.js"></script>
    </head>
<body>
    <h2>首页</h2>

    <a href="test1">点击</a><br/>

    <a href="test2?name=张三&age=18">传参数</a><br/>

    <a href="test3?name=李四&age=81">自动类型匹配pojo</a><br/>
    <a href="test4?date=2020/8/31">日期类型匹配</a><br/>
    <center>
        <form action="test4" method="get">
            <input name="name" placeholder="名字"/><br/>
            <input name="age" type="number" placeholder="年龄"/><br/>
            <input name="date" type="date" placeholder="日期"/><br/>
            <input type="submit"/>
        <form/>
    </center>
    <a href="test5?name=张三&age=18">返回json</a><br/>

     <a href="javascript:void(0)" id="bt">传递Json</a><br/>
     <a href="javascript:void(0)" id="bt2">Post传递Json</a><br/>
     <script>
     //javascript对象
       var user={"name":"朱八","age":"40"};
          $(function(){
             $("#bt").click(function(){
               $.ajax({
                 //编写json 设置属性 值
                 //请求路径
                 url:"test6",
                 //编码类型  默认	x-www-form-urlencoded
                 contentType:'application/json;charset=UTF-8',
                 //数据
                 //data:'{"name":"王五","age":"30"}',
                 //对象需要 转化json
                 data:JSON.stringify(user),
                 //返回数据类型
                 dataType:"json",
                 //请求类型
                 type:"POST",
                 //处理函数
                 success:function(data){
                 //date服务器的json数据
                 alert(data.name);
               }
             })
          })
        });

            //只能发送 x-www-form-urlencoded
            var url="test7";
                 $(function(){
                    $("#bt2").click(function(){
                      $.post(
                       url,
                       user,
                       function(data){
                          alert(data.success+data.message);
                       },
                       "json"
                      );
                 })
               });
     </script>
</body>
</html>
