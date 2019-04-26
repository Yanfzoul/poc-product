$(function () {
    $('.search-area-input').on('keyup', function () {
        var search = $('.search-area-input').val();
        var priceMin = $("#slider-snap-input-lower").val();
        var priceMax = $("#slider-snap-input-upper").val();
        console.info(search + " " + priceMin + " " + priceMax);
        $.get("/content/cultura/fr/resultat-de-la-recherche/jcr:content/root/responsivegrid/product_grid_magento.html?search=" +
              search + "&priceMin=" + priceMin + "&priceMax=" + priceMax, function (data) {
            $(".product-grid-magento").html(data);
        });
    });
});
