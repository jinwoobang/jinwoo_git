<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/web/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("input[name='bt']").click(function(){
		//var a=$("input[name='name']").val();
		$("form[name='frm']").submit();
		//alert(a);
	});
});
</script>
</head>
<body>
<form action="/web/Example.do" method="post" name="frm">
<input type="text" name="sb" placeholder="이름">
<input type="button" name="bt" value="버튼">
</form>
</body>
</html>