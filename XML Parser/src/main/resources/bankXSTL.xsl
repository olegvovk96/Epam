<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
	<xsl:template match="/" >
	<html>
		<head>
			<style>
				body{
					font-family: Arial; 
					font-size: 12pt; 
				}
				th, td{
					border: 1px solid black;
					text-align: center;
				}
				table{
					border-spacing: 0;
					border: 1px solid black;
				}
				.table td,
				.table th{
					width: 100px;
					height: 50px;
				}
				h2{
					font-weight: bold;
					color: green;
					text-align: center;
				}
			</style>
		</head>
     	<body>
        	<h2>Bank</h2>
        	<table class="table">
          		<tr>
            	    <th>Name bank</th>
            		<th>Country</th>
          		    <th colspan="2">Types</th>
            	    <th>Depositor</th>
          		    <th>Account_id</th>
            		<th>Amount on deposit</th>
            		<th>currency</th>
            		<th>profitability</th>
            		<th>time constraints</th> 
          		</tr>
          		
          		<xsl:for-each select="banks/bank">
            		<tr>
              			<td><xsl:value-of select="name"/></td>
             			<td><xsl:value-of select="country"/></td>
						<xsl:for-each select="types/type">
            					<td><xsl:value-of select="."/></td>
            			</xsl:for-each>
            			<td><xsl:value-of select="depositor"/></td>
            			<td><xsl:value-of select="accountId"/></td>
            			<td><xsl:value-of select="depositAmount"/></td>
            			<td><xsl:value-of select="currency"/></td>
            			<td><xsl:value-of select="profitability"/></td>
            			<td><xsl:value-of select="numberMonths"/></td>
            		</tr>
         	    </xsl:for-each>
			</table>
		</body>
	</html>
	</xsl:template>
</xsl:stylesheet>