<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%! String title = "Hello"; %>
<div>

    <div>
        <h3 align="center" style = "margin-top:1cm">${parent.title}</h3>
    </div>
    <div style="margin-top:1cm" class = "">
        <article class = "">
            ${parent.content}
        </article>
    </div>

    <div align = "right" style = "height:50px;margin-top:30px">
        <span> 阅读（</span>${parent.readCount}<span>）</span>
        <a id= "favour" href = "">赞</a>（ <span id ="favour_amount">${parent.favourCount}</span> ）
    </div>

    <hr/>

    <div name = "comments" id="comments">
        <c:forEach var = "child" items="${children}">
            <div>
                <p class = "">
                    <a herf = "#"> </a>
                </p>
                <article class = "" style = "text-indent:2em">
                    <a class = "comments" href = "/comment/getComment/${child.id}">${child.content}
                    </a>
                </article>
            </div>
            <div align = "right"> <span>${child.createTime}</span> <span style = "margin-left:20px"><a>回复</a><a>删除</a></span></div>
            <hr/>
        </c:forEach>
    </div>

    <form class = "form" >
        <textarea id = "comment" name = "comment" rows = 6 style = "width:100%;" maxlength = "512" placeholder = "发表评论" oninput = ""></textarea>
        <button class = "btn" id = "post" type = "button" value = "提交" onclick="postComment(${parent.id})">提交 </button>
    </form>

    <hr/>

    <script type = "text/javascript">
        var url = "/article/favour";
        $(function () {
            $("#favour").click(function () {
                if (!checkUser()) {
                    return false;
                }
                $("#favour_amount").load(url);
                return false;
            });
        });

        function validate () {
            var comment = document.getElementById('comment').value;
            /*
            if (!checkUser()) {
                return false;
            }
            */
            if (!comment || !comment.length) {
                alert("coment cant be null");
                return false;
            }
            return true;
        }

        function postComment(pid) {

            var url = "/comment/makeComment";

            if(!validate()){
                return false;
            }

            $.post(url, {content:$("#comment").val(), pid: pid, userId: <%= session.getAttribute("userId")%>}, function (data) {
                console.log(data );
                if (!data.success) {
                    alert("comment faild");
                    return false;
                }else {
                    $("#comments").prepend('<div> <p class = ""><a herf = "#"> </a> </p> <article class = "" style = "text-indent:2em">'+ $("#comment").val() + '</article> </div> <div align = "right"> <span>刚刚</span> <span style = "margin-left:20px"><a>回复</a><a>删除</a></span></div><hr/>');
                    $("#comment").val("");
                    return true;
                }
            })
        }

    </script>

</div>
<%@include file="footer.jsp"%>
