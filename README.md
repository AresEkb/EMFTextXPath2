EMFTextXPath2
=============

An implementation of XPath 2.0 metamodel (http://www.w3.org/TR/xpath20/).

Test suite based on the specification:

fn:doc(fn:document-uri($Nq)),
($x div $y) + xs:decimal($z),
fn:error(xs:QName("app:err057"), "Unexpected value", fn:string($v)),
some $x in $expr1 satisfies $x = 47,
//product[id = 47],
if (doc-available('abc.xml')) then doc('abc.xml') else (),
$N[@x castable as xs:date][xs:date(@x) gt xs:date("2000-01-01")],
$N[if (@x castable as xs:date)
   then xs:date(@x) gt xs:date("2000-01-01")
   else false()],
fn:collection("http://example.org")//customer,
xs:integer("12"),
9 cast as hatsize,
fn:doc("bib.xml")/books/book[fn:count(./author)>1],
(1 to 100)[. mod 5 eq 0],
my:three-argument-function(1, 2, 3),
my:two-argument-function((1, 2), 3),
my:two-argument-function(1, ()),
my:one-argument-function((1, 2, 3)),
my:one-argument-function(( )),
my:zero-argument-function( ),
child::div1/child::para,
/*,
/ *,
/*5,
/ * 5,
(/) * 5,
4 + / * 5,
4 + (/) * 5,
4 + /,
attribute::abc:href,
child::*,
*:NCName,
attribute(*, xs:decimal),
document-node(element(book)),
child::chapter[2],
descendant::toy[attribute::color = "red"],
child::employee[secretary][assistant],
(ancestor::*)[1],
child::para[fn:position() = fn:last()-1],
following-sibling::chapter[fn:position() = 1],
/child::book/child::chapter[fn:position() = 5]/child::section[fn:position() = 2],
child::*[self::chapter or self::appendix][fn:position() = fn:last()],
(10, 1, 2, 3, 4),
(10, 1 to 4),
(1 to 100)[. mod 5 eq 0],
$orders[fn:position() = (5 to 9)],
$book/(chapter | appendix)[fn:last()],
fn:doc("zoo.xml")/fn:id('tiger'),
$seq1 union $seq2,
($arg1 div $arg2) cast as xs:integer?,
$emp/hiredate - $emp/birthdate,
$unit-price - $unit-discount,
-$bellcost + $whistlecost,
-($bellcost + $whistlecost),
$book1/author eq "Kennedy",
fn:QName("http://example.com/ns1", "this:color")
   eq fn:QName("http://example.com/ns1", "that:color"),
(1, 2) = (2, 3),
/books/book[isbn="1558604820"] is /books/book[call="QA76.9 C3845"],
/transactions/purchase[parcel="28-451"] 
   << /transactions/sale[parcel="33-870"],
1 eq 1 and 2 eq 2,
for $x in X, $y in Y return $x + $y,
for $a in fn:distinct-values(book/author)
return (book/author[. = $a][1], book[author = $a]/title),
for $i in (10, 20),
    $j in (1, 2)
return ($i + $j),
for $x in $z, $y in f($x)
return g($x, $y),
fn:sum(for $i in order-item return @price *
@qty),
if ($widget1/unit-cost < $widget2/unit-cost) 
  then $widget1
  else $widget2,
every $part in /parts/part satisfies $part/@discounted,
some $emp in /emps/employee satisfies 
     ($emp/bonus > 0.25 * $emp/salary),
some $x in (1, 2, 3), $y in (2, 3, 4) 
     satisfies $x + $y = 4,
. instance of element(),
if ($x castable as hatsize) 
   then $x cast as hatsize 
   else if ($x castable as IQ) 
   then $x cast as IQ 
   else $x cast as xs:string,
xs:decimal($floatvalue * 0.2E-5),
$myaddress treat as element(*, USAddress)
