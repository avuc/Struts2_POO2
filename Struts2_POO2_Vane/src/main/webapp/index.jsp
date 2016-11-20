<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Contact Manager - Struts2 Hibernate Example</title>
</head>
<body>

<h1>Contact Manager</h1>
<s:actionerror/>

<s:form action="guar" method="post">
	<s:hidden name="objeAlum.codiAlum"/>
	<s:textfield name="objeAlum.nombAlum" label="Nombre"/>
	<s:textfield name="objeAlum.apelAlum" label="Apellido"/>
	<s:textfield name="objeAlum.mailAlum" label="Correo eléctronico"/>
	<s:textfield name="objeAlum.teleAlum" label="Teléfono"/>
	<s:textfield name="objeAlum.direAlum" label="Dirección"/>
	<s:textfield name="objeAlum.geneAlum" label="Género"/>
	<s:submit value="Agregar" align="center"/>
</s:form>

<h2>Alumnos</h2>
<table>
<tr>
	<th>Nombre</th>
	<th>Apellido</th>
	<th>Correo eléctronico</th>
	<th>Teléfono</th>
	<th>Dirección</th>
	<th>Género</th>
	<th>Modificar</th>
	<th>Eliminar</th>
</tr>
<s:iterator value="listAlum" var="objeAlum">
	<tr>
		<td><s:property value="nombAlum"/></td>
		<td><s:property value="apelAlum"/></td>
		<td><s:property value="teleAlum"/></td>
		<td><s:property value="direAlum"/></td>
		<td><s:property value="geneAlum"/></td>
		<td><a href="modi?id=<s:property value="id"/>">Modificar</a></td>
		<td><a href="elim?id=<s:property value="id"/>">Eliminar</a></td>
	</tr>	
</s:iterator>
</table>
</body>
</html>