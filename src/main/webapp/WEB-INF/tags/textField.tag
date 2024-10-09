<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="nameField" required="true" %>
<%@ attribute name="value" required="false" %>


<label for="${id}">${label}</label>
<input type="text" name="${nameField}" id="${id}" value="${value}" />