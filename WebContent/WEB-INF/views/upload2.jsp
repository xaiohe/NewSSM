<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form action="${pageContext.request.contextPath}/upload" method="'post" enctype="multipart/form-data">
     	<input type="button" name="button" value="添加附件" onclick="addInput()">
     	<input type="button" name="button" value="删除附件" onclick="deleteInput()">
     	<input type="submit" value="提交">
     	<sapn id="upload" ></sapn>js
		<script type="text/javascript">
     	var attachname="attach";
     	var i=1;
     	function addInput(){
     		if(i>0){
     			var attach=attachname+i;
     			if(createInput(attache)){
     				i=i+1;
     			}
     		}
     	}
     	function deleteInput(){
     		if(i>1){
     			i=i-1;
     			if(!removeInput()){
     				i=i+1;
     			}
     		}
     	}
     	function createInput(nm){
     		var aElement=document.createElement("input");
     		aElement.name=nm;
     		aElement.id=nm;
     		aElement.type="file";
     		aElement.size="50";
     		//aElement.value="thanks";
     		//aElement.onclick=Function("asdf()");
     		if(document.getElementById("upload").appendChild(aElement) == null)
     		return false;
     		return true;
     		}
     		function removeInput(nm){
     		var aElement = document.getElementById("upload");
     		if(aElement.removeChild(aElement.lastChild) == null)
     		return false;
     		return true;
     	}
     	</script>
     </form>
</body>
</html>