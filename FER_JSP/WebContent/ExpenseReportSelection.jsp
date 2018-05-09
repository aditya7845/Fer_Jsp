<html>
<head>
</head>

<body>
	<form action='ExpenseReportSelectionPost.jsp'>
		<jsp:include page="Header.jsp" />
		<jsp:include page="LeftFrame.jsp" />
		<table border='10' align='center' height='600px' width='600px'>
			<tr height='100px'>
				<td colspan='2' align='center'>Family Expense Report User:</td>
			</tr>
			<tr>
				<td>
					<table border='10' align='center'>
						<tr>
							<td colspan='2' align='center'>Get Expense</td>
						</tr>
						<tr>
							<td>Expense Type</td>
							<td><input type='text' name='expensetype'></td>
						</tr>
						<tr>
							<td>FromDate</td>
							<td><input type='text' name='fromdate'></td>
						</tr>
						<tr>
							<td>ToDate</td>
							<td><input type='text' name='todate'></td>
						</tr>

						<tr>
							<td colspan='2' align='center'><input type='submit'
								value='Get Report'></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height='100px'>
				<td colspan='2' align='center'>Footer</td>
			</tr>
		</table>
	</form>
</body>
</html>