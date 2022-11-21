<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="laydate/laydate.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
	<script>
		$(function () {
			$.post("${pageContext.request.contextPath}/selectdept.action",function (deptList) {
				var $deptSelect = $("#deptSelect")
				$deptSelect.empty();
				$.each(deptList,function (i, dept) {
					$deptSelect.append("<option value='"+dept.deptNo+"'>"+dept.deptName+"</option>");
				})
			},"json")
		})
	</script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-magic"> 修改员工</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${pageContext.request.contextPath}/updateEmp.action" enctype="multipart/form-data">
		<div class="form-group">
			<div class="label">
				<label>员工编号：</label>
			</div>
			<div class="field">
				<input type="text" class="input w50" value="${emp.empNo}" name="empNo" readonly/>
				<span></span>
			</div>
		</div>
      <div class="form-group">
        <div class="label">
          <label>员工姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${emp.empName}" name="empName"
		   placeholder="请输入姓名" />
          <span></span>
        </div>
      </div>
	  <div class="form-group">
	    <div class="label">
	      <label>员工职位：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="${emp.empJob}" name="empJob"
	  		   placeholder="员工职位"/>
	      <span></span>
	    </div>
	  </div>
		<div class="form-group">
			<div class="label">
				<label>入职日期：</label>
			</div>
			<div class="field">
				<input type="text" class="input w50"
					   id="hiredate"
					   value="${emp.empHiredate}" name="empHiredate"
					   placeholder="请选择职日期"/>
				<span></span>
				<script>
					laydate.render({
						elem: '#hiredate' //指定元素
					});
				</script>
			</div>
		</div>
	  <div class="form-group">
	    <div class="label">
	      <label>月薪：</label>
	    </div>
	    <div class="field">
	      <input type="text" class="input w50" value="${emp.empSal}" name="empSal"
	  		   placeholder="请输入月薪"/>
	      <span></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label">
	      <label>所在部门：</label>
	    </div>
	    <div class="field">
	      <select name="deptNo" class="input w50" id="deptSelect">
	        <option value="${emp.deptNo}"></option>
	        <%--<option value="">产品分类</option>--%>
	        <%--<option value="">产品分类</option>--%>
	        <%--<option value="">产品分类</option>--%>
	        <%--<option value="">产品分类</option>--%>
	      </select>
	    </div>
	  </div>
		<div class="form-group">
			<div class="label">
				<label>员工头像：</label>
			</div>
			<div class="field">
				<td> <img src="${pageContext.request.contextPath}/fileupload/${emp.empPhoto}" width="50" height="50"></td>
				<input type="file" class="input w50" value="" name="empPhoto"
					   placeholder="员工头像"/>
				<span></span>
			</div>
		</div>
	  <div class="form-group">
	    <div class="label">
	      <label></label>
	    </div>
	    <div class="field">
	      <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>
		  <button type="button" style="width: 110px;" class="button bg-green" onclick="javascript:history.back(-1)"> 返回</button>   
	    </div>
	  </div>    
    </form>
  </div>
</div>

</body></html>