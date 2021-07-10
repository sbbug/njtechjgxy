<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>科研论文提交界面</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
       <h2>科研论文信息提交</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/tea_paper/addPaper" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">材料：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="paper_status" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="paper_status" value="0">无
								    </label>
								 </td>
								 <td></td>
								  <td></td>
							</tr>
							<tr class="active">
							     <td><label class="radio">是否英文：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="paper_is_English" value="1">是
				                    </label>
								    <label class="radio">
								      <input type="radio" name="paper_is_English" value="0">否
								    </label>
								 </td>
								 <td></td>
								  <td></td>
							</tr>
							<tr class="active">
							      <td> <label class="radio">系别：     </label></td>
							       
							      
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="paper_department" class="form-control">
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
							      <td>
							           <label for="exampleInputName2">第一作者</label>
							      </td>
							      <td>
							           <input type="text" name = "paper_first_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第一作者单位</label>
							      </td>
							      <td>      
							            <input type="text" name="paper_first_author_unit" class="form-control"  placeholder="单位">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第二作者</label>
							      </td>
							      <td>
							           <input type="text" name="paper_second_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第二作者单位</label>
							      </td>
							      <td>      
							            <input type="text" name="paper_second_author_unit" class="form-control"  placeholder="单位">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第三作者</label>
							      </td>
							      <td>
							           <input type="text" value="第三作者" name="paper_third_author" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第三作者单位</label>
							      </td>
							      <td>      
							            <input type="text" value="第三作者单位" name="paper_third_author_unit" class="form-control"  placeholder="单位">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							          
							      </td>
							      <td>
							           
							      </td>
							      <td>
							            
							      </td>
							      <td>      
							            <label for="exampleInputName2">更多作者</label>
							      </td>
							</tr>
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">论文题目</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="paper_title" class="form-control"  placeholder="论文名称">
							      </td>
							      <td></td>
							      <td>
							      </td>
							</tr>
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">期刊名称</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="paper_period" class="form-control"  placeholder="期刊名称">
							      </td>
							      <td></td>
							      <td>
							      </td>
							</tr>
							<tr class="active">
							     <td>
							           <label for="exampleInputName2">期刊卷号</label>
							      </td>
							      <td>
							           <input type="text" name="paper_period_roll" class="form-control"  placeholder="期刊卷号">
							      </td>
							      <td>
							            <label for="exampleInputName2">期刊页号</label>
							      </td>
							      <td>      
							            <input type="text" name="paper_period_page" class="form-control"  placeholder="期刊页号">
							      </td>
							</tr>
							<tr class="active">
							   <td> <label class="radio">学校计点类别：     </label></td>
							       
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="paper_department_count" class="form-control">
									    <option value="1">院期刊库</option>
									    <option value="2">北大核心期刊库</option>
									    <option value="3">SCD库</option>
									    <option value="4">CSSCI库</option>
									    <option value="5">SCI库</option>
									    <option value="6">SSCI库</option>
									    
						   
                                     </select>
							      </td>
							      <td></td>
							      <td></td>
							</tr>
							<tr class="active">
							   <td> <label class="radio">学院期刊类别: </label></td>
							       
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="paper_department_kind" class="form-control">
									    <option value="A+">A+</option>
									    <option value="A">A</option>
									    <option value="B">B</option>
						                <option value="C">C</option>
						                <option value="D">D</option>
                                     </select>
							      </td>
							      <td></td>
							      <td></td>
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
		    	   
		    	   if(form.paper_status.value==""){
		    		   alert("请勾选材料是否为空");
		    		   return false;   
		    	   }
		    	   
		    	   if(form.paper_is_English.value==""){
		    		   alert("请勾选论文是否为英语");  
		    		   return false;
		    	   }
		    	   if(form.paper_department.value==""){
		    		   alert("请填写系别"); 
		    		   return false;
		    	   }
		    	   if(form.paper_first_author.value==""|| form.paper_first_author_unit.value==""){
		    		   alert("第一作者信息必填");
		    		   return false;
		    	   }
		    	   if(form.paper_second_author.value==""|| form.paper_second_author_unit.value==""){
		    		   alert("第二作者信息必填");
		    		   return false;
		    	   }
		    	   if(form.paper_title.value==""){
		    		   alert("请填写论文题目"); 
		    		   return false;
		    	   }
		    	   if(form.paper_period.value==""){
		    		   alert("请填写期刊名称");		    		  
		    		   return false;
		    	   }
		    	   if(form.paper_period_roll.value==""){
		    		   alert("请填写期刊卷号");		    		 
		    		   return false;
		    	   }
		    	   if(form.paper_period_page.value==""){
		    		   alert("请填写期刊页号");	    		  
		    		   return false;
		    	   }
		    	   if(form.upfile.value==""){
		    		   alert("请上传审核资料");    		  
		    		   return false;
		    	   }     	   
		    	   return true;
		       }
		   
		   </script>
   </div>
</body>
</html>