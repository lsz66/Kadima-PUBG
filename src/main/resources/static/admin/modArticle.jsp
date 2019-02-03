<%@ page import="cn.lsznb.kadima.entity.Article" %>
<%--
  Created by IntelliJ IDEA.
  User: lsz09
  Date: 2018/6/10
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%
    Article article = (Article) request.getSession().getAttribute("article");
    request.setAttribute("article", article);
    String str, radio;
    if (article.getCategory() <= 3) {
        radio = "<div class=\"radio\">\n" +
                "                    <label>\n" +
                "                        <input type=\"radio\" name=\"type\" value=\"1\"/>\n" +
                "                        开发者更新日记\n" +
                "                    </label>\n" +
                "                </div>\n" +
                "                <div class=\"radio\">\n" +
                "                    <label>\n" +
                "                        <input type=\"radio\" name=\"type\" value=\"2\"/>\n" +
                "                        活动公告\n" +
                "                    </label>\n" +
                "                </div>\n" +
                "                <div class=\"radio\">\n" +
                "                    <label>\n" +
                "                        <input type=\"radio\" name=\"type\" value=\"3\"/>\n" +
                "                        更新分析\n" +
                "                    </label>\n" +
                "                </div>";
        str = "新闻";
    } else {
        radio = "<div class=\"radio\">\n" +
                "                    <label>\n" +
                "                        <input type=\"radio\" name=\"type\" value=\"4\"/>\n" +
                "                        新手须知\n" +
                "                    </label>\n" +
                "                </div>\n" +
                "                <div class=\"radio\">\n" +
                "                    <label>\n" +
                "                        <input type=\"radio\" name=\"type\" value=\"5\"/>\n" +
                "                        进阶教学\n" +
                "                    </label>\n" +
                "                </div>\n" +
                "                <div class=\"radio\">\n" +
                "                    <label>\n" +
                "                        <input type=\"radio\" name=\"type\" value=\"6\"/>\n" +
                "                        战术策略\n" +
                "                    </label>\n" +
                "                </div>";
        str = "攻略";
    }
    request.setAttribute("str", str);
    request.setAttribute("radio", radio);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>更新${str}</title>
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
    <script src="../assets/js/wangEditor.min.js"></script>
</head>
<body>
<div class="container">
    <h3 class="text-center">更新${str}</h3><br/>
    <form action="${pageContext.request.contextPath}/article" method="post" id="newsForm">
        <input hidden name="action" value="update"/>
        <input hidden name="id" value="${article.id}"/>
        <div class="input-group input-group-md">
            <span class="input-group-addon">标题</span>
            <input type="text" class="form-control" name="title" value="${article.title}" required/>
        </div>
        <br/>
        <div class="panel panel-default">
            <div class="panel-heading">${str}类别</div>
            <div class="panel-body">
                ${radio}
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">正文</div>
            <div class="panel-body">
                <div id="editor"><p>${article.content}</p></div>
                <input hidden id="content" name="content" value=""/>
            </div>
        </div>
        <button type="submit" class="btn btn-success">提交</button>
    </form>
</div>
<script>
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();

    $("#newsForm").submit(function () {
        $("#content").val(editor.txt.html());
    });

    $(function () {
        $("input[value=${article.category}]").attr("checked", "checked");
    })
</script>
</body>
</html>