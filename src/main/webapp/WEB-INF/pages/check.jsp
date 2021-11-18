<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Check</title>
</head>
<body>
    <jsp:useBean id="now" class="java.util.Date"/>

    <table align="center">
        <tr>
            <td>${check.header}</td>
        </tr>
        <tr>
            <td>${check.nameShop}</td>
        </tr>
        <tr>
            <td>${check.phone}</td>
        </tr>
        <tr>
            <td><fmt:formatDate type="time" value="${now}" pattern="dd.MM.yyyy HH:mm:ss"/></td>
        </tr>
        <tr>
            <td>
                <table>
                    <tr align="right">
                        <td align="left" width="50">QTY</td>
                        <td width="100">DESCRIPTION</td>
                        <td width="60">PRICE</td>
                        <td width="70">TOTAL</td>
                    </tr>
                </table>
            </td>
        </tr>
        <c:forEach var="item" items="${check.purchases}">
            <tr>
                <td>
                    <table>
                        <tr align="right">
                            <td align="left" width="50">${item.unitsNumber}</td>
                            <td width="100">${item.product.name}</td>
                            <td width="60">${item.product.price}</td>
                            <td width="70">${item.worth}</td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td align="right">${item.discountLine}</td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <table>
                    <tr>
                        <td align="left" width="150">Taxable TOT.</td>
                        <td align="right" width="140">${check.tableTot}</td>
                    </tr>
                    <tr>
                        <td align="left">Vat</td>
                        <td align="right">${check.vat}</td>
                    </tr>
                    <tr>
                        <td align="left">TOTAL</td>
                        <td align="right">${check.total}</td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>
