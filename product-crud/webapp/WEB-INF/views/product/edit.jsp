<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html ">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/product?cmd=saveOrUpdate" method="post">
	<input type="hidden" name="id" value="${product.id}"/>
	<table border="1" cellpadding="0" cellspacing="0">
	<tr>
	<td>商品名称</td>
	<td><input type="text" name="productName" value='${product.productName}' required /></td>
	</tr>
	<tr>
	<td>价格</td>
	<td><input type="number" name="salePrice"  value="${product.salePrice}" required min="0"/></td>
	</tr>
	
	<tr>
	<td>供应商</td>
	<td><input type="text" name="supplier"  value="${product.supplier}" required/></td>
	</tr>
	
	<tr>
	<td>品牌</td>
	<td><input type="text" name="brand" value="${product.brand}" required/></td>
	</tr>
	<tr>
	<td>折扣</td>
	<td><input type="text" name="cutoff"  value="${product.cutoff}" required /></td>
	</tr>
	<tr>
	<td>成本价</td>
	<td><input type="number" name="costPrice"  value="${product.costPrice}" required min="0"/></td>
	</tr>
	<tr>
	<td>商品分类</td>
	<td>
	<select name="dir_id">
	<option value="1" ${product.dir.id==1?"selected":"" }>键盘</option>
	<option value="2" ${product.dir.id==2?"selected":"" }>无线鼠标</option>
	<option value="3" ${product.dir.id==3?"selected":"" }>有线鼠标</option>
	<option value="4" ${product.dir.id==4?"selected":"" }>游戏鼠标</option>
	</select>
	</td>
	</tr>
	<tr>
	<td colspan="2" ><input type="submit" value="保存"/></td>
	
	</tr>
	
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</form>
</body>
</html>