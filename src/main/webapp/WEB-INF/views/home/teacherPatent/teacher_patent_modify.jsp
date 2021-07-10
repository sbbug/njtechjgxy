<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专利申报信息修改</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jQuery.js"></script>	
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
       <h2>专利申报信息修改</h2>
		   <form class="form-inline" method="post" action="<%=request.getContextPath() %>/tea_patent/modify_save_patent" enctype ="multipart/form-data">
		            <div class="table-responsive">
					  <table class="table">
					  
							<tr class="active">
							     <td><label class="radio">材料：     </label></td>
							     <td> 
							        <label class="radio">
				                       <input type="radio" name="patent_status" value="1">有
				                    </label>
								    <label class="radio">
								      <input type="radio" name="patent_status" value="0">无
								    </label>
								     <c:choose>
								               <c:when test="${patent.patent_status == 1}">
								                       <script>
								                       $("input[name='patent_status']").get(0).checked=true
								                       </script>
								               </c:when>
								               <c:otherwise>
								                       <script>
								                       $("input[name='patent_status']").get(1).checked=true
								                       </script>                              
								               </c:otherwise>
							         </c:choose>
								 </td>
								 <td></td>
								  <td></td>
							</tr>
							
							<tr class="active">
							      <td> <label class="radio">系别：     </label></td>
							       
							      
							      <td>
							            <!-- 下面的数据采用动态提取 -->
				                     <select id="static_dropdown" name="patent_department" class="form-control">
				                         <c:forEach items = "${departs}" var = "depart">
                                                    <c:if test="${depart.depart_status != 0}">
                                                          <option value="${depart.depart_item}">${depart.depart_item}</option>
                                                    </c:if>
                                                    
                                         </c:forEach>
                                     </select>
                                      <script>
                                        $("#static_dropdown").val('${patent.patent_department}');
                                       </script>
							      </td>
							      <td></td>
							      <td></td>
							</tr>
                            <tr class="active">
							      <td>
							           <label for="exampleInputName2">第一作者</label>
							      </td>
							      <td>
							           <input type="text" name = "patent_first_author" value = "${patent.patent_first_author}"class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">第二作者</label>
							      </td>
							      <td>      
							            <input type="text" name="patent_second_author" value = "${patent.patent_second_author}" class="form-control"  placeholder="姓名">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">第三作者</label>
							      </td>
							      <td>
							           <input type="text" name="patent_third_author" value = "${patent.patent_third_author}" class="form-control"  placeholder="姓名">
							      </td>
							      <td>
							            <label for="exampleInputName2">其他作者</label>
							      </td>
							      <td>      
							            <input type="text" name="patent_other_author" value="${patent.patent_other_author }" class="form-control"  placeholder="多个姓名">
							      </td>
							</tr>
							<tr class="active">
							      <td>
							           <label for="exampleInputName2">专利类别</label>
							      </td>
							      <td>
							           <input type="text"  name="patent_class" value="${patent.patent_class}" class="form-control"  placeholder="专利类别">
							      </td>
							      <td>
							            <label for="exampleInputName2">专利名称</label>
							      </td>
							      <td>      
							            <input type="text"  name="patent_title" value="${patent.patent_title }" class="form-control"  placeholder="专利名称">
							      </td>
							</tr>
							
							<tr class="active">
							      <td>
							            <label for="exampleInputName2">专利号</label>  
							      </td>
							      
							      <td>
							            <input type="text" name="patent_num" value="${patent.patent_num}" class="form-control"  placeholder="专利号">
							      </td>
							      <td></td>
							      <td>
							      </td>
							</tr>
							<tr class="active">
							      <td> 
							            <label for="exampleInputName2">成果备注</label>
							      </td>
							       
							      <td colspan="3">
							           <textarea  name = "patent_remark" class="form-control" >
							           
							           </textarea>
							           <script>
							               document.getElementById("patent_remark").value=${patent.patent_remark};
                                      </script>
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
		    	   
		    	   if(form.patent_status.value==""){
		    		   alert("请勾选材料是否为空");
		    		   return false;   
		    	   }
		    	   		    	   
		    	  
		    	   if(form.patent_first_author.value==""){
		    		   alert("第一作者信息必填");
		    		   return false;
		    	   }
		    	  
		    	   if(form.patent_class.value==""){
		    		   alert("请填写专利类别"); 
		    		   return false;
		    	   }
		    	   if(form.patent_title.value==""){
		    		   alert("请填写专利名称");		    		  
		    		   return false;
		    	   }
		    	   if(form.patent_num.value==""){
		    		   alert("请填写专利号");		    		 
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