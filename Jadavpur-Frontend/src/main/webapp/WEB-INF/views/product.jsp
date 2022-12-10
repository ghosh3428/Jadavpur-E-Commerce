<div class="row">

	<%@ include file="./shared/sidemenu.jsp"%>
	<!-- /.col-lg-3 -->

	<div class="col-lg-9">

		<div class="row">
			<c:if test="${userclickallproducts == true}" var="data">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
					<li class="breadcrumb-item active">All Products</li>
				</ol>
			</c:if>
			<c:if test="${userclickcategoryproducts == true}" var="data">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
					<li class="breadcrumb-item"><a
						href="${contextRoot}/product/view/all/product">Product</a></li>
					<li class="breadcrumb-item active">${category.categoryName}</li>
				</ol>
			</c:if>
		</div>
		<div class="row">
			<table>
				<tr>
					<td>ID</td>
					<td>Name</td>
				</tr>

				<tr>
					<td>1</td>
					<td>Amit</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Sumit</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Sanjay</td>
				</tr>
				<tr>
					<td>4</td>
					<td>Vijay</td>
				</tr>
			</table>
		</div>
	</div>
</div>


