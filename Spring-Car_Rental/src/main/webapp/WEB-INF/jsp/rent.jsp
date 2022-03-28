<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/rent.css" rel="stylesheet" type="text/css">




	   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	      <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" 
    integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" 
    crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <!-- Include Required Prerequisites -->
<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/3/css/bootstrap.css" />
 
<!-- Include Date Range Picker -->
<script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rent a car</title>


</head>
<body>
// 
<div class="wrapper" style="width: 600px; margin:0 auto; margin-top:50px">

<h3><spring:message code="lang" text="Language"/> </label><br> </h3>

<a href="?language=rs">Serbian </a><a href="?language=en_US">English</a><br>

<h3><spring:message code="fillout" text="Language"/></h3>

<form:form action="/cars" method="post" modelAttribute="wrapper"   > 
 <div class="form-outline mb-6">
 
<form:select path="car.id" name='' class=" form-control" id="mySelect" style="height:40px;" >
    <form:option  value="${lista[0].id}" >${lista[0].brand} ${lista[0].model}</form:option>
    <c:forEach items="${lista}" var="item">
        <c:if test="${item != lista[0]}">
            <form:option   value="${item.id}">${item.brand} ${item.model} </form:option>
        </c:if>
    </c:forEach>
</form:select>
      
  <label for="mySelect" class="form-label"><spring:message code="form.car" text="Pick a car"/>  </label>
   <td><form:errors path="car.id" cssStyle="color: #ff0000;"/></td>
</div>



<div class="form-outline mb-4">

<form:input path="dateRange" id="picker" type="text" name="daterange" value="01/02/2022 - 01/04/2022"  class="form-control"/>
 <label for="picker" class="form-label"><spring:message code="form.datepicker" text="Rent date"/>  </label>
</div>
<div class="row mb-4">
    <div class="col">
      <div class="form-outline">
        <form:input path="rental.customer.name" type="text" id="name" class="form-control" />
              <label for="name" class="form-label"><spring:message code="form.name" text="First name"/>  </label>
      </div>
       <td><form:errors path="rental.customer.name" cssStyle="color: #ff0000;"/></td>
    </div>
   
    <div class="col">
      <div class="form-outline">
        <form:input path="rental.customer.surname" type="text" id="surname" class="form-control" />
    <label for="surname" class="form-label"><spring:message code="form.surname" text="First name"/>  </label>
      
   
      
      </div>
      <td><form:errors path="rental.customer.surname" cssStyle="color: #ff0000;"/></td>
    </div>	
  </div>
  <p>Cena zakupa po za izabrane dane:  </p>
  <p id="price"> </p>

  <p>Cena zakupa po danu  </p>
  <p id="priceCar"> </p>

 
  <!-- Text input -->
  <div class="form-outline mb-4">
    <form:input path="rental.customer.adress" type="text" id="adresa" class="form-control" />
    <label class="form-label" for="adresa"><spring:message code="form.adress" text="First name"/></label>
        <td><form:errors path="rental.customer.adress" cssStyle="color: #ff0000;"/></td>
  </div>


  <!-- Email input -->
  <div class="form-outline mb-4">
    <form:input path="rental.customer.email" type="email" id="email" class="form-control" />
    <label class="form-label" for="email"><spring:message code="form.email" text="First name"/></label>
        <td><form:errors path="rental.customer.email" cssStyle="color: #ff0000;"/></td>
  </div>

  <!-- Number input -->
  <div class="form-outline mb-4">
    <form:input path="rental.customer.phone"  id="phone" class="form-control" />
    <label class="form-label" for="phone"><spring:message code="form.phone" text="First name"/></label>
        <td><form:errors path="rental.customer.phone" cssStyle="color: #ff0000;"/></td>
  </div>
	 <div class="form-outline mb-4">

	
  <button type="submit" class="btn btn-primary btn-block mb-4"><spring:message code="form.submit" text="Submit"/>  </button>
    
</form:form>
</div>

</body>
<script>

function promeniCenuRente() {
	  document.getElementById("price").innerHTML  = trenutnaCenaPoDanu * trenutanBrojDana;
	}
function promeniCenu() {
	  document.getElementById("priceCar").innerHTML  = trenutnaCenaPoDanu;
	}
 
     ;
      const listaLista =JSON.parse('${dates}');
      const listaCena =JSON.parse('${prices}');

      var trenutnaCenaPoDanu = listaCena[0];
		var trenutanBrojDana = 0;
      
      document.getElementById("price").innerHTML  = listaCena[0]; //cena prvog elementa
      document.getElementById("priceCar").innerHTML  = listaCena[0]; //cena prvog elementa
     var unavailableDates = listaLista[0];  //trenutni nedostupni datumi

   
    
     console.log(typeof rade);
     console.log(typeof unavailableDates);
     
     
     document.addEventListener('DOMContentLoaded', function(){  
 	    var selectEle = document.getElementById('mySelect');
 	 
 	    selectEle.addEventListener('change', function(item){  //promenjen automobil
 	      unavailableDates = listaLista[selectEle.selectedIndex];
			
 	      trenutnaCenaPoDanu = listaCena[selectEle.selectedIndex];
 	     promeniCenuRente();
 	     promeniCenu();
 	  
 	    });
 	});



      function unavailable(date) {
    	 var datum =  new Date(date.value);
        dmy = datum.getFullYear()+ "-" + ('0' + (datum.getMonth()+1)).slice(-2)+ "-" + datum.getDate(); 
        if ($.inArray(dmy, unavailableDates) == -1) {
          return [true, ""];
        } else {
          return [false,"","Unavailable"];
        }
      }


   
      $(function() {
     
    	    $('#picker').daterangepicker({
    	    	isInvalidDate: function(date) {
      
    	    		 var datum =  date._d;
    	   	  
    	    		  dmy = datum.getFullYear()+ "-" + ('0' + (datum.getMonth()+1)).slice(-2)+ "-" + datum.getDate(); 
    	    		  console.log("primer je " + dmy);
    	    	        if ($.inArray(dmy, unavailableDates) == -1) {
    	    	          return false;	    	   
    	    	        } else {
    	    	          return true; //vracamo true ako je datum nedostupan
    	    	        }
    	    		}
    	    		});

    	    $('#picker').on('apply.daterangepicker', function(ev, picker) {
    	    	
    	    	  var start = moment(picker.startDate.format('YYYY-MM-DD'));
                  var end   = moment(picker.endDate.format('YYYY-MM-DD'));
    	    	  var diff = start.diff(end, 'days'); // dani izmedju datumma
    	    	  trenutanBrojDana = (-1)*diff;
    	    	  promeniCenuRente();
    	    	   
    	    	 	  
    	    	});
  
    	});
      </script>
</html>

  
