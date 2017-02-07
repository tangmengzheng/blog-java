<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%! String title = "登录"; %>
<%@include file="header.jsp"%>
<script type = "text/javascript">
    $(document).ready(function () {
       // captcha();
        $("#login").validate({
            rules: {
                name: {
                    required: true
                },
                password: {
                    required: true
                },
                captcha: {
                    required: true
                }
            },
            messages: {
                name: {
                    required:"请输入用户名"
                    },
                password: {
                        required: "请输入密码"
                },
                captcha: {
                    required: "请输入验证码"
                }
            }
         });

     });

</script>
    <div class="row" style="margin-top:1cm">
        <div class="col-sm-3"></div>
        <form  id = "login" class="form-horizontal form-validation col-sm-6" method = "POST" action="/login">
            <div class = "form-group" >
                <div class = "col-sm-3"></div>
                <h1 class = "col-sm-6" align = "center">登&nbsp&nbsp&nbsp&nbsp录</h1>
                <div class = "col-sm-3"></div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label"> 用户名:</label>
                <div class="col-sm-6">
                    <input 
                        id = "name"
                        class = "form-control" 
                        type = "text" 
                        name = "name"  
                        maxlength = "50"
                        placeholder = "name">
                    </input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label"> 密&nbsp&nbsp&nbsp&nbsp码:</label>
                <div class="col-sm-6">
                    <input 
                        id = "password"
                        class = "form-control" 
                        type = "password" 
                        name ="password" 
                        maxlength = "50"
                        placeholder = "password">
                    </input>
                </div>
            </div>

            <!--
            <div class="form-group">
                <label class="col-sm-3 control-label">验证码:</label>
                <div class="col-sm-4">
                    <input 
                        id = "captcha"
                        class = "form-control" 
                        type = "text" 
                        name ="captcha" 
                        maxlength = "6"
                        placeholder = "六位数字">
                    </input>
                </div>
                <img id = "capImg" src = "#" style = "width:70px;height:40px"></img>
            </div>
            -->

            <div class = "form-group">
                <label class="col-sm-1"></label>
                <div class="col-sm-8">
                    <c:if test = "${errMsg != null}" >
                        <p style = "color:red">${errMsg}</p>
                    </c:if>
                </div>
            </div>

            <div class="form-group" style = "margin-top:1cm">
                <div class="col-sm-3 col-xs-1"></div>
                <a type = "button " class = "btn btn-info col-sm-2 col-xs-4" value=" 注册" href = "/register">注册</a>
                <div class = "col-sm-2 col-xs-2"></div>
                <button type="submit" class = "btn btn-success col-sm-2 col-xs-4" value=" 登录">登录</button>
                <div class="col-sm-3 col-xs-1"></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
