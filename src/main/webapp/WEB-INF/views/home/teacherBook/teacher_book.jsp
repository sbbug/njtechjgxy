<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目申报界面</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/bootstrap-datetimepicker.zh-CN.js"></script>
<style type="text/css">
    .main{
       text-align:center;
       border:10px;
       font-weight:bold;
       border:5px solid gray;
       margin-left:10%;
       margin-right:10%;
       margin-top:0%;
    }
</style>

</head>
<body>
   <div class="main">
       <h2>著作教材申报信息提交</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/tea_book/addBook" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">材料：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="book_status" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="book_status" value="0">无
								    </label>
								 </td>
								 <td></td>
								  <td></td>
							</tr>
							
							<tr class="active">
							      <td> <label class="radio">系别：     </label></td>
							       
							      
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_1" name="book_department" class="form-control">
				                         <c:forEach items = "${departs}" var = "depart">
                                                    <c:if test="${depart.depart_status != 0}">
                                                          <option value="${depart.depart_item}">${depart.depart_item}</option>
                                                    </c:if>
                                                    
                                         </c:forEach>
                                     </select>
							      </td>
							      <td></td>
							      <td></td>
							</tr>
							<tr class="active">
							   <td> <label class="radio">著作类别：     </label></td>
							       
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_2" name="book_category_class" class="form-control">
									    <option value="专著">专著</option>
									    <option value="教材">教材</option>									   														   
                                     </select>
							      </td>
							      <td>
							           <label for="exampleInputName2">版权类型</label>
							      </td>
							      <td>
							              <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_3" name="book_copyright_type" class="form-control">
									    <option value="独著">独著</option>
									    <option value="合编">合编</option>	
									    <option value="主编">主编</option>									   														   
                                     </select>
							      </td>
							</tr>
                            <tr class="active">
							      <td>
							           <label for="exampleInputName2">第一作者</label>
							      </td>
							      <td>
							           <input type="text" name = "book_first_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第二作者</label>
							      </td>
							      <td>
							           <input type="text" name="book_second_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							            
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第三作者</label>
							      </td>
							      <td>
							           <input type="text" value="第三作者" name="book_third_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							          
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">书籍名称</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="book_name" class="form-control"  placeholder="书籍名称">
							      </td>
							      <td>
							              <label for="exampleInputName2">出版社名称</label>  
							      </td>
							      <td>
							              <input type="text" name="book_press_name" class="form-control"  placeholder="出版社">
							      </td>
							</tr>
							
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">书籍类型</label>
							      </td>
							      <td>
							                 <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown_4" name="book_which" class="form-control">
									    <option value="著作">著作</option>
									    <option value="教材">教材</option>	
									   									   														   
                                     </select>
							      </td>
							      <td>
							           <label for="exampleInputName2">字数</label>
							      </td>
							      <td>      
							          <input type="text" name="book_words" class="form-control"  placeholder="字数">
							      </td>
							</tr>
							<tr class="active">
							      <td> 
							            <label for="exampleInputName2">出版时间</label>
							      </td>
							       
							      <td>
							           <input type="text" id="book_publish_date" name="book_publish_date" class="form-control"  placeholder="出版时间">
							      </td>
							      <td>
							           
							      </td>
							      <td>
							           
							      </td>
							</tr>
	
							<tr class="active">
							      <td> 
							         <label class="radio">项目备注</label>
							      </td>
							       
	                              <td>						     
							          <input type="text" name="book_remark" class="form-control"  placeholder="填写备注"> 
							      </td>
							      <td>
							           
							      </td>
							      <td>
							         
							      </td>
							</tr>
                            <tr class="active">
							      <td> 
							         <label class="radio">材料上传(请以.zip格式上传): </label>
							      </td>
							       
							      <td>  
				                     <input type="file" name="upfile">
							      </td>
							      <td></td>
							      <td></td>
							</tr> 
							     
					  </table>
					</div>
   
		          <p>
		          <button type="submit" class="btn btn-info" onClick="return confirm(this.form)">确认提交</button>
		   </form>
		   ${result}
		   <script>
		       function confirm(form){
		    	   //数据输入是否为空进行验证
		    	   
		    	   if(form.book_status.value==""){
		    		   alert("请勾选材料是否为空");
		    		   return false;   
		    	   }		    	  		    	 
		    	   if(form.book_department.value==""){
		    		   alert("请填写系别"); 
		    		   return false;
		    	   }
		    	  
		    	   if(form.book_first_author.value==""){
		    		   alert("第一主持人必填");
		    		   return false;
		    	   }
		    	  
		    	   if(form.book_name.value==""){
		    		   alert("请填写书籍名称"); 
		    		   return false;
		    	   }		    	 		    	  
		    	   if(form.book_press_name.value==""){
		    		   alert("请填写出版社名称");	    		  
		    		   return false;
		    	   }		    	  
		    	   if(form.book_words.value==""){
		    		   alert("请填写书籍字数");	    		  
		    		   return false;
		    	   }
		    	   if(form.book_publish_date.value==""){
		    		   alert("请填写出版时间");	    		  
		    		   return false;
		    	   }
		    	   if(form.upfile.value==""){
		    		   alert("请上传审核资料");    		  
		    		   return false;
		    	   }     	   
		    	   return true;
		       }
		   
		   </script>
		
		    <script type="text/javascript">  
		      $('#book_publish_date').datetimepicker({  
		        format: 'yyyy-mm-dd',//定义时间格式  
		        autoclose: true,//选择好自动关闭  
		        minView: 2,//只选择到小时  
		        language: 'zh-CN', //汉化   
		      });  
		     
		    </script>  
		  
        
   </div>
</body>
</html>