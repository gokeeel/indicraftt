<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>

<body>

<h2>Consolidated Mark Statement</h2>

<table border="2" cellpadding="10">

<tr>

<th>Name</th>
<th>Roll No</th>
<th>Maths</th>
<th>Science</th>
<th>English</th>
<th>Total</th>
<th>Status</th>

</tr>

<xsl:for-each select="class/student">

<tr>

<td>
<xsl:value-of select="name"/>
</td>

<td>
<xsl:value-of select="rollno"/>
</td>

<td>
<xsl:value-of select="marks[subject='Maths']/score"/>
</td>

<td>
<xsl:value-of select="marks[subject='Science']/score"/>
</td>

<td>
<xsl:value-of select="marks[subject='English']/score"/>
</td>

<td>
<xsl:value-of select="sum(marks/score)"/>
</td>

<td>

<xsl:choose>

<xsl:when test="sum(marks/score) >= 150">

<font color="green">
Pass
</font>

</xsl:when>

<xsl:otherwise>

<font color="red">
Fail
</font>

</xsl:otherwise>

</xsl:choose>

</td>

</tr>

</xsl:for-each>

</table>

</body>

</html>

</xsl:template>

</xsl:stylesheet>