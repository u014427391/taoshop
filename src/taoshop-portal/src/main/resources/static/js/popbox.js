/*popbox*/
  var windowHeight,popupHeight,checkpos;
  function popPosition(dom){
	var windowHeight = $(window).height();
	    windowWidth = $(window).width();
	    popupHeight = $(dom).height();
	    popupWidth = $(dom).width();
	var posiTop = (windowHeight - popupHeight)/2-10;
	var posiLeft = (windowWidth - popupWidth)/2-10;
	$(dom).css({'width':popupWidth,"left":posiLeft,"top":posiTop}).show();	
	$('.mark').show().css({'height':$(window).height()});
  }
  $(function(){
    $(window).resize(function(){
      if($(".popbox").css("display")=="block"){
	    popPosition('.popbox');
	  }
    });
    $('.popbox .pop-close').click(function(){	
	  $('.mark').fadeOut();
	  $(this).parents('.popbox').hide();
    });
  });