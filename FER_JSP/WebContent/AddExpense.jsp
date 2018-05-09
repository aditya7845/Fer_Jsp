


<html>
<head>
</head>

<body>
	<form action="AddExpensePost.jsp">
		<jsp:include page="Header.jsp" />
		<jsp:include page="LeftFrame.jsp" />
		<table border='10' align='center' height='600px' width='600px'>
			<tr height='100px'>
				<td colspan='2' align='center'>Family Expense Report</td>
			</tr>
			<tr>
				<td>
					<table border='10' align='center'>
						<tr>
							<td colspan='2' align='center'>Add Expense</td>
						</tr>
						<tr>
							<td>Expense Type</td>
							<td><input type='text' name='expensetype'></td>
						</tr>
						<tr>
							<td>Date</td>
							<td><input type='text' name='date'></td>
						</tr>
						<tr>
							<td>Price</td>
							<td><input type='text' name='price'></td>
						</tr>
						<tr>
							<td>Number Of Items</td>
							<td><input type='text' name='numberofitems'></td>
						</tr>
						<tr>
							<td>Total</td>
							<td><input type='text' name='total'></td>
						</tr>
						<tr>
							<td>By Whom</td>
							<td><input type='text' name='bywhom'></td>
						</tr>
						<tr>
							<td colspan='2' align='center'><input type='submit'
								value='Add Expense'></td>

						</tr>
					</table>
				</td>
			</tr>
			<jsp:include page="Footer.jsp" />

		</table>
	</form>
</body>
</html>