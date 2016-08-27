<?php

  function generateQuery()
  {
    $queryArray[] = attributeExist("isbn");
    $queryArray[] = elementExist("naslov");
    $queryArray[] = elementExist("podnaslov");
    $queryArray[] = longContains('autor', 'ime', 'ime_autora');
    $queryArray[] = longContains('autor', 'prezime', 'prezime_autora');
    if (!empty($_REQUEST['izdavac']))
    {
      $queryArray[] = longContains('izdavac', 'naziv', 'naziv_izdavaca');
    }
    /*if (!empty($_REQUEST['datum_izdanja']))
    {
      $datum = explode(".", $_REQUEST['datum_izdanja']);
      if ($datum)
    }*/
    $queryArray[] = attributeExist("broj_stranica");
    $queryArray[] = postojanjeAtributa('jezik');
    $queryArray[] = attributeEqual("uvez");
	$queryArray[] = attributeEqual("izdanje");
    $queryArray[] = postojanjeElementa('ocjena');
    $queryArray[] = elementExist("kategorija");
    $queryArray = makni_prazne_upite($queryArray);
    $query = implode(" and ", $queryArray);

    if (empty($query))
      return "/knjiznica/knjiga";

    $query = "/knjiznica/knjiga[" . $query . "]";
    return $query;
  }

  function postojanjeAtributa($imeAtributa)
  {
    if (!empty($_REQUEST[$imeAtributa]))
    {
      foreach ($_REQUEST[$imeAtributa] as $atribut)
      {
        $queryFragment[] = "@" . $imeAtributa . "='" . $atribut . "'";
      }
      return "(" . implode(" or ", $queryFragment) . ")";
    }
    else
      return "";
  }

  function postojanjeElementa($imeElementa)
  {
    if (!empty($_REQUEST[$imeElementa]))
    {
      foreach ($_REQUEST[$imeElementa] as $element)
      {
        $queryFragment[] = $imeElementa . "='" . $element . "'";
      }
      return "(" . implode(" or ", $queryFragment) . ")";
    }
    else
      return "";
  }
  
  function attributeEqual($atribut)
  {
    if(!empty($_REQUEST[$atribut]))
      return "@" . $atribut . "='" . $_REQUEST[$atribut] . "'";
    return "";
  }

  function attributeExist($atribut)
  {
    if(!empty($_REQUEST[$atribut]))
      return "contains(@" . $atribut . ",'" . $_REQUEST[$atribut] . "')";
    return "";
  }

  function elementExist($element)
  {
    if(!empty($_REQUEST[$element]))
      return "contains(" . $element . ",'" . $_REQUEST[$element] . "')";
    return "";
  }

  function getElementValue($node, $element)
  {
    return $node->getElementsByTagName($element)->item(0);
  }

  function longContains($roditeljElement, $dijeteElement, $formaElement)
  {
    if (!empty($_REQUEST[$formaElement]))
    {
      return $roditeljElement . "[contains(" . $dijeteElement . ", '" . $_REQUEST[$formaElement] . "')]";
    }
  }

  function makni_prazne_upite($argument)
  {
    $polje = array();
    while(list($kljuè, $vrijednost) = each($argument))
    {
      if (is_array($vrijednost))
      {
        $vrijednost = makni_prazne_upite($vrijednost);
        // does the result array contain anything?
        if (count($vrijednost)!=0)
        {
          // yes :-)
          $polje[$kljuè] = $vrijednost;
        }
      }
      else
      {
        if (trim($vrijednost) != "")
        {
          $polje[$kljuè] = $vrijednost;
        }
      }
    }
    unset($argument);
    return $polje;
  }

?>