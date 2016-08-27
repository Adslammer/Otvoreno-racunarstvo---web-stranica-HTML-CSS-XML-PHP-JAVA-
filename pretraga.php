<?php

  include ('funkcije.php');
  
  error_reporting (E_ALL);

  $dom = new DOMDocument();
  $dom->load('podaci.xml');

  $xp = new DOMXPath($dom);

  $query = generateQuery();
  $rezultat = $xp->query($query);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
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
        <li><a href="mailto:adrijan.jaksic@fer.hr"><strong>Kontakt (e-mail)</strong></a></li>
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
        <?php
          foreach ($rezultat as $element)
          {
        ?>
        <tr>
		  <td>
		    <?php
              echo $element->getAttribute('isbn');
            ?>
		  </td>
          <td>
            <?php
              echo getElementValue($element, 'naslov')->nodeValue;
              $podnaslov = getElementValue($element, 'podnaslov');
              if (!empty($podnaslov))
              {
                echo ":<br />";
                echo getElementValue($element, 'podnaslov')->nodeValue;
              }
            ?>
          </td>
          <td>
            <?php
              foreach($element->getElementsByTagName('autor') as $autor)
              {
                echo getElementValue($autor, 'ime')->nodeValue;
                echo " ";
                echo getElementValue($autor, 'prezime')->nodeValue;
                echo "<br />";
              }
            ?>
          </td>
          <td>
            <?php
              echo $element->getAttribute('jezik');
            ?>
	      </td>
		  <td>
            <?php
              echo $element->getAttribute('uvez');
            ?>
          </td>
		  <td>
            <?php
              echo $element->getAttribute('izdanje');
            ?>
		  </td>
		  <td>
			<?php
              echo $element->getAttribute('ocjena');
            ?>
          </td>
        </tr>
        <?php
          }
        ?>
      </table>
    </div>

    <div id="footer">
      © Knjižnica Fakulteta elektrotehnike i računarstva u Zagrebu 2012. Sva prava pridržana. | Unska 3, 10000 Zagreb, HRVATSKA | Tel. +385 1 6129-866 (6129-538, 6129-888) | email ferlib@fer.hr | webmaster: Adrijan Jakšić
    </div>
  </body>
</html>
