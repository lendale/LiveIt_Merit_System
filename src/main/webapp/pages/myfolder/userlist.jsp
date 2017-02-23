<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>

    <form action="${pageContext.request.contextPath}/modulename/${myFunction eq 'edit' ? 'edituser':'adduser'}"
          method="POST">
        User ID : <input type="text" name="userid" value="${myUser.uid}"/><br/>
        First Name : <input type="text" name="firstname" value="${myUser.fname}"/><br/>
        Last Name : <input type="text" name="lastname" value="${myUser.lname}"/><br/>
        Age : <input type="text" name="age" value="${myUser.age}"/><br/>
        Gender : <input type="text" name="gender" value="${myUser.gender}"/><br/>
        Password : <input type="text" name="password" value="${myUser.password}"/><br/>

        <button type="submit">SUBMIT ME!!!!</button>
    </form>

    <hr/>
    <hr/>
    <form action="${pageContext.request.contextPath}/modulename/deleteuser" method="POST">
        <table border="2">
            <tr>
                <td>UID</td>
                <td>FNAME</td>
                <td>LNAME</td>
                <td>AGE</td>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td><input type="checkbox" name="userid" value="${user.uid}"/></td>
                    <td>${user.uid}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/modulename/loadedit?userid=${user.uid}">${user.fname}</a>
                    </td>
                    <td>${user.lname}</td>
                    <td>${user.age}</td>
                </tr>
            </c:forEach>

        </table>
        <button type="submit">DELETE ME!!!!</button>
    </form>

</div>
