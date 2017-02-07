<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="header.jsp" %>
<%! String title =" Test"; %>
<div>
    <span style="float:right">
        <c:if test="${messages != null}">
            <span><a style="color: red;margin-right: 3px">消息<b>${fn:length(messages)}</b></a></span>
        </c:if>
        <span >欢迎<%= session.getAttribute("userName")%> ！</span>
    </span>
</div>
<div>
    <h2 align="center">Blogs</h2>
    <div style="margin-top:1cm">
		<table class = "table table-hover" style = "font-size:18px">
			<tbody>
                <c:forEach var="article" items="${articleList}">
                    <tr>
                        <td class = "col-sm-10"><a href="article/getArticle/${article.id}">${article.title}</a> </td>
                        <td align="right">${article.createTime}</td>
                    </tr>
                </c:forEach>

                <tr></tr>
			</tbody>
		</table>
    </div>
</div>
<%@include  file="footer.jsp" %>
