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


    $(document).on('change', '.categoriesFacets input', function () {
        var str = $("form").serialize();
        var search = $('.search-area-input').val();
        var priceMin = $("#slider-snap-input-lower").val();
        var priceMax = $("#slider-snap-input-upper").val();

        var categoriesSave = $('.categoriesFacets input').map(function() {
            var param = "catValue=" + $(this).attr("data") + "&catId=" + $(this).val();
            if ($(this).is(':checked'))
                param += "&catCheck=true"
            else
				 param += "&catCheck=false"
            return param;

        }).get().join('&');

        console.info(search + " " + priceMin + " " + priceMax + " " + str);

		$.get("/content/cultura/fr/resultat-de-la-recherche/jcr:content/root/responsivegrid/product_grid_magento.html?search=" +
            search + "&priceMin=" + priceMin + "&priceMax=" + priceMax + "&" + categoriesSave + "&" + str, function (data) {

                $(".product-grid-magento").html(data);
            });
    });
});
