<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <!-- Head -->
        <%@include file="include/head.jspf"  %>
    </head>
    <body style="padding: 10px">

        <div id="layout">
            <!-- Toggle -->
            <%@include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>顧客資料</h1>
                    <h2></h2>
                </div>
                <table class="pure-table" style="border: none;">
                    <td valign="top">
                        <!-- 表單 -->
                        <form:form class="pure-form"  
                                   modelAttribute="customer" 
                                   method="post" 
                                   action="${pageContext.request.contextPath}/mvc/customer/" >
                            <fieldset>
                                <legend>Customer Form</legend>
                                <form:input path="id" readonly="true" /><p />
                                <form:input path="name" placeholder="請輸入顧客名稱" /><p />
                                <form:input path="email" placeholder="請輸入顧客信箱" /><p />
                                <input type="text" id="_method" name="_method" readonly="true" value="${_method}" /><p />
                                <form:errors path="*" style="color:red" /><p />
                                <button type="sumbit" class="pure-button pure-button-primary">Submit</button>
                            </fieldset>
                        </form:form>
                    </td>
                    <td valign="top">
                        <!-- 列表 -->
                        <form class="pure-form">
                            <fieldset>
                                <legend>Club list</legend>
                                <table class="pure-table pure-table-bordered" width="100%">
                                    <thead>
                                        <tr>
                                            <th>序號</th>
                                            <th>名稱</th>
                                            <th>信箱</th>
                                            <th>建立時間</th>
                                            <th>修改</th>
                                            <th>刪除</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="customer" items="${customer_list}">                                    
                                            <tr>
                                                <td>${customer.id}</td>
                                                <td>${customer.name}</td>
                                                <td>${customer.email}</td>
                                                <td>${customer.createDate}</td>
                                                <td><a href="${pageContext.request.contextPath}/mvc/customer/${ customer.id }">修改</a></td>
                                                <td><a href="${pageContext.request.contextPath}/mvc/customer/delete/${customer.id}">刪除</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 
                            </fieldset>
                        </form>
                    </td>
                    <td valign="top">
                        <!-- 圖表 -->
                        <form class="pure-form">
                            <fieldset>
                                <legend>顧客人數長條圖</legend>

                            </fieldset>
                        </form>
                    </td>
                </table>   


            </div>
        </div>

        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>

        <script src="${pageContext.servletContext.contextPath}/js/ui.js"></script>
    </body>
</html>