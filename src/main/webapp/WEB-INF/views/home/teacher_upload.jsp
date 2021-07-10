<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
     <form action="<%=request.getContextPath() %>/common/doUpload" method="post"  enctype ="multipart/form-data" >
		 
		 
		  <div class="form-group">
		    <label for="exampleInputFile">File input</label>
		    <input type="file" name="upfile">
		    <p class="help-block">Example block-level help text here.</p>
		  </div>
		  
         <button type="submit" class="btn btn-default">Submit</button>
     </form>
</body>
</html>