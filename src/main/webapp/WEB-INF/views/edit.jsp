<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="header.jsp"%>
<%!  String title = "编辑"; %>
<div  style="margin-top:1cm">
    <!-- kindeditor-->
    <script charset="utf-8" src="/public/kindeditor-4.1.10/kindeditor-min.js"></script>
    <script charset="utf-8" src="/public/kindeditor-4.1.10/lang/zh_CN.js"></script>

    <script>
         var editor;
         KindEditor.ready(function(K) {
         editor = K.create('textarea[name="content"]', {
         allowFileManager : true,
         uploadJson : '/uploadimg'
         });

         });
    </script>

    <script type = "text/javascript">
        $(document).ready(function () {
            $("#article").validate({
                rules: {
                    title: {
                        required: true
                    },
                    content: {
                        required: true
                    }
                },
                messages: {
                    title: {
                        required:"标题不能为空"
                    },
                    content: {
                        required: "内容不能为空"
                    }
                }
            });

        });
        function validata () {
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            if (!title || !title.length) {
                alert("title can't be null");
                return false;
            }else if ( !content || !content.length) {
                alert("content can't be null");
                return false;
            }
            return true;
        }
    </script>

    <form  id= "article" class="form-horizontal" method = "POST" action = "/article/postArticle" onsubmit ="return validata()">
        <div class="form-group">
            <label class="col-sm-1 label-control">标题:</label>
            <input id = "title" class="col-sm-10"   name = "title" type="text" value = ""/>
        </div>
        <div class="form-group">
            <label class="col-sm-1 label-control">正文:</label>
            <textarea  name = "content" id="content" type="text" class="col-sm-10 form-control" style="width:100%;height:600px;">  </textarea>
        </div>
        <div class="form-group" align = "center">
            <button type="submit" class="btn btn-success" align = "right" >提交</button>
        </div>
    </form>

</div>
<%@include file="footer.jsp"%>