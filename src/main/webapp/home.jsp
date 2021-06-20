<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
	
		<table name="APIFocumentationGuideTableOfLibraryManagementSystemSayan" id="customers">
			<tr>
				<th><label>API URL</label></th>
				<th><label>Http Method</label></th>
				<th><label>Description</label></th>
			</tr>
			<tr>
				<td><label>/user/{id}</label></td>
				<td><label>GET</label></td>
				<td><label>Get the user of that particular ID</label></td>
			</tr>
			<tr>
				<td><label>/user</label></td>
				<td><label>POST</label></td>
				<td><label>Add an user<br/>JSON request format >>><br/>
				<pre>
				<code>{ 
					"userid": 1, 
					"userName": "jhon", 
					"emailId": "example@domain.com" 
				}</code>
				</pre>
				</label></td>
			</tr>
			<tr>
				<td><label>/user/{id}</label></td>
				<td><label>DELLETE</label></td>
				<td><label>Delete an user</label></td>
			</tr>
			<tr>
				<td><label>/user</label></td>
				<td><label>GET</label></td>
				<td><label>Get the list of all users</label></td>
			</tr>
			<tr>
				<td><label>/books/day/{date}</label></td>
				<td><label>GET</label></td>
				<td><label>Get the list of books available on that particular day (Date must be greater or equal to current date)</label></td>
			</tr>
			<tr>
				<td><label>/books/{id}</label></td>
				<td><label>GET</label></td>
				<td><label>Get the book with particular ID</label></td>
			</tr>
			<tr>
				<td><label>/books</label></td>
				<td><label>GET</label></td>
				<td><label>Get the list of all the books</label></td>
			</tr>
			<tr>
				<td><label>/books</label></td>
				<td><label>POST</label></td>
				<td><label>Add a book<br/>JSON request format >>><br/>
				<pre>
				<code>{<br/>
    				"id": 1,<br/>
    				"category": "category_name",<br/>
    				"bookName": "book_name",<br/>
    				"bookUrl": "http://book.com",<br/>
    				"availableBooks": 5,<br/>
    				"status": "available"<br/>
				}</code>
				</pre>
				</label></td>
			</tr>
			<tr>
				<td><label>/books/{id}</label></td>
				<td><label>DELETE</label></td>
				<td><label>Delete a book</label></td>
			</tr>
			<tr>
				<td><label>/borrowbook/{bookid}</label></td>
				<td><label>POST</label></td>
				<td><label>Borrow a book with particular book id<br/>JSON request format >>><br/>
				<pre>
				<code>{<br/>
    				"id": 1,<br/>
    				"userid": 2,<br/>
				    "bookingDate": "2022-05-27",<br/>
    				"chargePerDay": 50.0,<br/>
    				"no_Of_Days": 4<br/>
				}</code>
				</pre>
				</label></td>
			</tr>
			<tr>
				<td><label>/borrowbook/{borrowbookid}</label></td>
				<td><label>GET</label></td>
				<td><label>Get the borrowbook for that particular ID</label></td>
			</tr>
			<tr>
				<td><label>/borrowbook</label></td>
				<td><label>GET</label></td>
				<td><label>Get list of all the borrowbooks</label></td>+
			</tr>
			<tr>
				<td><label>/billing/{borrowbookid}</label></td>
				<td><label>POST</label></td>
				<td><label>Generate bill for that particular borrowbook ID<br/>JSON request format >>><br/>
				<pre>
				<code>{<br/>
    				"id": 1,<br/>
    				"returnDate": "2022-06-02",<br/>
    				"finePerDay": 20<br/>
				}</code>
				<pre/>
				</label></td>
			</tr>
			<tr>
				<td><label>/billing/getbill/{id}</label></td>
				<td><label>GET</label></td>
				<td><label>Get the bill for that particular billing ID</label></td>
			</tr>
		</table>
	
	
</body>
</html>