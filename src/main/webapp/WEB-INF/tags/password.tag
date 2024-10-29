<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="passwordField" required="true" %>
<%@ attribute name="value" required="false" %>


<label for="${id}">${label}</label>
<input type="password" name="${passwordField}" id="${id}" value="${value}" />