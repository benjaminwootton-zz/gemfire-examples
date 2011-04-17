<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<font face="verdana" size=-1/>
<h1><c:out escapeXml="false" value="<b>${location}</b> - Order Entry System"/></h1>
<div style="margin:10px;width:300px;border-style:solid;border-width:1px;padding:10px;float:left;">
Raise A New Order
<hr/>
<form:form>
    <table>
        <tr>
            <td><font size=-2>What Would You Like To Order?</td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Save Changes" />
            </td>
        </tr>
    </table>
</form:form>
</div>

<div style="margin:10px;width:600px;border-style:solid;border-width:1px;padding:10px;float:left;">
Current Orders
<hr/>
<c:forEach var="order" items="${orders}">
<c:if test='${order.location != location}'>
    <font color="lightgray">
</c:if>

<c:if test='${order.location == "Tokyo" }'>
  <img src=http://www.printableworldflags.com/icon-flags/24/Japan.png align=absmiddle>
</c:if>

<c:if test='${order.location == "London" }'>
  <img src=http://www.printableworldflags.com/icon-flags/24/United%20Kingdom.png align=absmiddle>
</c:if>

         <c:out escapeXml="false" value=" On <b>${order.creationDate}</b> an order for <b>${order.description}</b> was placed in <b>${order.location}</b>" /><br/>

<c:if test='${order.location != location}'>
    </font>
</c:if>

</c:forEach>
</div>

</body>
</html>

