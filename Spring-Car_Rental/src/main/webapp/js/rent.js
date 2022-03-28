

      var rade = ["2022-02-20","14-03-2022","15-3-2012"];
      const listaLista =JSON.parse('${dates}');
     var unavailableDates = listaLista[1];
     console.log(typeof rade);
     console.log(typeof unavailableDates);


     document.addEventListener('DOMContentLoaded', function(){
 	    var selectEle = document.getElementById('mySelect');
 	    selectEle.addEventListener('change', function(item){
 	      unavailableDates = listaLista[selectEle.selectedIndex];

 	    });
 	});


      function unavailable(date) {
        dmy = date.getFullYear()+ "-" + ('0' + (date.getMonth()+1)).slice(-2)+ "-" + date.getDate();
        if ($.inArray(dmy, unavailableDates) == -1) {
          return [true, ""];
        } else {
          return [false,"","Unavailable"];
        }
      }



      $( function() {
          $('#datepicker').datepicker({ beforeShowDay: unavailable });

      } );
