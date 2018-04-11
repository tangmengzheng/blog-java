﻿<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%! String title = "注册"; %>
<%@include file="header.jsp"%>
<script type = "text/javascript">
    $(function () {
        $("#sign").validate({
            rules: {
                name: {
                    required: true
                },
                password: {
                    required: true
                },
                repass: {
                    required: true,
                    equalTo: "#password"
                },
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
                name: {
                    required:"请输入用户名"
                    },
                password: {
                    required: "请输入密码"
                },
                repass: {
                    required: "请重复密码",
                    equalTo: "两次输入不一致"
                },
                email: {
                    required: "请输入email",
                    email: "邮箱格式有误"
                }
            }
         });

     });
</script>
<div class="row" style="margin-top:1cm">
    <div class = "col-sm-3"></div>

    <form id = "sign" class ="form-horizontal col-sm-6" method="post" action="/register">
        <div class = "form-group">
            <div class = "col-sm-3"></div>
            <h2 class = "col-sm-6" align = "center">注&nbsp&nbsp&nbsp&nbsp册</h2>
            <div clas = "col-sm-3"></div>
        </div>

        <div class = "form-group">
            <label class = "col-sm-3 control-label"> 用&nbsp&nbsp&nbsp户&nbsp&nbsp&nbsp名:</label>
            <div class= "col-sm-6">
                <input type="text" name="name" maxlength = "50" id="name" class="form-control"/>
            </div>
        </div>


        <div class = "form-group">
            <label class = "col-sm-3 control-label">密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码:</label>
            <div class = "col-sm-6">
                <input type="password" id = "password" maxlength = "50" name = "password"  class="form-control"/>
            </div>
        </div>

        <div class = "form-group">
            <label class = "col-sm-3 control-label">密&nbsp码&nbsp确&nbsp认:</label>
            <div class = "col-sm-6">
                <input type="password" id = "repass" name = "repass" maxlength = "50" class="form-control"/>
            </div>
        </div>

        <div class = "form-group">
            <label class = "col-sm-3 control-label">邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱:</label>
            <div class="col-sm-6">
                <input type="text" id = "email" name= "email" maxlength = "50" class = "form-control"/>
            </div>
        </div>

        <div class = "form-group">
            <label class="col-sm-1"></label>
            <div class="col-sm-8">
                <c:if test = "errMsg != null">
                    <p style = "color:red">${errMsg}</p>
                </c:if>
            </div>
        </div>

        <div class = "form-group" style = "margin-top:1cm">
            <div class = "col-sm-3 col-xs-1"></div>
            <a type = "button" class = "btn btn-info col-sm-2 col-xs-4" value = "登录"  href = "/login" />登&nbsp&nbsp录</a>
            <div class = "col-sm-2 col-xs-2"></div>
            <button type = "submit" class = "btn btn-success col-sm-2 col-xs-4" value = "注册"/>注&nbsp&nbsp册</button>
            <div class = "col-sm-3 col-xs-1"></div>
        </div>
    </form>
</div>

</div>
</body>
</html>
