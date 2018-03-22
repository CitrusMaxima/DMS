/*------------------------------------------------------
    Author : www.webthemez.com
    License: Commons Attribution 3.0
    http://creativecommons.org/licenses/by/3.0/
---------------------------------------------------------  */

(function ($) {
    "use strict";
    var mainApp = {

        initFunction: function () {
            /*MENU 
            ------------------------------------*/
            $('#main-menu').metisMenu();
			
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });

            /* MORRIS BAR CHART
			-----------------------------------------*/
            Morris.Bar({
                element: 'morris-bar-chart',
                data:arr1,
                xkey: 'y',
                ykeys: ['a', 'b'],
                labels: ['已召开', '未召开'],
				 barColors: [
    '#e96562','#414e63',
    '#A8E9DC' 
  ],
                hideHover: 'auto',
                resize: true
            });
	 


            /* MORRIS DONUT CHART
			----------------------------------------*/
            Morris.Donut({
                element: 'morris-donut-chart',
                data:arr2,
				   colors: [
    '#414e63',
    '#e96562' 
  ],
                resize: true
            });
           
        
            $('.bar-chart').cssCharts({type:"bar"});
            $('.donut-chart').cssCharts({type:"donut"}).trigger('show-donut-chart');

        },

        initialization: function () {
            mainApp.initFunction();

        }

    }
    // Initializing ///

    $(document).ready(function () {
		$(".dropdown-button").dropdown();
		$("#sideNav").click(function(){
			if($(this).hasClass('closed')){
				$('.navbar-side').animate({left: '0px'});
				$(this).removeClass('closed');
				$('#page-wrapper').animate({'margin-left' : '260px'});
				
			}
			else{
			    $(this).addClass('closed');
				$('.navbar-side').animate({left: '-260px'});
				$('#page-wrapper').animate({'margin-left' : '0px'}); 
			}
		});
		
        mainApp.initFunction(); 
    });

    var a = new Array("y: '2006',a: 70,b: 65",
                "y: '2007',a: 75,b: 65",
                "y: '2008',a: 50,b: 40",
                "y: '2009',a: 75,b: 65",
                "y: '2010',a: 50,b: 40",
                "y: '2011',a: 75,b: 65",
                "y: '2012',a: 30,b: 55");
    var b = new Array("label: '未召开',value: 30", "label: '已召开',value: 50");
    
    var arr1 = [];
    var arr2 = [];
    var obj1 = new Object();
    var obj2 = new Object();
    for(var i=0; i<a.length; i++){
        obj1[i] = eval('(' + "{"+a[i].toString()+"}" + ')');
        arr1.push(obj1[i]);
    }
    for(var j=0; j<b.length; j++){
        obj2[i] = eval('(' + "{"+b[j].toString()+"}" + ')');
        arr2.push(obj2[i]);
    }

	$(".dropdown-button").dropdown();
	
}(jQuery));
