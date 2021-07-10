<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>院期刊库条目修改</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>

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
       <h2>修改期刊</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/admin_own/save_modify_own" >
		            <div class="table-responsive">
					  <table class="table">					  																										
                            <tr class="active">
							      <td>
							           <label for="exampleInputName2">ISSN</label>
							      </td>
							      <td>
							           <input type="text" name = "own_issn" value ="${own.own_issn}"class="form-control"  placeholder="issn">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">期刊简称</label>
							      </td>
							      <td>
							           <input type="text" name="own_name" value="${own.own_name}" class="form-control"  placeholder="期刊简称">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							            
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">期刊分区</label>
							      </td>
							      <td>
							           <input type="text"  name="own_area" value="${own.own_area}" class="form-control"  placeholder="期刊分区">
							      </td>
							      <td>
							          
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">期刊全称</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="own_fullname" value="${own.own_fullname}" class="form-control"  placeholder="期刊全称">
							      </td>
							      <td>
							               
							      </td>
							      <td>
							             
							      </td>
							</tr>
							
							
						   <tr class="active">
							     <td>
							           <label for="exampleInputName2">期刊等级</label>
							      </td>
							      <td>
							                 <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="own_rank" class="form-control">
									    <option value="A+">A+</option>
									    <option value="A">A</option>	
									   	<option value="B">B</option>
									   	<option value="C">C</option>
									   	<option value="D">D</option>								   														   
                                     </select>
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							          
							      </td>
							</tr>
                            <tr class="active">
							    
							     <td><label class="radio">期刊状态：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="own_status" value="1" checked>启用
				                    </label>
								    <label class="radio">
								      <input type="radio" name="own_status" value="0">禁用
								    </label>
								     <c:choose>
								               <c:when test="${own.own_status == 1}">
								                       <script>
								                       $("input[name='own_status']").get(0).checked=true
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='own_status']").get(1).checked=true
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								 
							</tr>
					  </table>
					</div>
   
		          <p>
		          <button type="submit" class="btn btn-info" onClick="return confirm(this.form)">保存修改</button>
		   </form>
		   
		   ${result}
		   <script>
		       function confirm(form){
		    	   //数据输入是否为空进行验证
		    	   
		    	   if(form.own_issn.value==""){
		    		   alert("请输入ISSN");
		    		   return false;   
		    	   }		    	  		    	 
		    	   if(form.own_name.value==""){
		    		   alert("请输入期刊名称"); 
		    		   return false;
		    	   }
		    	  
		    	   if(form.own_area.value==""){
		    		   alert("请输入期刊分区");
		    		   return false;
		    	   }
		    	   if(form.own_fullname.value==""){
		    		   alert("请输入期刊全名");
		    		   return false;
		    	   }
		    	  
		    	  
		    	   return true;
		       }
		   
		   </script>
		
			  
        
   </div>
</body>
</html>