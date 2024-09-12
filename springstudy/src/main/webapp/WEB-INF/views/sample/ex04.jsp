<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var name = "${sampleDTO.name}";
	
	console.log("이름 " + name);
</script>
</head>
<body>
	<h2>SAMPLE DTO : ${sampleDTO.name} </h2>
	<h2> 나이 : ${sampleDTO.age} </h2>
	<h2>PAGE : ${page} </h2>
</body>
</html>