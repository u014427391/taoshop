window['layer'] && layer.config({
    extend: ['skin/osa/style.css'], //加载新皮肤
    skin: 'layer-ext-osa' //一旦设定，所有弹层风格都采用此主题。
});

$(function() {
	if($('.site-nav').size() > 0){
		$('.sider-bar').height($('.main-wrap').height());
	}


	$(document).on('click', '.sider-nav-item', function(){
		if(!$(this).hasClass('current')){
			$('.sider-nav-item').removeClass('current');
			$(this).addClass('current');
		}
	});

	$(document).on('click', '.sider-nav-s li', function(){
		if(!$(this).hasClass('current')){
			$('.sider-nav-s li').removeClass('current');
			$(this).addClass('current');
		}
	});

	$('.grid tr').hover(function(){
		$(this).addClass('tr-hover');
	}, function(){
		$(this).removeClass('tr-hover');
	});
});