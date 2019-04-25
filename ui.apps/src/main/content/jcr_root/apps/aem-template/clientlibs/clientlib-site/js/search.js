$(function () {
    $('[data-toggle="search"]').on('click', function () {
        $('.search-area-wrapper').show();
    });

    $('.search-area-wrapper .close-btn').on('click', function () {
        $('.search-area-wrapper').hide();
    });
    
    $('.search-area-wrapper .search-area-input').on('keyup', function () {
    	var search = $('.search-area-wrapper .search-area-input').val();
    	console.info(search);
    	$.get("/content/cultura/fr/resultat-de-la-recherche/jcr:content/root/responsivegrid/product_grid_magento.html?categoryId=" + search, function( data ) {
    		$(".products-grid").html(data);
    	});
    });
    
});
