<jsp:useBean id="bookinfo" class="com.ssi.Book" scope="session"/>


<html>
<body>
	<h3>Book Details</h3>
	<hr>
		<pre>
			BCode   :	<jsp:getProperty name="bookinfo" property="code"/>
			Title   :	<jsp:getProperty name="bookinfo" property="title"/>
			Author  :	<jsp:getProperty name="bookinfo" property="author"/>
			Subject :	<jsp:getProperty name="bookinfo" property="subject"/>
			Price   :	<%=bookinfo.getPrice()%>
		
		</pre>
	<hr>
	<a href="search.jsp">Search-More</a><br>
	<a href="index.jsp">Home</a>
</body>
</html>