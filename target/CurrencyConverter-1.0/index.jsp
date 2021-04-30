<%--
  Created by IntelliJ IDEA.
  User: steam
  Date: 30.04.2021
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="just.css" rel="stylesheet" type="text/css">

    <title>Конвертёр</title>
</head>
<body>
<form class="form-style-1" method="post">
    <label>Amount <p><input type="text" placeholder="amount" name="amount" required></p></label>
    <label>Convert</label>
    <label>From <p><select required size = "1"  name="values">
        <option selected disabled>Select currency</option>
        <option value="USD">USD</option>
        <option value="KZT">KZT</option>
        <option value="RUB">RUB</option>
    </select></p></label>
    <label>To <p><select required size = "1"  name="values2">
        <option selected disabled>Select currency</option>
        <option value="USD">USD</option>
        <option value="KZT">KZT</option>
        <option value="RUB">RUB</option>
    </select></p></label>


    <label>Result ${currency}</label>
    <p><input type="submit"></p>
</form>


</body>
</html>
