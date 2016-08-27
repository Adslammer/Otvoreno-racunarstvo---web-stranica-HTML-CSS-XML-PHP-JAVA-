<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" indent="yes" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" /> 

<xsl:template match="/">
  <html xmlns="http://www.w3.org/1999/xhtml" >
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8" />
		<meta name="author" content="Adrijan Jakšić" />
		<meta name="revised" content="2012/04/12" />
		<link rel="stylesheet" type="text/css" href="dizajn.css" />
		<title>Knjižnica</title>
	</head>
	
	<body>
		<div id="header">
		  <a href="index.html">
			<img src="images/naslovna.jpg" alt="" class="image" />
		  </a>
		  <a href="index.html" id="header_text">
            Knjižnica FER-a
          </a>
		</div>
		
		<div id="navigacija">
          <ul>
			<li><a href="index.html"><strong>Početna</strong></a></li>
            <li><a href="obrazac.html"><strong>Pretraživanje</strong></a></li>
            <li><a href="podaci.xml"><strong>Katalog knjiga</strong></a></li>
            <li><a href="http://www.rasip.fer.hr/"><strong>FER-RASIP</strong></a></li>
            <li><a href="http://www.fer.hr/" target="_blank"><strong>FER.hr</strong></a></li>
			<li>
              <a>
                <xsl:attribute name="href">mailto:adrijan.jaksic@fer.hr</xsl:attribute>
                <strong>Kontakt (e-mail)</strong>
              </a>
			</li>
		  </ul>
		</div>
		
		<div id="sadrzaj">
			<h1>Katalog knjiga</h1>
			<table class="pruge">
				<tr>
					<th>ISBN</th>
					<th>Naslov</th>
					<th>Autor</th>
					<th>Jezik</th>
					<th>Uvez</th>
					<th>Izdanje</th>
					<th>Ocjena</th>
				</tr>
				<xsl:for-each select="knjiznica/knjiga">
				<tr>
					<td align="center"><xsl:value-of select="@isbn"/></td>
					<td align="center"><xsl:value-of select="naslov" />
					    <xsl:if test="string(podnaslov)">:<br />
                         <xsl:value-of select="podnaslov" />
                        </xsl:if>
				    </td>
					<td align="center"><xsl:value-of select="autor/ime"/><xsl:text> </xsl:text><xsl:value-of select="autor/prezime" /></td>
					<td align="center"><xsl:value-of select="@jezik"/></td>
					<td><xsl:value-of select="@uvez"/></td>
					<td align="center"><xsl:value-of select="@izdanje"/></td>
					<td align="center"><xsl:value-of select="@ocjena"/></td>
				</tr>
				</xsl:for-each>
			</table>
		</div>
			
		<div id="footer">
            © Knjižnica Fakulteta elektrotehnike i računarstva u Zagrebu 2012. Sva prava pridržana. | Unska 3, 10000 Zagreb, HRVATSKA | Tel. +385 1 6129-866 (6129-538, 6129-888) | email ferlib@fer.hr | webmaster: Adrijan Jakšić
        </div>
	</body>
  </html>
</xsl:template>
</xsl:stylesheet>