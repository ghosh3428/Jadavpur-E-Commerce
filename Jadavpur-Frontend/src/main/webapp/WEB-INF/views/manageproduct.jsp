<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">

		<div class="offset-md-1 col-md-10">
			<div class="card">

				<div class="card-heading bg-success text-white">
					<h1>Product Management</h1>
				</div>


				<div class="card-body">

					<sf:form method="post" modelAttribute="newProduct">

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="name"> Enter
								Product Name </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name"
									class="form-control" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-form-label col-md-4" for="brand"> Enter
								Brand Name </label>
							<div class="col-md-8">
								<sf:input type="text"  path="brand" id="brand" placeholder="Brand Name"
									class="form-control" />
							</div>

						</div>
						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="name"> Enter
								Product Quantity </label>
							<div class="col-md-8">
								<sf:input type="text" path ="quantity" id="quantity" placeholder="Product Name"
									class="form-control" />

							</div>
						</div>

						<div class="form-group row">
							<label class="col-form-label col-md-4" for="brand"> Enter
								Unit Price </label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" id="unitPrice" placeholder="Brand Name"
									class="form-control" />

							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="description">
								Enter Product Description </label>
							<div class="col-md-8">
								<sf:textarea class="form-control" path="description" rows="5" id="description"
									placeholder="Enter product description : "/>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4"> Select Supplier </label>
							<div class="col-md-8">
								<sf:select  id="category" path="supplierId" items="${supplierlist}"
									itemLabel="firstName" itemValue="id" class="form-control">
								</sf:select>

							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4"> Select Category </label>
							<div class="col-md-8">
								<sf:select  id="category" path="categoryId" items="${categorylist}"
									itemLabel="categoryName" itemValue="id" class="form-control">
								</sf:select>

							</div>
						</div>

						<div class="form-group row">

							<div class="offset-md-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="submit"
									class="btn btn-primary btn-lg" />
							</div>

						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>









</div>







