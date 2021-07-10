<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SSCI期刊修改</title>
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
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/admin_ssci/save_modify_ssci" >
		            <div class="table-responsive">
					  <table class="table">					  																										
                            <tr class="active">
							      <td>
							           <label for="exampleInputName2">期刊中文名</label>
							      </td>
							      <td>
							           <input type="text" name = "ssci_chinese_name" value="${ssci.ssci_chinese_name}" class="form-control"  placeholder="中文名">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">期刊英文名</label>
							      </td>
							      <td>
							           <input type="text" name="ssci_English_name" value="${ssci.ssci_English_name}" class="form-control"  placeholder="英文名">
							      </td>
							      <td>
							           
							      </td>
							      <td>      
							            
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">期刊属性</label>
							      </td>
							      <td>
							           <input type="text"  name="ssci_class" value="${ssci.ssci_class}" class="form-control"  placeholder="期刊属性">
							      </td>
							      <td>
							          
							      </td>
							      <td>      
							           
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">ISSN</label>
							      </td>
							      <td>
							           <input type="text"  name="ssci_issn" value="${ssci.ssci_issn}" class="form-control"  placeholder="ISSN">
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
				                       <input type="radio" name="ssci_status" value="1" checked>启用
				                    </label>
								    <label class="radio">
								      <input type="radio" name="ssci_status" value="0">禁用
								    </label>
								     <c:choose>
								               <c:when test="${ssci.ssci_status == 1}">
								                       <script>
								                       $("input[name='ssci_status']").get(0).checked=true
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='ssci_status']").get(1).checked=true
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								 
							</tr>																								   
                           
					  </table>
					</div>
   
		          <p>
		          <button type="submit" class="btn btn-info" onClick="return confirm(this.form)">修改</button>
		   </form>
		   
		   ${result}
		   <script>
		       function confirm(form){
		    	   //数据输入是否为空进行验证
		    	   
		    	   if(form.ssci_chinese_name.value==""){
		    		   alert("请输入期刊中文名");
		    		   return false;   
		    	   }		    	  		    	 
		    	   if(form.ssci_Eglish_name.value==""){
		    		   alert("请输入期刊英文名"); 
		    		   return false;
		    	   }
		    	  
		    	   if(form.ssci_class.value==""){
		    		   alert("请输入期刊属性");
		    		   return false;
		    	   }
		    	   if(form.ssci_issn.value==""){
		    		   alert("请输入期刊ISSN");
		    		   return false;
		    	   }
		    	 
		    	  
		    	  
		    	   return true;
		       }
		   
		   </script>
		
			  
        
   </div>
</body>
</html>