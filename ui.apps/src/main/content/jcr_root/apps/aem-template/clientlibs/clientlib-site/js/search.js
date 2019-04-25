$(function () {    
    $('.search-area-input').on('keyup', function () {
    	var search = $('.search-area-input').val();
    	console.info(search);
    	$.get("/content/cultura/fr/resultat-de-la-recherche/jcr:content/root/responsivegrid/product_grid_magento.html?search=" + search, function( data ) {
    		$(".product-grid-magento").html(data);
    	});
    });
    
});
